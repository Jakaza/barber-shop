package tut.ac.za.barbershop.controllers;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tut.ac.za.barbershop.dto.BookingDelDto;
import tut.ac.za.barbershop.dto.BookingDto;
import tut.ac.za.barbershop.dto.BookingStatusDto;
import tut.ac.za.barbershop.entities.Booking;
import tut.ac.za.barbershop.entities.Customer;
import tut.ac.za.barbershop.service.BookingService;
import tut.ac.za.barbershop.utils.SessionManager;

import java.util.List;

@Controller
public class BookingController {

    private final BookingService bookingService;
    private final SessionManager sessionManager;

    @Autowired
    public BookingController(BookingService bookingService, SessionManager sessionManager) {
        this.bookingService = bookingService;
        this.sessionManager = sessionManager;
    }


    @PostMapping("/make-reservation")
    public String bookSeat(@Valid @ModelAttribute("booking") BookingDto bookingDto,
                           BindingResult result,
                           Model model, HttpSession session){
        Customer customer = sessionManager.getCustomerFromSession(session.getId());

        if (customer == null) {
            return "redirect:/login";
        }else{
            model.addAttribute("booking", bookingDto);

            if(result.hasErrors()){
                System.out.println("Something went wrong");
                System.out.println("Errors:");
                for (FieldError error : result.getFieldErrors()) {
                    System.out.println(error.getDefaultMessage());
                }
                model.addAttribute("booking", bookingDto);
                return "frontend";
            }

            System.out.println(bookingDto.toString());

            System.out.println("No Errors");
            bookingService.reserveSeat(bookingDto , customer);
            return "redirect:/book?success";
        }
    }

    @PostMapping("/delete-reservation")
    public String deleteReservation(@Valid @ModelAttribute("bookingDel") BookingDelDto bookingDelDto,
                                    Model model, HttpSession session){
        Customer customer = sessionManager.getCustomerFromSession(session.getId());
        if (customer == null) {
            return "redirect:/login";
        }else{
            bookingService.deleteReservation(bookingDelDto);
            return "redirect:/all-bookings?delsuccess";
        }
    }

    @PostMapping("/update-booking-status")
    public String upDateBookingStatus(@Valid @ModelAttribute("bookingStatus") BookingStatusDto bookingStatusDto,
                           Model model, HttpSession session){
        Customer customer = sessionManager.getCustomerFromSession(session.getId());

        if (customer == null) {
            return "redirect:/";
        }else{
            model.addAttribute("bookingStatusDto", bookingStatusDto);

            if((bookingStatusDto.getStatus().isEmpty() && bookingStatusDto.getStatus() == null) && "00:00".equals(bookingStatusDto.getTime()) ){
                System.out.println("Something went wrong");
                System.out.println("Errors:");
                return "redirect:/all-bookings?error=Please select booking status to update";
            }

            System.out.println("No Errors");
            bookingService.upDateBookingStatus(bookingStatusDto);
            return "redirect:/all-bookings?success";
        }
    }

    @GetMapping("/user-bookings-testing")
    public String getUserBookings(Model model, HttpSession session){
        Customer customer = sessionManager.getCustomerFromSession(session.getId());

        if (customer == null) {
            return "redirect:/";
        }else {

            List<Booking> bookings = bookingService.getBookingsById(customer.getId());

            if (bookings != null && !bookings.isEmpty()) {
                System.out.println("List of bookings:");
                for (Booking booking : bookings) {
                    System.out.println("Booking ID: " + booking.getId());
                    System.out.println("Name: " + booking.getName());
                    System.out.println("Contacts: " + booking.getContacts());
                    System.out.println("Time: " + booking.getTime());
                    System.out.println("Date: " + booking.getDate());
                    System.out.println("Branch: " + booking.getBranch());
                    System.out.println("Style: " + booking.getStyle());
                    System.out.println("Status: " + booking.getStatus());
                    System.out.println("Creation Date: " + booking.getCreationDate());
                    System.out.println("Customer ID: " + booking.getCustomer().getId());
                    System.out.println("---------------------------------------------");
                }

            }
            return "testing";
        }

    }
}
