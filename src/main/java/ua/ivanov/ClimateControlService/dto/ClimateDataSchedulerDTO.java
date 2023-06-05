package ua.ivanov.ClimateControlService.dto;

import ua.ivanov.ClimateControlService.models.ClimateData;

public class ClimateDataSchedulerDTO {
    float temperature;
    float humidity;
    
    public ClimateDataSchedulerDTO() {
    }

    public ClimateDataSchedulerDTO(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
    }
    public ClimateDataSchedulerDTO(ClimateData data) {
        this.temperature = data.getTemperature();
        this.humidity = data.getHumidity();
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
