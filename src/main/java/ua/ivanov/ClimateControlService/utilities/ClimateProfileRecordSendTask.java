package ua.ivanov.ClimateControlService.utilities;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import ua.ivanov.ClimateControlService.dto.ProfileRecordSchedulerDTO;

public class ClimateProfileRecordSendTask implements Runnable{
    ProfileRecordSchedulerDTO dataToSend;
    String ip;
    
    public ClimateProfileRecordSendTask(ProfileRecordSchedulerDTO dataToSend, String ip) {
        this.dataToSend = dataToSend;
        this.ip = ip;
    }

    public ClimateProfileRecordSendTask() {
    }

    @Override
    public void run() {
        RestTemplate template = new RestTemplate();
        
        // Створюємо заголовки і встановлюємо Content-Type
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Створюємо об'єкт HttpEntity з JSON-об'єктом та заголовками
        HttpEntity<ProfileRecordSchedulerDTO> requestEntity = new HttpEntity<>(dataToSend, headers);

        String uri = "http://"+ip+":8081/setcurrentclimate";
        System.out.println(uri);
        var responce = template.exchange(uri,HttpMethod.POST, requestEntity, String.class);
        System.out.println(responce);
    }

    public ProfileRecordSchedulerDTO getDataToSend() {
        return dataToSend;
    }

    public void setDataToSend(ProfileRecordSchedulerDTO dataToSend) {
        this.dataToSend = dataToSend;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
