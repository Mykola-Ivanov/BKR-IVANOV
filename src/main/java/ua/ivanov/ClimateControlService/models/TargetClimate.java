package ua.ivanov.ClimateControlService.models;

import jakarta.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Table(name = "target_climate")
@Entity
public class TargetClimate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "target_climate_id")
    private Integer id;

    @Column(name = "target_temperature")
    private float temperature;
    
    @Column(name = "target_humidity")
    private float humidity;

    @Column(name = "data_date")
    public Date registrationDate;

    @Column(name = "data_time")
    private Time registratiomTime;
}
