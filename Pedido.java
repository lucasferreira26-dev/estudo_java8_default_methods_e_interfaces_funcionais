package Aula4_Default_Methods_labs;

public class Pedido {

    private String cliente;
    private double valor;
    private Status status;

    public Pedido(String cliente, double valor, Status status) {
        this.cliente = cliente;
        this.valor = valor;
        this.status = status;
    }

    public String getCliente() {
        return cliente;
    }

    public double getValor() {
        return valor;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return cliente + " - R$" + valor + " - " + status;
    }
}
