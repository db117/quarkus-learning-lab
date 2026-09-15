# 25. 毕业项目：完整实现一个 Quarkus Extension

## 目标

实现：

```text
quarkus-learning-extension
```

应用只需要写：

```java
@LearningService("java")
public class JavaLearningService {
}
```

Extension 自动完成：

```text
Jandex
  ↓
扫描 @LearningService
  ↓
BuildStep
  ↓
BuildItem
  ↓
校验重复 name
  ↓
Gizmo / Synthetic Bean
  ↓
Recorder
  ↓
Runtime LearningRegistry
```

最终应用可访问：

```text
GET /api/system/learning-services
```

查看 Extension 自动注册的服务。

## 必须用到

- runtime / deployment 分离
- `@BuildStep`
- `BuildItem`
- Jandex
- Synthetic Bean 或 Bean registration
- Gizmo（至少一个小场景）
- Recorder
- Config
- Integration Test
- Native Image Test

## 禁止

- 在 runtime 做 classpath scan
- 用 reflection 偷懒替代 Jandex / generated code
- 把所有逻辑塞进 runtime module

## Spring 对照

设想如果用 Spring Boot 实现相同功能，会使用：

```text
Starter
AutoConfiguration
ClassPath Scan
BeanDefinitionRegistryPostProcessor
BeanPostProcessor
Runtime proxy / reflection
```

最后把两种设计完整对比。

## 文档产出

《从零实现 Quarkus Extension》
