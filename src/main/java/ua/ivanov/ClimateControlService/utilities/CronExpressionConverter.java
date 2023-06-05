package ua.ivanov.ClimateControlService.utilities;

import java.sql.Time;
import java.text.SimpleDateFormat;

public class CronExpressionConverter {
    public static String convertToCronExpression(Time time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("ss mm HH * * *");        
        return dateFormat.format(time);
    }
}