package model;

public class Cliente extends Pessoa {
	protected String sobrenome;
	protected String email;
	protected String senha;
	protected String sexo;
	protected String cpf;
	protected String telefone;
	protected String cep;
	protected String cidade;
	
	public Cliente(int id_pessoa, String nome, String nascimento, String sobrenome, String email, String senha,
			String sexo, String cpf, String telefone, String cep, String cidade) {
		super(id_pessoa, nome, nascimento);
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
		this.sexo = sexo;
		this.cpf = cpf;
		this.telefone = telefone;
		this.cep = cep;
		this.cidade = cidade;
		fixNascimento(nascimento);
		fixSexo(sexo);
	}
	
	public Cliente(String nome, String nascimento, String sobrenome, String email, String senha,
			String sexo, String cpf, String telefone, String cep, String cidade) {
		super(nome, nascimento);
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
		this.sexo = sexo;
		this.cpf = cpf;
		this.telefone = telefone;
		this.cep = cep;
		this.cidade = cidade;
		fixNascimento(nascimento);
		fixSexo(sexo);
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	private void fixSexo(String sexo) {
		if (sexo.equals("Masculino")) {
			this.sexo = "M";
		} else if (sexo.equals("Feminino")) {
			this.sexo = "F";
		} else {
			System.out.println("Error");
		}
	}
	
}
