package iesb.pp2024.devlab3.giuliacb;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class FileProducer implements Runnable {
	
	private final BlockingQueue<String> queue;
	private final String inputFile;
	
	//inicialização tardia
	public FileProducer(BlockingQueue<String> queue, String inputFile){
		this.queue = queue;
		this.inputFile = inputFile;
	}

	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			String line;
			
			while ((line = reader.readLine()) != null) {
				System.out.println(">> " + getClass() + ": " + line);
				
				queue.offer(line);
			}
		} catch(IOException e) {
			System.err.println(e);
		}
	}

}
