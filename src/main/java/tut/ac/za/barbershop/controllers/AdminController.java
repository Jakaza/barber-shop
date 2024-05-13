package tut.ac.za.barbershop.controllers;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import tut.ac.za.barbershop.dto.BookingDto;
import tut.ac.za.barbershop.dto.BookingStatusDto;
import tut.ac.za.barbershop.dto.HairStyleDto;
import tut.ac.za.barbershop.entities.Booking;
import tut.ac.za.barbershop.entities.Customer;
import tut.ac.za.barbershop.entities.HairStyle;
import tut.ac.za.barbershop.service.BookingService;
import tut.ac.za.barbershop.service.CustomerService;
import tut.ac.za.barbershop.service.HaireStyleService;
import tut.ac.za.barbershop.utils.SessionManager;

import java.util.List;

@Controller
public class AdminController {

    private final SessionManager sessionManager;
    private final CustomerService customerService;
    private final BookingService bookingService;
    private final HaireStyleService haireStyleService;

    public AdminController(SessionManager sessionManager, CustomerService customerService, BookingService bookingService, HaireStyleService haireStyleService) {
        this.sessionManager = sessionManager;
        this.customerService = customerService;
        this.bookingService = bookingService;
        this.haireStyleService = haireStyleService;
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

    @GetMapping("/all-hair-style")
    public String getAllHairStyle(Model model, HttpSession session) {
        Customer user = sessionManager.getCustomerFromSession(session.getId());
        if (user != null) {

            List<HairStyle> hairStyles = haireStyleService.findAllHairStyles();

            model.addAttribute("hairStyles", hairStyles);
            return "viewHairStyles";
        }else{
            return "redirect:/";
        }
    }

    @PostMapping("/admin/hairstyle/create")
    public String addHairStyle(@Valid @ModelAttribute("hairstyle") HairStyleDto hairStyleDto,
                           BindingResult result,
                           Model model, HttpSession session){
        Customer customer = sessionManager.getCustomerFromSession(session.getId());

        if (customer == null) {
            return "redirect:/login";
        }else{
            model.addAttribute("hairstyle", hairStyleDto);

            if(result.hasErrors()){
                System.out.println("Something went wrong");
                System.out.println("Errors:");
                for (FieldError error : result.getFieldErrors()) {
                    System.out.println(error.getDefaultMessage());
                }
                model.addAttribute("hairStyleDto", hairStyleDto);
                return "viewHairStyles";
            }

            System.out.println(hairStyleDto.toString());

            System.out.println("No Errors");
            haireStyleService.addNewHairStyle(hairStyleDto);
            return "redirect:/all-hair-style?success";
        }
    }

    @PostMapping("/admin/hairstyle/update")
    public String updateHairStyle(@Valid @ModelAttribute("hairstyle") HairStyleDto hairStyleDto,
                               BindingResult result,
                               Model model, HttpSession session){
        Customer customer = sessionManager.getCustomerFromSession(session.getId());

        if (customer == null) {
            return "redirect:/login";
        }else{
            model.addAttribute("hairstyle", hairStyleDto);

            if(result.hasErrors()){
                System.out.println("Something went wrong");
                System.out.println("Errors:");
                for (FieldError error : result.getFieldErrors()) {
                    System.out.println(error.getDefaultMessage());
                }
                model.addAttribute("hairStyleDto", hairStyleDto);
                return "redirect:/all-hair-style?error";
            }
            haireStyleService.updateHairStyle(hairStyleDto);
            return "redirect:/all-hair-style?updatesuccess";
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
