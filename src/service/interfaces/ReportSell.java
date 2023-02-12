package service.interfaces;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author Odilov_Zafarjon
 * @link https://t.me/zafarzhon_odilov
 */
public interface ReportSell {
    double sumOfDay(LocalDate localDate);
    double sumOfLastHour(LocalDateTime localDateTime);
    double sumOfWeekYear(int weekOfYear,int year);
    double sumOfMonth(int monthYear,int year);
    double sum(LocalDate from, LocalDate to);
    double sumFromToHour(LocalDateTime from, LocalDateTime to);
    double sumOfDay(LocalDate localDate, String zoneId);
}
