package br.ETS.almoxarifado;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Produto produto = new Produto(new DadosProduto(1, "Bomba de combustivel", "459037A", "PS", 5));
        System.out.println(produto.toString());
    }
}