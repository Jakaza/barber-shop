package tut.ac.za.barbershop.controllers;

import tut.ac.za.barbershop.service.CustomerService;
import tut.ac.za.barbershop.utils.SessionManager;

public class AdminController {

    private final SessionManager sessionManager;
    private final CustomerService customerService;

    public AdminController(SessionManager sessionManager, CustomerService customerService) {
        this.sessionManager = sessionManager;
        this.customerService = customerService;
    }


    ///adminMenu
}
