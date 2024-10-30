/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.exemplo_trocademensagens_java;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author nando
 */
public class Exemplo_TrocaDeMensagens_Java {

    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria(1000);
        BlockingQueue<Operacao> filaOperacoes = new ArrayBlockingQueue<>(50);
        Random random = new Random();
        
        Thread processador = new Thread(new ProcessadorOperacoes(conta, filaOperacoes));
        processador.start();
        
        Runnable gerarOperacoes = () -> {
            for(int i=0;i<100;i++){
                double valor = 50 +(200 -50)*random.nextDouble();
                Operacao.Tipo tipo = random.nextBoolean() ? Operacao.Tipo.DEPOSITO:Operacao.Tipo.SAQUE;
                
                try{
                    filaOperacoes.put(new Operacao(tipo,valor));
                    Thread.sleep(random.nextInt(100));
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                    break;
                }
            }   
        };
            
            Thread t1 = new Thread(gerarOperacoes, "Thread 1");
            Thread t2 = new Thread(gerarOperacoes, "Thread 2");
            
            t1.start();
            t2.start();
        }
    }

