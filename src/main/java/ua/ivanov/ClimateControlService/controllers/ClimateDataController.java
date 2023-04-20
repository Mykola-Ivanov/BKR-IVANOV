package ua.ivanov.ClimateControlService.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.ivanov.ClimateControlService.models.ClimateData;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("")
public class ClimateDataController {

    @GetMapping("")
    public String index(){
        return "home";
    }
    @PostMapping("/data")
    public ResponseEntity<HttpStatus> getDataFromSystem(@RequestBody ClimateData data){
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        data.setRegistrationdata(timestamp);
        System.out.println(data.toString());
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @ResponseBody
    @GetMapping("/dataget")
    public Map<String, Object> getData() {
        // Отримання даних для графіка
        // Наприклад, з бази даних або з іншого джерела
        Map<String, Object> data = new HashMap<>();
        data.put("label",(new Timestamp(new Date().getTime())).toString());
        data.put("value", Math.random() * 100);
        return data;
    }
    @GetMapping(value="/plot")
    public String getMethodName() {
        return "plotdata";
    }
    
}
