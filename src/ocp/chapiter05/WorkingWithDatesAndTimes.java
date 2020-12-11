package ocp.chapiter05;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class WorkingWithDatesAndTimes {

	public static void main(String[] args) {

		System.out.println("-------------------------LocalDate-------------------------");
		LocalDate date1 = LocalDate.of(2015, Month.JANUARY, 20);
		LocalDate date2 = LocalDate.of(2015, 1, 20);
		System.out.println(date1);
		System.out.println(date2);
		System.out.println("-------------------------LocalTime-------------------------");
		LocalTime time1 = LocalTime.of(6, 15); // hour and minute
		LocalTime time2 = LocalTime.of(6, 15, 30); // + seconds
		LocalTime time3 = LocalTime.of(6, 15, 30, 200); // + nanoseconds
		System.out.println(time1);
		System.out.println(time2);
		System.out.println(time3);
		System.out.println("-------------------------LocalDateTime-------------------------");
		LocalDateTime dateTime1 = LocalDateTime.of(2015, Month.JANUARY, 20, 6, 15, 30);	//2015-01-20T06:15:30
		LocalDateTime dateTime2 = LocalDateTime.of(date1, time1);	// 2015-01-20T06:15
		System.out.println(dateTime1);
		System.out.println(dateTime2);
		System.out.println("-------------------------now()-------------------------");
		System.out.println(LocalDate.now());	// 2020-12-06
		System.out.println(LocalTime.now());	// 10:40:44.529754300
		System.out.println(LocalDateTime.now());	// 2020-12-06T10:40:44.529754300
		System.out.println("-------------------------Manipulation-------------------------");
		LocalDate date = LocalDate.of(2014, Month.JANUARY, 20);
		System.out.println(date); // 2014-01-20
		date = date.plusDays(2);
		System.out.println(date); // 2014-01-22
		date = date.plusWeeks(1);
		System.out.println(date); // 2014-01-29
		date = date.plusMonths(1);
		System.out.println(date); // 2014-02-28
		date = date.plusYears(5);
		System.out.println(date); // 2019-02-28
		date = date.minusDays(5);
		System.out.println(date); // 2019-02-23
		System.out.println("-------------------------formatting-------------------------");
		LocalDate dateF = LocalDate.of(2020, Month.JANUARY, 20);
		LocalTime time = LocalTime.of(11, 12, 34);
		LocalDateTime dateTime = LocalDateTime.of(dateF, time);
		System.out.println(dateF.format(DateTimeFormatter.ISO_LOCAL_DATE));	// 2020-01-20
		System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));	// 11:12:34
		System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));	// 2020-01-20T11:12:34
		System.out.println("-------------------------formatting pers-------------------------");
		DateTimeFormatter f = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm");
		System.out.println(dateTime.format(f)); // January 20, 2020, 11:12
		System.out.println("-------------------------formatting pers-------------------------");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM dd yyyy");
		LocalDate dateL = LocalDate.parse("01 02 2015", dtf);
		LocalTime timeL = LocalTime.parse("11:22");
		System.out.println(dateL); // 2015-01-02
		System.out.println(timeL); // 11:22
		
		LocalDate toDay = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
		System.out.println("Today is: " +  LocalDate.now().format(formatter));
		
		
		Instant instant = Instant.now();
		long timeStampMillis = instant.toEpochMilli();
		System.out.println("epoch milliseconds is: " + timeStampMillis);
		long timeStampSeconds = instant.getEpochSecond();
		System.out.println("epoch-seconds is:" + timeStampSeconds);

	}

}
