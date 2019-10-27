package com.lvat.SpringTest.login.repositories;

import com.lvat.SpringTest.login.entities.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsersRepository extends PagingAndSortingRepository<Users, Long> {
    <T> Page<T> findByActive(Integer active, Class<T> type, Pageable pageable);

    <T> T findByEmail(String email, Class<T> type);
}
