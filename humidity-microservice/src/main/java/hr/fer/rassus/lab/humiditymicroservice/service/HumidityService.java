package hr.fer.rassus.lab.humiditymicroservice.service;

import hr.fer.rassus.lab.humiditymicroservice.entity.HumidityReadingEntity;
import hr.fer.rassus.lab.humiditymicroservice.repository.HumidityReadingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class HumidityService {
    private final HumidityReadingRepository humidityRepository;

    public HumidityDto getHumidity() {
        log.debug("Received request for humidity reading.");

        int readingId = getCurrentReadingId();

        log.debug("Reading ID: {}", readingId);

        Double humidityValue = humidityRepository.findById(readingId)
                .map(HumidityReadingEntity::getValue)
                .orElse(null);

        log.debug("Humidity value: {}", humidityValue);

        return HumidityDto.fromValue(humidityValue);
    }

    private int getCurrentReadingId() {
        long brojAktivnihSekundi = System.currentTimeMillis() / (1000 * 60);
        return (int) (brojAktivnihSekundi % 100) + 1;
    }
}
