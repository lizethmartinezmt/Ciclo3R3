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
@Repository
public class RoomRepository {
    
    @Autowired
    private RoomInterface crud;

    public List<Room> getAll() {
        return (List<Room>) crud.findAll();
    }

    public Optional<Room> getRoom(int id) {
        return crud.findById(id);
    }

    public Room save(Room room) {
        return crud.save(room);
    }

    public void delete(Room room) {
        crud.delete(room);
    }
    
}
