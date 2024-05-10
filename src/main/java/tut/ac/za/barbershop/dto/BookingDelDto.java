package tut.ac.za.barbershop.dto;

public class BookingDelDto {

    private Long bookingId;

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public String toString() {
        return "BookingDelDto{" +
                "bookingId=" + bookingId +
                '}';
    }
}
