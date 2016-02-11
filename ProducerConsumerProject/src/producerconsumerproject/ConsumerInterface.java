/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumerproject;

/**
 *
 * @author Algharabeh
 */
public interface ConsumerInterface <T> {
    
    /**
     * * This method is intended to consume a single object of type T that it has
     * retrieved from the shared BufferInterface warehouse..
     * 
     
     * @param warehouse Source of the object being consumed.
     */
    void consume(BufferInterface<T> warehouse);
}


