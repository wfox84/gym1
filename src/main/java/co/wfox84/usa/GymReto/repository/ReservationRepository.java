/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.wfox84.usa.GymReto.repository;

import co.wfox84.usa.GymReto.model.Client;
import co.wfox84.usa.GymReto.model.Reservation;
import co.wfox84.usa.GymReto.reports.CounterClient;
import co.wfox84.usa.GymReto.repository.crud.ReservationCrudRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author masterKomodoro
 */
@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    
    public List<Reservation> getAll(){
        
        return (List<Reservation>) reservationCrudRepository.findAll();
    
    }
    public Optional<Reservation> getReservation(int id){
    
        return reservationCrudRepository.findById(id);
    
    }
    
    public Reservation save(Reservation r){
    
        return reservationCrudRepository.save(r);
    }
    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }

    public List<Reservation> getReservationByStatus(String status){
        return  reservationCrudRepository.findAllByStatus(status);
    }
    public List<Reservation> getReservationPeriod (Date a, Date b){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(a,b);
    }
    public List<CounterClient> getTopClient(){
        List<CounterClient> res= new ArrayList<>();
        List<Object[]> report = reservationCrudRepository.countTotalReservationByClient();
        for (int i=0; i<report.size();i++){
            res.add(new CounterClient((Long)report.get(i)[1],(Client) report.get(i)[0]));

        }
        return res;
    }
    
}
