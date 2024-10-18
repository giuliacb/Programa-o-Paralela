package iesb.pp2024.devlab6.giuliacb.util;

public interface IConfig {
	
	 public static final String NOME_THREAD_CREDITO = "THREAD CREDITO";
	 public static final String NOME_THREAD_DEBITO = "THREAD DEBITO";
	 public static final int NUM_MAXIMO_THREADS = 1; // Controla acesso exclusivo
	 public static final double SALDO_INICIAL = 100.0; // Saldo inicial da conta
	 public static final int TEMPO_SLEEP_THREAD = 1000; // Tempo de espera entre operações
	 public static final double[] VALORES_CREDITOS = {100.0, 200.0, 150.0}; // Lançamentos de crédito
	 public static final double[] VALORES_DEBITOS = {50.0, 60.0, 70.0, 80.0, 30.0}; // Lançamentos de débito
}
