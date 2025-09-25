package moviebooking;

public abstract class BookingSystem {
    /** Checks the availability of the showtime.
     * @param showTime
     * @return whether the showtime is available
     */
    public abstract boolean checkAvailability(String showTime);
    /** Books tickets for a specified showtime.
     * @param showTime
     * @param tickets
     */
    public abstract void bookTicket(String showTime, int tickets);
    /** Cancels reservation for a specified showtime.
     * @param showTime
     * @param tickets
     */
    public abstract void cancelReservation(String showTime, int tickets);
}
