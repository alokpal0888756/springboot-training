package com.npci.accountservice;

import com.npci.accountservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repo extends JpaRepository<Account, Long> {
}
