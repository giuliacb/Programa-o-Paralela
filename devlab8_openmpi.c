#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <string.h>
#include "mpi.h"

int main(int argc, char *argv[])
{
	//variavies globais
	int ranque;
	int num_procs;
	int origem;
	int destino = 0;
	int etiq = 1;
	char mensagem[200];
	int finalizado = 0;

	//openMPI
	MPI_Status estado;

	//chamada inicial para o MPI
	MPI_Init(&argc, &argv);

	// determina o ranque dos processos em exec
	MPI_Comm_rank(MPI_COMM_WORLD, &num_procs);

	// determina o numero de processos em exec
	MPI_Comm_size(MPI_COMM_WORLD, &num_procs);

	//codigo paralelizado: implementa modelo 
	//RN:odos os processos com ranque diferente de zero enviam uma mensagem
	if(ranque != destino){ //produtor (SEND)
		sprintf(mensagem, ">> O processo %d está executando em OpenMPI c/paralelismo.", ranque);

		MPI_Send(mensagem, strlen(mensagem) + 1, MPI_CHAR, destino, etiq, MPI_COMM_WORLD);
	} else { //consumidor (RECV)
		//RN: processo com o ranque 0 recebe o num_procs-1 mensagens
		for(origem = 1; origem < num_procs; origem++){
			MPI_Recv(mensagem, 200, MPI_CHAR, origem, etiq, MPI_COMM_WORLD, &estado);

			//imprime as mensagens recebidas por meio do OpenMPI
			printf("%s\n", mensagem);
		}
	}

	// logs
	int mpi_versao, mpi_subversao;
	MPI_Get_version(&mpi_versao, &mpi_subversao);
	printf(">> MPI Version: %d \n", mpi_versao);

	char maquina[MPI_MAX_PROCESSOR_NAME];
	int aux;
	MPI_Get_processor_name(maquina, &aux);

	printf(">> Número de tarefas = [%d], Ranque = [%d] executando na máquina [%s]! \n", num_procs, ranque, maquina);



	//o prog está para termianr
	MPI_Finalized(&finalizado);

	if(!finalizado){ //!= null
		//executa o encerramento do paralelismo para o mpi
		MPI_Finalize();
	}


	return 0;
}