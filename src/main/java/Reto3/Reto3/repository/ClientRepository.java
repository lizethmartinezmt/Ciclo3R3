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
//Permite traer y enviar info de base de datos
@Repository
public class ClientRepository {
    
    @Autowired
    //metodos que llaman las acciones del crud repository
    private ClientInterface crud1;

    // Consulta los elementos de la base y los entrega en una lista
    public List<Client> getAll() {
        return (List<Client>) crud1.findAll();
    }

    //Si el dato esta se entrega y si no existe el dato no ejecuta nada;
    // con ese Optional se evitan problemas con los null
    public Optional<Client> getClient(int id) {
        return crud1.findById(id);
    }

     //Para guardar
    public Client save(Client client) {
        return crud1.save(client);
    }

     //Para eliminar
    public void delete(Client client) {
        crud1.delete(client);
    }
}
