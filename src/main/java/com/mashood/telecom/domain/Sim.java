package com.mashood.telecom.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "t_sim")
public class Sim {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sim_id")
    private long id;
    @Column(name = "sim_number")
    private String simNumber;
    @Column(name = "sim_pin")
    private String simPin;

    public Sim() {
    }

    public Sim(long id, String simNumber, String simPin) {
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
