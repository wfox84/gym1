/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.wfox84.usa.GymReto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
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
@Table(name="message")
public class Message implements Serializable{
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;

    /**
     *
     * @return
     */
    public Integer getIdMessage() {
        return idMessage;
    }

    /**
     *
     * @param idMessage
     */
    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    /**
     *
     * @return
     */
    public String getMessageText() {
        return messageText;
    }

    /**
     *
     * @param messageText
     */
    public void setMessageText(String messageText) {
        this.messageText = messageText;
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
     */
    @ManyToOne
    @JoinColumn (name="idMachine")
    @JsonIgnoreProperties({"messages","client","reservations"})
    private Machine machine;
    /**
     *
      */
    @ManyToOne
    @JoinColumn (name="idClient")
    @JsonIgnoreProperties({"messages","reservations","client"})
    private Client client;

}
