# 12. Quarkus Bootstrap 与 Augmentation

## 学习目标

建立 Quarkus 最核心的执行阶段模型。

## Spring 启动模型

```text
main
 ↓
SpringApplication.run
 ↓
ApplicationContext
 ↓
refresh
 ↓
scan / BeanFactory / bean creation
 ↓
ready
```

## Quarkus 模型

```text
Build
 ↓
Augmentation
 ↓
Extension processing
 ↓
Build Steps
 ↓
metadata analysis / generated code
 ↓
application artifact

Runtime
 ↓
static init / runtime init
 ↓
ready
```

## 源码入口候选

```text
QuarkusAugmentor
ExtensionLoader
AugmentActionImpl
StartupActionImpl
GeneratedMain
ApplicationImpl
```

## 必做实验

分别跟踪：

- `quarkus:dev`
- `mvn package`
- 打包后 `java -jar`

记录三者路径哪里相同、哪里不同。

## 文档产出

《Spring Boot 启动流程 vs Quarkus Bootstrap》
