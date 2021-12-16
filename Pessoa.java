package control;

public class Pessoa {
	private String cpf, senha, nome, email, caminho, proximo,tipo;
	private String dataNasc;
	
	public Pessoa(String cpf, String senha, String nome, String email, String caminho, String proximo, String tipo,
			String dataNasc, String idade) {
		super();
		this.cpf = cpf;
		this.senha = senha;
		this.nome = nome;
		this.email = email;
		this.caminho = caminho;
		this.proximo = proximo;
		this.tipo = tipo;
		this.dataNasc = dataNasc;
	}
	public Pessoa() {
		super();
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCaminho() {
		return caminho;
	}
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	public String getProximo() {
		return proximo;
	}
	public void setProximo(String proximo) {
		this.proximo = proximo;
	}
	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
