package com.eragapati.producer.barconsumerservice.controller;

import com.eragapati.producer.barconsumerservice.client.webclient.FooClient;
import com.eragapati.producer.barconsumerservice.model.BarResponse;
import com.eragapati.producer.barconsumerservice.service.BarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping(path = "/api/bar/greeting", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class BarController {

    private final BarService barService;
    private final FooClient fooClient;

    @GetMapping
    public Mono<BarResponse> barGreetings(){
        log.info("Calling Provider Foo");
        return fooClient.getFooResponse("Bar says Hi", "BarService")
                .flatMap(fooResponse -> Mono.just(new BarResponse(fooResponse.id(), fooResponse.greeting())));
    }
}
