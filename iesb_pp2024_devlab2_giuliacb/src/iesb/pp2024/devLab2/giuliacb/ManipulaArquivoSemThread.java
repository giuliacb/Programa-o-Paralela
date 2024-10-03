package iesb.pp2024.devLab2.giuliacb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ManipulaArquivoSemThread {
	public void lerArquivoSemParalelismo(String nmArquivo, boolean isPrint) {
		BufferedReader bufferedReader = null;
		try {
			File file = new File(nmArquivo);
			String line;
			bufferedReader = new BufferedReader(new FileReader(file));
			
			while((line = bufferedReader.readLine()) != null) {
				if (isPrint) {
					System.out.println(line);
				}
			}
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e2) {
				System.err.println(e2);
			}
		}
	}

}
