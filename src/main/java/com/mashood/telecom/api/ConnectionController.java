package com.mashood.telecom.api;

import com.mashood.telecom.data.SimLinkRequestData;
import com.mashood.telecom.domain.Customer;
import com.mashood.telecom.service.CustomerReadPlateformService;
import com.mashood.telecom.service.CustomerWritePlateformService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/link")
public class ConnectionController {

    private final CustomerWritePlateformService customerWritePlateformService;
    private final CustomerReadPlateformService customerReadPlateformService;
    private Logger logger = LoggerFactory.getLogger(ConnectionController.class);


    @Autowired
    public ConnectionController(CustomerWritePlateformService customerWritePlateformService, CustomerReadPlateformService customerReadPlateformService) {
        this.customerWritePlateformService = customerWritePlateformService;
        this.customerReadPlateformService = customerReadPlateformService;
    }

    @PostMapping("{id}")
    public Customer LinkSimToCustomer(@RequestBody SimLinkRequestData simId, @PathVariable("id") Long customerId){
        logger.info("Link: Liking Sim "+simId+" to Customer "+customerId);
        return this.customerWritePlateformService.linkSim(customerId,simId.getId());
    }


}
