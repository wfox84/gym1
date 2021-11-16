/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.wfox84.usa.GymReto.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * 
 * @author masterKomodoro
 */
@Entity
@Table(name="Client")
public class Client implements Serializable{
    /**
     *
      */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;
    private String email;
    private String password;
    private String name;
    private Integer age;
    /**
     *
     */
    @OneToMany (cascade = {CascadeType.PERSIST },mappedBy = "client")
    @JsonIgnoreProperties("client")
    public List<Message> messages;
    /**
     *
     */
    @OneToMany (cascade = {CascadeType.PERSIST},mappedBy = "client")
    @JsonIgnoreProperties("client")
    public List<Reservation> reservations;

    /**
     *
     * @return
     */
    public Integer getIdClient() {
        return idClient;
    }

    /**
     *
     * @param idClient
     */
    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public Integer getAge() {
        return age;
    }

    /**
     *
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     *
     * @return
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     *
     * @param messages
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    /**
     *
     * @return
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     *
     * @param reservations
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

}
