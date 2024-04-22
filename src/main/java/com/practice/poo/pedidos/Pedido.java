package com.practice.poo.pedidos;

import com.practice.poo.exceptions.CambioEstadoInvalidoException;

import java.util.Date;
import java.util.List;

public class Pedido {
    private double id = new Date().getTime()*23123;
    private Usuario usuario;
    private EstadoPedido estado = EstadoPedido.BORRADOR;
    private TipoPedido tipo;
    private List<Golosina> golosinas;

    public Pedido( Usuario usuario, TipoPedido tipo, List<Golosina> golosinas) {

        this.usuario = usuario;
        this.tipo = tipo;
        this.golosinas = golosinas;
    }

//    GETTERS AND SETTERS
public double getId() {
    return id;
}

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public TipoPedido getTipo() {
        return tipo;
    }

    public void setTipo(TipoPedido tipo) {
        this.tipo = tipo;
    }

    public List<Golosina> getGolosinas() {
        return golosinas;
    }

    public void setGolosinas(List<Golosina> golosinas) {
        this.golosinas = golosinas;
    }

//    METODOS

//    valida el cambio de estado del pedido
private boolean validarCambioEstado(EstadoPedido nuevoEstado) throws CambioEstadoInvalidoException {
    switch (estado){
        case BORRADOR:
            if(nuevoEstado == EstadoPedido.PENDIENTE_APROBACION){
                return true;
            }else{
                throw  new CambioEstadoInvalidoException("No podes cambiar directamente un pedido en estado Borrador a "+nuevoEstado);
            }

        case PENDIENTE_APROBACION:
            if (nuevoEstado == EstadoPedido.APROBADO || nuevoEstado == EstadoPedido.RECHAZADO) {
                return true;
            } else {
                throw new CambioEstadoInvalidoException("No puedes cambiar un pedido en estado 'Pendiente Aprobación' a '" + nuevoEstado + "'");
            }

        case APROBADO:
        case RECHAZADO:
            throw new CambioEstadoInvalidoException("No puedes cambiar un pedido en estado '" + estado + "' a otro estado.");

        default:
            throw new CambioEstadoInvalidoException("El estado actual del pedido es inválido.");
    }
}

// cambia el estado del pedido en caso de pasar las validaciones
    public void cambiarEstado( EstadoPedido nuevoEstado){
        try{
            if(this.validarCambioEstado(nuevoEstado)){
                this.setEstado(nuevoEstado);
            }
        }catch (CambioEstadoInvalidoException e){
            System.out.println( e.getMessage());
        }

    }


}
