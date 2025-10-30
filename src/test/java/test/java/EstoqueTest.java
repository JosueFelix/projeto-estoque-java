package test.java;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import java.util.List;


import main.java.Estoque;
import main.java.Produto;

public class EstoqueTest {

    private Estoque estoque;

    @Before
    public void setUp() {
        estoque = new Estoque();
    }

    // --- Testes para US #1 (Já existem) ---
    @Test
    public void deveCadastrarNovoProdutoComSucesso() {
        Produto p = estoque.cadastrarProduto("Monitor", "Monitor 24 polegadas", 10);
        assertNotNull(p);
        assertEquals(1, p.getId()); // [cite: 36]
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDeveCadastrarProdutoComNomeDuplicado() {
        estoque.cadastrarProduto("Teclado", "Teclado ABNT2", 5);
        estoque.cadastrarProduto("Teclado", "Outro Teclado", 2); // [cite: 37]
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDeveCadastrarProdutoComQuantidadeNegativa() {
        estoque.cadastrarProduto("Mouse", "Mouse sem fio", -1); // [cite: 38]
    }

    // --- Testes para US #2 (NOVA ATUALIZAÇÃO) ---
    @Test
    public void deveListarTodosOsProdutos() {
        estoque.cadastrarProduto("Produto A", "Desc A", 1);
        estoque.cadastrarProduto("Produto B", "Desc B", 2);
        List<Produto> lista = estoque.listarProdutos();
        assertEquals(2, lista.size()); // [cite: 46]
    }

    @Test
    public void deveRetornarListaVaziaSeNenhumProdutoCadastrado() {
        List<Produto> lista = estoque.listarProdutos();
        assertEquals(0, lista.size()); // [cite: 47]
    }
}