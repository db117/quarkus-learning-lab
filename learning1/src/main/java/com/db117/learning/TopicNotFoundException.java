package com.db117.learning;

/** 表示主题不存在，由 TopicNotFoundMapper 转换为 404 响应。 */
public class TopicNotFoundException extends RuntimeException {

    public TopicNotFoundException(long id) {
        super("Topic not found: " + id);
    }
}
