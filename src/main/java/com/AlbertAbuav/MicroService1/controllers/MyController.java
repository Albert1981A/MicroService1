package com.AlbertAbuav.MicroService1.controllers;

import com.AlbertAbuav.MicroService1.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private MyService myService;

    @GetMapping("num/block")
    public int blocking() {
        int number = (int)(Math.random()*101);
        myService.blockingOperation(number);
        return number;
    }

    @GetMapping("num/nun-block")
    public int nunBlocking() {
        int number = (int)(Math.random()*101);
        myService.nonBlockingOperation(number);
        return number;
    }
}
