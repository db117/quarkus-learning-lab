# 22. Quarkus Test

## 学习目标

理解 Quarkus Test 启动的是怎样的 Quarkus runtime。

## Spring 对照

```text
Spring TestContext
@SpringBootTest
MockMvc
@MockBean
```

Quarkus：

```text
@QuarkusTest
QuarkusTestExtension
RestAssured
TestProfile
InjectMock
```

## 必做实验

- REST integration test
- CDI injection in test
- mock bean
- profile
- native test（Native 章节再补）

## 源码入口

重点跟：

```text
QuarkusTestExtension
```

## 文档产出

《Spring TestContext vs Quarkus Test Runtime》
