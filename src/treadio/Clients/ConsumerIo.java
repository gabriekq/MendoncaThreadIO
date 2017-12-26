/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treadio.Clients;






/**
 *
 * @author Gabriel
 */
public class ConsumerIo implements Runnable {
 
private final SyncManege Shared;  
    
    

    public ConsumerIo( SyncManege sharedLocation  ) {
      
     Shared = sharedLocation;
    }
    
   
    @Override
    public  void run() {
       
    
        for(int ind = 1;ind <=100;ind++){
        
            try{
            
                System.err.println("reading -> "+Shared.get());
            
            }catch(InterruptedException exception){
            exception.printStackTrace();
            }
       
        
        }
        
        System.out.println("Consumer Done");
        
        
        
    }
    
    
    
    
    
    
    
}
