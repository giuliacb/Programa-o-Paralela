package iesb.pp2024.devlab6.giuliacb;

import java.util.concurrent.Semaphore;

import iesb.pp2024.devlab6.giuliacb.negocio.ContaCorrente;
import iesb.pp2024.devlab6.giuliacb.negocio.SemaforoThread;
import iesb.pp2024.devlab6.giuliacb.util.IConfig;

public class DevLab6Main {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println(">> Giulia Campelo Bezerra, 2212130008");
		
		Semaphore semaforo = new Semaphore(IConfig.NUM_MAXIMO_THREADS);
        
        // Cria threads de crédito e débito
        SemaforoThread tCredito = new SemaforoThread(semaforo, IConfig.NOME_THREAD_CREDITO);
        SemaforoThread tDebito = new SemaforoThread(semaforo, IConfig.NOME_THREAD_DEBITO);
        
        // Inicia as threads
        tCredito.start();
        tDebito.start();
        
        // Aguarda a conclusão das threads
        tCredito.join();
        tDebito.join();
        
        // Exibe o saldo final da conta corrente
        System.out.println(">> Saldo final da conta corrente: R$ " 
                + ContaCorrente.saldoContaCorrente);

	}

}
