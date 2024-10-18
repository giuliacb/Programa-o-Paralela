package iesb.pp2024.devlab6.giuliacb.negocio;

import java.util.concurrent.Semaphore;

import iesb.pp2024.devlab6.giuliacb.util.IConfig;

public class SemaforoThread extends Thread {

    private Semaphore semaforo;
    private String nomeThread;

    public SemaforoThread(Semaphore semaforo, String nomeThread) {
        super(nomeThread);
        this.semaforo = semaforo;
        this.nomeThread = nomeThread;
    }

    @Override
    public void run() {
        if (this.getName().equals(IConfig.NOME_THREAD_CREDITO)) {
            realizarCreditos();
        } else if (this.getName().equals(IConfig.NOME_THREAD_DEBITO)) {
            realizarDebitos();
        }
    }

    private void realizarCreditos() {
        System.out.println(">> Iniciando [" + nomeThread + "]");
        
        try {
            // Adquire o bloqueio do semáforo
            semaforo.acquire();
            System.out.println("[" + nomeThread + "] obteve permissão para realizar créditos.");
            
            for (double valor : IConfig.VALORES_CREDITOS) {
                ContaCorrente.saldoContaCorrente += valor;
                System.out.println("[" + nomeThread + "] Crédito de R$" + valor + " | Saldo atual: R$ " + ContaCorrente.saldoContaCorrente);
                Thread.sleep(IConfig.TEMPO_SLEEP_THREAD);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Libera o bloqueio do semáforo
            System.out.println("[" + nomeThread + "] liberando o recurso.");
            semaforo.release();
        }
    }

    private void realizarDebitos() {
        System.out.println(">> Iniciando [" + nomeThread + "]");

        try {
            // Adquire o bloqueio do semáforo
            semaforo.acquire();
            System.out.println("[" + nomeThread + "] obteve permissão para realizar débitos.");
            
            for (double valor : IConfig.VALORES_DEBITOS) {
                if (ContaCorrente.saldoContaCorrente >= valor) {
                    ContaCorrente.saldoContaCorrente -= valor;
                    System.out.println("[" + nomeThread + "] Débito de R$" + valor + " | Saldo atual: R$ " + ContaCorrente.saldoContaCorrente);
                } else {
                    System.out.println("[" + nomeThread + "] Saldo insuficiente para débito de R$" + valor + " | Saldo atual: R$ " + ContaCorrente.saldoContaCorrente);
                }
                Thread.sleep(IConfig.TEMPO_SLEEP_THREAD);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Libera o bloqueio do semáforo
            System.out.println("[" + nomeThread + "] liberando o recurso.");
            semaforo.release();
        }
    }
}