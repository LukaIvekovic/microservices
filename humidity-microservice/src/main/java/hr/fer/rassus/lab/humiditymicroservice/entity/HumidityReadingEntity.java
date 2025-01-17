package hr.fer.rassus.lab.humiditymicroservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "humidity_reading")
public class HumidityReadingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "reading")
    private Double reading;
}
