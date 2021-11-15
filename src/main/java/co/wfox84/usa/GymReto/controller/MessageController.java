/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.wfox84.usa.GymReto.controller;

import co.wfox84.usa.GymReto.model.Message;
import co.wfox84.usa.GymReto.service.MessageService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * 
 * @author masterKomodoro
 */
@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class MessageController {
    
    @Autowired
    private MessageService messageService;
    
    @GetMapping("/all")
    public List<Message> getMessage(){
        return messageService.getAll();    
    }

    @GetMapping("/{idMessage}")
    public Optional<Message> getMessage(@PathVariable("id") int idMessage){
        return messageService.getMessage(idMessage);
    
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message message){
        return messageService.save(message);
    
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message message){
        return  messageService.update(message);
    }

    @DeleteMapping("/{idMessage}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("idMessage") int idMessage){
        return messageService.deleteMessage(idMessage);
    }

    
}
