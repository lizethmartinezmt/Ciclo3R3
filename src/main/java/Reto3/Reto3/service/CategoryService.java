/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto3.Reto3.service;

import Reto3.Reto3.model.Category;
import Reto3.Reto3.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KUKURU
 */
@Service
public class CategoryService {
    
    /**
     * Permite recibir la logica de negocio
     * Le va a indicar al framework
     */
    @Autowired
    private CategoryRepository metodosCrud;

    /**
     * Retorna una lista
     */
    public List<Category> getAll() {
        return metodosCrud.getAll();
    }

    /**
     * get para obtener una categoria especifica por medio del servicio
     */
    public Optional<Category> getCategory(int categoryId) {
        return metodosCrud.getCategory(categoryId);
    }

    /**
     * Guardar registro de habitación
     */
    public Category save(Category categoria) {
        if (categoria.getId() == null) {
            return metodosCrud.save(categoria);
        } else {
            Optional<Category> e = metodosCrud.getCategory(categoria.getId());
            if (e.isEmpty()) {
                return metodosCrud.save(categoria);
            } else {
                return categoria;
            }
        }
    }

    /**
     * Funcion para actualizar
     */
    public Category update(Category categoria) {
        if (categoria.getId() != null) {
            Optional<Category> g = metodosCrud.getCategory(categoria.getId());
            if (!g.isEmpty()) {
                if (categoria.getDescription() != null) {
                    g.get().setDescription(categoria.getDescription());
                }
                if (categoria.getName() != null) {
                    g.get().setName(categoria.getName());
                }
                return metodosCrud.save(g.get());
            }
        }
        return categoria;
    }

    /**
     * Funcion para eliminar
     */
    public boolean deleteCategory(int categoriaId) {
        Boolean d = getCategory(categoriaId).map(categoria -> {
            metodosCrud.delete(categoria);
            return true;
        }).orElse(false);
        return d;
    }
}
