package com.db117.learning;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/** 内存版 REST CRUD 示例，展示路由、校验和响应处理。 */
@Path("/topics")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
public class TopicResource {

    private final Map<Long, Topic> topics = new ConcurrentHashMap<>();
    private final AtomicLong ids = new AtomicLong();

    @GET
    public Response list() {
        return Response.ok(topics.values()).build();
    }

    @GET
    @Path("/{id}")
    public Topic get(@PathParam("id") long id) {
        return require(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@Valid TopicRequest request) {
        long id = ids.incrementAndGet();
        Topic topic = new Topic(id, request.title);
        topics.put(id, topic);
        return Response.created(URI.create("/topics/" + id))
                .header("X-Study-Chapter", "04")
                .entity(topic)
                .build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Topic update(@PathParam("id") long id, @Valid TopicRequest request) {
        require(id);
        Topic updated = new Topic(id, request.title);
        topics.put(id, updated);
        return updated;
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") long id) {
        if (topics.remove(id) == null) {
            throw new TopicNotFoundException(id);
        }
    }

    private Topic require(long id) {
        Topic topic = topics.get(id);
        if (topic == null) {
            throw new TopicNotFoundException(id);
        }
        return topic;
    }

    /** REST 返回的主题数据。 */
    public record Topic(long id, String title) {
    }
}
