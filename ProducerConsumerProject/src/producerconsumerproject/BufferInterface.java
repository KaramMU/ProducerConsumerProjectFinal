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
public interface BufferInterface <T> {
     /**
     * Stores a single object of type T. If the buffer is full when this 
     * method is called, store throws a BufferFullException
     * 
     * @param item Object of type T being stored
     * @throws BufferFullException 
     */
    void    store(T item) throws BufferFullException;
    
    /**
     * This method grants access to the buffer's critical regions
     * 
     * @param me    Process requesting access 
     */
    void    enter(int me);
    
    
    /**
     * This method releases access to buffers critical regions
     * 
     * 
     * @param me    Process leaving the critical region
     */
    void    leave(int me);
    /**
     * Gets the next available object of type T from the buffer. If the buffer
     * is empty when this method is called, next throws a BufferEmptyExcption
     * 
     * @return  an object of type T
     * @throws BufferEmptyException 
     */
    T       next() throws BufferEmptyException;
    
    /**
     * This method returns true when there is no more room to store items,
     * otherwise it returns false.
     * 
     * @return true when full
     */
    Boolean isFull();
    
    /**
     * This method returns true when there are no stored items, otherwise
     * it returns false.
     * 
     * @return true when empty
     */
    Boolean isEmpty();
    
}



