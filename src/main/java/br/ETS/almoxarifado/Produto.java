package br.ETS.almoxarifado;

import java.util.Objects;

public class Produto {
    private int id;
    private String produto;
    private String partnumber;
    private String divisao;
    private int quantidade;

    public Produto(DadosProduto dadosProduto) {
        this.id = dadosProduto.id();
        this.produto = dadosProduto.produto();
        this.partnumber = dadosProduto.partnumber();
        this.divisao = dadosProduto.divisao();
        this.quantidade = dadosProduto.quantidade();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return id == produto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getPartnumber() {
        return partnumber;
    }

    public void setPartnumber(String partnumber) {
        this.partnumber = partnumber;
    }

    public String getDivisao() {
        return divisao;
    }

    public void setDivisao(String divisao) {
        this.divisao = divisao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", produto='" + produto + '\'' +
                ", partnumber='" + partnumber + '\'' +
                ", divisao='" + divisao + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
}
