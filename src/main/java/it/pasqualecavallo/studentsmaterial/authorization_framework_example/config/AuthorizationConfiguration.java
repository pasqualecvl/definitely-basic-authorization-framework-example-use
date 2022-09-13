package it.pasqualecavallo.studentsmaterial.authorization_framework_example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import it.pasqualecavallo.studentsmaterial.authorization_framework.config.DefinitelyBasicAuthorizationFrameworkAutoconfiguration;

@Configuration
@Import(DefinitelyBasicAuthorizationFrameworkAutoconfiguration.class)
public class AuthorizationConfiguration {

}
