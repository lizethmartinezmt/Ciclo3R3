/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto3.Reto3.repository;

import Reto3.Reto3.model.Category;
import Reto3.Reto3.repository.interfaces.CategoryInterface;
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
public class CategoryRepository {
    
    @Autowired
    //metodos que van a llamar las acciones del crud repository
    private CategoryInterface crud2;
    
    // Consulta los elementos de la base y los entrega en una lista
    public List<Category> getAll() {
        return (List<Category>) crud2.findAll();
    }

    //Si el dato esta se entrega y si no existe el dato no ejecuta nada;
    // con ese Optional se evitan problemas con los null
    public Optional<Category> getCategory(int id) {
        return crud2.findById(id);
    }

    //Para guardar
    public Category save(Category categoria) {
        return crud2.save(categoria);
    }

    //Para eliminar
    public void delete(Category categoria) {
        crud2.delete(categoria);
    }
}
