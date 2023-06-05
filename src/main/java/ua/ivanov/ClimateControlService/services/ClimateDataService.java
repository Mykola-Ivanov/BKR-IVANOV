package ua.ivanov.ClimateControlService.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import ua.ivanov.ClimateControlService.dto.ClimateDataPlotDTO;
import ua.ivanov.ClimateControlService.models.ClimateData;
import ua.ivanov.ClimateControlService.repositories.ClimateDataRepository;


@Service
public class ClimateDataService {    
    private ClimateDataRepository climateDataRepository;

    @Autowired
    public ClimateDataService(ClimateDataRepository climateDataRepository) {
        this.climateDataRepository = climateDataRepository;
    }
    
    @Transactional
    public void save(ClimateData climateData){
        climateDataRepository.save(climateData);
    }

    public String sendTargetClimate(float temperature,float humidity,String destinaAdress){
        //"example.com/api/endpoint";
        String jsonBody = "{\"temperature\": \""+temperature+"\", \"humidity\": "+humidity+"}";

        // Створюємо об'єкт RestTemplate
        RestTemplate restTemplate = new RestTemplate();
        
        // Створюємо заголовки і встановлюємо Content-Type
        HttpHeaders headers = new HttpHeaders();
        headers.setContentLength(jsonBody.getBytes().length);
        headers.setContentType(MediaType.APPLICATION_JSON);
        

        // JSON-об'єкт, який буде відправлено у тілі запиту
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("temperature", temperature);
        requestBody.put("humidity", humidity);

        // Створюємо об'єкт HttpEntity з встановленими заголовками та тілом
        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        // Відправляємо PUT-запит і отримуємо відповідь
        ResponseEntity<String> responseEntity = restTemplate.exchange(destinaAdress, HttpMethod.PUT, requestEntity, String.class);

        // Отримуємо відповідь
        return responseEntity.getBody();
    }
    
    public void sendClimateProfile(int id){

    }
    @Transactional(readOnly = true)
    public List<ClimateDataPlotDTO> findLast20records() {
        var list = climateDataRepository.findTop20ByRegistrationDateOrderByRegistratiomTimeDesc(new java.util.Date(System.currentTimeMillis()));
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        list.stream().forEach(i->System.out.println(format.format(i.getRegistratiomTime())));
        List<ClimateDataPlotDTO> listDTO = new ArrayList<ClimateDataPlotDTO>();
        for (ClimateData climateData : list) {
            listDTO.add(new ClimateDataPlotDTO(climateData));
        }
        return listDTO;
    }
    public ClimateData getLast(){
        ClimateData data = climateDataRepository.findTop1ByRegistrationDateOrderByRegistratiomTimeDesc(new java.util.Date(System.currentTimeMillis())).get(0);
        return data;
    }
}
