package Reto3.Reto3.repository.interfaces;

import Reto3.Reto3.model.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author KUKURU
 * Se llama la clase category y se nombre integer ya que es el tipo de dato de la llave primaria
 * la papeleriacrudrepository hereda a crudrepository
 */
public interface ReservationInterface extends CrudRepository<Reservation, Integer>{
    
     //Realización de consulta
     // el objeto c es una reservacion, se va a hacer un conte de los clientes usados por reservacion
     //le estamos pidiendo un objeto cliente y un numero

    @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c group by c.client order by COUNT (c.client) desc")
    public List<Object[]> countTotalReservationByClient();
    
    //QUERY METHODS!
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne,Date dateTwo);
    //public List<Reservations> findAllByStartBetween (Date dateOne, Date dateTwo);
    public List<Reservation> findAllByStatus (String statusAAA);
}
