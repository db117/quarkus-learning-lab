# 24. Native Image：把前面的知识串起来

## 学习目标

不是学习一个 `-Dnative` 参数，而是解释 Quarkus 为什么天然适合 Native Image。

## 知识链

```text
Jandex
  +
BuildStep
  +
BuildItem
  +
Gizmo
  +
Recorder
  +
Build-time initialization
        ↓
减少 runtime dynamic behavior
        ↓
GraalVM Native Image
```

## Spring 对照

```text
Spring Runtime Model
        ↓
Spring AOT
        ↓
Native Image
```

对比 Quarkus 从一开始就围绕 build-time augmentation 设计。

## 必做实验

1. JVM package。
2. Native package。
3. 比较构建时间。
4. 比较启动时间。
5. 比较 RSS。
6. 为自定义 Extension 做 native 验证。
7. 故意加入 reflection 场景，观察 Native Image 问题并修复。

## 文档产出

《Spring AOT vs Quarkus Build-time Architecture》
