package ua.ivanov.ClimateControlService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import org.springframework.transaction.annotation.Transactional;
import ua.ivanov.ClimateControlService.models.ClimateData;
import ua.ivanov.ClimateControlService.repositories.ClimateDataRepository;

//import java.sql.Timestamp;
//import java.util.List;//@Transactional(readOnly = true)

@Service
public class ClimateDataService {

    private final ClimateDataRepository climateDataRepository;
    @Autowired
    public ClimateDataService(ClimateDataRepository climateDataRepository) {
        this.climateDataRepository = climateDataRepository;
    }
    public void save(ClimateData climateData){
        climateDataRepository.save(climateData);
    }
    //public List<ClimateData> getDataForTheLastTime(){
    //    return climateDataRepository.getBetweenBy(new Timestamp(),new Timestamp())
    //}
}
