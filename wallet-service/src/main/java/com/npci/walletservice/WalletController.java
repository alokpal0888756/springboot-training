package com.npci.walletservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    WalletService walletService;



    @GetMapping("/{accountNumber}")
    public ResponseEntity<Wallet> getAccountDetails(@PathVariable long accountNumber){
        return ResponseEntity.status(200).body(walletService.getAccountDetails(accountNumber));
    }
}
