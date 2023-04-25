import java.text.SimpleDateFormat;
import java.util.Date;

/* Classe "ClientePJ" herda de classe "Cliente"
 * Variáveis de instância:
 - (final) String cnpj
 - Date dataFundacao

 * Getters e setters para cada variável.

 * Construtor para a classe, recebendo cada uma das variaveis acima, mais as variáveis
 da superclasse (nome, endereco).
 
 * Métodos de classe:
 + boolean validarCNPJ(String cnpj): dada uma String cnpj, verifica se é válido por meio 
 do cálculo dos dois dígitos verificadores e da quantidade de dígitos numéricos. 
 Mais detalhes no método.
 
 * Métodos de instância:
 + @Override String toString(): retorna uma String com as variáveis de instância. A data 
 também é formatada usando a biblioteca java.text.SimpleDateFormat. 
 */


public class ClientePJ extends Cliente{
	private final String cnpj;
	private Date dataFundacao;
	
	public ClientePJ(String nome, String cnpj) {
		super(nome);
		this.cnpj = cnpj;
	}

	public Date getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public String getCnpj() {
		return cnpj;
	}

	
	public static boolean validarCNPJ(String cnpj) {
		String cnpjSoNum = cnpj.replaceAll("[^0-9]", ""); // Verifica se o CNPJ tem 14 dígitos numéricos.
		if (cnpjSoNum.length() != 14)					  // Se não, retorna false: CNPJ inválido.
			return false;									
		
		for (int i = 0; i < 14; i++) {
			char digAtual = cnpjSoNum.charAt(i);
    		if (i == 13)
    			return false; 							// Se chegar no último, retorna falso: CPF inválido.
    		char digProx = cnpjSoNum.charAt(i + 1);
    		if (digAtual != digProx) 					// Um número do CNPJ é sempre comparado com o dígito
    			break;				 					// subsequente. Caso forem iguais, a checagem continua.
    	}
		
		int primDigVer;									// Cálculo do primeiro dígito verificador	
		int soma = 0;
		for (int i = 0; i < 4; i++) {
			soma += (5 - i) * Character.getNumericValue(cnpjSoNum.charAt(i));
		}
		for (int i = 4; i < 12; i++) {
			soma += (13 - i) * Character.getNumericValue(cnpjSoNum.charAt(i));
		}
		int resto = soma % 11;
		if (resto == 0 || resto == 1)
			primDigVer = 0;
		else
			primDigVer = 11 - resto;
		if (primDigVer != Character.getNumericValue(cnpjSoNum.charAt(12))) // Se o dígito calculado é diferente do presente,
			return false;												   // retorna falso: CNPJ inválido.
		
		int segDigVer;													   // Cálculo do segundo dígito verificador.
		soma = 0;
		for (int i = 0; i < 5; i++) {
			soma += (6 - i) * Character.getNumericValue(cnpjSoNum.charAt(i));
		}
		for (int i = 5; i < 13; i++) {
			soma += (14 - i) * Character.getNumericValue(cnpjSoNum.charAt(i));
		}
		resto = soma % 11;
		if (resto == 0 || resto == 1)
			segDigVer = 0;
		else
			segDigVer = 11 - resto;
		
		if (segDigVer != Character.getNumericValue(cnpjSoNum.charAt(13)))  // Se o dígito calculado é diferente do presente,
			return false;												   // retorna false: CNPJ inválido.
		
		return true;													   // Se passar pelas verificações, o CNPJ é válido
	}
	
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		String str = "Nome da empresa: " + this.getNome() + "\n"
				   + "Endereco: " + this.getEndereco() + "\n"
				   + "CNPJ: " + this.getCnpj() + "\n"
				   + "Data de fundacao: " + (sdf.format(this.getDataFundacao())) + "\n";
		return str;
	}
	
}
	

