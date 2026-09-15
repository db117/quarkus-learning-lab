# 05. CDI 基础

## 学习目标

把 Spring IoC 的已有知识映射到 CDI，而不是只记注解。

## 学习内容

```text
Bean
Scope
Context
Qualifier
Injection Point
Producer
Alternative
Instance<T>
Observer
Interceptor
```

## Spring 对照

```text
@Component/@Service       @ApplicationScoped 等
@Autowired                @Inject
@Bean                     @Produces
@Qualifier                @Qualifier
@Primary                  Alternative / Priority / Qualifier 组合
ApplicationEvent          CDI Event
```

## 必做实验

1. constructor injection
2. qualifier 注入两个实现
3. producer 创建对象
4. CDI Event
5. request scope 与 application scope 对比

## 文档产出

《Spring IoC 开发者快速理解 CDI》

## 完成标准

能解释 Bean、Scope、Context 是三个不同概念。
