import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Scanner;

/* Classe "Validacao"
 * Métodos de classe:
 + static boolean ehInteiro(String str): retorna true caso for um valor inteiro, e false
 caso não. Isso é feito pelo tratamento de exceções.
 + static boolean apenasLetras(String str): retorna se uma String é formada apenas por letras
 e caracteres de espaço.
 + static boolean ehIntervaloValido(String str, int ini, int fim): retorna se uma String, que
 previamente deve ser um inteiro, está dentro de um intervalo [ini, fim).
 + static boolean validarCPF(String cpf): dada uma String cpf, verifica se é válido por meio 
 do cálculo dos dois dígitos verificadores e da quantidade de dígitos numéricos. 
 Mais detalhes no método.
 + static boolean validarCNPJ(String cnpj): dada uma String cnpj, verifica se é válido por meio 
 do cálculo dos dois dígitos verificadores e da quantidade de dígitos numéricos. 
 Mais detalhes no método.
 + static boolean validarData(String dataStr): verifica se a data dada na entrada é válida, 
 seguindo o modelo DD/MM/AAAA.
 + static Data formatarData(String dataStr, Scanner input): dada uma String, retorna uma data 
 formatada do modo desejado, se for possível.
 + static int calcularIdade(Date data): calcula a idade de um ClientePF, data sua data de nascimento
 e a data atual, calculando a diferença em anos.
 */




public class Validacao {
	
	public static boolean ehInteiro(String str) {
		try {
			Integer.parseInt(str);
			return true;
		}
		catch (Exception ex) {
			return false;
		}
	}
	
	public static boolean apenasLetras(String str) {
		return str.matches("[a-zA-Z ]+");
	}
	
	public static boolean ehIntervaloValido(String str, int ini, int fim) {
		int num = Integer.parseInt(str);
		if (num < ini || num > fim)
			return false;
		return true;
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

	
	public static boolean validarData(String dataStr) {
		String dataSoNum = dataStr.replaceAll("[^0-9]", "");
		if (dataStr.length() != 10 || dataSoNum.length() != 8 ||
		dataStr.charAt(2) != '/' || dataStr.charAt(5) != '/') {
			System.out.println("-- ERRO! Data invalida! Escreva novamente conforme o modelo: DD/MM/AAAA\n"
								   + "(exemplo, Nove de Março de 1999 - 09/03/1999): --");
			return false; 
		}
		return true;
	}
	
	
	public static Date formatarData(String dataStr, Scanner input) {
		boolean dataValida = validarData(dataStr);
		while (!dataValida) {
			dataStr = input.nextLine();
			dataValida = validarData(dataStr);
		}
		
		int dia = Integer.parseInt(dataStr.substring(0, 2));
		int mes = Integer.parseInt(dataStr.substring(3, 5));
		int ano = Integer.parseInt(dataStr.substring(6, 10));

		Date data = new Date(ano - 1900, mes - 1, dia);
		return data;
	}
	
	
	public static int calcularIdade(Date data) {
		LocalDate hoje = LocalDate.now();
		int diaNasc = data.getDate();
		int mesNasc = data.getMonth() + 1;
		int anoNasc = data.getYear() + 1900;
		LocalDate dataNasc = LocalDate.of(anoNasc, mesNasc, diaNasc);
		
		if (dataNasc.isAfter(hoje) || dataNasc.isEqual(hoje)) {
			return 0;
		}
		
		int idade = Period.between(dataNasc, hoje).getYears();
		return idade;
	}
	
	
}
