package tut.ac.za.barbershop.dto;

import jakarta.validation.constraints.NotBlank;

public class BookingStatusDto {

    private Long bookingId;

    private String status;

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
