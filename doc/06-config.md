# 06. Quarkus Configuration

## 学习目标

理解 SmallRye Config，并提前建立 Build Time Config / Runtime Config 概念。

## Spring 对照

```text
Environment              Config
@Value                   @ConfigProperty
@ConfigurationProperties @ConfigMapping
Profile                   %dev / %test / %prod
```

## 必做实验

- ConfigMapping
- 默认值
- Optional
- Profile
- 环境变量覆盖
- 测试配置

## 重点问题

为什么某些 Quarkus 配置在打包后无法通过 runtime 配置改变？

这个问题暂时不要求源码级回答，后续 Extension 章节重新回答。

## 文档产出

《Spring Configuration vs Quarkus SmallRye Config》
