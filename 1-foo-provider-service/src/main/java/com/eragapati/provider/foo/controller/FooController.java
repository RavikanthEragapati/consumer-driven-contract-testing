package com.eragapati.provider.foo.controller;

import com.eragapati.provider.foo.model.FooResponse;
import com.eragapati.provider.foo.service.FooService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/foo/greeting", produces = MediaType.APPLICATION_JSON_VALUE)
public class FooController {

    private final FooService fooService;
    @GetMapping
    public Mono<FooResponse> fooGreetings(@RequestParam("id") UUID id) {
        log.info("received call for {}", id);
        return fooService.getFooService(id);
    }


}
