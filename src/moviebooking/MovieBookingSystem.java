package moviebooking;

import java.util.ArrayList;

public class MovieBookingSystem extends BookingSystem {
    /** Arraylist for available showtimes. */
    private ArrayList<String> showtimes;
    /** Arraylist for tickets available per showtime. */
    private ArrayList<Integer> availableTickets;
    /** Total number of available tickets. */
    private final int totalTICKETS = 75;

    /** Available tickets getter.
     * @param showTime
     * @return number of available tickets
     */
    public int getAvailableTickets(final String showTime) {
        int timeslot = findMovieIndex(showTime);
        return availableTickets.get(timeslot);
    }

    /** Arraylist for tickets booked per showtime. */
    private ArrayList<Integer> bookedTickets;
    /** Booked tickets getter.
     * @param showTime
     * @return number of booked tickets
     */
    public int getBookedTickets(final String showTime) {
        int timeslot = findMovieIndex(showTime);
        return bookedTickets.get(timeslot);
    }

    /**
     * MovieBookingSystem constructor.
     */
    public MovieBookingSystem() {
        showtimes = new ArrayList<>();
        availableTickets = new ArrayList<>();
        bookedTickets = new ArrayList<>();

        addShow("10:00 AM", totalTICKETS);
        addShow("1:00 PM", totalTICKETS);
        addShow("3:00 PM", totalTICKETS);
        addShow("7:00 PM", totalTICKETS);

    }

    /**
     * Checks the availability of the showtime.
     * @param showTime
     * @return whether the showtime is available
     */
    public boolean checkAvailability(final String showTime) {
        int timeslot = findMovieIndex(showTime);
        if (timeslot == -1) {
            System.out.println("Invalid showtime.");
            return false;
        }
        return availableTickets.get(timeslot) > 0;
    }

    /**
     * Books tickets for a specified showtime.
     * @param showTime
     * @param tickets
     */
    public void bookTicket(final String showTime, final int tickets) {
        int timeslot = findMovieIndex(showTime);
        if (timeslot == -1) {
            System.out.println("Invalid showtime.");
            return;
        }
        if (availableTickets.get(timeslot) >= tickets) {
            availableTickets.set(timeslot, availableTickets.get(timeslot)
                    - tickets);
            bookedTickets.set(timeslot, bookedTickets.get(timeslot) + tickets);
            System.out.println(tickets + " tickets successfully booked for "
                    + showTime);
        } else {
            System.out.println(
                    "Not enough tickets available for this showtime");
        }
    }

    /**
     * Cancels reservation for a specified showtime.
     * @param showTime
     * @param tickets
     */
    public void cancelReservation(final String showTime, final int tickets) {
        int timeslot = findMovieIndex(showTime);
        if (timeslot == -1) {
            System.out.println("Invalid showtime.");
            return;
        }
        if (bookedTickets.get(timeslot) >= tickets) {
            bookedTickets.set(timeslot, bookedTickets.get(timeslot) - tickets);
            availableTickets.set(timeslot, availableTickets.get(timeslot)
                    + tickets);
            System.out.println(tickets + " tickets successfully canceled for "
                    + showTime);
        } else {
            System.out.println("Invalid operation "
                    + "(Attempt to cancel more tickets than booked)");
        }
    }

    /** Returns the index number of the specified showtime.
     * @param showTime
     * @return index of showTime
     */
    public int findMovieIndex(final String showTime) {
        return showtimes.indexOf(showTime);
    }

    private void addShow(final String showTime, final int tickets) {
        showtimes.add(showTime);
        availableTickets.add(tickets);
        bookedTickets.add(0);
    }

    /**
     * Main method to test MovieBookingSystem functionality.
     * @param args
     */
    public static void main(final String[] args) {
//        MovieBookingSystem movie = new MovieBookingSystem();
//
//        movie.checkAvailability("10:00 AM");
//        movie.bookTicket("10:00 AM", 5);
//        movie.bookTicket("10:00 AM", 100);
//        movie.cancelReservation("10:00 AM", 3);
//        movie.bookTicket("1:00 PM", 2);
//        movie.cancelReservation("1:00 PM", 5);
    }

}
