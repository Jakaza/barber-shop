package tut.ac.za.barbershop.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
@Controller
public class CustomErrorController {

    @GetMapping("/pageNotFound")
    public String handlePageNotFound() {
        return "pageNotFound";
    }

}


