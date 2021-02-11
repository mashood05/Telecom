package com.mashood.telecom.service;

import com.mashood.telecom.data.SimResponceData;
import com.mashood.telecom.domain.Sim;

public interface SimWritePlateformService {
    SimResponceData createSim(Sim sim);
}
