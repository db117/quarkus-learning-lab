package com.db117.learning;

/** 问候服务接口，由多个带限定符的 CDI Bean 实现。 */
public interface GreetingFormatter {
    String greet(String name);
}
