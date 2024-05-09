package tut.ac.za.barbershop.controllers;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import tut.ac.za.barbershop.dto.BookingDto;
import tut.ac.za.barbershop.entities.Customer;
import tut.ac.za.barbershop.service.BookingService;
import tut.ac.za.barbershop.utils.SessionManager;

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
}
