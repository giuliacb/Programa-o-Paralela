package br.edu.iesb.pp2024.devlab1;

public class Thread3 extends Thread {

	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(">> Thread3 [tec tec]...");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				
			}
		}
	}
}
