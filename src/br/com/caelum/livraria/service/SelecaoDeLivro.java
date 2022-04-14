package br.com.caelum.livraria.service;

import br.com.caelum.livraria.dominio.*;
import org.javamoney.moneta.Money;

public class SelecaoDeLivro {

    private final TodosLivros todosLivros;
    private final CarrinhoDeComprasFactory factory;
    private final CalculadoraFrete calculadoraFrete;


    //==========================================================
    //Código Antigo
    //==========================================================
    //	private final Set<CarrinhoDeCompras> carrinhos;
    //
    //	public SelecaoDeLivro(TodosLivros todosLivros, CalculadoraFrete calculadoraFrete) {
    //		this.todosLivros = todosLivros;
    //		this.calculadoraFrete = calculadoraFrete;
    //		this.carrinhos = new HashSet<>();
    //	}
    //
    //	public CarrinhoDeCompras adionarLivroNoCarrinhoDoCliente(ISBN isbn, Cliente cliente, String cep){
    //		Livro livro = todosLivros.por(isbn);
    //		Money valorFrete = calculadoraFrete.baseadoEm(cep);
    //
    //		CarrinhoDeCompras carrinho = new CarrinhoDeCompras(cliente, livro,valorFrete, now());
    //		if (carrinhos.contains(carrinho)) {
    //			carrinho = carrinhos.stream()
    //					.filter(umCarrinho -> umCarrinho.doCliente(cliente))
    //					.findFirst()
    //					.orElse(null);
    //			if (carrinho != null) carrinho.getLivros().adicionar(livro);
    //		}
    //		else carrinhos.add(carrinho);
    //		return carrinho;
    //	}

	//==================================================================
	//Código Refatorado
	//==================================================================
    public SelecaoDeLivro(TodosLivros todosLivros, CalculadoraFrete calculadoraFrete, CarrinhoDeComprasFactory factory) {
        this.todosLivros = todosLivros;
        this.calculadoraFrete = calculadoraFrete;
        this.factory = factory;
    }

    //===================================================================
    //Foi extraído o código que tinha como função obter o carrinho de compra
    //para adicionar um livro (Vamos criar uma classe para cuidar dessa responsabilidade
    // CarrinhoDeComprasFactory.java
    //===================================================================
    public CarrinhoDeCompras adicionarLivroNoCarrinhoDoCliente(ISBN isbn, Cliente cliente) {
        Livro livro = todosLivros.por(isbn);
        Money valorFrete = calculadoraFrete.baseadoEm(cliente.getCep());
        return factory.obterCarrinho(cliente, livro, valorFrete);
    }
}
