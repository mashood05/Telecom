package com.mashood.telecom.api;

import com.mashood.telecom.data.SimResponceData;
import com.mashood.telecom.domain.Sim;
import com.mashood.telecom.service.SimReadPlatformService;
import com.mashood.telecom.service.SimWritePlateformService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sim")
public class SimController {



    private final SimWritePlateformService simWritePlateformService;
    private final SimReadPlatformService simReadPlatformService;
    private Logger logger = LoggerFactory.getLogger(SimController.class);
    @Autowired
    public SimController(SimWritePlateformService simWritePlateformService, SimReadPlatformService simReadPlatformService) {
        this.simWritePlateformService = simWritePlateformService;
        this.simReadPlatformService = simReadPlatformService;
    }

    @PostMapping
    public SimResponceData createSim(@RequestBody Sim s){
        logger.info("Sim: Creating sim "+s.getSimNumber());
        return this.simWritePlateformService.createSim(s);
    }

    @GetMapping
    public List<Sim> getAllSims(){
        return this.simReadPlatformService.getAllSims();
    }

    @GetMapping("{customerId}")
    public List<Sim> getCustomerSims(@PathVariable("customerId") Long id){
        logger.info("Sim: Getting all sim of customer "+id);
        return this.simReadPlatformService.getSimsByCustomerId(id);
    }


}
