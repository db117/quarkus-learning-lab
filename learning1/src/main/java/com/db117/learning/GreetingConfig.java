package com.db117.learning;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;

import java.util.Optional;

/** 映射 greeting 配置，展示默认值和可选配置项。 */
@ConfigMapping(prefix = "greeting")
public interface GreetingConfig {

    @WithDefault("hello from Quarkus")
    String message();

    @WithDefault("zh-CN")
    String locale();

    Optional<String> suffix();
}
