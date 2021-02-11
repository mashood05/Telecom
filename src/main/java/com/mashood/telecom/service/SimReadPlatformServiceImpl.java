package com.mashood.telecom.service;

import com.mashood.telecom.domain.Customer;
import com.mashood.telecom.domain.CustomerRepository;
import com.mashood.telecom.domain.Sim;
import com.mashood.telecom.domain.SimRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimReadPlatformServiceImpl implements SimReadPlatformService {

    private final CustomerRepository customerRepository;
    private final SimRepository simRepository;

    public SimReadPlatformServiceImpl(CustomerRepository customerRepository, SimRepository simRepository) {
        this.customerRepository = customerRepository;
        this.simRepository = simRepository;
    }

    // this function will return SIMS of CUSTOMERS according to customer id
    @Override
    public List<Sim> getSimsByCustomerId(Long id) {

        List<Sim> simResponceDataHolder = new ArrayList<>();

        Customer customer = this.customerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer Not Found"));

        Iterable<Sim> sim = customer.getSim();

        sim.forEach(simResponceDataHolder::add);

        return simResponceDataHolder;
    }

    // this function will return all SIMS
    @Override
    public List<Sim> getAllSims() {
        return this.simRepository.findAll();
    }
}
