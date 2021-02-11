package com.mashood.telecom.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mashood.telecom.domain.Customer;
import com.mashood.telecom.domain.Sim;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;

public class CustomerResponceData {


    private long id;
    private String name;
    private String email;
    private Date date;

    public CustomerResponceData() {
    }

    public CustomerResponceData(long id, String name, String email, Date date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
