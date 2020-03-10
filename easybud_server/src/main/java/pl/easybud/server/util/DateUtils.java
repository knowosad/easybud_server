package pl.easybud.server.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateUtils {
  public DateUtils() {
  }

  public static String createDate(Date date) {
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy_HH_mm");
    return format.format(date);
  }

  public static Date createDate(int year, int month, int day) {
    return toDate(LocalDate.of(year, month, day));
  }

  public static Date toDate(LocalDateTime ldt) {
    return ldt != null ? Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant()) : null;
  }

  public static Date toDate(LocalDate ld) {
    return ld != null ? Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant()) : null;
  }

  public static LocalDateTime toLocalDateTime(Date date) {
    return date != null ? LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()) : null;
  }

  public static LocalDateTime toLocalDateTime(LocalDate date) {
    return date != null ? date.atStartOfDay(ZoneId.systemDefault()).toLocalDateTime() : null;
  }

  public static LocalDateTime toLocalDateTime(Long timestamp) {
    return timestamp != null ? Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDateTime() : null;
  }

  public static LocalDate toLocalDate(Date date) {
    return date != null ? date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;
  }

  public static LocalDate toLocalDate(Long timestamp) {
    return timestamp != null ? Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDate() : null;
  }

  public static boolean isSameYearMonth(YearMonth yearMonth, Date date) {
    return yearMonth.compareTo(YearMonth.from(toLocalDateTime(date))) == 0;
  }

  public static boolean isSameYearMonth(YearMonth yearMonth, LocalDate date) {
    return yearMonth.compareTo(YearMonth.from(date)) == 0;
  }

  public static boolean isSameYearMonth(LocalDate date1, LocalDate date2) {
    return YearMonth.from(date1).compareTo(YearMonth.from(date2)) == 0;
  }

  public static Long getMinutesBetweenDates(LocalDateTime date1, LocalDateTime date2) {
    return ChronoUnit.MINUTES.between(date1.isBefore(date2) ? date1 : date2, date2.isAfter(date1) ? date2 : date1);
  }

  public static Long getDaysBetweenDates(LocalDateTime date1, LocalDateTime date2) {
    return ChronoUnit.DAYS.between(date1.isBefore(date2) ? date1 : date2, date2.isAfter(date1) ? date2 : date1);
  }

  public static Long getDaysBetweenDates(LocalDate date1, LocalDate date2) {
    return ChronoUnit.DAYS.between(date1.isBefore(date2) ? date1 : date2, date2.isAfter(date1) ? date2 : date1);
  }

  public static boolean isBetweenFullDayDate(LocalDate fromDate, LocalDate toDate, LocalDateTime date) {
    LocalDateTime fromDateTime = fromDate.atStartOfDay();
    LocalDateTime toDateTime = toDate.atTime(LocalTime.MAX);
    return !date.isBefore(fromDateTime) && !date.isAfter(toDateTime);
  }

  public static boolean isBetweenYearMonth(Date fromDate, Date toDate, YearMonth date) {
    LocalDate from = toLocalDate(fromDate);
    LocalDate to = toLocalDate(toDate);
    return !date.isBefore(YearMonth.from(from)) && !date.isAfter(YearMonth.from(to));
  }

  public static String toStringDate(Date date) {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
    return format.format(date);
  }

  public static Date toDate(String date) {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

    try {
      return format.parse(date);
    } catch (ParseException var3) {
      return null;
    }
  }
}