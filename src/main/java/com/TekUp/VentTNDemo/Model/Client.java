package com.TekUp.VentTNDemo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 16th**
 ************************************/
@Entity
public class Client extends User{

    //default constructor
    public Client() {
    }

    //default constructor
    public Client(long id, String name, String address, String email, String password, String telephone_number, int poste_code) {
        super(id, name, address, email, password, telephone_number, poste_code);
    }

    @OneToMany(mappedBy = "client",cascade = CascadeType.REMOVE)
    private Set<Message> clients_messages = new HashSet<>();

    @OneToMany(mappedBy = "client",cascade = CascadeType.REMOVE)
    private Set<Order> clients_orders = new HashSet<>();

    public Set<Message> getClients_messages() {
        return clients_messages;
    }

    public void setClients_messages(Set<Message> clients_messages) {
        this.clients_messages = clients_messages;
    }

    public Set<Order> getClients_orders() {
        return clients_orders;
    }

    public void setClients_orders(Set<Order> clients_orders) {
        this.clients_orders = clients_orders;
    }
}
