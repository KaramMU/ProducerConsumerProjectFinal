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
public class ProducerThread extends Thread implements ThreadInterface {
    
    private boolean StopReq = false;  //Indicates that this thread has been requested to stop running.
    
    private BufferInterface<Integer> sharedBuffer;  //Shared buffer which this thread will produces integers
    
    private IntegerProducer producer;  //Instance of class that will do the producing
    
    
    public ProducerThread(Integer processId, BufferInterface<Integer> warehouse)  //constructor
    {
        
        sharedBuffer = warehouse;
        producer = new IntegerProducer(processId);
    }
    
    
    
    @Override
    public void run() //override of ThreadInterface's run method
    {
        StopReq = false;
        
       
        while(!StopReq)
        {
           
            producer.produce(sharedBuffer);
        }

       
        System.out.println("Produced = " + producer.totalProduced());
    }
    
    
    
    @Override
    public void Stop()   //override of ThreadInterface's stop method
    {
        StopReq = true;
    }
}
