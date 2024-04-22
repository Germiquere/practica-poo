package com.practice.poo.listarNumeros;

public class ImprimirNumeros implements Runnable {
    private final int inicio;
    private final int fin;

    public ImprimirNumeros(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    public void run() {
        for (int i = inicio; i <= fin; i++) {
            System.out.println(i);
        }
    }
}
