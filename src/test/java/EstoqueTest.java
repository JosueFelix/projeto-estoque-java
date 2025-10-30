package test.java;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

public class EstoqueTest {

    private Estoque estoque;

    @Before
    public void setUp() {
        estoque = new Estoque();
    }

    // --- Testes para US #1: Cadastrar Produto ---

    @Test
    public void deveCadastrarNovoProdutoComSucesso() {
        Produto p = estoque.cadastrarProduto("Monitor", "Monitor 24 polegadas", 10);

        assertNotNull(p);
        assertEquals(1, p.getId());
        assertEquals("Monitor", p.getNome());
        assertEquals(10, p.getQuantidade());
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDeveCadastrarProdutoComNomeDuplicado() {
        estoque.cadastrarProduto("Teclado", "Teclado ABNT2", 5);
        estoque.cadastrarProduto("Teclado", "Outro Teclado", 2); // Deve falhar
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDeveCadastrarProdutoComQuantidadeNegativa() {
        estoque.cadastrarProduto("Mouse", "Mouse sem fio", -1); // Deve falhar
    }

}