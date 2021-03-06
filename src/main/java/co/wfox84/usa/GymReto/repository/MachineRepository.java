/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.wfox84.usa.GymReto.repository;

import co.wfox84.usa.GymReto.crudrepository.MachineCrudRepository;
import co.wfox84.usa.GymReto.model.Machine;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author masterKomodoro
 */
@Repository
public class MachineRepository {
    /**
     *
     */
    @Autowired
    private MachineCrudRepository machineCrudRepository;

    /**
     *
     * @return
     */
    public List<Machine> getAll(){
        return (List<Machine>) machineCrudRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<Machine> getMachine(int id){
        return machineCrudRepository.findById(id);
    }

    /**
     *
     * @param machine
     * @return
     */
    public Machine save(Machine machine){
        return machineCrudRepository.save(machine);
    }

    /**
     *
     * @param machine
     */
    public void delete(Machine machine){
        machineCrudRepository.delete(machine);
    }
}
