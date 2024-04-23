package com.npci.walletservice;

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
    public Wallet getAccountDetails(long accountNumber){
        String URL = "http://ACCOUNT-SERVICE/account/" + accountNumber;
        // get the Account object from the remote service
        //Account account = rest.getForObject(URL, Account.class);
        Account account = feignCheck.getAccount(accountNumber);
        // Initialize wallet from the object
        Wallet wallet = new Wallet("MyPay", 500, 500+account.getBalance(), account);
        return wallet;
    }
}
