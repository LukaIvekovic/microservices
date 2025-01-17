package hr.fer.rassus.lab.aggregatormicroservice.client;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "clients")
public record ClientsProperties(
        String temperatureServiceUrl,
        String humidityServiceUrl
) {
}
