package com.eragapati.producer.barconsumerservice.controller;

import com.eragapati.producer.barconsumerservice.model.FooClientResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static java.util.Objects.requireNonNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@AutoConfigureStubRunner(stubsMode = CLASSPATH, ids = "com.eragapati.producer:1-foo-provider-service:+:stubs:8090")
class BarControllerIntegrationTest {
        private WebTestClient webTestClient = WebTestClient
            .bindToServer()
            .baseUrl("http://localhost:8090")
            .build();
    @Test
    void test() {
        webTestClient.get()
                .uri(uriBuilder -> uriBuilder.path("/api/foo/greeting")
                        .queryParam("id","3ecbaa20-3157-49a7-b8bf-eeeca9170de4")
                        .build())
                .exchange().expectStatus().isOk()
                .expectBody().jsonPath("greeting").isEqualTo("Foo says - Hello");
    }


}