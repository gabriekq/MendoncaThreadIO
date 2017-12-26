/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treadio.Controler;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import treadio.Modelo.Numero;




/**
 *
 * @author Gabriel
 */
public class ManageIo {
    
private ObjectOutputStream output;    
private ObjectInputStream input;    

    
    public void Open(){
    
      try{    
      output = new ObjectOutputStream(new FileOutputStream( "numero.ser"));
      input = new ObjectInputStream(new FileInputStream("numero.ser"));
     }catch(IOException ioException){
          System.err.println("Erro to open the file");
     }
    
        
    
    }
    
       
    
public void Save(Numero numero  ){
  
    try{
    output.writeObject(numero);
   output.flush();
    }catch(IOException ioExeption){
    
        System.err.println("Error writing to file.");
    }
    
}

 public Numero GetObject( ){
 Numero numero =null;
 try{
 
 while(true){
  numero   =      (Numero) input.readObject(); 
      
 
  
 }
  
 
 }catch(EOFException endOfFileException){
       
    //System.err.println("end of file was reached"); 
 }catch( ClassNotFoundException classNotFoundException){
 
 System.err.println( "Unable to create object." );
 
 }catch(IOException ioException){
 System.err.println( "Error during read from file." );
 }
 
 return numero;
 }



public void CloseFile(){

    try{
    
        if(input != null ){
        input.close();
        }
        
        if(output != null){
        output.close();
        }
        
    }catch(IOException ioEception ){
    
        System.err.println("Error Closing file");
        System.exit(1);
        
    }
    
}
    
    

    
    
    
    
    
}
