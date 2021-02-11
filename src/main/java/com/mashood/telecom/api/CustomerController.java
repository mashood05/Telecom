package com.mashood.telecom.api;

import com.mashood.telecom.data.CustomerResponceData;
import com.mashood.telecom.domain.Customer;
import com.mashood.telecom.service.CustomerReadPlateformService;
import com.mashood.telecom.service.CustomerWritePlateformService;
import com.mashood.telecom.utils.notifier.ImportentDateNotifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {


    private final CustomerWritePlateformService customerWritePlateformService;
    private final CustomerReadPlateformService customerReadPlateformService;
    private final ImportentDateNotifier importentDateNotifier;
    private Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    public CustomerController(CustomerWritePlateformService customerWritePlateformService, CustomerReadPlateformService customerReadPlateformService, ImportentDateNotifier importentDateNotifier) {
        this.customerWritePlateformService = customerWritePlateformService;
        this.customerReadPlateformService = customerReadPlateformService;
        this.importentDateNotifier = importentDateNotifier;
    }

    @PostMapping
    public CustomerResponceData createCustomer(@RequestBody Customer c){
        logger.info("Creating customer:"+ c.getName());
        Customer customer = this.customerWritePlateformService.createCustomer(c);
        CustomerResponceData customerResponceData = new CustomerResponceData();
        customerResponceData.setId(customer.getId());
        customerResponceData.setName(customer.getName());
        customerResponceData.setEmail(customer.getEmail());
        customerResponceData.setDate(customer.getDate());
        return customerResponceData;
    }

    @GetMapping
    public List<Customer> getAllCustomer(){
        logger.info("Customer: Getting all customers");
        return this.customerReadPlateformService.getAllCustomer();
    }

    @GetMapping("{customerId}")
    public Customer getCustomerSims(@PathVariable("customerId") Long id){
        logger.info("Customer: Getting sims of customer"+id.toString());
        return this.customerReadPlateformService.getCustomerById(id);
    }



}
