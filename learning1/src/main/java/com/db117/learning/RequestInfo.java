package com.db117.learning;

import jakarta.enterprise.context.RequestScoped;

import java.util.UUID;

/** 请求级 Bean，每个 HTTP 请求持有独立 ID。 */
@RequestScoped
public class RequestInfo {

    private final String id = UUID.randomUUID().toString();

    public String id() {
        return id;
    }
}
