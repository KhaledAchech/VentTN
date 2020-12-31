package com.TekUp.VentTNDemo.Configuration;
/************************************
 ********* author : Khaled ***********
 *** last update : December the 31st**
 ************************************/
public interface PasswordEncryptOrDecrypt {

    int key = 5;

    public String EncryptPassword(String password);
    public String DecryptPassword(String password);
}
