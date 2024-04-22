package com.practice.poo;

import com.practice.poo.listarNumeros.ListarNumeros;
import com.practice.poo.pedidos.*;

import java.util.ArrayList;
import java.util.List;

public class PracticaPoo {
    public static void main(String[] args){
//        =====IMPORTANTE LEER!!! =====

//        Descomentar linea 14 y 15 para hacer funcionar el listado de los numeros
//        ListarNumeros lista = new ListarNumeros(1000000);
//        lista.listar();

//        =====IMPORTANTE LEER!!! =====
        Usuario usuario = new Usuario("German");

        Golosina zugus = new Golosina("zugus",1500);

        Golosina palitoDelaSelva = new Golosina("Palito de la selva",2350);

        List <Golosina> golosinas = new ArrayList<>();

        golosinas.add(zugus);

        golosinas.add(palitoDelaSelva);

        Pedido pedido = new Pedido(usuario, TipoPedido.MINORISTA,golosinas);
        System.out.println( pedido.getId());
        System.out.println("==============================================");
        System.out.println("Primer cambio");
        pedido.cambiarEstado(EstadoPedido.PENDIENTE_APROBACION);
        System.out.println(pedido.getEstado());
        System.out.println("==============================================");
        System.out.println("Segundo cambio");
        pedido.cambiarEstado(EstadoPedido.APROBADO);
        System.out.println(pedido.getEstado());
        System.out.println("==============================================");
        System.out.println("Tercer cambio");
        pedido.cambiarEstado(EstadoPedido.BORRADOR);
        System.out.println(pedido.getEstado());
        System.out.println("==============================================");

//


    }
}
