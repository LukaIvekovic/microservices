package hr.fer.rassus.lab.aggregatormicroservice.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ReadingType {
    TEMPERATURE("Temperature"),
    HUMIDITY("Humidity");

    private final String name;
}
