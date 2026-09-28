## 构建流程

> 构建应用时，Quarkus 会执行各扩展的 BuildStep，通过 BuildItem 传递信息，并扫描应用类、发现和校验 CDI Bean。随后它生成
> Bean、代理和启动代码，把 Recorder 记录的初始化逻辑与应用类、依赖一起打包。
> 目的就是把尽可能多的工作提前到构建期完成，让应用启动更快，并尽早发现配置或依赖问题。

### 系列图

```mermaid
sequenceDiagram
    autonumber
    participant Maven as "Maven package 阶段"
    participant BuildMojo
    participant CuratedApplication
    participant AugmentActionImpl
    participant QuarkusAugmentor
    participant ExtensionLoader
    participant BuildChainBuilder
    participant BuildExecutionBuilder
    participant ApplicationIndexBuildStep
    participant CombinedIndexBuildStep
    participant ArcProcessor
    participant LifecycleEventsBuildStep
    participant ArcRecorder
    participant MainClassBuildStep
    Maven ->> BuildMojo: 触发构建目标：#doExecute()
    BuildMojo ->> CuratedApplication: 创建增强环境：#createAugmentor()
    CuratedApplication -->> BuildMojo: 返回 AugmentAction
    BuildMojo ->> AugmentActionImpl: 开始生产构建：#createProductionApplication()
    AugmentActionImpl ->> AugmentActionImpl: 进入增强流程：#runAugment()
    AugmentActionImpl ->> QuarkusAugmentor: 创建并运行增强器：builder().build().run()
    QuarkusAugmentor ->> ExtensionLoader: 加载扩展 BuildStep：#loadStepsFrom()
    ExtensionLoader -->> QuarkusAugmentor: 返回构建链配置
    QuarkusAugmentor ->> BuildChainBuilder: 注册 BuildStep 和 BuildItem 依赖
    QuarkusAugmentor ->> BuildChainBuilder: 构造依赖图：#build()
    BuildChainBuilder -->> QuarkusAugmentor: 依赖图构建完成
    QuarkusAugmentor ->> BuildExecutionBuilder: 创建执行器并提供初始 BuildItem
    QuarkusAugmentor ->> BuildExecutionBuilder: 启动构建链：#execute()
    BuildExecutionBuilder ->> ApplicationIndexBuildStep: 建立应用索引：#build()
    BuildExecutionBuilder ->> CombinedIndexBuildStep: 建立组合索引：#build()
    BuildExecutionBuilder ->> ArcProcessor: 1/6 创建 ArC 处理上下文：#initialize()
    BuildExecutionBuilder ->> ArcProcessor: 2/6 注册 Bean：#registerBeans()
    BuildExecutionBuilder ->> ArcProcessor: 3/6 注册合成 Observer：#registerSyntheticObservers()
    BuildExecutionBuilder ->> ArcProcessor: 4/6 校验 Bean 部署：#validate()
    BuildExecutionBuilder ->> ArcProcessor: 5/6 生成 Bean 资源：#generateResources()
    BuildExecutionBuilder ->> ArcProcessor: 6/6 记录容器初始化：#initializeContainer()
    ArcProcessor ->> ArcRecorder: 记录 initContainer() 调用
    Note over ArcProcessor, ArcRecorder: STATIC_INIT：记录初始化逻辑，构建期不启动运行时容器
    BuildExecutionBuilder ->> LifecycleEventsBuildStep: 记录启动事件：#startupEvent()
    LifecycleEventsBuildStep ->> ArcRecorder: 记录 handleLifecycleEvents() 调用
    Note over LifecycleEventsBuildStep, ArcRecorder: RUNTIME_INIT：应用运行时再触发 StartupEvent
    BuildExecutionBuilder ->> MainClassBuildStep: 生成应用类：#build()
    BuildExecutionBuilder ->> MainClassBuildStep: 生成主入口：#mainClassBuildStep()
    MainClassBuildStep -->> BuildExecutionBuilder: 生成 ApplicationImpl 和 GeneratedMain
    BuildExecutionBuilder -->> QuarkusAugmentor: 返回 BuildResult
    QuarkusAugmentor -->> AugmentActionImpl: 返回 BuildResult
    AugmentActionImpl -->> BuildMojo: 返回构建产物
    BuildMojo -->> Maven: Quarkus 构建完成
```

### 构建产物

```text
target/quarkus-app/
├── quarkus-run.jar                  # 启动入口
├── app/<应用名>.jar                  # 应用自身的类和资源
├── lib/
│   ├── boot/                         # 启动器依赖
│   └── main/                         # 应用运行时依赖
├── quarkus/
│   ├── generated-bytecode.jar        # Gizmo 生成的类和资源
│   └── transformed-bytecode.jar      # 有字节码转换时生成
└── quarkus-app.dat                   # 启动所需的应用/类路径元数据
```