# 26. 总结：Spring Boot vs Quarkus 架构

## 目标

不再看局部 API，重新回答最初的问题：

> Spring Boot 与 Quarkus 的核心架构差异到底是什么？

## 最终对照表

| 能力          | Spring                      | Quarkus                        |
|---------------|-----------------------------|--------------------------------|
| DI            | Spring IoC                  | CDI / ArC                      |
| Bean Metadata | BeanDefinition              | BeanInfo / build-time metadata |
| Bootstrap     | Runtime 为主                | Build Time + Runtime           |
| 扩展          | BeanFactory/BPP/AutoConfig  | BuildStep                      |
| 构建依赖      | Order / lifecycle           | BuildItem DAG                  |
| 扫描          | Startup/runtime             | Jandex / augmentation          |
| 代理/增强     | Runtime Proxy 较多          | Build-time generation 较多     |
| AOP           | Spring AOP                  | CDI Interceptor / ArC          |
| 自动配置      | AutoConfiguration           | Extension                      |
| Web           | DispatcherServlet / WebFlux | Quarkus REST / Vert.x          |
| 开发模式      | DevTools                    | Dev Mode                       |
| 外部服务      | Testcontainers 等           | Dev Services                   |
| Reactive      | Reactor                     | Mutiny                         |
| Native        | Spring AOT                  | 原生 build-time architecture   |

## 最终必须回答的 10 个问题

1. Quarkus 为什么强调 build time？
2. Augmentation 到底做了什么？
3. ArC 与 Spring BeanFactory 最大的结构差异是什么？
4. Bean Discovery 与 Bean Instance Creation 为什么要区分？
5. BuildStep 为什么不是 BeanPostProcessor？
6. BuildItem 为什么能决定 BuildStep 的执行关系？
7. Extension 为什么不是 Starter？
8. Jandex / Gizmo / Recorder 各自解决什么问题？
9. 为什么 Quarkus 的 Native Image 支持相对自然？
10. 哪些场景下 Spring Boot 反而更合适？

如果不能独立回答，回到对应章节补实验，而不是继续看新内容。

## 最终文档

《Spring Boot 与 Quarkus：Runtime Framework 与 Build-time Framework 的架构对比》
