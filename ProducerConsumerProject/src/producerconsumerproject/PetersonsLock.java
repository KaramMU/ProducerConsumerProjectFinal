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
public class PetersonsLock {
    
    private final Integer NumofSupportedProcesses = 2; // number of supported processes
    
    private volatile Integer turn; //indicates which process' turn to process it is
   
    private volatile boolean[] flags = new boolean[NumofSupportedProcesses];  //array of boolean flags used to change the process
    
    
    public void enter(int processId)  //method used to enter a process 
    {
        int otherProcess = 1 - processId;
        flags[processId] = true;
        turn = processId;
        while (turn == processId && flags[otherProcess] == true)
        {
            
        }
    }
    
    public void leave(int processId)  //method used to leave process
    {
        flags[processId] = false;
    }
}

    
