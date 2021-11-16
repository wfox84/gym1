/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.wfox84.usa.GymReto.repository;



import co.wfox84.usa.GymReto.model.Message;
import co.wfox84.usa.GymReto.crudrepository.MessageCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author masterKomodoro
 */
@Repository
public class MessageRepository {
    /**
     *
     */
    @Autowired
    private MessageCrudRepository messageCrudRepository;

    /**
     *
     * @return
     */
    public List<Message> getAll(){
        
        return (List<Message>) messageCrudRepository.findAll();
    
    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<Message> getMessage(int id){
    
        return messageCrudRepository.findById(id);
    
    }

    /**
     *
     * @param message
     * @return
     */
    public Message save(Message message){
    
        return messageCrudRepository.save(message);
    }

    /**
     *
     * @param message
     */
    public void delete(Message message){
        messageCrudRepository.delete(message);
    }

}
