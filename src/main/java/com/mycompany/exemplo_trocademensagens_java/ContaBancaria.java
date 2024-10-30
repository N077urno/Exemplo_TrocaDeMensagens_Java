/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exemplo_trocademensagens_java;

/**
 *
 * @author nando
 */
public class ContaBancaria {
    private double saldo;
    
    public ContaBancaria(double saldoInicial){
        this.saldo = saldoInicial;
    }
    
    public synchronized void processarOperacao(Operacao operacao){
        switch(operacao.getTipo()){
            case SAQUE:
                if(saldo >= operacao.getValor()){
                    saldo -= operacao.getValor();
                    System.out.println("Saque de..: "+ String.format("%.2f",operacao.getValor())+" realizado. Novo Saldo..: "+saldo);
                }else{
                    System.out.println("Saldo Insuficiente para o saque de..: "+String.format("%.2f", operacao.getValor())+". Saldo Atual..:"+saldo);
                }
                break;
            case DEPOSITO:
                saldo += operacao.getValor();
                System.out.println("Deposito de..: "+String.format("%.2f", operacao.getValor())+" realizado. Novo Saldo..: "+saldo);
                break;
        }
    }
    
    public double getSaldo(){
        return saldo;
    }
}
