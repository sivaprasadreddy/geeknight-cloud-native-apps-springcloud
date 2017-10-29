package com.geeknight.catalogservice;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "catalog-service")
@Setter
@Getter
public class CatalogServiceConfig {
    private String corsMapping;
    private String corsAllowedOrigins;
}
