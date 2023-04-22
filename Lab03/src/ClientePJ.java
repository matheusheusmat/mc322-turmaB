import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientePJ extends Cliente{
	private final String cnpj;
	private Date dataFundacao;
	
	public ClientePJ(String nome, String endereco,
			 		 String cnpj, Date dataFundacao) {
		super(nome, endereco);
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
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
	// 09/01/2003
	public static boolean validarCNPJ(String cnpj) {
		String cnpjSoNum = cnpj.replaceAll("[^0-9]", "");
		if (cnpjSoNum.length() != 14)
			return false;
		
		for (int i = 0; i < 14; i++) {
			char digAtual = cnpjSoNum.charAt(i);
    		if (i == 13)
    			return false; 							// Se chegar no último, retorna falso: CPF inválido.
    		char digProx = cnpjSoNum.charAt(i + 1);
    		if (digAtual != digProx) 					// Um número do CPF é sempre comparado com o dígito
    			break;				 					// subsequente. Caso forem iguais, a checagem continua.
    	}
		
		int primDigVer;
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
		if (primDigVer != Character.getNumericValue(cnpjSoNum.charAt(12)))
			return false;
		
		int segDigVer;
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
		
		if (segDigVer != Character.getNumericValue(cnpjSoNum.charAt(13)))
			return false;
		
		return true;
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
	

