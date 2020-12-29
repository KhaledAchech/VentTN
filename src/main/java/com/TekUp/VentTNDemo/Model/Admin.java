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
public class Admin extends User {

    //default constructor
    public Admin() {
    }

    //constructor with parameters
    public Admin(long id, String name, String address, String email, String password, String telephone_number, int poste_code) {
        super(id, name, address, email, password, telephone_number, poste_code);
    }




    @OneToMany(mappedBy = "admin",cascade = CascadeType.REMOVE)
    private Set<Message> admins_messages = new HashSet<>();

    public Set<Message> getAdmins_messages() {
        return admins_messages;
    }

    public void setAdmins_messages(Set<Message> admins_messages) {
        this.admins_messages = admins_messages;
    }
}
