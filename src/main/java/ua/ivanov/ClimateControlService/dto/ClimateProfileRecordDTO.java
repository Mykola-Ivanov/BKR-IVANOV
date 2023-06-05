package ua.ivanov.ClimateControlService.dto;

public class ClimateProfileRecordDTO {
    
    float targetTemperature;
    float targetHumidity;
    String startTime;
    
    public ClimateProfileRecordDTO(float targetTemperature, float targetHumidity, String startTime) {
        this.targetTemperature = targetTemperature;
        this.targetHumidity = targetHumidity;
        this.startTime = startTime;
    }
    public ClimateProfileRecordDTO() {
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
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}
