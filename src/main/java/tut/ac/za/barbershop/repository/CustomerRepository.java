package tut.ac.za.barbershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tut.ac.za.barbershop.entities.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);
}
