package com.TekUp.VentTNDemo.Services;

import com.TekUp.VentTNDemo.Model.Bill;
import com.TekUp.VentTNDemo.Model.Message;
import com.TekUp.VentTNDemo.Model.Product;

import java.util.List;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 18th**
 ************************************/
public interface MessageService {
    Message findMessageById(long id);
    List<Message> findAllMessages();

    Message addMessage(Message message);
    Message modifyMessage(long id, Message message);
    Message deleteMessageById(long id);
}
