import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ClientePJ extends Cliente {
 /* Classe "ClientePJ" herda de classe "Cliente"
 * Variáveis de instância:
 - (final) String cnpj
 - Date dataFundacao
 - int qtdFuncionarios
 - ArrayList<Frota> listaFrotas
 
 * Getters e setters para cada variável.
 
 * Construtor para a classe, que recebe nome e cnpj.
 
 * Métodos da classe:
 + public static ClientePF criarClientePJ(Scanner input): instancia um ClientePJ e recebe 
 as informações do usuário (nome, endereço, CNPJ, data de fundação, idade, quantidade de
 funcionários, e-mail, telefone). Ao final, retorna o ClientePJ criado. 
	  
 + public boolean cadastrarFrota(Scanner input): instancia e adiciona uma Frota na 
 listaFrotas de um ClientePJ.
 
 + public boolean atualizarFrota(Scanner input): adiciona ou remove um Veiculo de uma Frota,
 chamando, para isso, os métodos adicionarVeiculo e removerVeiculo da classe Frota.
 
 + public boolean getVeiculosPorFrota(Scanner input): imprime todos os veículos de uma Frota, 
 caso haja frotas e tenha veículos nela.
 
 + public boolean removerFrota(Scanner input, Seguradora seg): imprime e remove uma Frota
 da listaFrotas. Também remove um Seguro associado a ela, caso exista.
 
 - private boolean temSeguroERemove(Seguradora seg, Veiculo veic, Boolean remover): procura
 uma Frota na listaSeguros de uma Seguradora. Retorna true, caso encontre. Se remover == true, 
 e a encontrar, a remove da lista.
 
 + public boolean cadastrarSeguroPJ(Scanner input, Seguradora seg): cadastra um Seguro, caso
 o ClientePJ possua Frotas. Realiza a verificacao se a Frota já é ou não segurada, ou seja,
 possui um Seguro associado a ela.

 + public String toString(): Retorna uma String com alguns dos atributos de instância. 
 */

	private final String cnpj;
	private Date dataFundacao;
	private int qtdFuncionarios;
	private ArrayList<Frota> listaFrotas;
	
	public ClientePJ(String nome, String cnpj) {
		super(nome);
		this.cnpj = cnpj;
		this.listaFrotas = new ArrayList<Frota>();
	}

	public Date getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public ArrayList<Frota> getListaFrota() {
		return listaFrotas;
	}

	public void setListaFrota(ArrayList<Frota> listaFrota) {
		this.listaFrotas = listaFrota;
	}

	public String getCnpj() {
		return cnpj;
	}
	
	public int getQtdFuncionarios() {
		return qtdFuncionarios;
	}

	public void setQtdFuncionarios(int qtdFuncionarios) {
		this.qtdFuncionarios = qtdFuncionarios;
	}

	public static ClientePJ criarClientePJ(Scanner input) {
		System.out.println("\n** CADASTRO DE PESSOA JURIDICA **");
		
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
		
		System.out.println("Data de fundacao da empresa, na forma DD/MM/AAAA\n"
						 + "(exemplo, 01 de Agosto de 2011 - 01/08/2011):");
		
		inputAtual = input.nextLine();
		
		Date data = Validacao.formatarData(inputAtual, input);
		cl.setDataFundacao(data);
		
		int idade = Validacao.calcularIdade(data);
		cl.setIdade(idade);
		
		System.out.print("Endereco: ");
		inputAtual = input.nextLine();
		cl.setEndereco(inputAtual);
		
		System.out.print("Telefone: ");
		inputAtual = input.nextLine();
		cl.setTelefone(inputAtual);
		
		System.out.print("E-mail: ");
		inputAtual = input.nextLine();
		cl.setEmail(inputAtual);
		
		System.out.print("Quantidade de funcionarios: ");
		inputAtual = input.nextLine();
		boolean ehInteiro = Validacao.ehInteiro(inputAtual);
		while (!ehInteiro || Integer.parseInt(inputAtual) <= 0) {
			System.out.print("-- ERRO! Insira um numero valido: ");
			inputAtual = input.nextLine();
			ehInteiro = Validacao.ehInteiro(inputAtual);
		}
		cl.setQtdFuncionarios(Integer.parseInt(inputAtual));
		System.out.println("-- Empresa cadastrada com sucesso! --\n");
		return cl;
	}
	
	public boolean cadastrarFrota() {
		Frota fr = new Frota();
		listaFrotas.add(fr);
		System.out.println("-- Frota cadastrada com sucesso! --");
		System.out.println("-- O código da nova frota é: " + fr.getCode() + " --\n");
		return true;
	}
	
	public boolean atualizarFrota(Scanner input) {
		System.out.println("** ATUALIZAR FROTA **");
		if (listaFrotas.isEmpty()) {
			System.out.println("-- ERRO! Nenhuma Frota foi cadastrada para esse Cliente PJ. --");
			return false;
		}
			
		Validacao.listarTodos(listaFrotas, "FROTA");
		System.out.println("-- Digite o numero correspondente a Frota que deseja atualizar");
		System.out.println("e tecle ENTER, ou \"0\" para cancelar a operacao. --");
		String inputAtual = input.nextLine();
		
		if (inputAtual.equals("0"))
			return false;
		
		while (!Validacao.ehInteiro(inputAtual) || !Validacao.ehIntervaloValido(inputAtual, 1, listaFrotas.size())) {
			 System.out.println("-- ERRO! Numero invalido. Selecione algum da lista apresentada");
			 System.out.println("ou \"0\" para cancelar a operacao. --");
			 inputAtual = input.nextLine();
			 System.out.println("");
			 if (inputAtual.equals("0"))
				 return false;
		}
		
		Frota fr = listaFrotas.get(Integer.parseInt(inputAtual) - 1);
		
		System.out.println("Quer adicionar um Veiculo ou Remover um Veiculo?");
		System.out.println("1 | Adicionar veiculo\n"
				 		 + "2 | Remover veiculo");
		inputAtual = input.nextLine();
		
		if (inputAtual.equals("1")) {
			fr.adicionarVeiculo(input);
			return true;
		}
		
		if (inputAtual.equals("2")) {
			if (fr.getListaVeiculos().isEmpty()) {
				System.out.println("-- ERRO! A Frota nao possui Veiculos cadastrados! --\n");
				return false;
			}
			return fr.removerVeiculo(input);
		}
		
		System.out.println("-- ERRO! Operacao invalida --");
		return false;
	}
	
	public boolean getVeiculosPorFrota(Scanner input) {
		System.out.println("** IMPRIMIR VEICULOS DE UMA FROTA **");
		
		if (listaFrotas.isEmpty()) {
			System.out.println("-- ERRO! Nenhuma Frota foi cadastrada para esse Cliente PJ. --");
			return false;
		}
		
		Validacao.listarTodos(listaFrotas, "FROTA");
		System.out.println("-- Digite o numero correspondente a Frota que deseja visualizar");
		System.out.println("e tecle ENTER, ou \"0\" para cancelar a operacao. --");
		String inputAtual = input.nextLine();
		
		if (inputAtual.equals("0"))
			return false;
		
		while (!Validacao.ehInteiro(inputAtual) || !Validacao.ehIntervaloValido(inputAtual, 1, listaFrotas.size())) {
			 System.out.println("-- ERRO! Numero invalido. Selecione algum da lista apresentada");
			 System.out.println("ou \"0\" para cancelar a operacao. --");
			 inputAtual = input.nextLine();
			 System.out.println("");
			 if (inputAtual.equals("0"))
				 return false;
		}
		
		Frota fr = listaFrotas.get(Integer.parseInt(inputAtual) - 1);
		
		if (fr.getListaVeiculos().isEmpty()) {
			System.out.println("-- ERRO! A Frota selecionada nao possui veiculos cadastrados. --\n");
			return false;
		}
		
		Validacao.listarTodos(fr.getListaVeiculos(), "VEICULO");
		return true;
	}
	
	public boolean removerFrota(Scanner input, Seguradora seg) {
		System.out.println("** REMOVER FROTA **");
		if (listaFrotas.isEmpty()) {
			System.out.println("-- ERRO! Nenhuma Frota foi cadastrada para esse Cliente PJ. --\n");
			return false;
		}
		
		Validacao.listarTodos(listaFrotas, "FROTA");
		System.out.println("-- Digite o numero correspondente a Frota que deseja remover");
		System.out.println("e tecle ENTER, ou \"0\" para cancelar a operacao. --");
		String inputAtual = input.nextLine();
		
		if (inputAtual.equals("0"))
			return false;
		
		while (!Validacao.ehInteiro(inputAtual) || !Validacao.ehIntervaloValido(inputAtual, 1, listaFrotas.size())) {
			 System.out.println("-- ERRO! Numero invalido. Selecione algum da lista apresentada");
			 System.out.println("ou \"0\" para cancelar a operacao. --");
			 inputAtual = input.nextLine();
			 System.out.println("");
			 if (inputAtual.equals("0"))
				 return false;
		}
		
		Frota fr = listaFrotas.get(Integer.parseInt(inputAtual) - 1);
		temSeguroERemove(seg, fr, true);
		return listaFrotas.remove(fr);
	}
	
	private boolean temSeguroERemove(Seguradora seg, Frota fr, Boolean remover) {
		SeguroPJ seguroPJ = null;
		boolean encontrou = false;
		if ((seg.getListaSeguros()).isEmpty())
			return encontrou;
		
		for (Seguro seguro : seg.getListaSeguros()) {
			if (seguro.getClass().equals(SeguroPJ.class)) {
				seguroPJ = (SeguroPJ)seguro;
				if (seguroPJ.getFrota() == fr) {
					encontrou = true;
					break;
				}
			}
		}
		
		if (encontrou && remover) {
			seg.getListaSeguros().remove(seguroPJ);
		}
		
		return encontrou;
	}
	
	public boolean cadastrarSeguroPJ(Scanner input, Seguradora seg) {
		if (listaFrotas.isEmpty()) {
			System.out.println("-- ERRO! Nenhuma Frota cadastrada para esse Cliente! --\n");
			return false;
		}
		
		Validacao.listarTodos(listaFrotas, "FROTA");
		System.out.println("-- Digite o numero correspondente a Frota para a qual deseja");
		System.out.println("cadastrar Seguro e tecle ENTER, ou \"0\" para cancelar a operacao. --");
		String inputAtual = input.nextLine();
		
		if (inputAtual.equals("0"))
			return false;
		
		while (!Validacao.ehInteiro(inputAtual) || !Validacao.ehIntervaloValido(inputAtual, 1, listaFrotas.size())) {
			 System.out.println("-- ERRO! Numero invalido. Selecione algum da lista apresentada");
			 System.out.println("ou \"0\" para cancelar a operacao. --");
			 inputAtual = input.nextLine();
			 System.out.println("");
			 if (inputAtual.equals("0"))
				 return false;
		}
		
		Frota fr = listaFrotas.get(Integer.parseInt(inputAtual) - 1);
		
		if (temSeguroERemove(seg, fr, false)) {
			System.out.println("-- ATENCAO! Esta Frota ja possui Seguro! --");
			return false;
		}
		
		SeguroPJ seguroPJ = SeguroPJ.criarSeguroPJ(input, this, fr, seg);
		seg.adicionarSeguro(seguroPJ);
		return true;
	}
	
	@Override
	public String toString() {
		String str = "Nome da Empresa       | " + this.getNome() + "\n"
				   + "CNPJ                  | " + cnpj + "\n"
			       + "Telefone              | " + this.getTelefone() + "\n"
				   + "E-mail                | " + this.getEmail() + "\n"
				   + "Endereco              | " + this.getEndereco() + "\n"
				   + "Qtd. de Funcionarios  | " + this.getQtdFuncionarios() + "\n"
				   + "Anos desde a fundacao | " + this.getIdade() + " anos";
		return str;
	}
}
