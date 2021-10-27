/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto3.Reto3.service;

import Reto3.Reto3.model.Message;
import Reto3.Reto3.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KUKURU
 */
@Service
public class MessageService {
    
    /**
     * Permite recibir la logica de negocio
     * Le va a indicar al framework
     */
    @Autowired
    private MessageRepository metodosCrud;
    
    /**
     * Retorna una lista
     */
    public List<Message> getAll() {
        return metodosCrud.getAll();
    }

    /**
     * get para obtener un mensaje especifica por medio del servicio
     */
    public Optional<Message> getMessage(int messageId) {
        return metodosCrud.getMessage(messageId);
    }

    /**
     * Guardar registro de habitación
     */
    public Message save(Message message) {
        if (message.getIdMessage() == null) {
            return metodosCrud.save(message);
        } else {
            Optional<Message> e = metodosCrud.getMessage(message.getIdMessage());
            if (e.isEmpty()) {
                return metodosCrud.save(message);
            } else {
                return message;
            }
        }
    }
    
    /**
     * Funcion para actualizar
     */
    public Message update (Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> e = metodosCrud.getMessage(message.getIdMessage());
            if(!e.isEmpty()){
                
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }
    

    /**
     * Funcion para eliminar
     */
    public boolean deleteMessage(int id) {
        Boolean aBoolean = getMessage(id).map(message -> {
            metodosCrud.delete(message);
            return true;
        }).orElse( aBoolean = false);
        return aBoolean;
    }
    
}
