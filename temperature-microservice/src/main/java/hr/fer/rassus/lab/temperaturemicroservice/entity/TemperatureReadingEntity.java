package hr.fer.rassus.lab.temperaturemicroservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "temperature_reading")
public class TemperatureReadingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "reading")
    private Double reading;
}
