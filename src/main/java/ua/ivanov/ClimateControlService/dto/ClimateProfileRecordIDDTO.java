package ua.ivanov.ClimateControlService.dto;

public class ClimateProfileRecordIDDTO {
    public int climateProfileRecordId;
    float targetTemperature;
    float targetHumidity;
    String startTime;
    String endTime;
    public ClimateProfileRecordIDDTO(int climateProfileRecordId, float targetTemperature, float targetHumidity,
            String startTime, String endTime) {
        this.climateProfileRecordId = climateProfileRecordId;
        this.targetTemperature = targetTemperature;
        this.targetHumidity = targetHumidity;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public ClimateProfileRecordIDDTO() {
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
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
