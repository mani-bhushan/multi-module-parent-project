package com.apps.org.custom.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.apps.org.entity.generators.AuditorAwareGenerator;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class JpaConfig {

	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditorAwareGenerator();
	}

}