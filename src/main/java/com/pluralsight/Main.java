import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        // 1. Get the current date and time in your local time zone
        ZonedDateTime localDateTime = ZonedDateTime.now();

        // 2. Convert the local time to GMT (UTC) time
        ZonedDateTime gmtDateTime = localDateTime.withZoneSameInstant(ZoneId.of("GMT"));

        // ---- EXERCISE 2 FORMATS ----

        // Format 1: 04/22/2026 (MM/dd/yyyy)
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(localDateTime.format(fmt1));

        // Format 2: 2026-04-22 (yyyy-MM-dd)
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(localDateTime.format(fmt2));

        // Format 3: Wednesday, April 22, 2026 (EEEE, MMMM d, yyyy)
        // Locale.US ensures English names for days and months match the requirements
        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy", Locale.US);
        System.out.println(localDateTime.format(fmt3));

        // Format 4: Wednesday, Apr 22, 2026  10:02 (GMT Time)
        DateTimeFormatter fmt4 = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy  HH:mm", Locale.US);
        System.out.println(gmtDateTime.format(fmt4) + "   ← display in GMT time");


        // ---- CHALLENGE FORMAT ----

        System.out.println("\nCHALLENGE:");

        // Format Challenge: 5:02 on 22-Apr-2026 (h:mm on dd-MMM-yyyy)
        DateTimeFormatter fmtChallenge = DateTimeFormatter.ofPattern("h:mm 'on' dd-MMM-yyyy", Locale.US);
        System.out.println(localDateTime.format(fmtChallenge) + "   ← display in your local time zone");
    }
}
