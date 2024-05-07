package tut.ac.za.barbershop.utils;
import tut.ac.za.barbershop.entities.Customer;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class SessionManager {
    private Map<String, Customer> sessionMap = new HashMap<>();

    public void createSession(String sessionId, Customer customer) {
        sessionMap.put(sessionId, customer);
    }

    public Customer getCustomerFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

}