package ua.ivanov.ClimateControlService.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StaticScheduleManager {
    @Autowired
    @Qualifier("picowip")
    String ip;
    // "0 * * * * *"      один раз на хвилину
    // "* * * * * *"    один раз на секунду
    @Scheduled(cron = "* * * * * *")
    public void updatePID() {
        RestTemplate template = new RestTemplate(); 
        // Створюємо заголовки і встановлюємо Content-Type
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String uri = "http://"+ip+":8080/updatepid";//    
        //System.out.println(uri);
        var responce = template.exchange(uri,HttpMethod.POST, null, String.class);
        //System.out.println(responce);
    }
    @Scheduled(cron = "0 * * * * *")
    public void getClimate(){
        RestTemplate template = new RestTemplate(); 
        // Створюємо заголовки і встановлюємо Content-Type
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String uri = "http://localhost:8080/climate/data";//    
        //System.out.println(uri);
        var responce = template.exchange(uri,HttpMethod.POST, null, String.class);
        //System.out.println(responce);
    }
    
}
