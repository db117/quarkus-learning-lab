package com.db117.learning;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.Map;

/** 将主题不存在异常转换为 JSON 404 响应。 */
@Provider
public class TopicNotFoundMapper implements ExceptionMapper<TopicNotFoundException> {

    @Override
    public Response toResponse(TopicNotFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND)
                .type(MediaType.APPLICATION_JSON)
                .entity(Map.of("error", exception.getMessage()))
                .build();
    }
}
