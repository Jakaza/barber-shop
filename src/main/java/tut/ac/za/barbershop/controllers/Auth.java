package tut.ac.za.barbershop.controllers;


import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import tut.ac.za.barbershop.dto.CustomerDto;
import tut.ac.za.barbershop.dto.CustomerLoginDto;
import tut.ac.za.barbershop.entities.Customer;
import tut.ac.za.barbershop.service.CustomerService;
import tut.ac.za.barbershop.utils.SessionManager;


@Controller
public class Auth {

    private final SessionManager sessionManager;
    private final CustomerService customerService;

    public Auth(SessionManager sessionManager, CustomerService customerService) {
        this.sessionManager = sessionManager;
        this.customerService = customerService;
    }

    @GetMapping("/")
    public String home(Model model , HttpSession session){
        Customer customer = sessionManager.getCustomerFromSession(session.getId());
        if(customer != null){
            return "redirect:/book";
        }
        return "index";
    }

    @GetMapping("/book")
    public String barber(Model model , HttpSession session){
        Customer customer = sessionManager.getCustomerFromSession(session.getId());
        if (customer != null) {
            session.setAttribute("authenticated", true);
            model.addAttribute("user_id", customer.getId());
            return "frontend";
        }else{
            return "redirect:/login";
        }
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        CustomerDto customer = new CustomerDto();
        model.addAttribute("customer", customer);
        return "register";
    }


    @GetMapping("/login")
    public String showLoginForm(Model model){
        CustomerLoginDto customer = new CustomerLoginDto();
        model.addAttribute("customerLogin", customer);
        return "login";
    }

    @GetMapping("/logout")
    public String customerLogout(Model model , HttpSession session){
        String sessionId = session.getId();
        sessionManager.removeSession(sessionId);
        return "redirect:/";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("customer") CustomerDto customerDto,
                               BindingResult result,
                               Model model){

        Customer customer = customerService.findCustomerByEmail(customerDto.getEmail());

        if(customer != null && customer.getEmail() != null && !customer.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if(result.hasErrors()){
            model.addAttribute("customer", customerDto);
            return "/register";
        }
        customerService.saveCustomer(customerDto);
        return "redirect:/register?success";
    }

    @PostMapping("/auth/login")
    public String loginUser(@Valid @ModelAttribute("customerLogin") CustomerLoginDto customerLoginDto,
                            BindingResult result,
                            Model model , HttpSession session){
        Customer customer = customerService.customerLogin(customerLoginDto.getEmail(), customerLoginDto.getPassword());

        if (customerLoginDto.getEmail().equals("myadmin@gmail.com") && customerLoginDto.getPassword().equals("admin")) {
            Customer admin = new Customer();
            admin.setEmail("myadmin@gamil.com");
            admin.setPassword("admin");
            sessionManager.createSession(session.getId(), admin);
            return "redirect:/dashboard";
        }
        if(result.hasErrors()){
            model.addAttribute("customerLogin", customerLoginDto);
            return "/login";
        }
        if (customer != null) {
            sessionManager.createSession(session.getId(), customer);
            return "redirect:/";
        } else {
            model.addAttribute("error", "Invalid email or password, Please enter correct credential.");
            return "/login"; // Return to the login page
        }
    }

}
