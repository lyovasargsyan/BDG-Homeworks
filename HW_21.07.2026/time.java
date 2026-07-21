import java.time.*;
public class time{
    public static void main(String... args) {
        // Use LocalDate.now() to print today’s date.
        LocalDate today = LocalDate.now();
        System.out.println("Today's date: " + today);

        System.out.println();

        // Parse the string "2025-12-31" into a LocalDate object and print it.
        LocalDate parsedDate = LocalDate.parse("2025-12-31");
        System.out.println("Parsed date: " + parsedDate);

        System.out.println();

        // Given your birthdate as a string (e.g., "2000-06-15"), calculate and print your age in years using Period.between(...)
        LocalDate birthdate = LocalDate.parse("2000-06-15");
        Period age = Period.between(birthdate, today);
        System.out.println("Age in years: " + age.getYears());

        System.out.println();

        // Input a date and add 100 days to it. Print the new date.
        LocalDate inputDate = LocalDate.of(2008, 1, 1); 
        LocalDate newDate = inputDate.plusDays(100);
        System.out.println("New date after adding 100 days: " + newDate);

        System.out.println();

        // Use LocalTime.now() to display the current system time.
        LocalTime currentTime = LocalTime.now();
        System.out.println("Current system time: " + currentTime);

        System.out.println();

        // Print the current time in Tokyo, New York, and Yerevan using ZonedDateTime.now(ZoneId.of(...)).
        ZonedDateTime tokyoTime = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        ZonedDateTime newYorkTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        ZonedDateTime yerevanTime = ZonedDateTime.now(ZoneId.of("Asia/Yerevan"));
        System.out.println("Current time in Tokyo: " + tokyoTime);
        System.out.println("Current time in New York: " + newYorkTime);
        System.out.println("Current time in Yerevan: " + yerevanTime);

        System.out.println();

        // You have a meeting at 2025-07-26T14:00 in Yerevan. Convert this time to London and Los Angeles time using ZonedDateTime.
        ZonedDateTime meetingYerevan = ZonedDateTime.of(LocalDate.of(2025, 7, 26), LocalTime.of(14, 0), ZoneId.of("Asia/Yerevan"));
        ZonedDateTime meetingLondon = meetingYerevan.withZoneSameInstant(ZoneId.of("Europe/London"));
        ZonedDateTime meetingLosAngeles = meetingYerevan.withZoneSameInstant(ZoneId.of("America/Los_Angeles"));
        System.out.println("Meeting time in Yerevan: " + meetingYerevan);
        System.out.println("Meeting time in London: " + meetingLondon);
        System.out.println("Meeting time in Los Angeles: " + meetingLosAngeles);

        System.out.println();

        // Given two LocalTime values (e.g., 08:00 and 15:45), calculate the time difference using Duration.between().
        LocalTime time1 = LocalTime.of(8, 0);
        LocalTime time2 = LocalTime.of(15, 45);
        Duration duration = Duration.between(time1, time2);
        System.out.println("Time difference: " + duration.toHours() + " hours and " + duration.toMinutesPart() + " minutes");

        System.out.println();

        // Ask the user to enter a date and tell whether it’s a Saturday or Sunday using getDayOfWeek().
        LocalDate userDate = LocalDate.parse("2023-10-14"); // Example user input
        DayOfWeek day = userDate.getDayOfWeek();
        if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
            System.out.println("The entered date is a " + day);
        } else {
            System.out.println("The entered date is not a weekend.");
        }
        System.out.println();
        // Print all available time zone IDs using ZoneId.getAvailableZoneIds().
        System.out.println("Available time zone IDs:");
        for (String zoneId : ZoneId.getAvailableZoneIds()) {
            System.out.println(zoneId);
        }
    }
}




