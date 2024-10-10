package iesb.pp2024.devlab5.giuliacb;

import java.util.concurrent.Semaphore;

import iesb.pp2024.devlab5.giuliacb.negocio.RecursoCompartilhado;
import iesb.pp2024.devlab5.giuliacb.negocio.SemaforoThread;
import iesb.pp2024.devlab5.giuliacb.util.IConfig;

public class DevLab5Main {

	public static void main(String[] args) throws InterruptedException {
//		//Exemplo 1: explorando diferentes...
//		System.out.println(RecursoCompartilhado.variavelCompartilhada);
//		
//		RecursoCompartilhado recurso = new RecursoCompartilhado();
//		System.out.println(recurso.saldoContaCorrente);
//		//-----------------------------------------------------------------
		
		Semaphore semaforo = new Semaphore(IConfig.NUM_MAX_THREAD);
		
		SemaforoThread semaforoThreadA =  new SemaforoThread(semaforo, IConfig.NOME_THREAD_CONCORRENTE_A);
		
		SemaforoThread semaforoThreadB =  new SemaforoThread(semaforo, IConfig.NOME_THREAD_CONCORRENTE_B);

		//inicializa as threads do semaforo
		semaforoThreadA.start();
		semaforoThreadB.start();
		
		//garantir que eleas concluam as suas atividades juntas
		semaforoThreadA.join();
		semaforoThreadB.join();
		
		System.out.println(">> valor final da operação:" + RecursoCompartilhado.variavelCompartilhada + "]");
	}

}
