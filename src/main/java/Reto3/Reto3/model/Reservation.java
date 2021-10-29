/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto3.Reto3.model;

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
 * @author KUKURU
 */
@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

    @Id
    /**
     * Función para que el id sea generado automaticamente
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * Atributo id
     */
    private Integer idReservation;
    /**
     * Atributo startDate
     */
    private Date startDate;
    /**
     * Atributo devolutionDate
     */
    private Date devolutionDate;
    /**
     * Atributo status
     */
    private String status = "created";
    
    /**
     * Llave Foranea para la unión con a tabla room
     */
    @ManyToOne
    //como se va a llamar la llave foranea
    @JoinColumn(name = "id")
    @JsonIgnoreProperties("reservations")
    /**
     * Estamos llamando al objeto Room (atributo)
     */
    private Room room;

    /**
     * Llave Foranea para la unión con a tabla client
     */
    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"reservations", "messages"})
    /**
     * Estamos llamando al objeto Client
     */
    private Client client;
    
    /**
     * Atributo score
     */
    private String score;

    /**
     * Permite acceder al valor del atributo 
     * @return room
     */
    public Room getRoom() {
        return room;
    }

    /**
     *Permite asignar un valor al atributo
     * @param room
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * Permite acceder al valor del atributo 
     * @return client
     */
    public Client getClient() {
        return client;
    }

    /**
     *Permite asignar un valor al atributo
     * @param client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Permite acceder al valor del atributo 
     * @return idReservation
     */
    public Integer getIdReservation() {
        return idReservation;
    }

    /**
     *Permite asignar un valor al atributo
     * @param idReservation
     */
    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    /**
     * Permite acceder al valor del atributo 
     * @return startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     *Permite asignar un valor al atributo
     * @param startDate 
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Permite acceder al valor del atributo 
     * @return DevolutionDate
     */
    public Date getDevolutionDate() {
        return devolutionDate;
    }

    /**
     *Permite asignar un valor al atributo
     * @param devolutionDate
     */
    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    /**
     * Permite acceder al valor del atributo 
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     *Permite asignar un valor al atributo
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    /**
     * Permite acceder al valor del atributo 
     * @return score
     */
    public String getScore() {
        return score;
    }

    /**
     *Permite asignar un valor al atributo
     * @param score
     */
    public void setScore(String score) {
        this.score = score;
    }
    
}
