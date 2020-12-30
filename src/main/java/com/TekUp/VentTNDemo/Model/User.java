package com.TekUp.VentTNDemo.Model;


import com.TekUp.VentTNDemo.Configuration.PasswordEncryptOrDecrypt;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 16th**
 ************************************/

/* The parent Class for all the users */
@Entity
@Table(name = "user_table")
public class User implements PasswordEncryptOrDecrypt {

    //class attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;
    private String email;
    private String password;
    private String telephone_number;
    private int poste_code;
    private String type;

    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    private Set<Message> users_messages = new HashSet<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    private Set<Order> users_orders = new HashSet<>();
    //Default Constructor
    public User(){}

    //Class Constructor
    public User(long id, String name, String address, String email, String password, String telephone_number, int poste_code, String type) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.password = password;
        this.telephone_number = telephone_number;
        this.poste_code = poste_code;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone_number() {
        return telephone_number;
    }

    public void setTelephone_number(String telephone_number) {
        this.telephone_number = telephone_number;
    }

    public int getPoste_code() {
        return poste_code;
    }

    public void setPoste_code(int poste_code) {
        this.poste_code = poste_code;
    }

    public Set<Message> getUsers_messages() {
        return users_messages;
    }

    public void setUsers_messages(Set<Message> users_messages) {
        this.users_messages = users_messages;
    }

    public Set<Order> getUsers_orders() {
        return users_orders;
    }

    public void setUsers_orders(Set<Order> users_orders) {
        this.users_orders = users_orders;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", telephone_number='" + telephone_number + '\'' +
                ", poste_code=" + poste_code +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id == user.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String EncryptPassword(String password) {
        int key = PasswordEncryptOrDecrypt.key;

        char[] enc = password.toCharArray();

        String encpass = "";

        for(char e : enc)
        {
            e += key;
            encpass+=e;
        }

        return encpass;
    }

    @Override
    public String DecryptPassword(String password) {
        int key = PasswordEncryptOrDecrypt.key;

        char[] dec = password.toCharArray();

        String decpass = "";

        for(char e : dec)
        {
            e -= key;
            decpass+=e;
        }

        return decpass;
    }
}
