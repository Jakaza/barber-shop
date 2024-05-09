package tut.ac.za.barbershop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tut.ac.za.barbershop.dto.BookingDto;
import tut.ac.za.barbershop.entities.Booking;
import tut.ac.za.barbershop.entities.Customer;
import tut.ac.za.barbershop.repository.BookingRepository;

import java.util.Date;
import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public void reserveSeat(BookingDto bookingDto, Customer customer) {
        Booking booking = new Booking();
        booking.setName(bookingDto.getName());
        booking.setContacts(bookingDto.getContacts());
        booking.setDate(bookingDto.getDate());
        booking.setBranch(bookingDto.getBranch());
        booking.setTime(bookingDto.getTime());
        booking.setStyle(bookingDto.getStyle());
        booking.setCreationDate(new Date());
        booking.setStatus("Pending");
        booking.setCustomer(customer);
        bookingRepository.save(booking);
    }

    public List<Booking> getBookings(Long id) {
        return bookingRepository.findAll();
    }
}
