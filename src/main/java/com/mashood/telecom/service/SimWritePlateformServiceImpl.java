package com.mashood.telecom.service;

import com.mashood.telecom.data.SimResponceData;
import com.mashood.telecom.domain.CustomerRepository;
import com.mashood.telecom.domain.Sim;
import com.mashood.telecom.domain.SimRepository;
import org.springframework.stereotype.Service;

@Service
public class SimWritePlateformServiceImpl implements SimWritePlateformService {

    private final CustomerRepository customerRepository;
    private final SimRepository simRepository;

    public SimWritePlateformServiceImpl(CustomerRepository customerRepository, SimRepository simRepository) {
        this.customerRepository = customerRepository;
        this.simRepository = simRepository;
    }


    // this function will create SIM
    @Override
    public SimResponceData createSim(Sim sim) {
        Sim simDbResponce = this.simRepository.save(sim);
        SimResponceData simResponceData = new SimResponceData();
        simResponceData.setId(simDbResponce.getId());
        simResponceData.setSimNumber(simDbResponce.getSimNumber());
        simResponceData.setSimPin(simDbResponce.getSimPin());
        return simResponceData;
    }
}
