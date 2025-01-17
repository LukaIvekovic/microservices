package hr.fer.rassus.lab.humiditymicroservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "HUMIDITY_READING", schema = "HUMIDITY")
public class HumidityReadingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "VALUE")
    private Double value;
}
