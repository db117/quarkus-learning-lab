# 08. Spring IoC vs CDI：容器模型

## 学习目标

从“使用层”进入“容器模型层”。

## Spring 已有知识复习

建议结合自己的 Spring 文档复习：

```text
BeanDefinitionRegistry
ConfigurationClassPostProcessor
DefaultListableBeanFactory
AbstractAutowireCapableBeanFactory
BeanPostProcessor
```

## Quarkus / CDI 对照

研究概念：

```text
BeanInfo
InjectionPointInfo
ScopeInfo
InterceptorInfo
ObserverInfo
BeanDeployment
```

## 核心问题

1. Spring 为什么需要 BeanDefinition？
2. CDI Bean metadata 与 BeanDefinition 有何不同？
3. Spring 的容器组装发生在哪个阶段？
4. Quarkus 为什么要提前完成大量 Bean 分析？

## 文档产出

《Spring BeanDefinition vs CDI Bean Model》
