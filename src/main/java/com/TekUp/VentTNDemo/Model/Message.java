package com.TekUp.VentTNDemo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 16th**
 ************************************/
@Entity
/*Message Class */
public class Message {

    //Class Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "content")
    private String content;
    private String subject;
    private LocalDate date;


    @ManyToOne
    @JsonIgnore
    private User user;



    //Constructor without parameters
    public Message() { }

    /*
    //Constructor with parameters for client messages
    public Message(long id, String message, String subject, LocalDate date,Client from, Admin to) {
        this.id = id;
        this.message = message;
        this.subject = subject;
        this.date = date;
        this.client = from;
        this.admin = to;
    }

    //Constructor with parameters for admin messages
    public Message(long id, String message, String subject, LocalDate date, Admin from, client to) {
        this.id = id;
        this.message = message;
        this.subject = subject;
        this.date = date;
        this.admin = from;
        this.client = to;
    }
    */
    //basic constructor
    public Message(long id, String message, String subject, LocalDate date)
    {
        this.id = id;
        this.content = message;
        this.subject = subject;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String message) {
        this.content = message;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        return id == message.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", Subject='" + subject + '\'' +
                ", date=" + date +
                '}';
    }

}
