package ua.ivanov.ClimateControlService.dto;

import java.text.SimpleDateFormat;

import ua.ivanov.ClimateControlService.models.ClimateData;

public class ClimateDataPlotDTO {
    
    private float temperature;
    private float humidity;
    private float pressure;
    private String registratiomTime;
    
    public ClimateDataPlotDTO(){

    }
    public ClimateDataPlotDTO(ClimateData climateData){
        temperature = climateData.getTemperature();
        humidity = climateData.getHumidity();
        pressure = climateData.getPressure();
        SimpleDateFormat formater = new SimpleDateFormat("HH:mm");
        registratiomTime = formater.format(climateData.getRegistratiomTime());
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
    public String getRegistratiomTime() {
        return registratiomTime;
    }
    public void setRegistratiomTime(String registratiomTime) {
        this.registratiomTime = registratiomTime;
    }
    
}
