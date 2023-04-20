package ua.ivanov.ClimateControlService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.ivanov.ClimateControlService.models.ClimateData;

public interface ClimateDataRepository extends JpaRepository<ClimateData, Integer> {
    // Можете додати власні методи репозиторію, які вам потрібні
}
