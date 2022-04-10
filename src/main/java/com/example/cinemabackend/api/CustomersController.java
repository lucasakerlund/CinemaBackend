package com.example.cinemabackend.api;

import com.example.cinemabackend.model.Customer;
import com.example.cinemabackend.service.CustomerService;
import org.json.JSONObject;
import org.springframework.transaction.jta.UserTransactionAdapter;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/customers")
@RestController
public class CustomersController {

    private final CustomerService service;

    public CustomersController(CustomerService service){
        this.service = service;
    }

    @GetMapping("{id}")
    public Customer getCustomerBySecurityNumber(@PathVariable("id") String securityNumber){
        return service.getCustomerBySecurityNumber(securityNumber);
    }

    @GetMapping(path = "isSecurityNumberAvailable/{id}")
    public boolean isSecurityNumberAvailable(@PathVariable("id") String id){
        return service.isSecurityNumberAvailable(id);
    }

    @PostMapping
    public void createCustomer(@RequestBody String data){
        JSONObject object = new JSONObject(data);
        service.insertCustomer(object.getString("name"), object.getString("security_number"), object.getString("mail"));
    }

}
