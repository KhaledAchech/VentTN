package com.TekUp.VentTNDemo.Model;

import javax.persistence.*;
import java.time.LocalDate;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 17th**
 ************************************/
@Entity
@Table(name = "Bill_Table")
//The class Bill
public class Bill {

    //class attributs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bill_ID;

    private String address_livraison;
    private String mode_paiement;
    private LocalDate date_commande;
    private int promotion;
    private float montant;

    @OneToOne(mappedBy = "bill")
    private Order order;

    //default constructor
    public Bill() {}

    //constructor with parameters
    public Bill(long bill_ID, String address_livraison, String mode_paiement, LocalDate date_commande, int promotion, float montant, Order order) {
        this.bill_ID = bill_ID;
        this.address_livraison = address_livraison;
        this.mode_paiement = mode_paiement;
        this.date_commande = date_commande;
        this.promotion = promotion;
        this.montant = montant;
        this.order = order;
    }

    public long getBill_ID() {
        return bill_ID;
    }

    public void setBill_ID(long bill_ID) {
        this.bill_ID = bill_ID;
    }

    public String getAddress_livraison() {
        return address_livraison;
    }

    public void setAddress_livraison(String address_livraison) {
        this.address_livraison = address_livraison;
    }

    public String getMode_paiement() {
        return mode_paiement;
    }

    public void setMode_paiement(String mode_paiement) {
        this.mode_paiement = mode_paiement;
    }

    public LocalDate getDate_commande() {
        return date_commande;
    }

    public void setDate_commande(LocalDate date_commande) {
        this.date_commande = date_commande;
    }

    public int getPromotion() {
        return promotion;
    }

    public void setPromotion(int promotion) {
        this.promotion = promotion;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bill bill = (Bill) o;

        return bill_ID == bill.bill_ID;
    }

    @Override
    public int hashCode() {
        return (int) (bill_ID ^ (bill_ID >>> 32));
    }

    @Override
    public String toString() {
        return "Bill{" +
                "bill_ID=" + bill_ID +
                ", address_livraison='" + address_livraison + '\'' +
                ", mode_paiement='" + mode_paiement + '\'' +
                ", date_commande=" + date_commande +
                ", promotion=" + promotion +
                ", montant=" + montant +
                ", order=" + order +
                '}';
    }
}
