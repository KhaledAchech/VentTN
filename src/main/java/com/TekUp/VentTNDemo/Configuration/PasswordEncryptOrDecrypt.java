package com.TekUp.VentTNDemo.Configuration;

public interface PasswordEncryptOrDecrypt {

    int key = 5;

    public String EncryptPassword(String password);
    public String DecryptPassword(String password);
}
