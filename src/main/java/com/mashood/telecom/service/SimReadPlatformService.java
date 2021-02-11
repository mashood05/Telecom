package com.mashood.telecom.service;

import com.mashood.telecom.domain.Sim;

import java.util.List;

public interface SimReadPlatformService {
    List<Sim> getSimsByCustomerId(Long id);
    List<Sim> getAllSims();
}
