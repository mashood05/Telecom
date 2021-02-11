package com.mashood.telecom.data;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SimResponceData {

    private long id;
    private String simNumber;
    private String simPin;

    public SimResponceData() {
    }

    public SimResponceData(long id, String simNumber, String simPin) {
        this.id = id;
        this.simNumber = simNumber;
        this.simPin = simPin;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSimNumber() {
        return simNumber;
    }

    public void setSimNumber(String simNumber) {
        this.simNumber = simNumber;
    }

    public String getSimPin() {
        return simPin;
    }

    public void setSimPin(String simPin) {
        this.simPin = simPin;
    }
}
