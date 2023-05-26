package ua.ivanov.ClimateControlService.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ClimateProfileRecords")
public class ClimateProfileRecord {
    @Id
    int climateProfileRecordId;

    float targettemperature;

    float targetHumidity;

    Date startTime;

    Date endTime;

    @ManyToOne
    ClimateProfile profile;
}
