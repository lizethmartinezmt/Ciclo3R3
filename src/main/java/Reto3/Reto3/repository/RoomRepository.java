/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto3.Reto3.repository;

import Reto3.Reto3.model.Room;
import Reto3.Reto3.repository.interfaces.RoomInterface;
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
public class RoomRepository {
    
    @Autowired
    //metodos que van a llamar las acciones del crud repository
    private RoomInterface crud;

    // Consulta los elementos de la base y los entrega en una lista
    public List<Room> getAll() {
        return (List<Room>) crud.findAll();
    }

    //Si el dato esta se entrega y si no existe el dato no ejecuta nada;
    // con ese Optional se evitan problemas con los null
    public Optional<Room> getRoom(int id) {
        return crud.findById(id);
    }

    //Para guardar
    public Room save(Room room) {
        return crud.save(room);
    }

    //Para eliminar
    public void delete(Room room) {
        crud.delete(room);
    }
    
}
