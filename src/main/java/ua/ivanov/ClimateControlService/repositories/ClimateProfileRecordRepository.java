package ua.ivanov.ClimateControlService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.ivanov.ClimateControlService.models.ClimateProfileRecord;

@Repository
public interface ClimateProfileRecordRepository extends JpaRepository<ClimateProfileRecord, Integer>{
    ClimateProfileRecord findById(int id);
}
