package ua.ivanov.ClimateControlService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import ua.ivanov.ClimateControlService.models.ClimateData;
import ua.ivanov.ClimateControlService.services.ClimateDataService;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import org.springframework.http.HttpHeaders;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/climate")
public class ClimateDataController {
    ClimateDataService service;
    String picowip;
    @Autowired
    public ClimateDataController(ClimateDataService service,Environment env) {
        this.service = service;
        this.environment = env;
    }
    @ResponseBody
    @PostMapping("/data")
    public ResponseEntity<HttpStatus> getDataFromSystem(@RequestBody ClimateData data){
        System.out.println(data.toString());
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @ResponseBody
    @GetMapping("/getdatetime")
    public Map<String, Object> getTime(){
        Map<String, Object> time = new HashMap<>();
        Date date = new Date();
        var timestamp = new Timestamp(date.getTime());
        time.put("date",timestamp.getDate());
        time.put("hours",timestamp.getHours());
        time.put("minutes",timestamp.getMinutes());
        time.put("seconds",timestamp.getSeconds());
        return time; 
    }
    @GetMapping("")
    public String index(){
        return "home";
    }
    @GetMapping("/viewdata")
    public Map<String, Object> getData() {
        // Отримання даних для графіка
        // Наприклад, з бази даних або з іншого джерела
        Map<String, Object> data = new HashMap<>();
        data.put("label",(new Timestamp(new Date().getTime())).toString());
        data.put("value", Math.random() * 100);
        return data;
    }

        // Отримуємо відповідь
        String response = responseEntity.getBody();

        // Виводимо вміст відповіді
        System.out.println("Response: " + response);
        return ;
    }

    @PutMapping("/setclimateprofile")
    public void setHumidityPoint(float humiditySetPoint){
        
        return ;
    }

    @GetMapping(value="/plot")
    public String getMethodName() {
        return "plotdata";
    }
    
}
