package com.mashood.telecom.data;

import com.mashood.telecom.domain.Customer;

public class CustomerRequestData {
    private Customer customer;

    public CustomerRequestData() {
    }

    public CustomerRequestData(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
