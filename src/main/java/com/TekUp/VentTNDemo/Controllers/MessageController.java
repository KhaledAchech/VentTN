package com.TekUp.VentTNDemo.Controllers;

import com.TekUp.VentTNDemo.Model.Message;
import com.TekUp.VentTNDemo.Services.MessageService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/************************************
 ********* author : Khaled ***********
 *** last update : November the 18th**
 ************************************/
/*Message Controller*/
@RestController
@RequestMapping(MessageController.BASE_URL)
public class MessageController {

    //Mapping Url
    public static final String  BASE_URL = "/api/DemoVersion/Message";

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PreAuthorize("hasAnyRole('CLIENT','ADMIN')")
    @GetMapping("/secured")
    public List<Message> findAllMessages()
    {
        return messageService.findAllMessages();
    }

    @PreAuthorize("hasAnyRole('CLIENT','ADMIN')")
    @GetMapping("/secured/{id}")
    public Message findMessageById(@PathVariable long id)
    {
        return messageService.findMessageById(id);
    }

}
