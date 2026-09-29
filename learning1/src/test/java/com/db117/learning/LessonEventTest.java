package com.db117.learning;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** 验证 CDI 发布的 LessonEvent 能被监听器接收。 */
@QuarkusTest
class LessonEventTest {

    @Inject
    Event<LessonEvent> events;

    @Inject
    LessonObserver observer;

    @Test
    void notifiesObserver() {
        LessonEvent event = new LessonEvent("测试事件");
        events.fire(event);

        assertEquals(event, observer.lastEvent());
    }
}
