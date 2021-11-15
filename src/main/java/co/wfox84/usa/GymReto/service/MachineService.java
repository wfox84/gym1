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
    private MachineRepository methodsCrud;
    
    public List<Machine> getAll(){
        return methodsCrud.getAll();
    }
        
    public Optional<Machine> getMachine(int id){
            return methodsCrud.getMachine(id);
    }
   
    public Machine save(Machine  machine){
        if(machine.getId()==null){
            return methodsCrud.save(machine);
        }else{
            Optional<Machine> maux=methodsCrud.getMachine(machine.getId());
            if(maux.isEmpty()){
                return methodsCrud.save(machine);
            }else{
                return machine;
            }
        }
    }
    public Machine update(Machine machine){
        if(machine.getId()!=null){
            Optional<Machine> machine1=methodsCrud.getMachine(machine.getId());
            if(!machine1.isEmpty()){
                if(machine.getName()!=null){
                    machine1.get().setName(machine.getName());
                }
                if(machine.getBrand()!=null){
                    machine1.get().setBrand(machine.getBrand()); ;
                }
                if(machine.getYear() !=null){
                    machine1.get().setYear(machine.getYear());
                }
                if(machine.getDescription()!=null){
                    machine1.get().setDescription(machine.getDescription());
                }
                if(machine.getCategory()!=null){
                    machine1.get().setCategory(machine.getCategory());
                }
                methodsCrud.save(machine1.get());
                return machine1.get();
            }else{
                return machine;
            }
        }else{
            return machine;
        }
    }

    public boolean deleteMachine(int id) {
        Boolean aBoolean = getMachine(id).map(machine -> {
            methodsCrud.delete(machine);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}