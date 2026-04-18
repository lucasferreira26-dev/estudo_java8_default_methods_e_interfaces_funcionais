# 🧾 Sistema de Processamento de Pedidos com Java 8

## 📌 Sobre o projeto

Este projeto foi desenvolvido com o objetivo de praticar conceitos importantes do Java 8, com foco em **programação funcional** e uso de **interfaces funcionais**.

A aplicação simula um sistema simples de pedidos, permitindo aplicar filtros, executar ações encadeadas e manipular coleções de forma eficiente.

---

## 🚀 Tecnologias utilizadas

- Java 8+
- Programação Funcional
- Expressões Lambda

---

## 🧠 Conceitos aplicados

### ✔️ Predicate
Utilizado para representar regras de negócio (condições booleanas).

Exemplos no projeto:
- Filtrar pedidos com valor acima de R$500
- Filtrar pedidos com status PAGO
- Combinar filtros com `.and()`

---

### ✔️ Consumer
Responsável por executar ações sobre os dados.

Exemplos:
- Impressão de pedidos
- Execução de ações encadeadas com `.andThen()`

---

### ✔️ Encadeamento de operações

Uso do método `.andThen()` para executar múltiplas ações em sequência:

```java
Consumer<Pedido> acaoCompleta = mostrarPedido.andThen(mensagemProcessamento);
```

### ✔️ Manipulação de listas

Uso do método:

```java
removeIf()
```

- Para remover pedidos com status CANCELADO.

### 📦 Estrutura do projeto
src/
 - ├── Main.java
 - ├── Pedido.java
 - └── Status.java
