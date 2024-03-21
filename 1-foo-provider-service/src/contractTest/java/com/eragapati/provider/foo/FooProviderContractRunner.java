package com.eragapati.provider.foo;

import com.eragapati.provider.foo.controller.FooController;
import com.eragapati.provider.foo.entity.FooGreeting;
import com.eragapati.provider.foo.repository.FooRepository;
import io.restassured.module.webtestclient.RestAssuredWebTestClient;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.AutoConfigureDataR2dbc;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebFluxTest(value = FooController.class)
@AutoConfigureDataR2dbc
public class FooProviderContractRunner {

    @MockBean
    FooRepository fooRepository;

    @Autowired
    FooController fooController;

    @BeforeEach
    public void setup() {
        RestAssuredWebTestClient.standaloneSetup(fooController);

        // Note: We always mocked outbound calls such as database or http call,
        // not the logic inside our controller or service class

        // This is intentional we want the data returned by these stubs
        // should go through the application logic and generate the end response

        // This way we make sure when we accidentally change the contract.
        when(fooRepository.findById(any(UUID.class)))
                .thenReturn(Mono.just(
                        new FooGreeting(UUID.fromString("3ecbaa20-3157-49a7-b8bf-eeeca9170de4"),
                                "Foo says - Hello",
                                "FooService",
                                "BarService")
                ));
    }
}
