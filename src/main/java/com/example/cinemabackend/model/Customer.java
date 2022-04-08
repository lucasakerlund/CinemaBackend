package com.example.cinemabackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
    private int customer_id;
    private String name;
    private String mail;

    public Customer(@JsonProperty("customer_id") int customer_id,
                    @JsonProperty("name") String name,
                    @JsonProperty("mail") String mail){

        this.customer_id = customer_id;
        this.name = name;
        this.mail = mail;
    }
    public int getCustomer_id(){return customer_id;}

    public void setCustomer_id(int customer_id){this.customer_id = customer_id;}

    public String getName(){return name;}
    public void setName(String name){
        this.name = name;
    }

    public String getMail(){return mail;}
    public void setMail(String mail){
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ",name='" + name + '\'' +
                ",mail='" + mail + '\'' +
                '}';
    }
}
