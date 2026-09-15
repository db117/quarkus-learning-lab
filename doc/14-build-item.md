# 14. BuildItem 与构建依赖图

## 学习目标

理解 Quarkus Build Chain 的数据流模型。

## 学习内容

```text
BuildItem
SimpleBuildItem
MultiBuildItem
BuildProducer<T>
consume / produce
Build Chain DAG
```

## 思维模型

```text
BuildStep A
  │ produce FooBuildItem
  ▼
BuildStep B
  │ consume FooBuildItem
  │ produce BarBuildItem
  ▼
BuildStep C
```

## Spring 对照

比较：

```text
@Order
Ordered
@DependsOn
Lifecycle
```

Spring 更常围绕对象和生命周期排序；Quarkus 构建期更强调 **产物依赖**。

## 必做实验

设计三个 BuildStep，只通过 BuildItem 建立执行依赖，不显式排序。

## 文档产出

《Quarkus BuildItem：用数据依赖组织构建流程》
