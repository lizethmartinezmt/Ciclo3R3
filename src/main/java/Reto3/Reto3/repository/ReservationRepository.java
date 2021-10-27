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
//Permite traer y enviar información de base de datos
@Repository
public class ReservationRepository {
    
    @Autowired
     //metodos que van a llamar las acciones del crud repository
    private ReservationInterface crud4;

     // Consulta los elementos de la base y los entrega en una lista
    public List<Reservation> getAll() {
        return (List<Reservation>) crud4.findAll();
    }

    //Si el dato esta se entrega y si no existe el dato no ejecuta nada;
    // con ese Optional se evitan problemas con los null
    public Optional<Reservation> getReservation(int id) {
        return crud4.findById(id);
    }
    
    //Para guardar
    public Reservation save(Reservation reservation) {
        return crud4.save(reservation);
    }

     //Para eliminar
    public void delete(Reservation reservation) {
        crud4.delete(reservation);
    }
    
}
