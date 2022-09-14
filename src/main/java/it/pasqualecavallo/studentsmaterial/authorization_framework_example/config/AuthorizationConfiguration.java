package it.pasqualecavallo.studentsmaterial.authorization_framework_example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import it.pasqualecavallo.studentsmaterial.authorization_framework.config.DefinitelyBasicAuthorizationFrameworkAutoconfiguration;
import it.pasqualecavallo.studentsmaterial.authorization_framework.security.ExclusionPatterEvaluator;

@Configuration
@Import(DefinitelyBasicAuthorizationFrameworkAutoconfiguration.class)
public class AuthorizationConfiguration {

	/**
	 * Allow the global exclusion pattern to work. 
	 * If you don't need this behavior, feel free not to create this bean.
	 * @see it.pasqualecavallo.studentsmaterial.authorization_framework.filter.DetectMethodHandlerFilter
	 * @return
	 */
	@Bean
	public ExclusionPatterEvaluator exclusionPatterEvaluator() {
		return new ExclusionPatterEvaluator().mustExcludeAntPathMatchers("/litterally-unfiltered", "/litterally-unfiltered/**");
	}
	
}
