package com.example.management.repository;

import com.example.management.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE ACCOUNT SET employee_id = ?1 WHERE id = ?2", nativeQuery = true)
    void setEmployeeId(Long idEmployee, Long idAccount);
}
