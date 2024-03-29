package ie.atu.customerservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerDetails addCustomer(CustomerDetails customer) {
        validateCustomerDetails(customer);
        CustomerDetails savedCustomer = customerRepository.save(customer);
        return savedCustomer;
    }

    // needs more methods

    public boolean validateCustomerDetails(CustomerDetails details) {
        if (details.getName() == null || details.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name required");
        }
        if (details.getEmail() == null || !details.getEmail().contains("@")) {
            throw new IllegalArgumentException("Valid email required");
        }
        return true;
    }

}
