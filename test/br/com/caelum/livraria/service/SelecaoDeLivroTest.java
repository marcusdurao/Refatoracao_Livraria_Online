package br.com.caelum.livraria.service;

import br.com.caelum.livraria.dominio.CalculadoraFrete;
import br.com.caelum.livraria.dominio.CarrinhoDeCompras;
import br.com.caelum.livraria.dominio.CarrinhoDeComprasFactory;
import br.com.caelum.livraria.dominio.TodosLivros;
import org.javamoney.moneta.Money;
import org.junit.Before;
import org.junit.Test;

import static br.com.caelum.livraria.dominio.ISBNTest.outroIsbnValido;
import static br.com.caelum.livraria.dominio.ISBNTest.umIsbnValido;
import static br.com.caelum.livraria.dominio.Livraria.reais;
import static br.com.caelum.livraria.dominio.LivroTest.OUTRO_LIVRO;
import static br.com.caelum.livraria.dominio.LivroTest.UM_LIVRO;
import static br.com.caelum.livraria.dominio.ObjetosParaTestes.UM_CLIENTE;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SelecaoDeLivroTest {
	
	private TodosLivros todosLivros;
	private SelecaoDeLivro servico;
	private CalculadoraFrete calculadoraFrete; 
	private CarrinhoDeComprasFactory todosCarrinhosDeCompras;
	
	@Before
	public void setUp() {
		this.todosLivros = mock(TodosLivros.class);
		when(todosLivros.por(umIsbnValido)).thenReturn(UM_LIVRO);
		
		this.todosCarrinhosDeCompras = new CarrinhoDeComprasFactory();
		this.calculadoraFrete = mock(CalculadoraFrete.class);
		when(calculadoraFrete.baseadoEm(anyString())).thenReturn(Money.of(5, reais));
		this.servico = new SelecaoDeLivro(todosLivros, calculadoraFrete, todosCarrinhosDeCompras);
	}
	
	@Test
	public void criarUmCarrinhoDeComprasComUmLivro() {
		CarrinhoDeCompras carrinho = servico.adicionarLivroNoCarrinhoDoCliente(umIsbnValido, UM_CLIENTE);
		
		assertThat(carrinho.doCliente(UM_CLIENTE), is(true));
		assertThat(carrinho, contains(UM_LIVRO));
	}
	
	@Test
	public void adicionarLivroEmCarrinhoDeComprasExistente() {
		when(todosLivros.por(outroIsbnValido)).thenReturn(OUTRO_LIVRO);
		
		servico.adicionarLivroNoCarrinhoDoCliente(umIsbnValido, UM_CLIENTE);
		CarrinhoDeCompras carrinho = servico.adicionarLivroNoCarrinhoDoCliente(outroIsbnValido, UM_CLIENTE);
		
		assertThat(carrinho.doCliente(UM_CLIENTE), is(true));
		assertThat(carrinho, hasItems(UM_LIVRO, OUTRO_LIVRO));
	}
}