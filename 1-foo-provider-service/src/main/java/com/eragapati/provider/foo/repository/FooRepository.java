package com.eragapati.provider.foo.repository;

import com.eragapati.provider.foo.entity.FooGreeting;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface FooRepository extends R2dbcRepository<FooGreeting, UUID> {
}
