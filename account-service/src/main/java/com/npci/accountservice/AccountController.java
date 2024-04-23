package com.npci.accountservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RequestMapping("/account")
@RestController
public class AccountController {

    @Value("${server.port}")
    private String port;

    @Value("${database.username}")
    private String username;

    @Value("${database.password}")
    private String password;


    @GetMapping("/{accountNumber}")
    public ResponseEntity<Object> getBalance(@PathVariable("accountNumber") long accountNumber){
        double balance = (Math.random()*12345) + accountNumber;
        balance = Math.ceil(balance);
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("account", accountNumber);
        map.put("balance", balance);
        map.put("port", port);
        map.put("username", username);
        map.put("password", password);
        return ResponseEntity.status(200).body(map);

    }
}
