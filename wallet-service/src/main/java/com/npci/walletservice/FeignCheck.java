package com.npci.walletservice;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("http://ACCOUNT-SERVICE")
public interface FeignCheck {

    @GetMapping("/account/{accountNumber}")
    public Account getAccount(@PathVariable("accountNumber") long accountNumber);

}
