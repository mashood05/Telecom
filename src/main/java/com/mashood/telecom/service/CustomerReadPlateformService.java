package com.mashood.telecom.service;

import com.mashood.telecom.data.CustomerResponceData;
import com.mashood.telecom.domain.Customer;

import java.util.List;

public interface CustomerReadPlateformService {
    List<Customer> getAllCustomer();
    Customer getCustomerById(long id);
}
