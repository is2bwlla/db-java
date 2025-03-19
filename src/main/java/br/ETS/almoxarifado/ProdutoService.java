package br.ETS.almoxarifado;

import java.util.ArrayList;

public class ProdutoService {
    private ArrayList<Produto> produtos = new ArrayList<>();

    public void adicionarNovoProduto(DadosProduto dadosProduto) {
        var produto = new Produto(dadosProduto);

        if (produtos.contains(produto)) {
            throw new RegraDaAplicacaoException("Já existe u tipo de produto com este ID");
        }
        produtos.add(produto);
    }
}
