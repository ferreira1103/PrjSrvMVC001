package br.com.teste.model;

public class Estudante {

	int Codigo;
	String Nome;
	String Cidade;
	String Telefone;
	
	public Estudante() {
		super();
		
		Codigo = 0;
		Nome = " ";
		Cidade = " ";
		Telefone = " ";
	}

	public Estudante(int codigo, String nome, String cidade, String telefone) {
		super();
		
		Codigo = codigo;
		Nome = nome;
		Cidade = cidade;
		Telefone = telefone;
	}

	public int getCodigo() {
		return Codigo;
	}
	public void setCodigo(int codigo) {
		Codigo = codigo;
	}

	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCidade() {
		return Cidade;
	}
	public void setCidade(String cidade) {
		Cidade = cidade;
	}

	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	
	@Override
	public String toString() {
		return "Estudante [Codigo=" + Codigo + ", Nome=" + Nome + ", Cidade=" + Cidade + ", Telefone=" + Telefone
				+ ", getCodigo()=" + getCodigo() + ", getNome()=" + getNome() + ", getCidade()=" + getCidade()
				+ ", getTelefone()=" + getTelefone() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
