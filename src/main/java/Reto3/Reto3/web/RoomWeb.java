/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto3.Reto3.web;

import Reto3.Reto3.model.Room;
import Reto3.Reto3.service.RoomService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author KUKURU
 */
@RestController
@RequestMapping("/api/Room")
public class RoomWeb {
    
    @Autowired

    private RoomService servicios;

    @GetMapping("/Holamundo")
    public String saludar() {
        return "Hola Mundo";
    }

    @GetMapping("/all")
    public List<Room> getRooms() {
        return servicios.getAll();
    }

    @GetMapping("/{id}")

    public Optional<Room> getRoom(@PathVariable("id") int roomId) {
        return servicios.getRoom(roomId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Room save(@RequestBody Room room) {
        return servicios.save(room);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Room update(@RequestBody Room room){
        return servicios.update(room);
    }
    

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return servicios.deleteHabitaciones(id);
    }
}
