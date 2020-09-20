package com.lockdown.learning.questionservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "application", ignoreInvalidFields = true)
@Configuration
public class ApplicationConfiguration {
}
