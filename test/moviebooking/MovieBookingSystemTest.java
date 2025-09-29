package moviebooking;
//Code reviewed by : Manuel John L. Dalacan
//Remarks:
//No checkstyle error on this class.

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MovieBookingSystemTest {
    /** MovieBookingSystem instance for testing purposes. */
    private MovieBookingSystem movie;
    /** Captures the output printed to System.out during tests. */
    private final ByteArrayOutputStream outCont = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        movie = new MovieBookingSystem();
        outCont.reset();
        System.setOut(new PrintStream(outCont));
    }

    @DisplayName("Test Check Availability")
    @Test
    void testCheckAvailabilityValidInput() {
        final int t75 = 75;
        assertTrue(movie.checkAvailability("10:00 AM"));
        movie.bookTicket("10:00 AM", t75);
        assertFalse(movie.checkAvailability("10:00 AM"));

    }

    @DisplayName("Test Check Availability")
    @Test
    void testCheckAvailabilityInvalidInput() {
        movie.checkAvailability("11:00 AM");
        String expectedOutput = "Invalid showtime.";
        assertEquals(expectedOutput, outCont.toString().trim(),
                "The output should match the expected output.");
    }

    @DisplayName("Test Invalid Showtime")
    @Test
    void testInvalidShowtime() {
        final int t5 = 5;
        movie.bookTicket("11:00 AM", t5);
        String expectedOutput = "Invalid showtime.";
        assertEquals(expectedOutput, outCont.toString().trim(),
                "The output should match the expected output.");
    }

    @DisplayName("Test successful movie booking")
    @Test
    void testBookTicketValidInput() {
        final int t5 = 5;
        final int t70 = 70;
        movie.bookTicket("10:00 AM", t5);
        assertEquals(t70, movie.getAvailableTickets("10:00 AM"));
    }

    @DisplayName("Test unsuccessful movie booking")
    @Test
    void testBookTicketInvalidInput() {
        final int t100 = 100;
        movie.bookTicket("10:00 AM", t100);
        String expectedOutput = "Not enough tickets "
                + "available for this showtime";
        assertEquals(expectedOutput, outCont.toString().trim(),
                "The output should match the expected output.");
    }

    @DisplayName("Test successful cancel booking")
    @Test
    void testCancelReservationValidInput() {
        final int t5 = 5;
        final int t3 = 3;
        movie.bookTicket("10:00 AM", t5);
        movie.cancelReservation("10:00 AM", t3);
        assertEquals(2, movie.getBookedTickets("10:00 AM"));
    }

    @DisplayName("Test unsuccessful cancel booking")
    @Test
    void testCancelReservationInvalidInput() {
        final int t5 = 5;
        final int t10 = 10;
        movie.bookTicket("10:00 AM", t5);
        movie.cancelReservation("10:00 AM", t10);
        String expectedOutput = "5 tickets successfully booked for 10:00 AM\r\n"
                + "Invalid operation"
                + " (Attempt to cancel more tickets than booked)";
        assertEquals(expectedOutput, outCont.toString().trim(),
                "The output should match the expected output.");
    }
    @DisplayName("Test Cancel Invalid Showtime")
    @Test
    void testCancelInvalidShowtime() {
        final int t5 = 5;
        movie.cancelReservation("11:00 AM", t5);
        String expectedOutput = "Invalid showtime.";
        assertEquals(expectedOutput, outCont.toString().trim(),
                "The output should match the expected output.");
    }

    @DisplayName("Test book another showtime")
    @Test
    void testBookAnotherShowtime() {
        final int t5 = 5;
        final int t70 = 70;
        movie.bookTicket("1:00 PM", t5);
        assertEquals(t70, movie.getAvailableTickets("1:00 PM"));
    }
}
