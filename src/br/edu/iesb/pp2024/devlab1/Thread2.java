package br.edu.iesb.pp2024.devlab1;

public class Thread2 implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(">> Thread2 [tec tec]...");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				
			}
		}
	}
}
