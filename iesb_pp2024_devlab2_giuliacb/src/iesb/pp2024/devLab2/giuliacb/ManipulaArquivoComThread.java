package iesb.pp2024.devLab2.giuliacb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ManipulaArquivoComThread extends Thread {
	
	public static final String ARQUIVO = "SISANT.csv";

	@Override
	public void run() {
	}
	
	public void lerArquivoComParalelismo(boolean isPrint) {
		BufferedReader bufferedReader = null;
		int qtdLinhas = 0;
		
		try {
			File file = new File(ARQUIVO);
			String line;
			bufferedReader = new BufferedReader(new FileReader(file));
			
			while((line = bufferedReader.readLine()) != null){
				if(isPrint) {
					System.out.println(">> Thread: " +line);
				}
				qtdLinhas++;
			}
			
			System.out.println(">> Quantidade de linhas com a Thread: "+ qtdLinhas);
		} catch(IOException e) {
			System.err.println(e);
		} finally {
			try {
				bufferedReader.close();
			} catch(IOException e2) {
				System.err.println(e2);
			}
		}
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
