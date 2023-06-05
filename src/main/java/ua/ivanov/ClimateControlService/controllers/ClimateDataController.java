package ua.ivanov.ClimateControlService.controllers;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import ua.ivanov.ClimateControlService.dto.ClimateDataPlotDTO;
import ua.ivanov.ClimateControlService.models.*;
import ua.ivanov.ClimateControlService.services.*;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;

@Controller
@RequestMapping("/climate")
public class ClimateDataController {
    ClimateDataService service;
    String picowip;
    
    
    public ClimateDataController() {
    }
    @Autowired
    public ClimateDataController(ClimateDataService service, String picowip) {
        this.service = service;
        this.picowip = picowip;
    }
    
    @GetMapping("")
    public String index(){
        return "redirect:/climate/plot";
    }
    @ResponseBody
    @GetMapping("/getlast")
    public ClimateData getData() {
        // Отримання останнього запису
        ClimateData data = service.getLast();
        return data;
    }

    @GetMapping(value="/plot")
    public String getMethodName(Model model) {
        var records = service.findLast20records();

        var time = new ArrayList<String>();
        var temperature = new ArrayList<Float>();
        var humidity = new ArrayList<Float>();
        var pressure = new ArrayList<Float>();
        for (ClimateDataPlotDTO climateData : records) {
            time.add( climateData.getRegistratiomTime());
            temperature.add( climateData.getTemperature());
            humidity.add(climateData.getHumidity());
            pressure.add(climateData.getPressure());
        }
        Collections.reverse(time);
        Collections.reverse(temperature);
        Collections.reverse(humidity);
        Collections.reverse(pressure);

        model.addAttribute("xTime", time);
        model.addAttribute("temperature", temperature);
        model.addAttribute("humidity", humidity);
        model.addAttribute("pressure", pressure);

        return "climate/plotdata";
    }

    @PostMapping("/data")
    public ResponseEntity<HttpStatus> getDataFromSystem(){
        RestTemplate template = new RestTemplate(); 
        // Створюємо заголовки і встановлюємо Content-Type
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String uri = "http://"+picowip+":8080/getclimate";//    
        System.out.println(uri);
        ResponseEntity<ClimateData> responce = template.exchange(uri,HttpMethod.GET, null, ClimateData.class);
        System.out.println(responce);
        ClimateData data = responce.getBody();
        if(data != null){
            data.setRegistratiomTime(new Time(System.currentTimeMillis()));
            data.setRegistrationDate(new Date(System.currentTimeMillis()));
            service.save(data);
            return ResponseEntity.ok(HttpStatus.OK);
        }
        else {
            return ResponseEntity.ok(HttpStatus.NO_CONTENT);
        }
    }
    // @ResponseBody
    // @GetMapping("/getdatetime")
    // public Map<String, Object> getTime(){
    //     Map<String, Object> time = new HashMap<>();
    //     java.util.Date date = new Date(System.currentTimeMillis());
    //     DateFormat format = new SimpleDateFormat("HH:mm");
    //     format.setTimeZone(TimeZone.getTimeZone("Europe/Kiev"));
    //     time.put("time",format.format(date)+":00");
    //     return time; 
    // }
}
