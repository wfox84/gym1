/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.wfox84.usa.GymReto.repository.crud;

import co.wfox84.usa.GymReto.model.Reservation;
import org.springframework.data.repository.CrudRepository;

/**
 * 
 * @author masterKomodoro
 */
public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {
    
}
