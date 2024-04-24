package com.npci.asyncdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/sync", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getSync(){
        return ResponseEntity.status(200).body(userService.getUsersSync());
    }

    @GetMapping(path = "/async", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseEntity<Object> getAsync(){
        return ResponseEntity.status(200).body(userService.getUsersAsync());
    }
}
