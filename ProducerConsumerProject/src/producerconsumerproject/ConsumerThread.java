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
public class ConsumerThread extends Thread implements ThreadInterface {
     
    private boolean StopReq = false;  //Indicates that this thread has been requested to stop running
    
    private BufferInterface<Integer> sharedBuffer;  // The Shared buffer where thread will consume integers
   
    private IntegerConsumer consumer;   //Instance of class that does the conusimg 
    

    public ConsumerThread(Integer processId, BufferInterface<Integer> warehouse) //Constructor
    {
        
        sharedBuffer = warehouse; 
       
        consumer = new IntegerConsumer(processId);  
    }
   
 
    @Override
    public void run()   //override of ThreadInterface's run method
    {
        StopReq = false;
        
        
        while(!StopReq)
        {
            
            consumer.consume(sharedBuffer);
        }
        
        
        System.out.println("Consumed = " + consumer.totalConsumed());
    }
    
    
    
    @Override
    public void Stop()  //override of ThreadInterface's stop method
    {
        StopReq = true;
    }
}

    

