package memento_mediator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTimestampFormatter {

    String format = "EEEE, MMMM d, u 'at' h:mma";
    DateTimeFormatter formatter;

    @BeforeEach
    void setup() {
        formatter = DateTimeFormatter.ofPattern(format);
    }

    @Test
    void testFormatterOnInstance() {
        String expected = "Wednesday, October 29, 2025 at 12:09PM";

        // credit for this strategy goes to: https://www.baeldung.com/java-instant-to-string#1-using-the-datetimeformatter-class
        formatter = DateTimeFormatter.ofPattern(format).withZone(ZoneId.systemDefault());
        Instant instant = Instant.parse("2025-10-29T12:09:00.00-07:00");
        String actual = formatter.format(instant);

        assertEquals(expected, actual);
    }

    @Test
    void testFormatterSingleDigitMinute() {
        String expected = "Wednesday, October 29, 2025 at 12:09PM";
        LocalDateTime timestamp = LocalDateTime.of(2025, 10, 29, 12, 9);
        String actual = timestamp.format(formatter);
        assertEquals(expected, actual);
    }

    @Test
    void testFormatterSingleDigitAmHour() {
        String expected = "Wednesday, October 29, 2025 at 7:59AM";
        LocalDateTime timestamp = LocalDateTime.of(2025, 10, 29, 7, 59);
        String actual = timestamp.format(formatter);
        assertEquals(expected, actual);
    }

    @Test
    void testFormatterSingleDigitPmHour() {
        String expected = "Wednesday, October 29, 2025 at 7:59PM";
        LocalDateTime timestamp = LocalDateTime.of(2025, 10, 29, 19, 59);
        String actual = timestamp.format(formatter);
        assertEquals(expected, actual);
    }

    @Test
    void testFormatterAllSingleDigitAm() {
        String expected = "Wednesday, October 29, 2025 at 7:09AM";
        LocalDateTime timestamp = LocalDateTime.of(2025, 10, 29, 7, 9);
        String actual = timestamp.format(formatter);
        assertEquals(expected, actual);
    }

    @Test
    void testFormatterAllSingleDigitPm() {
        String expected = "Wednesday, October 29, 2025 at 7:09PM";
        LocalDateTime timestamp = LocalDateTime.of(2025, 10, 29, 19, 9);
        String actual = timestamp.format(formatter);
        assertEquals(expected, actual);
    }

    @Test
    void testFormatterSingleDigitDay() {
        String expected = "Saturday, October 4, 2025 at 12:59PM";
        LocalDateTime timestamp = LocalDateTime.of(2025, 10, 4, 12, 59);
        String actual = timestamp.format(formatter);
        assertEquals(expected, actual);
    }

    @Test
    void testFormatterSingleDigitMonth() {
        String expected = "Saturday, March 29, 2025 at 12:59PM";
        LocalDateTime timestamp = LocalDateTime.of(2025, 3, 29, 12, 59);
        String actual = timestamp.format(formatter);
        assertEquals(expected, actual);
    }

    @Test
    void testFormatterSingleDigitDayMonth() {
        String expected = "Saturday, March 1, 2025 at 12:59PM";
        LocalDateTime timestamp = LocalDateTime.of(2025, 3, 1, 12, 59);
        String actual = timestamp.format(formatter);
        assertEquals(expected, actual);
    }

    @Test
    void testFormatterAllSingleDigits() {
        String expected = "Saturday, March 1, 2025 at 7:09AM";
        LocalDateTime timestamp = LocalDateTime.of(2025, 3, 1, 7, 9);
        String actual = timestamp.format(formatter);
        assertEquals(expected, actual);
    }

    @Test
    void testFormatterDoubleDigitMinute() {
        String expected = "Wednesday, October 29, 2025 at 5:19PM";
        LocalDateTime timestamp = LocalDateTime.of(2025, 10, 29, 17, 19);
        String actual = timestamp.format(formatter);
        assertEquals(expected, actual);
    }

    @Test
    void testFormatterDoubleDigitAmHour() {
        String expected = "Wednesday, October 29, 2025 at 10:09AM";
        LocalDateTime timestamp = LocalDateTime.of(2025, 10, 29, 10, 9);
        String actual = timestamp.format(formatter);
        assertEquals(expected, actual);
    }

    @Test
    void testFormatterDoubleDigitPmHour() {
        String expected = "Wednesday, October 29, 2025 at 10:09PM";
        LocalDateTime timestamp = LocalDateTime.of(2025, 10, 29, 22, 9);
        String actual = timestamp.format(formatter);
        assertEquals(expected, actual);
    }

    @Test
    void testFormatterAllDoubleDigitAm() {
        String expected = "Wednesday, October 29, 2025 at 11:59AM";
        LocalDateTime timestamp = LocalDateTime.of(2025, 10, 29, 11, 59);
        String actual = timestamp.format(formatter);
        assertEquals(expected, actual);
    }

    @Test
    void testFormatterAllDoubleDigitPm() {
        String expected = "Wednesday, October 29, 2025 at 11:59PM";
        LocalDateTime timestamp = LocalDateTime.of(2025, 10, 29, 23, 59);
        String actual = timestamp.format(formatter);
        assertEquals(expected, actual);
    }

    @Test
    void testFormatterDoubleDigitDay() {
        String expected = "Saturday, March 15, 2025 at 7:09AM";
        LocalDateTime timestamp = LocalDateTime.of(2025, 3, 15, 7, 9);
        String actual = timestamp.format(formatter);
        assertEquals(expected, actual);
    }

    @Test
    void testFormatterDoubleDigitMonth() {
        String expected = "Wednesday, October 1, 2025 at 7:09AM";
        LocalDateTime timestamp = LocalDateTime.of(2025, 10, 1, 7, 9);
        String actual = timestamp.format(formatter);
        assertEquals(expected, actual);
    }

    @Test
    void testFormatterDoubleDigitDayMonth() {
        String expected = "Wednesday, October 29, 2025 at 7:09AM";
        LocalDateTime timestamp = LocalDateTime.of(2025, 10, 29, 7, 9);
        String actual = timestamp.format(formatter);
        assertEquals(expected, actual);
    }

    @Test
    void testFormatterAllDoubleDigits() {
        String expected = "Wednesday, October 29, 2025 at 12:59PM";
        LocalDateTime timestamp = LocalDateTime.of(2025, 10, 29, 12, 59);
        String actual = timestamp.format(formatter);
        assertEquals(expected, actual);
    }

}
