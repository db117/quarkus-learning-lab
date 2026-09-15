# 07. CDI Interceptor 与 Event 使用

## 学习目标

在进入 ArC 源码前，先通过实际代码掌握 Interceptor 与 Event。

## 实践

实现自定义注解：

```java
@Timed
```

让被标记的方法自动统计耗时。

再实现：

```text
LessonStartedEvent
LessonCompletedEvent
```

## Spring 对照

```text
Spring AOP / MethodInterceptor
ApplicationEventPublisher
@EventListener
```

## 必做实验

- Interceptor Binding
- `@AroundInvoke`
- Priority
- synchronous event
- observer

## 文档产出

《Spring AOP / Event 与 CDI Interceptor / Event 对照》
