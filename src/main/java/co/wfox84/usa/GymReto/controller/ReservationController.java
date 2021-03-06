/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.wfox84.usa.GymReto.controller;

import co.wfox84.usa.GymReto.model.Reservation;
import co.wfox84.usa.GymReto.reports.CounterClient;
import co.wfox84.usa.GymReto.reports.StatusReservation;
import co.wfox84.usa.GymReto.service.ReservationService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * 
 * @author masterKomodoro
 */
@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}) public class ReservationController {
    /**
     *
     */
    @Autowired
    private ReservationService reservationService;

    /**
     *
     * @return
     */
    @GetMapping("/all")
    public List<Reservation> getReservation(){
        return reservationService.getAll();    
    }

    /**
     *
     * @param idReservation
     * @return
     */
    @GetMapping("/{idReservation}")
    public Optional<Reservation> getReservation(@PathVariable("idReservation") int idReservation){
        return reservationService.getReservation(idReservation);
    
    }

    /**
     *
     * @param reservation
     * @return
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation){
        return reservationService.save(reservation);
    
    }

    /**
     *
     * @param reservation
     * @return
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation  reservation){
        return reservationService.update(reservation);
    }

    /**
     *
     * @param idReservation
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("idReservation") int idReservation){
        return reservationService.deleteReservation(idReservation);
    }

    /**
     *
     * @return
     */
    @GetMapping("/report-status")
    public StatusReservation getReservationStatusReport(){
        return reservationService.getReservationStatusReport();
    }

    /**
     *
     * @param dateOne
     * @param dateTwo
     * @return
     */
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservationsReportDates(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo){
        return reservationService.getReservationPeriod(dateOne, dateTwo);
    }

    /**
     *
     * @return
     */
    @GetMapping("/report-clients")
    public List<CounterClient> getClients(){
        return reservationService.getTopClients();
    }

}
