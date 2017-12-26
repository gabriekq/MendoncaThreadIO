/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treadio.Clients;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import treadio.Controler.ManageIo;
import treadio.Modelo.Numero;

/**
 *
 * @author Gabriel
 */
public class SyncManege {

private final  ManageIo manegeIo;    
private boolean occupied = false;


    public SyncManege(ManageIo manege ) {
    
        manegeIo = manege;
    
    
    }
    
    
    
    public synchronized  void set(int value) throws InterruptedException{
    
    while(occupied){
    
        System.out.println("Producer tries to write");
        wait();
    }
    
   
    manegeIo.Save(new Numero(value));
    
    
    occupied = true;
    
    notifyAll();
    
    }
    
    public synchronized  int get() throws InterruptedException{
     
        
        
        while(!occupied){
        System.out.println("Consumer tries to read");
        wait();        
        }
    
      occupied = false;
      Numero numero =  manegeIo.GetObject();  
       
    
       notifyAll();
    
    return  numero.getValor() ; 
    }
    
    
    
    
    
    
}
