package ua.ivanov.ClimateControlService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.ivanov.ClimateControlService.models.ClimateProfileRecord;
import ua.ivanov.ClimateControlService.repositories.ClimateProfileRecordRepository;

@Service
@Transactional(readOnly = true)
public class ClimateProfileRecordService {
    ClimateProfileRecordRepository climateProfileRecordRepository;

    @Autowired
    public ClimateProfileRecordService(ClimateProfileRecordRepository climateProfileRecordRepository) {
        this.climateProfileRecordRepository = climateProfileRecordRepository;
    }
    public ClimateProfileRecord getById(int id) {
        return climateProfileRecordRepository.findById(id);
    }
    @Transactional
    public void deleteById(int id){
        climateProfileRecordRepository.deleteById(id);
    }
    @Transactional
    public void save(ClimateProfileRecord record) {
        climateProfileRecordRepository.save(record);
    }

    @Transactional
    public void setRecordById(List<ClimateProfileRecord> records,int id,ClimateProfileRecord record){
        for (int i = 0; i < records.size(); i++) {
            if(records.get(i).getClimateProfileRecordId()==id){
                climateProfileRecordRepository.save(record);
                break;
            }
        }
    }
    public boolean addRecord(List<ClimateProfileRecord> records,ClimateProfileRecord record){
        boolean result = false;
        if(records.size()==0){
            records.add(record);
            return true;
        }
        for (int index = 0; index < records.size()-1; index++) {
            if(record.getStartTime().compareTo(records.get(index).getStartTime()) == 1){
                records.add(index+1,record);
                break;
            }
        }
        if(!result){
            var compare = record.getStartTime().compareTo(records.get(records.size()-1).getStartTime());
            if(compare == 1){
                return records.add(record);
            }else{
                records.add(0,record);
                return true;
            }
            
        }
        return result;
    }
}
