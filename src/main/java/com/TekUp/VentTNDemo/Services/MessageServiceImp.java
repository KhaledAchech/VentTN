package com.TekUp.VentTNDemo.Services;

import com.TekUp.VentTNDemo.Model.Category;
import com.TekUp.VentTNDemo.Model.Message;
import com.TekUp.VentTNDemo.Repositories.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 18th**
 ************************************/
@Service
public class MessageServiceImp implements MessageService {

    private final MessageRepo messageRepo;

    @Autowired
    public MessageServiceImp(MessageRepo messageRepo)
    {
        super();
        this.messageRepo = messageRepo;
    }

    @Override
    public Message findMessageById(long id) {
        return messageRepo.findById(id).get();
    }

    @Override
    public List<Message> findAllMessages() {
        return (List<Message>) messageRepo.findAll();
    }

    @Override
    public Message addMessage(Message message) {
        return messageRepo.save(message);
    }

    @Override
    public Message modifyMessage(long id, Message newMessage) {
        Message thisMessage = this.findMessageById(id);

        if(newMessage.getContent()!=null)
        {
            thisMessage.setContent(newMessage.getContent());
        }
        if(newMessage.getSubject()!=null)
        {
            thisMessage.setSubject(newMessage.getSubject());
        }

        return messageRepo.save(thisMessage);
    }

    @Override
    public Message deleteMessageById(long id) {
        Message message = this.findMessageById(id);
        messageRepo.deleteById(id);
        return message;
    }
}
