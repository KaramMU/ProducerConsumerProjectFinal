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
public class IntegerConsumer implements ConsumerInterface<Integer> {
     
    private Integer consumed; //keeps track of the running total of all consumed integers
    
    private Integer processIdentifier; // The Process id
    
    
    public IntegerConsumer(Integer threadId)  //Constructor
    {
        
        consumed = 0;
      
        processIdentifier = threadId;
    }
    
   

    
    public void consume(BufferInterface<Integer> warehouse) //override of the ConsumerInterface's consume method
    {
        
        warehouse.enter(processIdentifier);
        
        
        while(!warehouse.isEmpty())
        {
            try
            {
                
                consumed += warehouse.next();
            }
            catch(BufferEmptyException bufferEmptyException)
            {
                break;
            }
        }
        
        
        warehouse.leave(processIdentifier);
    }
    
    
    public Integer totalConsumed()  //returns the amount consumed.
    {
        return consumed;
    }
}


