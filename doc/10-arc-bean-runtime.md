# 10. ArC Bean 生成、Context 与运行时创建

## 学习目标

理解“Build Time 已经处理 Bean”并不意味着“Build Time 已经创建业务对象实例”。

## 源码关注点

```text
BeanGenerator
ClientProxyGenerator
ComponentsProvider
ArcRecorder
ArcContainerImpl
Context
InjectableBean
```

## Spring 对照

从：

```text
AbstractAutowireCapableBeanFactory#doCreateBean
populateBean
initializeBean
```

切入比较。

## 核心问题

1. Bean metadata 何时产生？
2. 代理类何时产生？
3. Bean instance 何时真正创建？
4. Scope Context 如何保存对象？
5. Client Proxy 为什么存在？

## 文档产出

《Spring Bean 创建流程 vs ArC Bean Runtime》
