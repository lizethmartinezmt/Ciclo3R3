package Reto3.Reto3.repository.interfaces;

import Reto3.Reto3.model.Message;
import org.springframework.data.repository.CrudRepository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author KUKURU
 */
public interface MessageInterface extends CrudRepository<Message, Integer>{
    
}
