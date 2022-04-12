package br.com.caelum.livraria.dominio;

import org.javamoney.moneta.Money;

public class CalculadoraDeCompra {
	//	public Money calcularValorTotal(Money subtotal, Money valorDoFrete, Desconto desconto) {
	//		if(subtotal.isZero()) return subtotal;
	//		subtotal = subtotal.subtract(desconto.getValor());
	//		subtotal = subtotal.add(valorDoFrete);
	//		return subtotal;
	//	}

	//===============================================================================
	// Método refatorado Remover atribuições a parametros
	//Criar uma varíavel valorTotal para receber o conteúdo do parametro e realizar as operações;
	//===============================================================================
	public Money calcularValorTotal(Money subtotal, Money valorDoFrete, Desconto desconto) {
		Money valorTotal = subtotal;
		if(valorTotal.isZero()) return valorTotal;
		valorTotal = valorTotal.subtract(desconto.getValor());
		valorTotal = valorTotal.add(valorDoFrete);
		return valorTotal;
	}
}
