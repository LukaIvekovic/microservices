package hr.fer.rassus.lab.temperaturemicroservice.controller;

import hr.fer.rassus.lab.temperaturemicroservice.service.TemperatureDto;
import hr.fer.rassus.lab.temperaturemicroservice.service.TemperatureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TemperatureController {
    private final TemperatureService temperatureService;

    @GetMapping("/temperature")
    public ResponseEntity<TemperatureDto> getTemperature() {
        try {
            log.info("Received request for temperature reading.");

            var temperature = temperatureService.getTemperature();

            log.info("Returning temperature reading: {}", temperature);

            return ResponseEntity.ok(temperature);

        } catch (Exception e) {
            log.error("Error while trying to get temperature reading!", e);
            return ResponseEntity.status(500).build();
        }
    }
}
