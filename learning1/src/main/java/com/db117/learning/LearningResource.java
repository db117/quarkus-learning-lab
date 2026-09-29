package com.db117.learning;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.Map;

/** 汇总 CDI、配置和拦截器示例的 REST 入口。 */
@Path("/learning")
@ApplicationScoped
public class LearningResource {

    @Inject
    LearningService learningService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> learn() {
        return learningService.summary();
    }
}
