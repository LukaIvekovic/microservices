package hr.fer.rassus.lab.aggregatormicroservice.client;

import hr.fer.rassus.lab.aggregatormicroservice.service.ReadingDto;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange(contentType = "application/json")
public interface TemperatureClient {
    @GetExchange("/temperature")
    ReadingDto fetchTemperature();
}
