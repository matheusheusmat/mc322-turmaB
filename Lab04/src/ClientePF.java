import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* Classe "ClientePF" herda de classe "Cliente"
 * Variáveis de instância:
 - (final) String cpf
 - Date dataNascimento 
 - date dataLicenca
 - int idade
 - String educacao 
 - String genero 
 - String classeEconomica
 
 * Getters e setters para cada variável.
 
 * Construtor para a classe.
 
 * Métodos de classe:
 + public static ClientePF criarClientePF(Scanner input): instancia um ClientePF e recebe 
 as informações do usuário (nome, endereço, CPF, data de nascimento, gênero, idade, data
 de licença de motorista, educação e classe econômica). Ao final, retorna o ClientePF criado. 
 
 * Métodos de instância:
 + double calcularScore(): com base na idade do ClientePF cadastrado, busca um fator na classe
 enum CalcSeguro. Retorna seu "score" para calcular o seguro, dado pelo produto entre um fator
 base, fator de idade e quantidade de veiculos (listaVeiculos.size()). Retorna o double score.
 + @Override String toString: retorna uma string com as variáveis de instância. A data também é
 formatada usando a biblioteca java.text.SimpleDateFormat.
 */

public class ClientePF extends Cliente{
	private final String cpf;
	private String genero;
	private Date dataNascimento;
	private int idade;
	private Date dataLicenca;
	private String educacao;
	private String classeEconomica;
	
	
	public ClientePF(String nome, String cpf) {
		super(nome);
		this.cpf = cpf;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
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

	public String getClasseEconomica() {
		return classeEconomica;
	}

	public void setClasseEconomica(String classeEconomica) {
		this.classeEconomica = classeEconomica;
	}

	public String getCpf() {
		return cpf;
	}
	
	public static ClientePF criarClientePF(Scanner input) {
		
		
		System.out.print("Nome do Cliente: ");
		String inputAtual = input.nextLine();
		boolean apenasLetras = Validacao.apenasLetras(inputAtual);
		while (!apenasLetras) {
			System.out.println("Atencao! O nome deve conter apenas letras.");
			System.out.print("Insira novamente: ");
			inputAtual = input.nextLine();
			apenasLetras = Validacao.apenasLetras(inputAtual);
		}
		
		
		System.out.print("CPF do Cliente: ");
		String cpf = input.nextLine();
		boolean cpfValido = Validacao.validarCPF(cpf);
		while(!cpfValido) {
			System.out.print("CPF invalido! Insira novamente: ");
			cpf = input.nextLine();
			cpfValido = Validacao.validarCPF(cpf);
		}
		
		ClientePF cl = new ClientePF(inputAtual, cpf);
		
		System.out.println("Data de nascimento, na forma DD/MM/AAAA\n"
						   + "(exemplo, Nove de Março de 1999 - 09/03/1999):");
		inputAtual = input.nextLine();
		Date data = Validacao.formatarData(inputAtual, input);
		int idade = Validacao.calcularIdade(data);
		while (idade < 18) {
			System.out.println("Idade invalida! O cliente deve ser maior de 18 anos.");
			System.out.print("Insira novamente: ");
			inputAtual = input.nextLine();
			data = Validacao.formatarData(inputAtual, input);
			idade = Validacao.calcularIdade(data);
		}
		cl.setDataNascimento(data);
		cl.setIdade(idade);
		
		System.out.println("Data da licenca de motorista, na forma DD/MM/AAAA\n"
						   + "(exemplo, Vinte e oito de Julho de 2021 - 28/07/2021):");
		inputAtual = input.nextLine();
		data = Validacao.formatarData(inputAtual, input);
		cl.setDataLicenca(data);
		
		System.out.print("Endereco: ");
		inputAtual = input.nextLine();
		cl.setEndereco(inputAtual);
		
		System.out.print("Nivel de escolaridade: ");
		inputAtual = input.nextLine();
		cl.setEducacao(inputAtual);
		
		System.out.print("Genero: ");
		inputAtual = input.nextLine();
		cl.setGenero(inputAtual);
		
		System.out.print("Classe economica: ");
		inputAtual = input.nextLine();
		cl.setClasseEconomica(inputAtual);
		
		System.out.println("-- Cliente cadastrado com sucesso! --\n");
		
		return cl;
	}
	
	
	@Override
	public double calcularScore() {
		int idade = this.getIdade();
		double fatorIdade;
		
		if (idade >= 18 && idade < 30) {
			fatorIdade = CalcSeguro.FATOR_18_30.getFator();
		}
		else if (idade >= 30 && idade < 60) {
			fatorIdade = CalcSeguro.FATOR_30_60.getFator();
		}
		else {
			fatorIdade = CalcSeguro.FATOR_60_90.getFator();
		}
		
		double valorBase = CalcSeguro.VALOR_BASE.getFator();
		double qtdVeiculos = this.getListaVeiculos().size();
		
		double score = valorBase * fatorIdade * qtdVeiculos;
		return score;
	}
	
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String str = "Nome do cliente | " + this.getNome() + "\n" 
				   + "Endereco | " + this.getEndereco() + "\n"
				   + "CPF | " + this.getCpf() + "\n"
				   + "Data de nascimento | " + sdf.format(this.getDataNascimento()) + "\n"
				   + "Data da licenca de motorista | " + sdf.format(this.getDataLicenca()) + "\n"
				   + "Genero | " + this.getGenero() + "\n"
				   + "Nivel de escolaridade | " + this.getEducacao() + "\n"
				   + "Classe economica | " + this.getClasseEconomica();
		return str;
	}


	
}
