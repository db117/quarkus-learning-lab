# 19. Quarkus REST 源码链路

## 学习目标

用真实 Extension 验证前面学习的 BuildStep / BuildItem / Jandex / generated code。

## Spring 对照

```text
DispatcherServlet
RequestMappingHandlerMapping
RequestMappingHandlerAdapter
HandlerMethod
```

## Quarkus 关注点

围绕下面问题追源码：

1. `@Path` 在什么时候被扫描？
2. `@GET` 的 metadata 在哪里形成？
3. build-time 生成了什么？
4. runtime 请求进来后还有多少扫描工作？
5. Vert.x 与 Quarkus REST 的边界在哪里？

## 建议阅读方式

不要试图一口气读完整个 Quarkus REST。

只跟一条：

```text
@Path("/api/topics")
@GET
```

从 build-time discovery 一直追到 runtime handler。

## 文档产出

《DispatcherServlet vs Quarkus REST：请求映射是如何建立的》
