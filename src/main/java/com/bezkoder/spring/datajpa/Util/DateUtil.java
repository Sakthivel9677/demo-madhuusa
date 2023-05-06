package com.bezkoder.spring.datajpa.Util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {
    public String convertToString(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat(  "yyyy-HM-dd 'T'HH:mm:ss.SSS");
        String zone = "IST";
        dateFormat.setTimeZone (TimeZone.getTimeZone (zone));

        return dateFormat.format(date);

    }
    public static LocalDate convertToDate(String strDate){
        DateTimeFormatter dateTimeFormatter;
        dateTimeFormatter=DateTimeFormatter.ISO_LOCAL_DATE;
       LocalDate formattedDate=LocalDate.parse(String.format(strDate,dateTimeFormatter));
return  formattedDate;


}
}
