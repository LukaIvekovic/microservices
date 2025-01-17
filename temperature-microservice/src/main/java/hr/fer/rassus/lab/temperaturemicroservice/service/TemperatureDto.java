package hr.fer.rassus.lab.temperaturemicroservice.service;

public record TemperatureDto(
        String name,
        String unit,
        Double value
) {
    private static final String NAME = "Temperature";
    private static final String UNIT = "C";

    public static TemperatureDto fromValue(Double value) {
        return new TemperatureDto(NAME, UNIT, value);
    }
}
