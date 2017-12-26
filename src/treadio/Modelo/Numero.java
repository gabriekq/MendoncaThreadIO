/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treadio.Modelo;

import java.io.Serializable;

/**
 *
 * @author Gabriel
 */
public class Numero implements  Serializable {
    
private int valor;





    public Numero(int valor) {
        setValor(valor);
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }


    
    
    
    
    
}
