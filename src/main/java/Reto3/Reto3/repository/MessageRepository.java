/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto3.Reto3.repository;

import Reto3.Reto3.model.Message;
import Reto3.Reto3.repository.interfaces.MessageInterface;
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
public class MessageRepository {
    
    @Autowired
    //metodos que van a llamar las acciones del crud repository
    private MessageInterface crud3;

    // Consulta los elementos de la base y los entrega en una lista
    public List<Message> getAll() {
        return (List<Message>) crud3.findAll();
    }

    //Si el dato esta se entrega y si no existe el dato no ejecuta nada;
    // con ese Optional se evitan problemas con los null
    public Optional<Message> getMessage(int id) {
        return crud3.findById(id);
    }

    //Para guardar
    public Message save(Message message) {
        return crud3.save(message);
    }

    //Para eliminar
    public void delete(Message message) {
        crud3.delete(message);
    }
}
