/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto3.Reto3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author KUKURU
 */
@Entity
@Table(name="Room")
public class Room implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /**
     * Id clave primaria
     */
    private Integer idRoom;
    /**
     * Captura de la habitación
     */
    private String name;
    /**
     * Nombre del hotel
     */
    private String hotel;
    /**
     * Estrellas
     */
    private Integer stars;
    /**
     * Descripción tipo de habitación
     */
    private String description;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("rooms")
    /**
     * Atributo Categoria
     */
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "room")
    @JsonIgnoreProperties({"room", "client"})
    /**
     * Mensaje
     */
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "room")
    @JsonIgnoreProperties({"room", "client"})
    /**
     * Reservas
     */
    private List<Reservation> reservations;

    public Integer getId() {
        return idRoom;
    }

    public void setId(Integer id) {
        this.idRoom = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    
}

