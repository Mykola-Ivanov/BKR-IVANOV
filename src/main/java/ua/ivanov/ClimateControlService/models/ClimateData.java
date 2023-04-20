package ua.ivanov.ClimateControlService.models;

//import javax.persistence.*;
//import javax.persistence.Entity;
import jakarta.persistence.*;

/*import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Basic;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;*/
import java.sql.Timestamp;


@Table(name = "climatedata")
@Entity
public class ClimateData {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "temperature")
    private float temperature;

    @Basic(optional = false)
    @Column(name = "humidity")
    private float humidity;

    @Basic(optional = false)
    @Column(name = "target_temperature")
    private float targettemperature;

    @Basic(optional = false)
    @Column(name = "target_humidity")
    private float targethumidity;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_time_stamp")
    private Timestamp registrationdata;
    public ClimateData(){}

    public ClimateData(float temperature, float humidity, float targettemperature, float targethumidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.targettemperature = targettemperature;
        this.targethumidity = targethumidity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public float getTargettemperature() {
        return targettemperature;
    }

    public void setTargettemperature(float targettemperature) {
        this.targettemperature = targettemperature;
    }

    public float getTargethumidity() {
        return targethumidity;
    }

    public void setTargethumidity(float targethumidity) {
        this.targethumidity = targethumidity;
    }

    public Timestamp getRegistrationdata() {
        return registrationdata;
    }

    @Override
    public String toString() {
        return "ClimateData{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                ", targettemperature=" + targettemperature +
                ", targethumidity=" + targethumidity +
                ", registrationdata=" + registrationdata +
                '}';
    }

    public void setRegistrationdata(Timestamp registrationdata) {
        this.registrationdata = registrationdata;
    }

}
