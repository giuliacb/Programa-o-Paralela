package iesb.pp2024.devLab2.giuliacb;

public class DevLab2Main {

	public static void main(String[] args) {
		// atalho system.out.println = syso + ctrl espaço
		System.out.println(">>Giulia Campelo Bezerra, 2212130008");
		System.out.println(">>DevLab2Main");
		
		//long startSemThread =  System.currentTimeMillis();
		long startSemThread =  System.nanoTime();
		
		//recursos que serão utilizados
		String nmArquivoLido = "exemplo_leitura.csv";
		boolean isPrintLine = true;
		ManipulaArquivoSemThread manipulaArquivoSemThread = new ManipulaArquivoSemThread();
		manipulaArquivoSemThread.lerArquivoSemParalelismo(nmArquivoLido, isPrintLine);
		
		//long finishSemThread =  System.currentTimeMillis(); para arquivos maiores
		long finishSemThread = System.nanoTime(); 
		System.out.println("## Tempo gasto sem Thread:" + (finishSemThread - startSemThread));
		
		
		//MANIPULAÇÃO DE ARQUIVOS GRANDES COM THREAD
		//exemplo com paralelismo errado
		//ManipulaArquivoComThread manipulaArquivoComThread = new ManipulaArquivoComThread();
		//manipulaArquivoComThread.lerArquivoComParalelismo(isPrintLine);
		
		long startComThread = System.nanoTime();
		Thread task1 = new ManipulaArquivoComThread();
		System.out.println(">>Status: " +task1.getState().ordinal() + " -> " +task1.getState());
		
		task1.start();
		
		long fnishComThread = System.nanoTime();
		System.out.println("## Tempo gasto com Thread:" + (finishSemThread - startSemThread));
		System.out.println(">>Status: " +task1.getState().ordinal() + " -> " +task1.getState());

	}
}
