package hr.fer.rassus.lab.humiditymicroservice.service;

public record HumidityDto(
        String name,
        String unit,
        Double value
) {
    private static final String NAME = "Humidity";
    private static final String UNIT = "%";

    public static HumidityDto fromValue(Double value) {
        return new HumidityDto(NAME, UNIT, value);
    }
}
