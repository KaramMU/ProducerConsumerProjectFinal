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
public class IntegerProducer implements ProducerInterface<Integer>  {
    
    private Integer TheNumStore;  //the last number stored in the shared buffer
    
    private Integer produced;  //keeps track of the running total of all produced integers
   
    private Integer processIdentifier;   // The Process id
    
     
    public IntegerProducer(Integer threadId)  //Constructor
    {
       
        TheNumStore = 0;
        produced = 0;
       
        processIdentifier = threadId;
    }
    
    
    @Override
    public void produce(BufferInterface<Integer> warehouse)  //Adds a value to the shared buffer and adds it to the running total
    {
        
        warehouse.enter(processIdentifier);
        
        
        while(!warehouse.isFull())
        {
            try
            {
                Integer val = nextTheNumStore();
                warehouse.store(val);
                produced += val;
            }
            catch(BufferFullException bufferFullException)
            {
                break;
            }
        }
        
        
        warehouse.leave(processIdentifier);
    }
    
    
    private Integer nextTheNumStore()  //method used to create a number to store in the shared buffer. 
    {
        TheNumStore += 1;
        if(TheNumStore > 10)
            TheNumStore = 1;
        return TheNumStore;
    }
    
    
    public Integer totalProduced()  //returns the amount produced
    {
        return produced;
    }
}

