package hr.fer.rassus.lab.aggregatormicroservice.service;

public record ReadingDto(
        String name,
        String unit,
        Double value
) {}
