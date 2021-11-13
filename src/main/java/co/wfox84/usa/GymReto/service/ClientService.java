/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.wfox84.usa.GymReto.service;


import co.wfox84.usa.GymReto.model.Client;
import co.wfox84.usa.GymReto.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author masterKomodoro
 */
@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getAll(){
        
        return clientRepository.getAll();
    }
        
    public Optional<Client> getClient(int id){
            return clientRepository.getClient(id);
    }
   
    public Client save(Client  c){
        if(c.getIdClient()==null){
            return clientRepository.save(c);        
        }else{
            Optional<Client> maux=clientRepository.getClient(c.getIdClient());
            if(maux.isEmpty()){
                return clientRepository.save(c);            
            }else{
                return c;
            
            }
        
        }
    
    }
}

