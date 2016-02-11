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
public interface ProducerInterface<T> {
    /**
     * This method is intended to produce a single item of type T and place
     * that item into the shared BufferInterface, warehouse.
     * 
     * @param warehouse storage for the item produced 
     */
    void produce(BufferInterface<T> warehouse);
}


