package ua.ivanov.ClimateControlService.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Table(name = "ClimateProfiles")
@Entity
public class ClimateProfile{
    @Id
    @Column(name = "climate_profile_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int climateProfileId;

    @Column(name = "climate_profile_name")
    public String climateProfileName;

    @Column(name = "selected")
    public boolean selected;

    @OneToMany(
        cascade = CascadeType.ALL
        ,mappedBy = "profile"
        ,fetch = FetchType.LAZY)
    public List<ClimateProfileRecord> records;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    

    public ClimateProfile() {
        
    }

    public ClimateProfile(String climateProfileName) {
        this.climateProfileName = climateProfileName;
        selected = false;
    }
    
    public int getClimateProfileId() {
        return climateProfileId;
    }

    public void setClimateProfileId(int climateProfileId) {
        this.climateProfileId = climateProfileId;
    }

    public String getClimateProfileName() {
        return climateProfileName;
    }

    public void setClimateProfileName(String climateProfileName) {
        this.climateProfileName = climateProfileName;
    }

    public List<ClimateProfileRecord> getRecords() {
        return records.stream().sorted((i,j)-> i.startTime.compareTo(j.startTime)).toList();
    }

    public void setRecords(List<ClimateProfileRecord> records) {
        this.records = records;
    }
}