import java.util.Date;
import java.text.SimpleDateFormat;

/* Classe "ClientePF" herda de classe "Cliente"
 * Variáveis de instância: 
 - (final) String cpf
 - Date dataNascimento 
 - date dataLicenca
 - String educacao 
 - String genero 
 - String classeEconomica
 
 * Getters e setters para cada variável.
 
 * Construtor para a classe, recebendo cada uma das variáveis acima, mais as variáveis
 da superclasse (nome, endereco).
 
 * Métodos de classe:
 + boolean validarCPF(String cpf): dada uma String cpf, verifica se é válido por meio 
 do cálculo dos dois dígitos verificadores e da quantidade de dígitos numéricos. 
 Mais detalhes no método.
 
 * Métodos de instância:
 + toString (override): retorna uma string com as variáveis de instância. A data também é
 formatada usando a biblioteca java.text.SimpleDateFormat.
 */

public class ClientePF extends Cliente {
	private final String cpf;
	private Date dataNascimento;
	private Date dataLicenca;
	private String educacao;
	private String genero;
	private String classeEconomica;
	
	public ClientePF(String nome, String cpf) {
		super(nome);
		this.cpf = cpf;
	}
	

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataLicenca() {
		return dataLicenca;
	}

	public void setDataLicenca(Date dataLicenca) {
		this.dataLicenca = dataLicenca;
	}

	public String getEducacao() {
		return educacao;
	}

	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getClasseEconomica() {
		return classeEconomica;
	}

	public void setClasseEconomica(String classeEconomica) {
		this.classeEconomica = classeEconomica;
	}

	public String getCpf() {
		return cpf;
	}	
	
	
	public static boolean validarCPF(String cpf) {
	   	String cpfSoNum = cpf.replaceAll("[^0-9]", ""); // Verificar se tem 11 dígitos numéricos.
	    if (cpfSoNum.length() != 11) 					// Se não, retorna falso: CPF inválido.
	    	return false;
	    	
	    for (int i = 0; i < 11; i++) { 					// Verifica se os dígitos são todos iguais.
	    	char digAtual = cpfSoNum.charAt(i);
	    	if (i == 10)
	    		return false; 							// Se chegar no último, retorna falso: CPF inválido.
	    	char digProx = cpfSoNum.charAt(i + 1);
	    	if (digAtual != digProx) 					// Um número do CPF é sempre comparado com o dígito
	    		break;				 					// subsequente. Caso forem iguais, a checagem continua.
	    }
	    	
	    int primDigVer;
	    int soma = 0; 									// Cálculo de primeiro dígito verificador.
	    for (int i = 0; i < 9; i++) {
	    	soma += (10 - i) * Character.getNumericValue(cpfSoNum.charAt(i));
	    }
	    int resto = soma % 11;
	    if (resto == 0 || resto == 1) {
	    	primDigVer = 0;
	    }
	    else
	    	primDigVer = 11 - resto;
	    if (primDigVer != Character.getNumericValue(cpfSoNum.charAt(9)))
	    	return false;								// Se o dígito calculado é diferente do presente, retorna
	    												// falso: CPF inválido.
	    int segDigVer;									// Cálculo de segundo dígito verificador.
	    soma = 0; 										
	    for (int i = 0; i < 10; i++) {
	    	soma += (11 - i) * Character.getNumericValue(cpfSoNum.charAt(i));
	    }
	    resto = soma % 11;
	    if (resto == 0 || resto == 1) {
	    	segDigVer = 0;
	    }
	    else
	    	segDigVer = 11 - resto;
	    if (segDigVer != Character.getNumericValue(cpfSoNum.charAt(10)))
	    	return false;								// Se o dígito calculado é diferente do presente, retorna
	    												// falso: CPF inválido.
	    return true; 									// Se passar pelas verificações, o CPF é válido.
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		String str = "Nome do cliente: " + this.getNome() + "\n" 
				   + "Endereco: " + this.getEndereco() + "\n"
				   + "CPF: " + this.getCpf() + "\n"
				   + "Data de nascimento: " + sdf.format(this.getDataNascimento()) + "\n"
				   + "Data da licenca de motorista: " + sdf.format(this.getDataLicenca()) + "\n"
				   + "Genero: " + this.getGenero() + "\n"
				   + "Nivel de escolaridade: " + this.getEducacao() + "\n"
				   + "Classe economica: " + this.getClasseEconomica() + "\n";
		return str;
	}
	
}
