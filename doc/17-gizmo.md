# 17. Gizmo：Build-time Bytecode Generation

## 学习目标

理解 Quarkus 为什么频繁“生成类”，而不是在 runtime 动态拼装行为。

## 学习内容

```text
ClassCreator
MethodCreator
ResultHandle
BytecodeCreator
generated classes
```

## Spring 对照

```text
JDK Proxy
CGLIB
ASM
Byte Buddy（生态中常见）
```

## 必做实验

使用 Gizmo 构建期生成一个类：

```text
GeneratedLearningRegistry
```

它能返回 Jandex 扫描到的 `@LearningService` 类名列表。

## 文档产出

《Runtime Proxy vs Build-time Bytecode：Quarkus Gizmo》

## 完成标准

能够解释代码生成与 Reflection configuration 之间的关系。
