import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* Classe "ClientePJ" herda de classe "Cliente"
 * Variáveis de instância: 
 - final String cnpj
 - Date dataFundacao
 - int qtdeFuncionarios
 
 * Getters e setters para cada variável.
 
 * Construtor para a classe.
 
 * Métodos de classe:
 + public static ClientePJ criarClientePJ(Scanner input): instancia um ClientePJ e recebe 
 as informações do usuário (nome, endereço, CNPJ e data de fundação). Ao final, retorna o 
 ClientePJ criado. 
 
 * Métodos de instância:
 + double calcularScore(): Retorna seu "score" para calcular o seguro, dado pelo produto 
 entre um fator base, a soma de 1 com a quantidade de funcionarios dividida por 100 e 
 quantidade de veiculos (listaVeiculos.size()). Retorna o double score.
 + @Override String toString: retorna uma string com as variáveis de instância. A data 
 também é formatada usando a biblioteca java.text.SimpleDateFormat.
 */

public class ClientePJ extends Cliente {
	private final String cnpj;
	private Date dataFundacao;
	private int qtdeFuncionarios;
	
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

	public int getQtdeFuncionarios() {
		return qtdeFuncionarios;
	}

	public void setQtdeFuncionarios(int qtdeFuncionarios) {
		this.qtdeFuncionarios = qtdeFuncionarios;
	}

	public String getCnpj() {
		return cnpj;
	}
	
	public static ClientePJ criarClientePJ(Scanner input) {
		System.out.print("Nome da Empresa: ");
		String inputAtual = input.nextLine();
		
		System.out.print("CNPJ da Empresa: ");
		String cnpj = input.nextLine();
		boolean cnpjValido = Validacao.validarCNPJ(cnpj);
		while (!cnpjValido) {
			System.out.print("CNPJ invalido! Insira novamente: ");
			cnpj = input.nextLine();
			cnpjValido = Validacao.validarCNPJ(cnpj);
		}
		
		ClientePJ cl = new ClientePJ(inputAtual, cnpj);
		
		System.out.print("Endereco: ");
		inputAtual = input.nextLine();
		cl.setEndereco(inputAtual);
		
		System.out.println("Data de fundacao da empresa, na forma DD/MM/AAAA\n"
						 + "(exemplo, 01 de Agosto de 2011 - 01/08/2011):");
		
		inputAtual = input.nextLine();
		
		Date data = Validacao.formatarData(inputAtual, input);
		cl.setDataFundacao(data);
		
		System.out.print("Quantidade de funcionarios: ");
		inputAtual = input.nextLine();
		boolean ehInteiro = Validacao.ehInteiro(inputAtual);
		while (!ehInteiro || Integer.parseInt(inputAtual) <= 0) {
			System.out.print("-- ERRO! Insira um numero valido: ");
			inputAtual = input.nextLine();
			ehInteiro = Validacao.ehInteiro(inputAtual);
		}
		cl.setQtdeFuncionarios(Integer.parseInt(inputAtual));
		
		System.out.println("-- Empresa cadastrada com sucesso! --\n");
		return cl;
	}
	
	@Override
	public double calcularScore() {
		double valorBase = CalcSeguro.VALOR_BASE.getFator();
		double doubleqtdFunc = qtdeFuncionarios;
		double qtdVeiculos = this.getListaVeiculos().size();
		double score = valorBase * (1 + (doubleqtdFunc) / 100) * qtdVeiculos;
		return score;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		String str = "Nome da empresa | " + this.getNome() + "\n"
				   + "Endereco | " + this.getEndereco() + "\n"
				   + "CNPJ | " + this.getCnpj() + "\n"
				   + "Data de fundacao | " + (sdf.format(this.getDataFundacao())) + "\n"
				   + "Quantidade de funcionarios | " + this.getQtdeFuncionarios();
		return str;
	}
	
}
