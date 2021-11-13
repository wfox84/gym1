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
   
    public Message save(Message  me){
        if(me.getIdMessage()==null){
            return messageRepository.save(me);        
        }else{
            Optional<Message> maux=messageRepository.getMessage(me.getIdMessage());
            if(maux.isEmpty()){
                return messageRepository.save(me);            
            }else{
                return me;
            
            }
        
        }
    
    }
}
