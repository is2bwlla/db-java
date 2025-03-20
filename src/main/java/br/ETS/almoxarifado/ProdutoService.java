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

    public ArrayList<Produto> exibirProdutosDoAlmoxarifado() {
        return produtos;
    }

    public Produto encontrarProdutoPeloID(int id) {
        return produtos
                .stream() // Chama os métodos para manipulação de listas
                .filter(produto -> produto.getId() == id) // filtra a lista com base em um critério, retorna lista filtrada
                .findFirst() // Retorna o primeiro objeto da lista
                .orElseThrow(() -> new RegraDaAplicacaoException("Produto com este ID não foi encontrado"));
    }

    public void adicionarQuantidadeDeUmProduto(int id, int quantidadeASerAdicionada) {
        var produto = encontrarProdutoPeloID(id);
        if(quantidadeASerAdicionada <= 0) {
            throw new RegraDaAplicacaoException("Quantidade a ser adicionada deve ser maior que 0.");
        }
        produto.setQuantidade(produto.getQuantidade() + quantidadeASerAdicionada);
    }

    public void  removerQuantidadeDeUmProduto(int id, int quantidadeASerRemovida) {
        var produto = encontrarProdutoPeloID(id);
        if (quantidadeASerRemovida <= 0) {
            throw new RegraDaAplicacaoException("Quantidade a ser removida deve ser maior que 0");
        }

        if (produto.getQuantidade() < quantidadeASerRemovida) {
            throw new RegraDaAplicacaoException("Essa determinada quantidade não está disponível.");
        }

        produto.setQuantidade(produto.getQuantidade() - quantidadeASerRemovida);
    }

    public void removerOProdutoDoAlmoxarifado(int id) {
        var produto = encontrarProdutoPeloID(id);
        produtos.remove(produto);
    }
}
