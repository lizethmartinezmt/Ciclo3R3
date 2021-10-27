/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto3.Reto3.service;

import Reto3.Reto3.model.Reservation;
import Reto3.Reto3.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KUKURU
 */
@Service
public class ReservationService {
    
    /**
     * Permite recibir la logica de negocio
     * Le va a indicar al framework
     */
    @Autowired
    private ReservationRepository metodosCrud;

    /**
     * Metodo que sirve para traer todas las reservaciones
     * @return 
     * Retorna una lista
     */
    public List<Reservation> getAll() {
        return metodosCrud.getAll();
    }

    /**
     * Metodo que sirve para traer una reservacion por el id
     * @param id
     * @return reservación
     * get para obtener una reservacion especifica por medio del servicio
     */
    public Optional<Reservation> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }

    /**
     * Metodo que sirve para guardar una reservacion
     * @param r
     * @return una nueva reservacion
     * Guardar registro de habitación
     */
    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return metodosCrud.save(reservation);
        } else {
            Optional<Reservation> e = metodosCrud.getReservation(reservation.getIdReservation());
            if (e.isEmpty()) {
                return metodosCrud.save(reservation);
            } else {
                return reservation;
            }
        }
    }

  
    /**
     * Metodo que sirve para actualizar una reservación
     * @param reservations
     * @return la actualizacion
     */
    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> e = metodosCrud.getReservation(reservation.getIdReservation());
            if (!e.isEmpty()) {

                if (reservation.getStartDate() != null) {
                    e.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    e.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    /**
     * Metodo para eiminar una reservación
     * @param id
     * @return un BOOLEAN true or false
     */
    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
