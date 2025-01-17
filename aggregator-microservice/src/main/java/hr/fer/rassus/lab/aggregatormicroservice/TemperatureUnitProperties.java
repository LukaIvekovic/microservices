package hr.fer.rassus.lab.aggregatormicroservice;

import hr.fer.rassus.lab.aggregatormicroservice.service.TemperatureUnit;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "temperature-unit")
public record TemperatureUnitProperties(
        TemperatureUnit unit
) {
}
