package com.restapi.test_rest_api.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class person {

    private final UUID id;
    @NotBlank
    private final String name;

    public person(@JsonProperty("id") UUID id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
