#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <string.h>
#include "mpi.h"
#define MAX 100


//devlab9 - controlando o status de uma aplicação paralela

int main(int argc, char *argv[])
{
	int ranque;
	int etiq = 0;
	int origem = 0;
	int destino = 1;
	int numeros[MAX];
	int total_num;
	int finalizado = 0;


	MPI_Status estado;

	//chamada inicial para OpenMPI

	MPI_Init(&argc, &argv);
	MPI_Comm_rank(MPI_COMM_WORLD, &ranque);

	//produtor
	//rn:envia um numero aleatorio de inteiros para o processo 1
	if(ranque == origem){
		srand(MPI_Wtime());
		total_num = (rand() / (float)RAND_MAX) * MAX;

		MPI_Send(numeros, total_num, MPI_INT, destino, etiq, MPI_COMM_WORLD);

		printf(">> Processo %d enviou %d números para o processo 1 \n", origem, total_num);
	}

	// consumidor
	//rn:recebe o MAX de numero do processo 0

	if(ranque == destino){
		MPI_Recv(numeros, MAX, MPI_INT, origem, etiq, MPI_COMM_WORLD, &estado);

		MPI_Get_count(&estado, MPI_INT, &total_num);

		//log das operações
		printf(">> Processo %d recebeu %d números. Origem da mensagem = %d, etiq = %d \n", destino, total_num, estado.MPI_SOURCE, estado.MPI_TAG);
	}	
	
	
	//o prog está para termianr
	MPI_Finalized(&finalizado);

	if(!finalizado){ //!= null
		//executa o encerramento do paralelismo para o mpi
		MPI_Finalize();
	}


	return 0;
}
