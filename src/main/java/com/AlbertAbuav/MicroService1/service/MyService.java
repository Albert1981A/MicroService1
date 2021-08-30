package com.AlbertAbuav.MicroService1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class MyService {

    @Autowired
    private RestTemplate restTemplate;

    public void blockingOperation(int number){
        restTemplate.postForEntity("http://localhost:8082/log?number=" + number, null, String.class);
    }

    @Async
    public CompletableFuture nonBlockingOperation(int number){
        return CompletableFuture.supplyAsync(() -> restTemplate.postForEntity("http://localhost:8082/log?number=" + number, null, String.class));
    }
}
