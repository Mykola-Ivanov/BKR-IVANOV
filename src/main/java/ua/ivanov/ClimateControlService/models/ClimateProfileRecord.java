package ua.ivanov.ClimateControlService.models;

import java.sql.Time;

import jakarta.persistence.*;
import ua.ivanov.ClimateControlService.dto.ClimateProfileRecordDTO;
import ua.ivanov.ClimateControlService.dto.ClimateProfileRecordIDDTO;


@Table(name = "ClimateProfileRecords")
@Entity
public class ClimateProfileRecord {
    @Id
    @Column(name = "climate_profile_record_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int climateProfileRecordId;

    @Column(name = "temperature")
    public float targetTemperature;

    @Column(name = "humidity")
    public float targetHumidity;

    @Column(name = "begin_time")
    public Time startTime;

    @ManyToOne
    @JoinColumn(name = "climate_profile_id",referencedColumnName = "climate_profile_id")
    ClimateProfile profile;

    public ClimateProfileRecord() {
    }

    public ClimateProfileRecord(ClimateProfileRecordDTO record) {
        targetHumidity = record.getTargetHumidity();
        targetTemperature = record.getTargetTemperature();
        String temp = record.getStartTime();
        if(temp.length()==5)
            temp = temp+":00";
        
        startTime = Time.valueOf(temp);
    }

    public ClimateProfileRecord(ClimateProfileRecordIDDTO record){
        climateProfileRecordId = record.climateProfileRecordId;
        targetHumidity = record.getTargetHumidity();
        targetTemperature = record.getTargetTemperature();
        String temp = record.getStartTime();
        if(temp.length()==5)
            temp = temp+":00";
        
        startTime = Time.valueOf(temp);
    }
    public int getClimateProfileRecordId() {
        return climateProfileRecordId;
    }

    public void setClimateProfileRecordId(int climateProfileRecordId) {
        this.climateProfileRecordId = climateProfileRecordId;
    }

    public float getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(float targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    public float getTargetHumidity() {
        return targetHumidity;
    }

    public void setTargetHumidity(float targetHumidity) {
        this.targetHumidity = targetHumidity;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public ClimateProfile getProfile() {
        return profile;
    }

    public void setProfile(ClimateProfile profile) {
        this.profile = profile;
    }
}
