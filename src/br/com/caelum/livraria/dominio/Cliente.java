package br.com.caelum.livraria.dominio;

//Foi removido o parametro cep da classe Selecao de Livro e adicionado
//como atributo do cliente
public class Cliente {

	private final String id;
	private final String cep;
	private final Telefone telefone;
	
	public Cliente(String id, String cep, Telefone telefone) {
		this.id = id;
		this.cep = cep;
		this.telefone = telefone;
	}

	@Override
	public boolean equals(Object obj) {
		boolean iguais = false;
		if(obj instanceof Cliente) {
			Cliente outra = (Cliente) obj;
			iguais = id.equals(outra.id);
		}
		return iguais;
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}

	public String getCep() {
		return cep;
	}
	
	public String getCepFormatado() {
		return String.format("%05d-%03d", Long.valueOf(cep) / 1000, Long.valueOf(cep) % 1000);
	}
	
	public String getTelefone() {
		return telefone.toString();
	}
}
