package com.db117.learning;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Map;

/** 组合配置、限定符、作用域和事件示例，供运行时跟踪。 */
@ApplicationScoped
public class LearningService {

    @Inject
    ConfigProbe config;

    @Inject
    @GreetingType("friendly")
    GreetingFormatter friendly;

    @Inject
    @GreetingType("formal")
    GreetingFormatter formal;

    @Inject
    @GreetingType("produced")
    GreetingFormatter produced;

    @Inject
    RequestInfo requestInfo;

    @Inject
    ApplicationCallCounter callCounter;

    @Inject
    Event<LessonEvent> events;

    @Trace
    public Map<String, Object> summary() {
        events.fire(new LessonEvent("开始"));
        try {
            return Map.of(
                    "config", config.snapshot(),
                    "greetings", List.of(
                            friendly.greet("Quarkus"),
                            formal.greet("Quarkus"),
                            produced.greet("Quarkus")),
                    "requestId", requestInfo.id(),
                    "applicationCall", callCounter.next());
        } finally {
            events.fire(new LessonEvent("完成"));
        }
    }
}
