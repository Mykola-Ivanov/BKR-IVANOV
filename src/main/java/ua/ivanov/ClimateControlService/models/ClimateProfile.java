package ua.ivanov.ClimateControlService.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ClimateProfiles")
class ClimateProfile{
    @Id
    int climateProfileId;

    String ClimateProfileName;

    @OneToMany(mappedBy = "")
    List<ClimateProfileRecord> records;
}