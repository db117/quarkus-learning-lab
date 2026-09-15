# 附录 A：源码阅读记录模板

复制这份模板到每个源码章节中使用。

```markdown
# 主题

## 1. 问题

这次准备回答什么？

## 2. 最小示例

给出触发该机制的最小代码。

## 3. Spring 对照

### 入口

### 核心类

### 调用链

## 4. Quarkus 源码入口

### 模块

### 核心类

### 关键方法

## 5. 调用链

```text
A
 ↓
B
 ↓
C
```

## 6. Build Time / Runtime 边界

哪些事情发生在 build time？
哪些事情发生在 runtime？

## 7. 生成了什么

- class
- metadata
- resource
- configuration

## 8. Spring vs Quarkus

画一张对比图。

## 9. 为什么

为什么 Quarkus 不沿用 Spring 的实现方式？

## 10. 结论

用 3～5 条总结这一机制。

```
