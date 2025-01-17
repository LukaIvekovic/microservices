package hr.fer.rassus.lab.aggregatormicroservice.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Mono;

@Configuration
public class ClientsConfig {
    @Bean
    HumidityClient humidityClient(ClientsProperties clientsProperties) {
        WebClient client = WebClient
                .builder()
                .defaultStatusHandler(HttpStatusCode::is4xxClientError, resp ->
                        resp.bodyToMono(String.class)
                                .flatMap(errorBody -> Mono.error(new RuntimeException(errorBody)))
                )
                .defaultStatusHandler(HttpStatusCode::is5xxServerError, resp ->
                        Mono.just(new RuntimeException(resp.statusCode().toString()))
                )
                .baseUrl(clientsProperties.humidityServiceUrl())
                .build();

        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(WebClientAdapter.create(client)).build();
        return factory.createClient(HumidityClient.class);
    }

    @Bean
    TemperatureClient temperatureClient(ClientsProperties clientsProperties) {
        WebClient client = WebClient
                .builder()
                .defaultStatusHandler(HttpStatusCode::is4xxClientError, resp ->
                        resp.bodyToMono(String.class)
                                .flatMap(errorBody -> Mono.error(new RuntimeException(errorBody)))
                )
                .defaultStatusHandler(HttpStatusCode::is5xxServerError, resp ->
                        Mono.just(new RuntimeException(resp.statusCode().toString()))
                )
                .baseUrl(clientsProperties.temperatureServiceUrl())
                .build();

        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(WebClientAdapter.create(client)).build();
        return factory.createClient(TemperatureClient.class);
    }
}
