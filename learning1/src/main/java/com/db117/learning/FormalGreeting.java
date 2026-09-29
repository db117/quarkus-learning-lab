package com.db117.learning;

import jakarta.enterprise.context.ApplicationScoped;

/** 使用 formal 限定符的正式问候服务。 */
@ApplicationScoped
@GreetingType("formal")
public class FormalGreeting implements GreetingFormatter {

    @Override
    public String greet(String name) {
        return "Welcome, " + name;
    }
}
