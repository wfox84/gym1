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
    /**
     *
     */
    @Autowired
    private MessageRepository messageRepository;

    /**
     *
     * @return
     */
    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    /**
     *
      * @param idMessage
     * @return
     */
    public Optional<Message> getMessage(int idMessage){
            return messageRepository.getMessage(idMessage);
    }

    /**
     *
     * @param message
     * @return
     */
    public Message save(Message  message){
        if(message.getIdMessage()==null){
            return messageRepository.save(message);
        }else{
            Optional<Message> maux=messageRepository.getMessage(message.getIdMessage());
            if(maux.isEmpty()){
                return messageRepository.save(message);
            }else {
                return message;
            }
        }
    }

    /**
     *
     * @param message
     * @return
     */
    public Message update(Message message) {
        if (message.getIdMessage()!= null) {
            Optional<Message> mess1 = messageRepository.getMessage(message.getIdMessage());
            if (!mess1.isEmpty()) {
                if (message.getMessageText()!= null) {
                    mess1.get().setMessageText(message.getMessageText());
                    mess1.get().setClient(message.getClient());
                    mess1.get().setMachine(message.getMachine());
                }
                messageRepository.save(mess1.get());
                return mess1.get();

            } else {
                return message;
            }
        } else {
            return message;
        }
    }

    /**
     *
     * @param idMessage
     * @return
     */
    public boolean deleteMessage(int idMessage) {
        Boolean aBoolean = getMessage(idMessage).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
