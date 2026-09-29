package com.db117.learning;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Map;

/** 读取当前生效的配置，便于跟踪配置映射和注入。 */
@ApplicationScoped
public class ConfigProbe {

    @Inject
    GreetingConfig config;

    public Map<String, String> snapshot() {
        return Map.of(
                "message", config.message(),
                "locale", config.locale(),
                "suffix", config.suffix().orElse("未配置"));
    }
}
