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
    //Para que el id sea autogenerado
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * Atributo id
     */
    private Integer id;
    /**
     * Atributo name
     */
    private String name;
    /**
     * Atributo hotel
     */
    private String hotel;
    /**
     * Atributo stars
     */
    private Integer stars;
    /**
     * Atributo description
     */
    private String description;
    
    
    //Objeto para crear una relacion con Categoria
    @ManyToOne
    //como se va a llamar la llave foranea
    @JoinColumn(name="categoryId")
    @JsonIgnoreProperties("rooms")
    /**
     * Estamos llamando al objeto Categoria (atributo)
     */
    private Category category;
    
    
    
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "room")
    @JsonIgnoreProperties({"room", "client"})
    /**
     * Estamos llamando al objeto Message
     */
    public List<Message> messages;
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "room")
    @JsonIgnoreProperties({"room", "client"})
    /**
     * Estamos llamando al objeto Reservations
     */
    public List<Reservation> reservations;
    
    
    /**
     * Permite acceder al valor del atributo 
     * @return messages
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     *Permite asignar un valor al atributo
     * @param messages 
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    /**
     * Permite acceder al valor del atributo 
     * @return reservations
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Permite asignar un valor al atributo
     * @param reservations 
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    /**
     * Permite acceder al valor del atributo 
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Permite asignar un valor al atributo
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }   
    
    /**
     * Permite acceder al valor del atributo 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Permite asignar un valor al atributo
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Permite acceder al valor del atributo 
     * @return hotel
     */
    public String getHotel() {
        return hotel;
    }

    /**
     * Permite asignar un valor al atributo
     * @param hotel 
     */
    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    /**
     * Permite acceder al valor del atributo 
     * @return stars
     */
    public Integer getStars() {
        return stars;
    }

    /**
     * Permite asignar un valor al atributo
     * @param stars 
     */
    public void setStars(Integer stars) {
        this.stars = stars;
    }

    /**
     * Permite acceder al valor del atributo 
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Permite asignar un valor al atributo
     * @param description 
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Permite acceder al valor del atributo 
     * @return category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Permite asignar un valor al atributo
     * @param category 
     */
    public void setCategory(Category category) {
        this.category = category;
    }
}