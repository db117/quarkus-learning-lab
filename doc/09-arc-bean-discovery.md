# 09. ArC Bean Discovery 源码

## 学习目标

第一次系统跟 ArC 构建期源码。

## 建议源码入口

```text
ArcProcessor
BeanProcessor
BeanDeployment
BeanInfo
InjectionPointInfo
```

## 建议调用链

```text
ArcProcessor
   ↓
BeanProcessor
   ↓
BeanDeployment
   ↓
Bean Discovery
   ↓
Injection Point Resolution
   ↓
Validation
```

## Spring 对照

```text
ConfigurationClassPostProcessor
ClassPathBeanDefinitionScanner
BeanDefinitionRegistry
DefaultListableBeanFactory
```

## 必做实验

给一个 Bean 增删：

- Scope
- Qualifier
- Producer
- Injection point

分别 Debug / 日志观察构建期处理。

## 文档产出

《Spring BeanDefinition 注册 vs Quarkus ArC Bean Discovery》

## 完成标准

能够明确区分：

```text
Bean metadata discovery
Bean class generation
Bean instance creation
```
