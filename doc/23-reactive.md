# 23. Vert.x / Mutiny / Reactive

## 学习目标

最后再进入 Reactive，避免把 Quarkus 错误理解成“Reactive 框架”。

## 学习顺序

```text
Vert.x
 ↓
Event Loop
 ↓
Worker Thread
 ↓
blocking / non-blocking
 ↓
Mutiny
 ↓
Uni / Multi
 ↓
Quarkus REST
```

## Spring 对照

```text
Spring MVC          blocking REST
Spring WebFlux      reactive REST
Reactor Mono        Mutiny Uni
Reactor Flux        Mutiny Multi
Netty               Vert.x runtime model（不是简单一一等价）
```

## 必做实验

同一个 API 分别写：

```text
同步返回
Uni<T>
```

记录处理线程，并加入一个 blocking 操作观察差别。

## 文档产出

《Spring WebFlux / Reactor vs Vert.x / Mutiny》
