package com.mashood.telecom.data;

public class SimRequestData {
    private String simNumber;
    private String simPin;

    public SimRequestData() {
    }

    public SimRequestData(String simNumber, String simPin) {
        this.simNumber = simNumber;
        this.simPin = simPin;
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
