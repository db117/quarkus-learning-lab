# 15. Quarkus Extension 架构

## 学习目标

理解 Extension 为什么不是“Quarkus Starter”。

## 结构

```text
learning-extension/
├── runtime/
└── deployment/
```

## 重点概念

```text
Processor
BuildStep
BuildItem
Feature
runtime config
build-time config
Synthetic Bean
Recorder
```

## Spring 对照

```text
Spring Boot Starter
        +
AutoConfiguration
        +
Conditional
        +
runtime bean registration
```

对比 Quarkus：

```text
Extension deployment
        ↓
build-time processing
        ↓
generated metadata/code
        ↓
Extension runtime
```

## 必做实验

创建最小 Extension：应用引入后在构建日志中看到自己的 Feature / BuildStep。

## 文档产出

《Spring Boot Starter vs Quarkus Extension》
