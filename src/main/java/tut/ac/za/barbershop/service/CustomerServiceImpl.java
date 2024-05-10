package tut.ac.za.barbershop.service;

import org.springframework.stereotype.Service;
import tut.ac.za.barbershop.dto.CustomerDto;
import tut.ac.za.barbershop.entities.Customer;
import tut.ac.za.barbershop.repository.CustomerRepository;
import tut.ac.za.barbershop.utils.PasswordEncryptor;

import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public void saveCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setFirstname(customerDto.getFirstname());
        customer.setAge(customerDto.getAge());
        customer.setEmail(customerDto.getEmail());
        customer.setGender(customerDto.getGender());
        customer.setSurname(customerDto.getSurname());
        customer.setCreationDate(new Date());
        customer.setPassword(PasswordEncryptor.hashPassword(customerDto.getPassword()));
        customerRepository.save(customer);
    }

    public Customer customerLogin(String email, String password) {
        Customer customer = customerRepository.findByEmail(email);
        if (customer != null) {
            String storedHashedPassword = customer.getPassword();
            if (PasswordEncryptor.verifyPassword(password, storedHashedPassword)) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void deleteCustomer(Long customerId) {

    }

    @Override
    public Customer findCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }
}
