package br.edu.iesb.pp2024.devlab1;

public class ProgramacaoParalelaDevLab1Main {

	public static void main(String[] args) {
		System.out.println("Hello, Programação Paralela 2024");
		
		Runnable objeto1 = new Thread1();
		Runnable objeto2 = new Thread2();
		
		//cria thread para execução
		Thread task1 = new Thread(objeto1);
		Thread task2 = new Thread(objeto2);
		Thread task3 = new Thread3();
		
		System.out.println(">> task1 status:" + task1.getState());
		System.out.println(">> task2 status:" + task2.getState());
		System.out.println(">> task3 status:" + task3.getState());
		
		//task1.metodoMonoThread();
		
		//errado!!!
		//task1.run();
		
		task1.start();
		task2.start();
		task3.start();
		
		System.out.println(">> task1 status:" + task1.getState());
		System.out.println(">> task2 status:" + task2.getState());
		System.out.println(">> task3 status:" + task3.getState());
	}

}
