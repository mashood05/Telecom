package com.mashood.telecom.utils.reporting;

import com.mashood.telecom.domain.Customer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public interface Report {
    public void genrateReport(List<Customer> customer, LocalDate localDate, LocalTime localTime);
}
