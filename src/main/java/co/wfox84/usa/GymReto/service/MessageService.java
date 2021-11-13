/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.wfox84.usa.GymReto.service;

import co.wfox84.usa.GymReto.model.Message;
import co.wfox84.usa.GymReto.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author masterKomodoro
 */
@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message> getAll(){
        
        return messageRepository.getAll();
    }
        
    public Optional<Message> getMessage(int id){
            return messageRepository.getMessage(id);
    }
   
    public Message save(Message  message){
        if(message.getIdMessage()==null){
            return messageRepository.save(message);
        }else{
            Optional<Message> maux=messageRepository.getMessage(message.getIdMessage());
            if(maux.isEmpty()){
                return messageRepository.save(message);
            }else{
                return message;
            
            }
        
        }
    
    }
    public Message update(Message message) {
        if (message.getIdMessage()!= null) {
            Optional<Message> e = messageRepository.getMessage(message.getIdMessage());
            if (!e.isEmpty()) {
                if (message.getMessageText()!= null) {
                    e.get().setMessageText(message.getMessageText());
                    e.get().setClient(message.getClient());
                    e.get().setMachine(message.getMachine());
                }
                messageRepository.save(e.get());
                return e.get();

            } else {
                return message;
            }
        } else {
            return message;
        }
    }
    public boolean deleteMessage(int idMessage) {
        Boolean aBoolean = getMessage(idMessage).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
