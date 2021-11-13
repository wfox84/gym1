/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.wfox84.usa.GymReto.service;

import co.wfox84.usa.GymReto.model.Reservation;
import co.wfox84.usa.GymReto.reports.CounterClient;
import co.wfox84.usa.GymReto.reports.StatusReservation;
import co.wfox84.usa.GymReto.repository.ReservationRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> e = reservationRepository.getReservation(reservation.getIdReservation());
            if (!e.isEmpty()) {
                if (reservation.getStartDate() != null) {
                    e.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    e.get().setStatus(reservation.getStatus());
                }
                reservationRepository.save(e.get());
                return e.get();
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }
    public boolean deleteReservation(int idReservation) {
        Boolean aBoolean = getReservation(idReservation).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    public StatusReservation getReservationStatusReport(){
        List<Reservation> completed = reservationRepository.getReservationByStatus("completed");
        List<Reservation> cancelled = reservationRepository.getReservationByStatus(("cancelled"));
        return new StatusReservation(completed.size(), cancelled.size());
    }
    public List<Reservation> getReservationPeriod(String dataA, String dataB){
        SimpleDateFormat parser= new SimpleDateFormat("yyyy-MM-dd");
        Date aDate =new Date();
        Date bDate = new Date();
        try{
            aDate=parser.parse(dataA);
            bDate= parser.parse(dataB);
        }catch (ParseException evt){
            evt.printStackTrace();
        }
        if(aDate.before(bDate)){
            return reservationRepository.getReservationPeriod(aDate,bDate);
        }else {
            return new ArrayList<>();
        }
    }
    public List<CounterClient> getTopClients(){
        return reservationRepository.getTopClient();
    }
}
