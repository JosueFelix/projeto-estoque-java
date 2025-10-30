package main.java;

import java.util.HashMap;
import java.util.Map;


public class Estoque {

    private Map<Integer, Produto> produtos;
    private Map<String, Integer> indicePorNome;
    private int proximoId = 1;

    public Estoque() {
        this.produtos = new HashMap<>();
        this.indicePorNome = new HashMap<>();
    }

    /**
     * User Story #1: Cadastrar novo produto
     */
    public Produto cadastrarProduto(String nome, String descricao, int quantidadeInicial) {
        if (indicePorNome.containsKey(nome.toLowerCase())) {
            throw new IllegalArgumentException("Erro: Produto com este nome já cadastrado.");
        }
        if (quantidadeInicial < 0) {
            throw new IllegalArgumentException("Erro: Quantidade inicial não pode ser negativa.");
        }
        int id = proximoId++;
        Produto novoProduto = new Produto(id, nome, descricao, quantidadeInicial);

        produtos.put(id, novoProduto);
        indicePorNome.put(nome.toLowerCase(), id);

        return novoProduto;
    }

}