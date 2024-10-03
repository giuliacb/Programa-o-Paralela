package iesb.pp2024.devlab3.giuliacb;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class FileConsumer implements Runnable {

	private final BlockingQueue<String> queue;
	private final String outputFile;
	private int contadorLinhas = 0;
	
	public FileConsumer(BlockingQueue<String> queue, String outputFile){
		this.queue = queue;
		this.outputFile = outputFile;
	}
	
	@Override
	public void run() {
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
			String line;
			
			while((line = queue.poll()) != null) {
				System.out.println(">> " + getClass() + ": " + line);
				
				writer.write(line);
				writer.newLine();
				contadorLinhas++;
			}
			System.out.println(">> ContadorLinhas: " + contadorLinhas);
			
		} catch(IOException e) {
			System.err.println(e);		}

	}

}
