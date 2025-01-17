package hr.fer.rassus.lab.temperaturemicroservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TEMPERATURE_READING", schema = "TEMPERATURE")
public class TemperatureReadingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "VALUE")
    private Double value;
}
