public abstract class Cliente {
 /* Classe abstrata "Cliente"
 * Variáveis de instância:
 - String nome
 - String endereco
 - String telefone
 - String email
 - int idade
 * Getters e setters para cada variável.
 
 * Construtor para a classe, que recebe String nome.
 */

	private String nome;
	private String telefone;
	private String endereco;
	private String email;
	private int idade;
	
	public Cliente(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public abstract String toString();
}
