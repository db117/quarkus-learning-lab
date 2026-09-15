# 21. Dev Services

## 学习目标

理解 Quarkus 如何让 Extension 在开发/测试阶段自动提供外部依赖服务。

> 本路线不使用数据库，因此不要用 PostgreSQL 作为主例子。

## 推荐实验对象

可任选一个：

- Keycloak / OIDC
- Kafka
- Redis

只需要一个即可。

## Spring 对照

```text
Testcontainers
@ServiceConnection
手工 Docker Compose
```

## 核心问题

1. 谁决定启动 Dev Service？
2. 为什么它只在 dev/test 运行？
3. Dev Service 生成的配置如何进入应用？

## 文档产出

《Quarkus Dev Services 的 Extension 驱动模型》
