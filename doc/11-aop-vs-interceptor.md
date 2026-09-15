# 11. Spring AOP vs CDI / ArC Interceptor 源码

## 学习目标

把已有 Spring AOP 源码知识直接迁移过来做架构比较。

## Spring 对照主线

```text
AnnotationAwareAspectJAutoProxyCreator
Advisor
ProxyFactory
JdkDynamicAopProxy / CGLIB
DefaultAdvisorChainFactory
ReflectiveMethodInvocation
```

## Quarkus 关注点

```text
Interceptor Binding metadata
InterceptorInfo
build-time resolution
Subclass generation
Invocation chain
```

## 核心问题

为什么 Spring 大量依赖 Runtime Proxy，而 Quarkus 更愿意在构建期生成需要的类？

## 必做实验

对第 07 章的 `@Timed`：

1. 找到构建期识别位置。
2. 找到生成代码。
3. 找到 runtime invocation。
4. 与 Spring `MethodInterceptor` 调用链画对比图。

## 文档产出

《Spring AOP Proxy vs Quarkus ArC Interceptor》
