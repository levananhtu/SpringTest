package com.lvat.SpringTest.login.repositories;

import com.lvat.SpringTest.login.entities.Roles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RolesRepository extends PagingAndSortingRepository<Roles, Long> {
    <T> Page<T> findByRoleName(String roleName, Class<T> type, Pageable pageable);
}
