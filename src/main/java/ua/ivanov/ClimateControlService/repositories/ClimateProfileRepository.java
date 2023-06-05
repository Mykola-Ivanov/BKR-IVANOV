package ua.ivanov.ClimateControlService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.ivanov.ClimateControlService.models.ClimateProfile;

@Repository
public interface ClimateProfileRepository extends JpaRepository<ClimateProfile, Integer>{
    ClimateProfile findByClimateProfileId(int id);

    List<ClimateProfile> findAllBySelectedTrue();
}
