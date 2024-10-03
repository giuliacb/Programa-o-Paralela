package br.edu.iesb.pp2024.devlab1;

public class Thread1 implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(">> Thread1 [tec tec]...");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				
			}
		}
	}
	
	public void metodoMonoThread() {
		int [] array = new int[10];
		for (int i = 0; i < array.length; i++) {
			System.out.println(">> Metodo não concorrente (não paralelo)");
		}
	}
}
