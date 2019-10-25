package com.lvat.SpringTest.login.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    /**
     * password encoder reference implemented in WebMvcConfig.java
     */
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * data source implemented out of the box by Spring Boot. We only need to provide the database information in the application.properties file (please see the reference below)
     */
    @Autowired
    private DataSource dataSource;

    /**
     * Reference to user and role queries stored in application.properties file (please see the reference below)
     */
    @Value(value = "${spring.queries.users-query}")
    private String usersQuery;

    /**
     * Reference to user and role queries stored in application.properties file (please see the reference below)
     */
    @Value(value = "${spring.queries.roles-query}")
    private String rolesQuery;

    /**
     * @param auth a
     * @throws Exception a
     * AuthenticationManagerBuilder provides a mechanism to get a user based on the password encoder, data source, user query and role query
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder);
    }

    /**
     * @param web a
     * @throws Exception a
     *
     * Due we have implemented Spring Security we need to let Spring knows that our resources folder can be served skipping the antMatchers defined
     *
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

    /**
     * @param http a
     * @throws Exception a
     *
     * Here we define the antMatchers to provide access based on the role(s) (lines 48 to 51), the parameters for the login process (lines 55 to 56), the success login page(line 53), the failure login page(line 53), and the logout page (line 58)
     *
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/")
                .permitAll()
                .antMatchers("/login")
                .permitAll()
                .antMatchers("/registration")
                .permitAll()
                .antMatchers("/admin/**")
                .hasAuthority("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .csrf()
                .disable()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?=error=true")
                .defaultSuccessUrl("/admin/home")
                .usernameParameter("email")
                .passwordParameter("password")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .and()
                .exceptionHandling()
                .accessDeniedPage("access-denied");
    }
}
