package com.TekUp.VentTNDemo.Model;


import javax.persistence.*;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 16th**
 ************************************/

/* The parent Class for all the users */
@Entity
@Table(name = "user_table")
public class User {

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

    //Default Constructor
    public User(){}

    //Class Constructor
    public User(long id, String name, String address, String email, String password, String telephone_number, int poste_code) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.password = password;
        this.telephone_number = telephone_number;
        this.poste_code = poste_code;
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
}
