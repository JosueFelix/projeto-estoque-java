package main.java; // <--- ADICIONE ESTA LINHA

public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private int quantidade;

    public Produto(int id, String nome, String descricao, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: '" + nome + "', Descrição: '" + descricao + "', Quantidade: " + quantidade;
    }
}