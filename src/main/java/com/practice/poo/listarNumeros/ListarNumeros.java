package com.practice.poo.listarNumeros;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ListarNumeros {
    private int numeros;
    public ListarNumeros(int numeros){
        this.numeros = numeros;
    }
    public void listar(){
        final int N = this.numeros;
        final int THREADS = Runtime.getRuntime().availableProcessors();

        ExecutorService executor = Executors.newFixedThreadPool(THREADS);
        int chunkSize = N / THREADS;

        for (int i = 0; i < THREADS; i++) {
            final int inicio = i * chunkSize + 1;
            final int fin = (i == THREADS - 1) ? N : (i + 1) * chunkSize;
            executor.submit(new ImprimirNumeros(inicio,fin));
        }

        executor.shutdown();
    }


}
