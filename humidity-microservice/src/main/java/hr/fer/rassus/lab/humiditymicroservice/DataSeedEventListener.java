package hr.fer.rassus.lab.humiditymicroservice;

import hr.fer.rassus.lab.humiditymicroservice.entity.HumidityReadingEntity;
import hr.fer.rassus.lab.humiditymicroservice.repository.HumidityReadingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
@RequiredArgsConstructor
public class DataSeedEventListener {
    private static final String CSV_FILE_PATH = "classpath:readings.csv";

    private final HumidityReadingRepository humidityReadingRepository;
    private final ResourceLoader resourceLoader;

    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
        Resource resource = resourceLoader.getResource(CSV_FILE_PATH);

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(resource.getInputStream()))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] values = line.split(",");
                if (values.length >= 3 && !values[2].isEmpty()) {
                    HumidityReadingEntity entity = new HumidityReadingEntity();
                    entity.setReading(Double.parseDouble(values[2]));
                    humidityReadingRepository.save(entity);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error reading CSV file", e);
        }
    }
}
