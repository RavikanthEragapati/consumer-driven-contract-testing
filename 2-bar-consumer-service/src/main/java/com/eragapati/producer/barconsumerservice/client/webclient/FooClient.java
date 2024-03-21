package com.eragapati.producer.barconsumerservice.client.webclient;

import com.eragapati.producer.barconsumerservice.model.FooClientResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class FooClient {

    private WebClient fooWebClient;
    public FooClient(WebClient.Builder webClientBuilder){
        this.fooWebClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }

    public Mono<FooClientResponse> getFooResponse(String message, String from){
        return fooWebClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/foo/greeting")
                        .queryParam("message", message)
                        .queryParam("from", from)
                        .build())
                .retrieve()
                .bodyToMono(FooClientResponse.class);
    }
}
