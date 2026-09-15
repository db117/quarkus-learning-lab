# 16. Jandex：构建期元数据索引

## 学习目标

理解 Quarkus 为什么可以避免在运行期大量 ClassPath 扫描与 Reflection。

## 学习内容

```text
Index
IndexView
ClassInfo
MethodInfo
FieldInfo
AnnotationInstance
DotName
```

## Spring 对照

```text
ClassPathScanningCandidateComponentProvider
MetadataReader
ASM
Reflection
```

## 必做实验

自定义：

```java
@LearningService
```

使用 Jandex 在 BuildStep 中找到所有标记类，并打印：

- class
- methods
- annotations

## 文档产出

《Spring ClassPath Scan vs Quarkus Jandex》
