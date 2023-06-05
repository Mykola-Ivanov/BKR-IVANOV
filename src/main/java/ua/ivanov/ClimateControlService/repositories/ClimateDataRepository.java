package ua.ivanov.ClimateControlService.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import ua.ivanov.ClimateControlService.models.ClimateData;
//@Repository

public interface ClimateDataRepository extends JpaRepository<ClimateData, Integer> {
    // Можете додати власні методи репозиторію, які вам потрібні
    public List<ClimateData> findTop20ByRegistrationDateOrderByRegistratiomTimeDesc(Date data);
    public List<ClimateData> findTop50ByRegistrationDateOrderByRegistratiomTimeDesc(Date data);
    public List<ClimateData> findTop1ByRegistrationDateOrderByRegistratiomTimeDesc(Date data);
}