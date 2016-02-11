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
public class CircularBuffer <T> implements BufferInterface<T>  {
                                                  
    private final Integer BUFFER_SIZE = 200000;    //unchangable buffer size
    
    private Object[] buffer = new Object[BUFFER_SIZE];
    
    private Integer  inPtr  = 0;  //value of input
    
    private Integer  outPtr = BUFFER_SIZE-1; //value of output
    
    private final PetersonsLock lock = new PetersonsLock(); // instance of PetersonsLock  
    
    
    public void enter(int me)  // A method that calls enter method
    {
        lock.enter(me);
    }
    
    public void leave(int me) // A method that calls leave method
    {
        lock.leave(me);
    }
    
   
    @Override
    public void store(T item) throws BufferFullException  //override of BufferInterface's store method  //stores item in the buffer if the buffer is not full                                             
    {
        if ( isFull() )
            throw new BufferFullException();
        buffer[inPtr] = item;
        inPtr = (++inPtr)%BUFFER_SIZE;
    }

    
   
    @Override
    public T next() throws BufferEmptyException //override of BufferInterface's next method
    {
        if ( isEmpty() )
            throw new BufferEmptyException();
        outPtr = (++outPtr)%BUFFER_SIZE;
        return (T)buffer[outPtr];
    }

    
    
    @Override
    public Boolean isFull()  //override of BufferInterface's isFull method
    {
        return inPtr.compareTo(outPtr) == 0;
    }

    
    
    @Override
    public Boolean isEmpty()  //override of BufferInterface's isEmpty method
    {
        return (outPtr+1)%BUFFER_SIZE == inPtr;
    }
    
}


