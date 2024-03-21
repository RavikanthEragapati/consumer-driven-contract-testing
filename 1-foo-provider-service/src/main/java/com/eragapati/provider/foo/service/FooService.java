package com.eragapati.provider.foo.service;

import com.eragapati.provider.foo.model.FooResponse;
import com.eragapati.provider.foo.repository.FooRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FooService {
    private final  FooRepository fooRepository;
    public Mono<FooResponse> getFooService(UUID id) {
        return fooRepository.findById(id)
                .flatMap(data ->  Mono.just(new FooResponse(data.getId(), data.getGreeting(), data.getSource(), data.getDest())));
    }
}
