/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto3.Reto3.service;

import Reto3.Reto3.model.Client;
import Reto3.Reto3.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KUKURU
 */
@Service
public class ClientService {
    
    /**
     * Permite recibir la logica de negocio
     * Le va a indicar al framework
     */
    @Autowired
    private ClientRepository metodosCrud;

    /**
     * Retorna una lista
     */
    public List<Client> getAll() {
        return metodosCrud.getAll();
    }

    /**
     * get para obtener un cliente especifica por medio del servicio
     */
    public Optional<Client> getClient(int clientId) {
        return metodosCrud.getClient(clientId);
    }
    
    /**
     * Guardar registro de habitación
     */
    public Client save(Client client) {
        if (client.getIdClient() == null) {
            return metodosCrud.save(client);
        } else {
            Optional<Client> e = metodosCrud.getClient(client.getIdClient());
            if (e.isEmpty()) {
                return metodosCrud.save(client);
            } else {
                return client;
            }
        }
    }

    /**
     * Funcion para actualizar
     */
    public Client update(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> e = metodosCrud.getClient(client.getIdClient());
            if (!e.isEmpty()) {
                if (client.getName() != null) {
                    e.get().setName(client.getName());
                }
                if (client.getAge() != null) {
                    e.get().setAge(client.getAge());
                }
                if (client.getPassword() != null) {
                    e.get().setPassword(client.getPassword());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return client;
            }
        } else {
            return client;
        }
    }

     /**
     * Funcion para eliminar
     */
    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            metodosCrud.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
