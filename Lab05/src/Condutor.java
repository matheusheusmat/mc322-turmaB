import java.util.ArrayList;
import java.util.Date;

public class Condutor {
/* Classe "Condutor"

 * Variáveis de instância:
 - String nome
 - (final) String cpf
 - Date dataNascimento
 - int idade
 - String telefone
 - String endereco
 - String email
 - ArrayList<Sinistro> listaSinistros
 
 * Getters e setters para cada variável.
 
 * Construtor para a classe.
	 
 * Métodos de classe:
 + public String toString(): Retorna uma String com alguns dos atributos de instância.
	
 */

	private String nome;
	private final String cpf;
	private Date dataNascimento;
	private int idade;
	private String telefone;
	private String endereco;
	private String email;
	private ArrayList<Sinistro> listaSinistros;
	
	public Condutor(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		this.listaSinistros = new ArrayList<Sinistro>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	public ArrayList<Sinistro> getListaSinistros() {
		return listaSinistros;
	}

	public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
		this.listaSinistros = listaSinistros;
	}

	public String getCpf() {
		return cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	@Override
	public String toString() {
		String str = "Nome     | " + nome + "\n"
				   + "CPF      | " + cpf + "\n"
				   + "Idade    | " + idade + "\n"
				   + "Telefone | " + telefone + "\n"
				   + "E-mail   | " + email + "\n"
				   + "Endereco | " + endereco;
		return str;
	}
}
