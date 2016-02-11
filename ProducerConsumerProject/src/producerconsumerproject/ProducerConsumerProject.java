/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumerproject;

/**
 *
 * @author Algharabeh
 * email: kmalgharabeh2016@spartans.manchester.edu
 */
public class ProducerConsumerProject {


    private static ProducerThread producerThread; //producer thread
    
    private static ConsumerThread consumerThread; //consumer thread
    
    private static BufferInterface<Integer> sharedBuffer; // shared buffer that the producer and consumer threads use
    
    private static final Integer ProducerProcessId = 0; //Id of the producer thread
    
    private static final Integer ConsumerProcessId = 1; //Id of the consumer thread
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws InterruptedException {
        
        sharedBuffer = new CircularBuffer<Integer>(); //Create the shared buffer
        
        producerThread = new ProducerThread(ProducerProcessId, sharedBuffer); //Create the thread objects, giving their thread ids
        consumerThread = new ConsumerThread(ConsumerProcessId, sharedBuffer);

        
        producerThread.start();  //Start the threads
        consumerThread.start();
                
        
        Thread.sleep(2000);  
        
        
        producerThread.Stop(); //Stop the producer thread first
         
        producerThread.join();
       
        consumerThread.Stop();  //Now stop the consumer thread.
        
        consumerThread.join(); //Wait until the thread has exited before moving on.
        
        System.out.println("DONE");
    }
    
}
       
   
   

