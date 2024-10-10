package iesb.pp2024.devlab5.giuliacb.negocio;

import java.util.concurrent.Semaphore;

import iesb.pp2024.devlab5.giuliacb.util.IConfig;

public class SemaforoThread extends Thread {
	
	Semaphore semaforo;
	String nomeThread;
	
	public SemaforoThread(Semaphore semaforo, String nomeThread) {
		super(nomeThread);
		
		this.semaforo = semaforo;
		this.nomeThread = nomeThread;
		
	}
	
	
	@Override
	public void run() {
		
		if(this.getName().equals(IConfig.NOME_THREAD_CONCORRENTE_A)) {
			System.out.println(">> Iniciando[" + this.nomeThread + "]");
			
			try {
				//OBTENDO PERMISSÃO DE ESCRITA
				System.out.println("[" + this.nomeThread + "] está aguardando permissão para acessar o recurso compartilhado" );
				
				this.semaforo.acquire();
				
				System.out.println("[" + this.nomeThread + "] obteve permissão para acessar o recurso compartilhado" );

				for(int i = 0; i < 10; i++) {
					//acessando o recurso compartilhado
					RecursoCompartilhado.variavelCompartilhada++;
					
					System.out.println("[" + this.nomeThread + "] alterou o recusro compartilhado" + RecursoCompartilhado.variavelCompartilhada);
					
					//implementando uma pausa para verificar o funcionamento 
					Thread.sleep(IConfig.TEMPO_SLEEP_THREAD);
				}
	
				
			}catch(InterruptedException exc) {
				exc.printStackTrace();
			}
			
			//libera a permissão de acesso ao recurso compartilhado
			System.out.println("[" + this.nomeThread + "] liberando a permissão de acesso ao recurso compartilhado");
			
			this.semaforo.release();
			
		} else {
			
			//THREAD B
			System.out.println(">> Iniciando[" + this.nomeThread + "]");
			
				try {
					System.out.println("[" + this.nomeThread + "] está aguardando permissão para acessar o recurso compartilhado" );
					
					//THREAD B
					this.semaforo.acquire();
					
					//THREAD B
					System.out.println("[" + this.nomeThread + "] obteve permissão para acessar o recurso compartilhado" );
	
					for(int i = 0; i < 5; i++) {
						//THREAD B
						RecursoCompartilhado.variavelCompartilhada--;
						
						//THREAD B
						System.out.println("[" + this.nomeThread + "] alterou o recusro compartilhado" + RecursoCompartilhado.variavelCompartilhada);
						
						//THREAD B
						Thread.sleep(IConfig.TEMPO_SLEEP_THREAD);
					}
		
					
				}catch(InterruptedException exc) {
					exc.printStackTrace();
				}
				
				//libera a permissão de acesso ao recurso compartilhado
				System.out.println("[" + this.nomeThread + "] liberando a permissão de acesso ao recurso compartilhado");
				
				this.semaforo.release();
			}
	}

}
