# 学习项目设计

## 项目目标

整个学习过程只维护一个仓库，通过不断演进同一个应用理解 Quarkus。

建议应用做成一个很小的 **Learning Service**：

```text
/api/topics
/api/lessons
/api/progress
/api/system
```

数据先保存在内存中，不引入数据库和 ORM。

## 初始结构

```text
quarkus-learning-lab/
├── README.md
├── docs/
└── app/
    ├── pom.xml
    └── src/
```

## 后期结构

学到 Extension 后演进为：

```text
quarkus-learning-lab/
├── docs/
├── app/
└── extensions/
    └── learning-extension/
        ├── runtime/
        ├── deployment/
        └── integration-tests/
```

## 约束

整个项目遵守下面几个约束：

1. 不使用 `quarkus-spring-*` 兼容扩展。
2. 不使用 Hibernate / Panache。
3. 优先使用 Jakarta / CDI / MicroProfile / Quarkus 原生 API。
4. 每个功能先完成使用，再跟源码。
5. Spring 代码只用于对照，不把 Spring 依赖放入项目。
6. 每章单独提交 Git commit，方便回溯。

## 建议 Git 标签

```text
phase-0-baseline
phase-1-app
phase-2-arc
phase-3-build-time
phase-4-runtime
phase-5-native
phase-6-extension
```
