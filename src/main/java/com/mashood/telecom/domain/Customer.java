package com.mashood.telecom.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "t_customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "birthdate")
    private Date date;

    @OneToMany(targetEntity = Sim.class,cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    @JoinColumn(name = "cs_fk",referencedColumnName = "customer_id")
    private List<Sim> sim;

    public Customer() {
    }

    public Customer(long id, String name, String email, Date date, List<Sim> sim) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.date = date;
        this.sim = sim;
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

    public List<Sim> getSim() {
        return sim;
    }

    public void setSim(List<Sim> sim) {
        this.sim = sim;
    }
}
