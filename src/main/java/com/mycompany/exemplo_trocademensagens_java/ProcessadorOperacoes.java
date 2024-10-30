/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exemplo_trocademensagens_java;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author nando
 */
public class ProcessadorOperacoes implements Runnable {
    private final ContaBancaria conta;
    private final BlockingQueue<Operacao> filaOperacoes;
    
    public ProcessadorOperacoes(ContaBancaria conta, BlockingQueue<Operacao> filaOperacoes){
        this.conta = conta;
        this.filaOperacoes = filaOperacoes;
    }
    
    @Override
    public void run() {
        try{
            while(true){
                Operacao operacao = filaOperacoes.take();
                conta.processarOperacao(operacao);
            }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("Processador de Operacoes Interrompido ");
        }
    }
    
}
