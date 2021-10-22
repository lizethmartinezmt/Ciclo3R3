/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto3.Reto3.repository;

import Reto3.Reto3.model.Client;
import Reto3.Reto3.repository.interfaces.ClientInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author KUKURU
 */
@Repository
public class ClientRepository {
    
    @Autowired
    private ClientInterface crud1;

    public List<Client> getAll() {
        return (List<Client>) crud1.findAll();
    }

    public Optional<Client> getClient(int id) {
        return crud1.findById(id);
    }

    public Client save(Client client) {
        return crud1.save(client);
    }

    public void delete(Client client) {
        crud1.delete(client);
    }
}
