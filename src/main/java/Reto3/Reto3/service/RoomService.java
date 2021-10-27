/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto3.Reto3.service;

import Reto3.Reto3.model.Room;
import Reto3.Reto3.repository.RoomRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KUKURU
 */
@Service
public class RoomService {

    /**
     * Permite recibir la logica de negocio
     * Le va a indicar al framework
     */
    @Autowired
    private RoomRepository crudMetodos;

    /**
     * Retorna una lista
     */
    public List<Room> getAll() {
        return crudMetodos.getAll();
    }

    /**
     * get para obtener una habitación especifica por medio del servicio
     */
    public Optional<Room> getRoom(int roomId) {
        return crudMetodos.getRoom(roomId);
    }

    /**
     * Guardar registro de habitación
     */
    public Room save(Room room) {
        if (room.getId() == null) {
            return crudMetodos.save(room);

        } else {

            Optional<Room> evt = crudMetodos.getRoom(room.getId());
            if (evt.isEmpty()) {
                return crudMetodos.save(room);

            } else {
                return room;

            }

        }

    }
    
    /**
     * Funcion para actualizar
     */
    public Room update (Room room){
        if(room.getId()!=null){
            Optional<Room> c=crudMetodos.getRoom(room.getId());
            if(!c.isEmpty()){
                
                if(room.getName()!=null){
                    c.get().setName(room.getName());
                }
                if(room.getHotel()!=null){
                    c.get().setHotel(room.getHotel());
                }
                if(room.getStars()!=null){
                    c.get().setStars(room.getStars());
                }
                if(room.getDescription()!=null){
                    c.get().setDescription(room.getDescription());
                }
                
                crudMetodos.save(c.get());
                return c.get();
            }else{
                return room;
            }
        }else{
            return room;
        }
    }
  

    /**
     * Funcion para eliminar
     */
    public boolean deleteHabitaciones(int id) {
        Boolean aBoolean = getRoom(id).map(habitaciones -> {
            crudMetodos.delete(habitaciones);
            return true;
        }).orElse( aBoolean = false);
        return aBoolean;
    }


}
