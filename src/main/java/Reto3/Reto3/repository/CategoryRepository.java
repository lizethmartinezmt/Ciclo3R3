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
@Repository
public class CategoryRepository {
    @Autowired
    private CategoryInterface crud2;
    
    public List<Category> getAll() {
        return (List<Category>) crud2.findAll();
    }

    public Optional<Category> getCategory(int id) {
        return crud2.findById(id);
    }

    public Category save(Category categoria) {
        return crud2.save(categoria);
    }

    public void delete(Category categoria) {
        crud2.delete(categoria);
    }
}
