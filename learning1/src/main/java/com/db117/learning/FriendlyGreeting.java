package com.db117.learning;

import jakarta.enterprise.context.ApplicationScoped;

/** 使用 friendly 限定符的亲切问候服务。 */
@ApplicationScoped
@GreetingType("friendly")
public class FriendlyGreeting implements GreetingFormatter {

    @Override
    public String greet(String name) {
        return "Hi, " + name;
    }
}
