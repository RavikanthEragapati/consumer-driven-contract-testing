package com.eragapati.provider.foo.model;

import jakarta.validation.constraints.Pattern;

import java.util.UUID;

import static com.eragapati.provider.foo.util.FooConstants.*;

public record FooResponse(@Pattern(regexp = UUID_REGEXP) UUID id,
                          @Pattern(regexp = ALPHA_NUMERIC_UNDERSCORE_REGEXP) String greeting,
                          @Pattern(regexp = ALPHA_NUMERIC_REGEXP) String fromService,
                          @Pattern(regexp = ALPHA_NUMERIC_REGEXP) String toService) {
}
