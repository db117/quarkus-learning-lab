# 04. Quarkus REST 基础

## 学习目标

只学习足够支撑后续源码实验的 REST API。

## Spring 对照

```text
@RestController        @Path
@GetMapping            @GET
@PostMapping           @POST
@PathVariable          @PathParam
@RequestParam          @QueryParam
ResponseEntity         Response
@ControllerAdvice      ExceptionMapper
```

## 实践

实现：

```text
GET    /api/topics
GET    /api/topics/{id}
POST   /api/topics
DELETE /api/topics/{id}
```

暂时使用内存 Map。

## 必做实验

- JSON 序列化
- Validation
- ExceptionMapper
- Request/Response headers

## 文档产出

《Spring MVC → Quarkus REST 快速迁移》

## 完成标准

可以不依赖 Spring 兼容层实现完整 REST CRUD。
