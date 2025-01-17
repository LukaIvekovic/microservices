package hr.fer.rassus.lab.aggregatormicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@ConfigurationPropertiesScan("hr.fer.rassus.lab.aggregatormicroservice")
@EnableConfigurationProperties
@SpringBootApplication
public class AggregatorMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AggregatorMicroserviceApplication.class, args);
    }

}
