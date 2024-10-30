/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exemplo_trocademensagens_java;

/**
 *
 * @author nando
 */
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Operacao {
    public enum Tipo {SAQUE, DEPOSITO}
    
    private final Tipo tipo;
    private final double valor;
    
    public Operacao(Tipo tipo, double valor){
        this.tipo = tipo;
        this.valor = valor;
    }
    
    public Tipo getTipo(){
        return tipo;
    }
    
    public double getValor(){
        return valor;
    }    
}
