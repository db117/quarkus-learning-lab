package com.db117.learning;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

/** 使用 Producer 方法创建第三种问候服务。 */
@ApplicationScoped
public class GreetingFactory {

    @Produces
    @ApplicationScoped
    @GreetingType("produced")
    GreetingFormatter producedGreeting() {
        return name -> "Produced greeting, " + name;
    }
}
