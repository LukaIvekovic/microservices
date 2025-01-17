package hr.fer.rassus.lab.aggregatormicroservice.service;

import hr.fer.rassus.lab.aggregatormicroservice.TemperatureUnitProperties;
import hr.fer.rassus.lab.aggregatormicroservice.client.HumidityClient;
import hr.fer.rassus.lab.aggregatormicroservice.client.TemperatureClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AggregatorService {
    private final TemperatureUnitProperties temperatureUnitProperties;

    private final TemperatureClient temperatureClient;
    private final HumidityClient humidityClient;

    public List<ReadingDto> fetchAggregateReadings() {
        log.debug("Fetching aggregate readings");

        ReadingDto temperatureReading = temperatureClient.fetchTemperature();
        ReadingDto humidityReading = humidityClient.fetchHumidity();

        log.debug("Fetched readings: temperature={}, humidity={}", temperatureReading, humidityReading);

        return List.of(humidityReading, convertTemperature(temperatureReading));
    }

    private ReadingDto convertTemperature(ReadingDto currentTemp) {
        var requiredUnit = temperatureUnitProperties.unit();
        var currentUnit = TemperatureUnit.fromString(currentTemp.unit());

        var convertedValue = TemperatureUnit.covertValue(currentTemp.value(), currentUnit, requiredUnit);

        log.debug("Converted temperature from {} to {}: {} -> {}", currentUnit, requiredUnit, currentTemp.value(), convertedValue);

        return new ReadingDto(ReadingType.TEMPERATURE.name(), requiredUnit.getUnit(), convertedValue);
    }
}
