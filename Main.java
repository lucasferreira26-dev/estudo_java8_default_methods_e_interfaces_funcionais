package Aula4_Default_Methods_labs;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args){

        List<Pedido> pedidos = new ArrayList<>();

        Pedido pedido1 = new Pedido("Pedro", 1500, Status.PAGO);
        Pedido pedido2 = new Pedido("Ana", 1000, Status.PENDENTE);
        Pedido pedido3 = new Pedido("Maria", 400, Status.CANCELADO);

        pedidos.add(pedido1);
        pedidos.add(pedido2);
        pedidos.add(pedido3);

        // Filtro 1: Filtrar pedidos acima de R$ 500
        Predicate<Pedido> pedidosAcimaDe500 = p ->
                p.getValor() > 500;

        // Consumindo os pedidos com o primeiro filtro aplicado
        Consumer<Pedido> imprimirPedidosAcimaDe500 = pedido ->
                System.out.println(pedido);

        // O método teste faz o filtro(Predicate) faz o filtro e o método accept imprime na tela conforme o
        // filtro
        pedidos.forEach(p -> {
            if (pedidosAcimaDe500.test(p)) {
                imprimirPedidosAcimaDe500.accept(p);
            }
        });

        System.out.println("-----------------------------");

        // Filtro 2: Filtrar apenas os pedidos pagos
        Predicate<Pedido> pedidosPagos = p ->
                p.getStatus() == Status.PAGO;

        // Consumindo od pedidos com o segundo filtro
        Consumer<Pedido> imprimirPedidosPagos = pedido ->
                System.out.println(pedido);

        // Imprimindo na tela conforme o segundo filtro
        pedidos.forEach(p -> {
            if (pedidosPagos.test(p)) {
                imprimirPedidosPagos.accept(p);
            }
        });

        System.out.println("-----------------------------");

        // Filtro 3: Essa é a combinação do primeiro e segundo filtro, ou seja, o método and() filtra os dados
        // conforme os 2 primeiros filtros, ele verifica se o pedido está acima de R$ 500 e se está pago, então
        // ele retorna os pedidos se for verdade
        Predicate<Pedido> combinacaoFiltros = pedidosAcimaDe500.and(pedidosPagos);

        // Cosumindo após o filtro
        Consumer<Pedido> imprimirCombinacaoFiltros = pedido ->
                System.out.println(pedido);

        // Exibindo na tela conforme o terceiro filtro
        pedidos.forEach(p -> {
            if (combinacaoFiltros.test(p)) {
                imprimirCombinacaoFiltros.accept(p);
            }
        });

        System.out.println("-----------------------------");

        // Nessa seção nós buscamos aplicar dois conceitos:
        // O primeiro busca criar dois Consumers e encadear ambos com o método andThen. Nós primeiros mostramos
        // os pedidos e depois exibimos a mensagem "Pedido processado!"
        Consumer<Pedido> mostrarPedido = pedido -> System.out.println(pedido);
        Consumer<Pedido> mensagemProcessamento = pedido -> System.out.println("Pedido processado!");

        Consumer<Pedido> acaoCompletaSobrePedidos = mostrarPedido.andThen(mensagemProcessamento);

        // O segundo conceito implica na utilização do método removeif(). Se um pedido tem um status = cancelado
        // ele será removido da lista
        pedidos.removeIf(pedido -> pedido.getStatus() == Status.CANCELADO);

        // Então nós exibimos a lista atual depois da regra do removeIf
        pedidos.forEach(acaoCompletaSobrePedidos);

        System.out.println("-----------------------------");

        // Essa seção busca apenas reutilizar métodos para testar todos os filtros novamente

        aplicaFiltro(pedidos, pedidosAcimaDe500, imprimirPedidosAcimaDe500);

        System.out.println("-----------------------------");

        aplicaFiltro(pedidos, pedidosPagos, imprimirPedidosPagos);

        System.out.println("-----------------------------");

        aplicaFiltro(pedidos, combinacaoFiltros, imprimirCombinacaoFiltros);

        System.out.println("-----------------------------");

        pedidosRemovidos(pedidos);
        pedidos.forEach(acaoCompletaSobrePedidos);
    }

    public static void aplicaFiltro(
            List<Pedido> pedidos,
            Predicate<Pedido> filtro,
            Consumer<Pedido> acao) {

            pedidos.forEach(pedido -> {
                if(filtro.test(pedido)){
                    acao.accept(pedido);
                }
            });
        }

    public static void pedidosRemovidos(List<Pedido> pedidos) {

        pedidos.removeIf(pedido -> pedido.getStatus() == Status.CANCELADO);
    }

}
