package moviebooking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MovieBookingSystemTest {
    private MovieBookingSystem movie;

    @BeforeEach
    void setUp() {
        movie = new MovieBookingSystem();
    }

    @DisplayName("Test Check Availability")
    @Test
    void testCheckAvailability_ValidInput() {
        assertTrue(movie.checkAvailability("10:00 AM"));
    }

    @DisplayName("Test Check Availability")
    @Test
    void testCheckAvailability_InvalidInput() {
        movie.bookTicket("10:00 AM", 75);
        assertFalse(movie.checkAvailability("10:00 AM"));
    }

    @DisplayName("Test successful movie booking")
    @Test
    void testBookTicket_ValidInput() {
        movie.bookTicket("10:00 AM", 5);
        assertTrue(movie.checkAvailability("10:00 AM"));
    }

    @DisplayName("Test unsuccessful movie booking")
    @Test
    void testBookTicket_InvalidInput() {
        movie.bookTicket("10:00 AM", 100);
        assertTrue(movie.checkAvailability("10:00 AM"));
    }

    @DisplayName("Test successful cancel booking")
    @Test
    void testCancelReservation_ValidInput() {
        movie.bookTicket("10:00 AM", 5);
        movie.cancelReservation("10:00 AM", 3);
        assertTrue(movie.checkAvailability("10:00 AM"));
    }

    @DisplayName("Test unsuccessful cancel booking")
    @Test
    void testCancelReservation_InvalidInput() {
        movie.bookTicket("10:00 AM", 5);
        movie.cancelReservation("10:00 AM", 10);
        assertTrue(movie.checkAvailability("10:00 AM"));
    }

    @DisplayName("Test book another showtime")
    @Test
    void testBookAnotherShowtime() {
        movie.bookTicket("1:00 PM", 5);
        assertTrue(movie.checkAvailability("1:00 PM"));
    }

}
