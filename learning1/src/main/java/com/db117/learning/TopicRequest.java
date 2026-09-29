package com.db117.learning;

import jakarta.validation.constraints.NotBlank;

/** REST 写入请求体，title 用于演示 Bean Validation。 */
public class TopicRequest {

    @NotBlank
    public String title;
}
