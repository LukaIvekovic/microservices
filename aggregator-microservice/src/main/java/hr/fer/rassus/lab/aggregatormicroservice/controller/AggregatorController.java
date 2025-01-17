package hr.fer.rassus.lab.aggregatormicroservice.controller;

import hr.fer.rassus.lab.aggregatormicroservice.service.ReadingDto;
import hr.fer.rassus.lab.aggregatormicroservice.service.AggregatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AggregatorController {
    private final AggregatorService aggregatorService;

    @GetMapping("/readings")
    public ResponseEntity<List<ReadingDto>> getReadings() {
        log.info("Fetching readings");

        var readings = aggregatorService.fetchAggregateReadings();

        log.info("Fetched readings: {}", readings);

        return ResponseEntity.ok(readings);
    }
}
