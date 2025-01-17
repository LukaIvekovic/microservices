package hr.fer.rassus.lab.aggregatormicroservice.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TemperatureUnit {
    KELVIN("K"),
    CELSIUS("C");

    private final String unit;

    public static TemperatureUnit fromString(String unit) {
        for (TemperatureUnit temperatureUnit : TemperatureUnit.values()) {
            if (temperatureUnit.unit.equalsIgnoreCase(unit)) {
                return temperatureUnit;
            }
        }
        throw new IllegalArgumentException("Unknown temperature unit: " + unit);
    }

    public static Double covertValue(Double value, TemperatureUnit from, TemperatureUnit to) {
        if (from == to) {
            return value;
        }

        if (from == CELSIUS && to == KELVIN) {
            return value + 273.15;
        }

        if (from == KELVIN && to == CELSIUS) {
            return value - 273.15;
        }

        throw new IllegalArgumentException("Cannot convert from " + from + " to " + to);
    }
}
