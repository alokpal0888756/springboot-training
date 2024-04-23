package com.npci.walletservice;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WalletService {

    @Autowired
    private RestTemplate rest;

    @Autowired
    FeignCheck feignCheck;

    // a method that calls remote service and returns the wallet
    @CircuitBreaker(name = "getAccount", fallbackMethod = "getAccount2")
    public Wallet getAccountDetails(long accountNumber){

        System.out.println("------Making Remote Call.........");
        String URL = "http://ACCOUNT-SERVICE/account/" + accountNumber;
        // get the Account object from the remote service
        //Account account = rest.getForObject(URL, Account.class);
        Account account = feignCheck.getAccount(accountNumber);
        // Initialize wallet from the object
        Wallet wallet = new Wallet("MyPay", 500, 500+account.getBalance(), account);
        return wallet;
    }

    // fallback method that is automatically executed if the remote service is down
    public Wallet getAccount2(long accountNumber, Throwable throwable){
        System.out.println("________Fallback:method: Alternate response_________");
        return new Wallet("MyPay", 500, 0, null);
    }
}
