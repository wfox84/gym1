/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.wfox84.usa.GymReto.controller;

import co.wfox84.usa.GymReto.model.Machine;
import java.util.List;
import java.util.Optional;
import co.wfox84.usa.GymReto.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * 
 * @author masterKomodoro
 */
@RestController
@RequestMapping("/api/Machine")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class MachineController {
    /**
     *
     */
    @Autowired
    private MachineService machineService;

    /**
     *
     * @return
     */
    @GetMapping("/all")
    public List<Machine> getMachine(){
        return machineService.getAll();    
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Optional<Machine> getMachine(@PathVariable("idMachine") int id){
        return machineService.getMachine(id);
    }

    /**
     *
     * @param machine
     * @return
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Machine save(@RequestBody Machine machine){
        return machineService.save(machine);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Machine update(@RequestBody Machine machine){
        return machineService.update(machine);
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return machineService.deleteMachine(id);
    }

}
