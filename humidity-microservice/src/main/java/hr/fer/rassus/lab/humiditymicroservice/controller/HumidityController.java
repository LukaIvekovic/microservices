package hr.fer.rassus.lab.humiditymicroservice.controller;

import hr.fer.rassus.lab.humiditymicroservice.service.HumidityDto;
import hr.fer.rassus.lab.humiditymicroservice.service.HumidityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HumidityController {
    private final HumidityService humidityService;

    @GetMapping("/humidity")
    public ResponseEntity<HumidityDto> getHumidity() {
        try {
            log.info("Received request for humidity reading.");

            var humidity = humidityService.getHumidity();

            log.info("Returning humidity reading: {}", humidity);

            return ResponseEntity.ok(humidity);

        } catch (Exception e) {
            log.error("Error while trying to get humidity reading!", e);
            return ResponseEntity.status(500).build();
        }
    }
}
