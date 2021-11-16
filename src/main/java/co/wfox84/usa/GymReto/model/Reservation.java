/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.wfox84.usa.GymReto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author masterKomodoro
 */
@Entity
@Table(name="Reservation")
public class Reservation implements Serializable{
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status="created";

    /**
     *
     * @return
     */
    public Integer getIdReservation() {
        return idReservation;
    }

    /**
     *
     * @param idReservation
     */
    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    /**
     *
     * @return
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     *
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     *
     * @return
     */
    public Date getDevolutionDate() {
        return devolutionDate;
    }

    /**
     *
     * @param devolutionDate
     */
    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    /**
     *
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     */
    public Machine getMachine() {
        return machine;
    }

    /**
     *
     * @param machine
     */
    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    /**
     *
     * @return
     */
    public Client getClient() {
        return client;
    }

    /**
     *
     * @param client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     *
     * @return
     */
    public String getScore() {
        return score;
    }

    /**
     *
     * @param score
     */
    public void setScore(String score) {
        this.score = score;
    }

    /**
     *
     */
    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties("reservations")
    private Machine machine;
    /**
     *
     */
    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"reservations","messages"})
    private Client client;
    /**
     *
     */
    private String score;

}
