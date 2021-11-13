/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.wfox84.usa.GymReto.service;

import co.wfox84.usa.GymReto.model.Reservation;
import co.wfox84.usa.GymReto.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author masterKomodoro
 */
@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getAll(){
        
        return reservationRepository.getAll();
    }
        
    public Optional<Reservation> getReservation(int id){
            return reservationRepository.getReservation(id);
    }
   
    public Reservation save(Reservation  r){
        if(r.getIdReservation()==null){
            return reservationRepository.save(r);        
        }else{
            Optional<Reservation> maux=reservationRepository.getReservation(r.getIdReservation());
            if(maux.isEmpty()){
                return reservationRepository.save(r);            
            }else{
                return r;
            
            }
        
        }
    
    }
    
}
