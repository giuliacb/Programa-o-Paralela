package iesb.pp2024.devlab3.giuliacb;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class DevLab3Main {

	public static void main(String[] args) {

		BlockingQueue<String> queue = new LinkedBlockingQueue();
		
		Thread producerThread = new Thread(new FileProducer(queue, IConfig.ARQUIVO_ORIGEM));
		Thread consumerThread = new Thread(new FileConsumer(queue, IConfig.ARQUIVO_DESTINO));
		
		producerThread.start();
		
		
		try {
			//sleep permite que a fila seja criada
			Thread.sleep(IConfig.TIME_SLEEP);
			consumerThread.start();
			
			
			producerThread.join();
			consumerThread.join();
		}catch(InterruptedException e) {
			System.err.println(e);
		}
	}

}
