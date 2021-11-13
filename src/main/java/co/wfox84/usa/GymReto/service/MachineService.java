/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.wfox84.usa.GymReto.service;

import co.wfox84.usa.GymReto.model.Machine;
import co.wfox84.usa.GymReto.repository.MachineRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author masterKomodoro
 */
@Service
public class MachineService {
    
    @Autowired
    private MachineRepository machineRepository;
    
    public List<Machine> getAll(){
        
        return machineRepository.getAll();
    }
        
    public Optional<Machine> getMachine(int id){
            return machineRepository.getMachine(id);
    }
   
    public Machine save(Machine  m){
        if(m.getId()==null){
            return machineRepository.save(m);        
        }else{
            Optional<Machine> maux=machineRepository.getMachine(m.getId());
            if(maux.isEmpty()){
                return machineRepository.save(m);            
            }else{
                return m;
            
            }
        
        }
    
    }
}
