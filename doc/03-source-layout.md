# 03. Quarkus 源码仓库与模块结构

## 学习目标

在正式跟源码前建立源码地图。

重点识别：

```text
quarkus/
├── core/
├── extensions/
├── independent-projects/
├── test-framework/
├── devtools/
└── integration-tests/
```

## 核心概念

重点观察 Extension 常见结构：

```text
xxx-extension/
├── runtime/
└── deployment/
```

理解：

- `deployment`：构建期逻辑
- `runtime`：最终应用运行时需要保留的部分

## Spring 对照

对比 Spring Boot 中：

```text
starter
spring-boot-autoconfigure
runtime library
```

但不要简单认为两者等价。

## 必做实验

在 Quarkus 源码中找到：

- ArC Extension
- Quarkus REST Extension
- 一个简单 Extension 的 runtime / deployment 模块

## 文档产出

《Quarkus 源码目录导读》
