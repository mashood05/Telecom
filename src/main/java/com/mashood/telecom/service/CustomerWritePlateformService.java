package com.mashood.telecom.service;

import com.mashood.telecom.domain.Customer;

import java.util.List;

public interface CustomerWritePlateformService {
    Customer createCustomer(Customer customer);
    Customer linkSim(Long customerId, List<Long> simId);
}
