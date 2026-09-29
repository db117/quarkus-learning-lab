package com.db117.learning;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

/** 观察 LessonEvent，便于跟踪 CDI 事件分发。 */
@ApplicationScoped
public class LessonObserver {

    private volatile LessonEvent lastEvent;

    public void onLesson(@Observes LessonEvent event) {
        lastEvent = event;
        System.out.println("Observed event: " + event.name());
    }

    public LessonEvent lastEvent() {
        return lastEvent;
    }
}
