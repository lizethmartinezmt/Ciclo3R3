/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto3.Reto3.repository;

import Reto3.Reto3.model.Reservation;
import Reto3.Reto3.repository.interfaces.ReservationInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author KUKURU
 */
@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationInterface crud4;

    public List<Reservation> getAll() {
        return (List<Reservation>) crud4.findAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return crud4.findById(id);
    }

    public Reservation save(Reservation reservation) {
        return crud4.save(reservation);
    }

    public void delete(Reservation reservation) {
        crud4.delete(reservation);
    }
    
}
