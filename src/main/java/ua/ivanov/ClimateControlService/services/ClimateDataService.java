package ua.ivanov.ClimateControlService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import org.springframework.transaction.annotation.Transactional;
import ua.ivanov.ClimateControlService.models.ClimateData;
import ua.ivanov.ClimateControlService.repositories.ClimateDataRepository;


@Service
public class ClimateDataService {

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
