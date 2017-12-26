/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treadio;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import treadio.Clients.ConsumerIo;
import treadio.Clients.ProducerIo;
import treadio.Clients.SyncManege;

import treadio.Controler.ManageIo;





/**
 *
 * @author Gabriel
 */
public class TreadIo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here
          ManageIo manege =      new ManageIo();
          manege.Open();
          SyncManege syncM = new SyncManege(manege);
        
          ExecutorService application = Executors.newCachedThreadPool();
          application.execute( new ConsumerIo(syncM) );
          application.execute(new ProducerIo(syncM));
  
         application.shutdown();
        
        try{
        
           
        boolean tasksEnded = application.awaitTermination(1, TimeUnit.MINUTES);
        
        if(tasksEnded){
           
            manege.CloseFile();
        
        
        }else{
          System.out.println("Timed out while waiting for tasks to finish.");
        }
       
        }catch(InterruptedException exception){
        System.out.println("Interrupted while waiting for tasks to finish.");
        
        }
        
        
     
        
    }
    
    
    
    
    
    
    
    
}
