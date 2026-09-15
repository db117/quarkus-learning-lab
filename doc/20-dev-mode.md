# 20. Dev Mode / Live Reload 源码与 ClassLoader

## 学习目标

理解 `quarkus dev` 为什么与普通 JVM 启动差别很大。

## 学习内容

```text
Dev Mode
ClassLoader hierarchy
reload
restart context
changed classes
Continuous Testing
Dev UI
```

## Spring 对照

```text
Spring Boot DevTools
RestartClassLoader
ApplicationContext restart
```

## 必做实验

分别修改：

- REST 方法体
- CDI Bean
- 配置
- Extension deployment 代码（后期）

记录每类修改触发什么级别的 reload。

## 文档产出

《Spring Boot DevTools vs Quarkus Dev Mode》
