package ua.ivanov.ClimateControlService.models;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Table(name = "climate_data")
@Entity
public class ClimateData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "climate_data_id")
    private Integer id;

    @Column(name = "temperature")
    private float temperature;
    
    @Column(name = "humidity")
    private float humidity;

    @Column(name = "pressure")
    private float pressure;

    @Column(name = "data_date")
    public Date registrationDate;

    @Column(name = "data_time")
    private Time registratiomTime;


    public ClimateData(float temperature, float humidity, float pressure, Date registrationDate,
            Time registratiomTime) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.registrationDate = registrationDate;
        this.registratiomTime = registratiomTime;
    }

    public ClimateData() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Time getRegistratiomTime() {
        return registratiomTime;
    }

    public void setRegistratiomTime(Time registratiomTime) {
        this.registratiomTime = registratiomTime;
    }

}
