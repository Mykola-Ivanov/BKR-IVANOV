package ua.ivanov.ClimateControlService.dto;

import ua.ivanov.ClimateControlService.models.ClimateData;

public class ClimateDataDTO {

    private float temperature;
    private float humidity;
    private float pressure;
    
    public ClimateDataDTO(){

    }
    public ClimateDataDTO(ClimateData climateData){
        temperature = climateData.getTemperature();
        humidity = climateData.getHumidity();
        pressure = climateData.getPressure();
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
    
}
