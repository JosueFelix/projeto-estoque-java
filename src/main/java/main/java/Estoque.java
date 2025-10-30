package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private Map<Integer, Produto> produtos = new HashMap<>();
    private Map<String, Integer> indicePorNome = new HashMap<>();
    private int proximoId = 1;

    // --- US #1
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

    // --- US #2 (NOVA ATUALIZAÇÃO) ---
    /**
     * User Story #2: Listar todos os produtos
     */
    public List<Produto> listarProdutos() {
        // [cite: 46]
        return new ArrayList<>(produtos.values());
    }
}