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
    /**
     * @Autowired annotation is used inSpring Framework. It injects the
     * dependency into the inner beans or collaborating beans. It is done by
     * using two modes: byType & byName.Internally, Spring checks using byName mode if the name is matched it
     * would inject the dependencies otherwise it would go for byType mode.
     */
    @Autowired
    private ReservationRepository reservationRepository;
    private ReservationRepository methodsCrud;
    /**
     *
     * @return  a list of all Reservations
     */
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    /**
     * Optional class in Java is used to get the value of this Optional instance.
     * If there is no value present in this Optional instance, then this method
     * throws NullPointerException.
     * @param idReservation
     * @return A reservation identified by the selected ID
     */
        
    public Optional<Reservation> getReservation(int idReservation){
            return reservationRepository.getReservation(idReservation);
    }

    /**
     *
     * @param reservation
     * @return
     */
    public Reservation save(Reservation  reservation){
        if(reservation.getIdReservation()==null){
            return reservationRepository.save(reservation);
        }else{
            Optional<Reservation> reser1=reservationRepository.getReservation(reservation.getIdReservation());
            if(reser1.isEmpty()){
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            
            }
        
        }
    
    }

    /**
     *
     * @param reservation
     * @return
     */
    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> reser = reservationRepository.getReservation(reservation.getIdReservation());
            if (!reser.isEmpty()) {
                if (reservation.getStartDate() != null) {
                    reser.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    reser.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    reser.get().setStatus(reservation.getStatus());
                }
                reservationRepository.save(reser.get());
                return reser.get();
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    /**
     *
     * @param idReservation
     * @return
     */
    public boolean deleteReservation(int idReservation) {
        Boolean aBoolean = getReservation(idReservation).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    /**
     *
     * @return
     */
    public StatusReservation getReservationStatusReport(){
        List<Reservation> completed = reservationRepository.getReservationByStatus("completed");
        List<Reservation> cancelled = reservationRepository.getReservationByStatus(("cancelled"));
        return new StatusReservation(completed.size(), cancelled.size());
    }

    /**
     *
     * @param dataA
     * @param dataB
     * @return
     */
    public List<Reservation> getReservationPeriod(String dataA, String dataB){
        SimpleDateFormat parser= new SimpleDateFormat("yyyy-MM-dd");
        Date aDate = new Date();
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

    /**
     *
     * @return
     */
    public List<CounterClient> getTopClients(){
        return reservationRepository.getTopClient();
    }
}
