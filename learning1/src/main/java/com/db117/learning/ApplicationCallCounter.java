package com.db117.learning;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.concurrent.atomic.AtomicLong;

/** 应用作用域计数器，用于观察 Bean 在多个请求间复用。 */
@ApplicationScoped
public class ApplicationCallCounter {

    private final AtomicLong count = new AtomicLong();

    public long next() {
        return count.incrementAndGet();
    }
}
