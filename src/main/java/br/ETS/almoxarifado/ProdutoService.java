package br.ETS.almoxarifado;

import java.sql.Connection;
import java.util.ArrayList;

public class ProdutoService {
    private ArrayList<Produto> produtos = new ArrayList<>();

    private ConnectionFactory connectionFactory;


    public ProdutoService() {
        this.connectionFactory = new ConnectionFactory();
    }

    public void adicionarNovoProduto(DadosProduto dadosProduto) {
        var produto = new Produto(dadosProduto);

        if (exibirProdutosDoAlmoxarifado().contains(produto)) {
            throw new RegraDaAplicacaoException("Já existe um tipo de produto com este ID");
        }
        Connection connection = connectionFactory.recuperarConexao();
        new ProdutoDAO(connection).salvar(dadosProduto);
    }

    public ArrayList<Produto> exibirProdutosDoAlmoxarifado() {
        Connection connection = connectionFactory.recuperarConexao();
        return new ProdutoDAO(connection).listar();
    }

    public Produto encontrarProdutoPeloID(int id) {
        Connection connection = connectionFactory.recuperarConexao();
        Produto produto = new ProdutoDAO(connection).listarPorID(id);

        if (produto != null) {
            return produto;
        } else {
            throw new RegraDaAplicacaoException("Não existe produto com esse ID.");
        }
    }

    public void adicionarQuantidadeDeUmProduto(int id, int quantidadeASerAdicionada) {
        var produto = encontrarProdutoPeloID(id);
        if(quantidadeASerAdicionada <= 0) {
            throw new RegraDaAplicacaoException("Quantidade a ser adicionada deve ser maior que 0.");
        }
        Connection connection = connectionFactory.recuperarConexao();
        new ProdutoDAO(connection).alterar(produto.getId(), produto.getQuantidade() + quantidadeASerAdicionada);
    }

    public void  removerQuantidadeDeUmProduto(int id, int quantidadeASerRemovida) {
        var produto = encontrarProdutoPeloID(id);

        if (quantidadeASerRemovida <= 0) {
            throw new RegraDaAplicacaoException("Quantidade a ser removida deve ser maior que 0");
        }

        if (produto.getQuantidade() < quantidadeASerRemovida) {
            throw new RegraDaAplicacaoException("Essa determinada quantidade não está disponível.");
        }
        Connection connection = connectionFactory.recuperarConexao();
        new ProdutoDAO(connection).alterar(produto.getId(), produto.getQuantidade() - quantidadeASerRemovida);
    }

    public void removerOProdutoDoAlmoxarifado(int id) {
        if (encontrarProdutoPeloID(id) != null) {
            Connection connection = connectionFactory.recuperarConexao();
            new ProdutoDAO(connection).deletar(id);
        } else {
            throw new RegraDaAplicacaoException("Não foi encontrado produto com esse ID.");
        }
    }
}
