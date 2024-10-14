package model;
public class Pessoa {
	protected int id_pessoa;
	protected String nome;
	protected String sobrenome;
	protected String email;
	protected String sexo;
	protected String cpf;
	protected String telefone;
	protected String nascimento;
	protected String senha;
	protected String CEP;
	protected String cidade;
	
	public Pessoa(int id_pessoa, String nome, String sobrenome, String email, String sexo, String cpf, String telefone,
			String nascimento, String senha, String cep, String cidade) {
		this.id_pessoa = id_pessoa;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.sexo = sexo;
		this.cpf = cpf;
		this.telefone = telefone;
		this.nascimento = nascimento;
		this.senha = senha;
		this.CEP = cep;
		this.cidade = cidade;
	}
	
	public Pessoa() {
		
	}

	public int getId_pessoa() {
		return id_pessoa;
	}

	public void setId_pessoa(int id_pessoa) {
		this.id_pessoa = id_pessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	
	
	
}
