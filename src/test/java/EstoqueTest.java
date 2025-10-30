
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import java.util.List;



public class EstoqueTest {

    private Estoque estoque; // (O erro de 'Estoque' VAI SUMIR)

    @Before
    public void setUp() {
        estoque = new Estoque();
    }

    // --- Testes para US #1 ---
    @Test
    public void deveCadastrarNovoProdutoComSucesso() {
        Produto p = estoque.cadastrarProduto("Monitor", "Monitor 24 polegadas", 10); // (O erro de 'Produto' VAI SUMIR)
        assertNotNull(p);
        assertEquals(1, p.getId());
    }

    // (O resto do seu código de teste está perfeito e não precisa mudar)
    @Test(expected = IllegalArgumentException.class)
    public void naoDeveCadastrarProdutoComNomeDuplicado() {
        estoque.cadastrarProduto("Teclado", "Teclado ABNT2", 5);
        estoque.cadastrarProduto("Teclado", "Outro Teclado", 2);
    }
    @Test(expected = IllegalArgumentException.class)
    public void naoDeveCadastrarProdutoComQuantidadeNegativa() {
        estoque.cadastrarProduto("Mouse", "Mouse sem fio", -1);
    }

    // --- Testes para US #2 ---
    @Test
    public void deveListarTodosOsProdutos() {
        estoque.cadastrarProduto("Produto A", "Desc A", 1);
        estoque.cadastrarProduto("Produto B", "Desc B", 2);
        List<Produto> lista = estoque.listarProdutos();
        assertEquals(2, lista.size());
    }
    @Test
    public void deveRetornarListaVaziaSeNenhumProdutoCadastrado() {
        List<Produto> lista = estoque.listarProdutos();
        assertEquals(0, lista.size());
    }

    // --- Testes para US #3 ---
    @Test
    public void deveAdicionarEstoqueAoProdutoComSucesso() {
        Produto p = estoque.cadastrarProduto("HD SSD", "1TB", 10);
        int idProduto = p.getId();
        Produto pAtualizado = estoque.adicionarEstoque(idProduto, 5);
        assertEquals(15, pAtualizado.getQuantidade());
    }
    @Test(expected = IllegalArgumentException.class)
    public void naoDeveAdicionarEstoqueProdutoNaoEncontrado() {
        estoque.adicionarEstoque(999, 5);
    }
    @Test(expected = IllegalArgumentException.class)
    public void naoDeveAdicionarEstoqueComQuantidadeNegativa() {
        Produto p = estoque.cadastrarProduto("RAM", "16GB", 10);
        estoque.adicionarEstoque(p.getId(), -5);
    }
    @Test(expected = IllegalArgumentException.class)
    public void naoDeveAdicionarEstoqueComQuantidadeZero() {
        Produto p = estoque.cadastrarProduto("RAM", "16GB", 10);
        estoque.adicionarEstoque(p.getId(), 0);
    }
}