# 13. BuildStep

## 学习目标

理解 Quarkus Extension 的最基本执行单元。

## 学习内容

```text
@BuildStep
BuildProducer<T>
BuildContext
conditional build step
execution ordering
```

## Spring 对照

可对照但不要等价：

```text
BeanFactoryPostProcessor
ImportSelector
AutoConfiguration
BeanDefinitionRegistryPostProcessor
```

## 核心问题

1. BuildStep 怎么被发现？
2. 谁调用 BuildStep？
3. BuildStep 为什么通常不需要 `@Order`？
4. BuildStep 怎样形成执行图？

## 必做实验

在自定义最小 Extension 中写两个 BuildStep，先不要做复杂功能，只观察调用。

## 文档产出

《BeanPostProcessor 思维切换：Quarkus BuildStep》
