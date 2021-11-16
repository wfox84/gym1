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
    public Machine save(Machine machine){
        if(machine.getId()==null){
            return machineRepository.save(machine);
        }else {
            Optional<Machine> e=machineRepository.getMachine(machine.getId());
            if (e.isEmpty()){
                return machineRepository.save(machine);
            }else{
                return machine;
            }
        }
    }
    public Machine update(Machine machine){
        if(machine.getId()!=null){
            Optional<Machine> e=machineRepository.getMachine(machine.getId());
            if(!e.isEmpty()){
                if(machine.getName()!=null){
                    e.get().setName(machine.getName());
                }
                if(machine.getBrand()!=null){
                    e.get().setBrand(machine.getBrand()); ;
                }
                if(machine.getYear() !=null){
                    e.get().setYear(machine.getYear());
                }
                if(machine.getDescription()!=null){
                    e.get().setDescription(machine.getDescription());
                }
                if(machine.getCategory()!=null){
                    e.get().setCategory(machine.getCategory());
                }
                machineRepository.save(e.get());
                return e.get();
            }else{
                return machine;
            }
        }else{
            return machine;
        }
    }
    public boolean deleteMachine(int id) {
        return getMachine(id).map(machine -> {
            machineRepository.delete(machine);
            return true;
        }).orElse(false);
    }
}