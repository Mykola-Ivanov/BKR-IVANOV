package ua.ivanov.ClimateControlService.dto;

import ua.ivanov.ClimateControlService.models.ClimateProfileRecord;

public class ProfileRecordSchedulerDTO {
    float temperature;
    float humidity;
    
    public ProfileRecordSchedulerDTO() {
    }

    public ProfileRecordSchedulerDTO(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
    }
    public ProfileRecordSchedulerDTO(ClimateProfileRecord data) {
        this.temperature = data.targetTemperature;
        this.humidity = data.targetHumidity;
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
}
