package tut.ac.za.barbershop.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tut.ac.za.barbershop.entities.Booking;
import tut.ac.za.barbershop.entities.Customer;
import tut.ac.za.barbershop.service.BookingService;
import tut.ac.za.barbershop.utils.SessionManager;

import java.util.List;


@Controller
public class ProfileController {
    private final BookingService bookingService;
    private final SessionManager sessionManager;

    public ProfileController(BookingService bookingService, SessionManager sessionManager) {
        this.bookingService = bookingService;
        this.sessionManager = sessionManager;
    }


    @GetMapping("/profile")
    public String profile(Model model, HttpSession session){
        Customer customer = sessionManager.getCustomerFromSession(session.getId());
        if (customer == null) {
            return "redirect:/login";

        }else{
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
            } else {
                System.out.println("No bookings found for the customer ID: " + customer.getId());
            }


            model.addAttribute("bookings", bookings);
            model.addAttribute("person", customer);
            return "profile";
        }
    }
}
