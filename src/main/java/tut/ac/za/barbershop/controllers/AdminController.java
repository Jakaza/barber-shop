package tut.ac.za.barbershop.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tut.ac.za.barbershop.dto.BookingDto;
import tut.ac.za.barbershop.dto.BookingStatusDto;
import tut.ac.za.barbershop.entities.Booking;
import tut.ac.za.barbershop.entities.Customer;
import tut.ac.za.barbershop.service.BookingService;
import tut.ac.za.barbershop.service.CustomerService;
import tut.ac.za.barbershop.utils.SessionManager;

import java.util.List;

@Controller
public class AdminController {

    private final SessionManager sessionManager;
    private final CustomerService customerService;
    private final BookingService bookingService;

    public AdminController(SessionManager sessionManager, CustomerService customerService, BookingService bookingService) {
        this.sessionManager = sessionManager;
        this.customerService = customerService;
        this.bookingService = bookingService;
    }

    @GetMapping("/dashboard")
    public String adminMenu(Model model, HttpSession session) {
        Customer user = sessionManager.getCustomerFromSession(session.getId());

        if (user != null) {
            return "adminMenu";
        }else{
            return "redirect:/";
        }
    }


    @GetMapping("/all-bookings")
    public String getAllBookings(Model model, HttpSession session) {
        Customer user = sessionManager.getCustomerFromSession(session.getId());
        if (user != null) {

            List<Booking> bookings = bookingService.getBookings();

            BookingStatusDto bookingStatusDto = new BookingStatusDto();
            model.addAttribute("bookingStatusDto", bookingStatusDto);
            model.addAttribute("bookings", bookings);

            return "viewBookings";
        }else{
            return "redirect:/";
        }
    }

    @GetMapping("/all-customers")
    public String getAllCustomers(Model model, HttpSession session) {
        Customer user = sessionManager.getCustomerFromSession(session.getId());
        if (user != null) {

            List<Customer> customers = customerService.findAllCustomers();

            BookingStatusDto bookingStatusDto = new BookingStatusDto();
            model.addAttribute("customers", customers);

            return "viewCustomers";
        }else{
            return "redirect:/";
        }
    }

    private boolean isAdmin(Customer user) {
        System.out.println("isAdmin : email" + user.getEmail());

        if(user.getEmail().equalsIgnoreCase("myadmin@gmail.com")){
            return true;
        }else{
            return false;
        }
    }

}
