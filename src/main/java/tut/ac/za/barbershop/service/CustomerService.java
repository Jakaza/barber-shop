package tut.ac.za.barbershop.service;

import tut.ac.za.barbershop.dto.CustomerDto;
import tut.ac.za.barbershop.entities.Customer;

public interface CustomerService {
    void saveCustomer(CustomerDto customerDto);
    void deleteCustomer(Long customerId);
    Customer findCustomerByEmail(String email);
    public Customer customerLogin(String email, String password);
}
