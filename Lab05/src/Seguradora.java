import java.util.ArrayList;
import java.util.Scanner;

public class Seguradora {

/* Classe "Seguradora"
 * Variáveis de classe
 - static ArrayList<Seguradora> listaSeguradoras
 
 * Variáveis de instância
 - String nome
 - (final) String cnpj
 - String telefone
 - String email
 - String endereco
 - ArrayList<Sinistro> listaSinistros
 - ArrayList<Cliente> listaClientes
 
 * Getters e setters para cada variável.
 
 * Construtor para a classe.
 
 * Métodos da classe:
 + public static void cadastrarSeguradora(Scanner input): instancia e adiciona uma Seguradora
 na listaSeguradoras.
 
 + public static Seguradora trocarSeguradora(Scanner input): imprime todas as Seguradoras
 adicionadas na listaSeguradoras, pede ao usuário escolher e a retorna.
 
 + public boolean cadastrarCliente(Cliente cliente): dado um Cliente, o adiciona na listaClientes
 da Seguradora.
 
 + public ArrayList<Cliente> listarClientes(String tipo): dado um tipo de Cliente, retorna
 uma ArrayList com todos os clientes do tipo especificado, se houver na listaClientes.  
 
 + public boolean atualizarVeiculoPF(Scanner input): atualiza a listaVeiculos de um ClientePF,
 adicionando ou removendo veiculos, chamando os métodos específicos na classe ClientePF.
 
 + public boolean cadastrarSeguro(Scanner input): cadastra um Seguro para um Cliente, dado
 seu tipo. Imprime todos os Clientes daquele tipo, e, escolhido um, cadastra um Seguro do
 tipo correto (SeguroPF ou SeguroPJ).
 
 + public void adicionarSeguro(Seguro seguro): adiciona um Seguro na listaSeguros.
 
 + public void listarTodosSeguros(): lista todos os Seguros da listaSeguros.
 
 + public ArrayList<Seguro> listarSegurosPorCliente(Scanner input, String modo): pede um tipo
 de Cliente, imprime a lista de Clientes com o tipo. O usuário escolhe o Cliente desejado.
 Dado esse cliente, imprime todos os Seguros associados a ele.
 
 + public ArrayList<Sinistro> listarSinistrosPorCliente(Scanner input): pede um tipo
 de Cliente, imprime a lista de Clientes com o tipo. O usuário escolhe o Cliente desejado.
 Dado esse cliente, imprime todos os Sinistros associados a Seguros que, por sua vez, estão
 associados a esse Cliente.
 
 + public boolean cancelarSeguro(Scanner input, Seguro seguro): cancela um Seguro, removendo-o
 da listaSeguros.
 
 + private void removerSegurosDeCliente(Cliente cl): dado um Cliente a ser excluído da
 listaClientes da Seguradora, remove todos os Seguros associados a ele.
 
 + public boolean excluirCliente(Scanner input): exclui um Cliente da listaClientes da
 Seguradora. Também remove todos os Seguros associados a ele, caso existam.
 
 + public void calcularReceita(): calcula o valorMensal de cada um dos Seguros presentes
 na listaSeguros, somando-os. A soma é a chamada "receita" da Seguradora, que é impressa.

 + public String toString(): Retorna uma String com alguns dos atributos de instância.
 */
	
	private String nome;
	private final String cnpj;
	private String telefone;
	private String email;
	private String endereco;
	private ArrayList<Cliente> listaClientes;
	private ArrayList<Seguro> listaSeguros;
	private static ArrayList<Seguradora> listaSeguradoras = new ArrayList<Seguradora>();

	public Seguradora(String nome, String cnpj) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.listaClientes = new ArrayList<Cliente>();
		this.listaSeguros = new ArrayList<Seguro>();
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}


	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}


	public ArrayList<Seguro> getListaSeguros() {
		return listaSeguros;
	}


	public void setListaSeguros(ArrayList<Seguro> listaSeguros) {
		this.listaSeguros = listaSeguros;
	}


	public static ArrayList<Seguradora> getListaSeguradoras() {
		return listaSeguradoras;
	}


	public static void setListaSeguradoras(ArrayList<Seguradora> listaSeguradoras) {
		Seguradora.listaSeguradoras = listaSeguradoras;
	}


	public String getCnpj() {
		return cnpj;
	}
	
	public static void cadastrarSeguradora(Scanner input) {
		System.out.println("\n** CADASTRO DE SEGURADORA **");
		
		System.out.print("Nome da Seguradora: ");
		String inputAtual = input.nextLine();
		
		System.out.print("CNPJ da Seguradora: ");
		String cnpj = input.nextLine();
		boolean cnpjValido = Validacao.validarCNPJ(cnpj);
		while (!cnpjValido) {
			System.out.print("CNPJ invalido! Insira novamente: ");
			cnpj = input.nextLine();
			cnpjValido = Validacao.validarCNPJ(cnpj);
		}
		
		Seguradora seg = new Seguradora(inputAtual, cnpj);
		
		System.out.print("Telefone: ");
		inputAtual = input.nextLine();
		seg.setTelefone(inputAtual);
		
		System.out.print("E-mail: ");
		inputAtual = input.nextLine();
		seg.setEmail(inputAtual);
		
		System.out.print("Endereco: ");
		inputAtual = input.nextLine();
		seg.setEndereco(inputAtual);
		
		listaSeguradoras.add(seg);
		System.out.println("-- Seguradora criada com sucesso! --\n");
	}
	
	public static Seguradora trocarSeguradora(Scanner input) {
		System.out.println("\n** TROCANDO SEGURADORA **");
		System.out.println("-- Deseja mudar para qual Seguradora?\nEscolha abaixo um número e tecle ENTER --\n");
		Validacao.listarTodos(listaSeguradoras, "Seguradora");
		
		String inputAtual = input.nextLine();
		boolean ehInteiro = Validacao.ehInteiro(inputAtual);
		boolean ehIntervaloValido = Validacao.ehIntervaloValido(inputAtual, 1, listaSeguradoras.size());
		
		while(!ehInteiro && !ehIntervaloValido) {
			System.out.println("-- ERRO! Seguradora invalida."
					+ "\nDigite o numero correto conforme a lista apresentada: ");
			inputAtual = input.nextLine();
			ehInteiro = Validacao.ehInteiro(inputAtual);
			ehIntervaloValido = Validacao.ehIntervaloValido(inputAtual, 1, listaSeguradoras.size());
		}
		
		Seguradora seg = listaSeguradoras.get(Integer.parseInt(inputAtual) - 1);
		System.out.println("-- Trocando para: " + seg.getNome() + "... --\n");
		return seg;
	}
	
	public boolean cadastrarCliente(Cliente cliente) {
		listaClientes.add(cliente);
		return true;
	}
	
	public ArrayList<Cliente> listarClientes(String tipo) {
		ArrayList<Cliente> listaClientesTipo = new ArrayList<Cliente>();
		
		int contador = 0;
		
		if (listaClientes.isEmpty())
			return listaClientesTipo;
		
		switch (tipo) {
		case "1":
			for (Cliente c : listaClientes) {
				if ((c.getClass()).equals(ClientePF.class)) {
					contador++;
					System.out.println("-- CLIENTE PF " + contador + " --\n" + c.toString() + "\n");
					listaClientesTipo.add(c);
				}
			}
			return listaClientesTipo;
		case "2":
			for (Cliente c : listaClientes) {
				if ((c.getClass()).equals(ClientePJ.class)) {
					contador++;
					System.out.println("-- CLIENTE PJ " + contador + " --\n" + c.toString() + "\n");
					listaClientesTipo.add(c);
				}
			}
			return listaClientesTipo;
		default:
			System.out.println("-- ERRO: Opcao invalida! --");
			return null;
		}
	}
	
	
	public boolean atualizarVeiculoPF(Scanner input) {
		System.out.println("** CADASTRO/EXCLUSAO DE VEICULO - CLIENTE PF **");
		ArrayList<Cliente> listaClientesPF = listarClientes("1");
		
		if (listaClientesPF == null) {
			return false;
		}
		
		if (listaClientesPF.isEmpty()) {
			System.out.println("-- ERRO! Nenhum Cliente PF foi cadastrado nessa Seguradora! --\n");
			return false;
		}
		
		
		System.out.println("-- Digite o numero correspondente ao Cliente para o qual");
		System.out.println("deseja adicionar ou remover veiculo na lista apresentada acima e tecle ENTER,");
		System.out.println("ou \"0\" para cancelar a operacao. --");
		String inputAtual = input.nextLine();
		
		if (inputAtual.equals("0"))
			return false;
		
		while (!Validacao.ehInteiro(inputAtual) || !Validacao.ehIntervaloValido(inputAtual, 1, listaClientesPF.size())) {
			 System.out.println("-- ERRO! Numero invalido. Selecione algum da lista apresentada");
			 System.out.println("ou \"0\" para cancelar a operacao. --");
			 inputAtual = input.nextLine();
			 System.out.println("");
			 if (inputAtual.equals("0"))
				 return false;
		}
		
		Cliente cl = listaClientesPF.get(Integer.parseInt(inputAtual) - 1);
		System.out.println("** CLIENTE: " + cl.getNome() + " **");
		ClientePF clpf = (ClientePF)cl;
		
		System.out.println("-- Deseja adicionar ou remover um Veiculo? --");
		System.out.println("1 | Adicionar novo Veiculo");
		System.out.println("2 | Remover um Veiculo");
		System.out.println("Digite uma opcao e confirme com ENTER. ");
		inputAtual = input.nextLine();
		
		if (inputAtual.equals("1")) {
			return clpf.adicionarVeiculo(input);
		}
		
		else if (inputAtual.equals("2")) {
			return clpf.removerVeiculo(input, this);
		}
		else {
			System.out.println("-- ERRO! Opcao invalida! --");
			return false;
		}
	}
	
	public boolean cadastrarSeguro(Scanner input) {
		System.out.println("** CADASTRO DE SEGURO **");
		System.out.println("-- Deseja cadastrar seguro para que tipo de cliente?\n"
						 + "Insira o numero e pressione ENTER, ou \"0\" para cancelar a operacao. --");
		System.out.println("1 | Pessoas Fisicas (PF)\n"
						 + "2 | Pessoas Juridicas (PJ)");
		
		String inputAtual = input.nextLine();
		
		if (inputAtual.equals("0"))
			return false;
		
		ArrayList<Cliente> listaClientesTipo = listarClientes(inputAtual);
		
		if (listaClientesTipo == null) {
			return false;
		}
		
		if (listaClientesTipo.isEmpty()) {
			System.out.println("-- ERRO! Nenhum Cliente do tipo desejado foi cadastrado nessa Seguradora! --\n");
			return false;
		}
		
		System.out.println("-- Digite o numero correspondente ao Cliente para o qual");
		System.out.println("deseja cadastrar um Seguro na lista apresentada acima e tecle ENTER,");
		System.out.println("ou \"0\" para cancelar a operacao. --");
		inputAtual = input.nextLine();
		if (inputAtual.equals("0"))
			return false;
		
		while (!Validacao.ehInteiro(inputAtual) || !Validacao.ehIntervaloValido(inputAtual, 1, listaClientesTipo.size())) {
			 System.out.println("-- ERRO! Numero invalido. Selecione algum da lista apresentada");
			 System.out.println("ou \"0\" para cancelar a operacao. --");
			 inputAtual = input.nextLine();
			 System.out.println("");
			 if (inputAtual.equals("0"))
				 return false;
		}
		
		Cliente cl = listaClientesTipo.get(Integer.parseInt(inputAtual) - 1);
		System.out.println("** CADASTRANDO SEGURO DE: " + cl.getNome() + " **");
		
		if ((cl.getClass()).equals(ClientePF.class)) {
			ClientePF clpf = (ClientePF)cl;
			return clpf.cadastrarSeguroPF(input, this);
		}
		else {
			ClientePJ clpj = (ClientePJ)cl;
			return clpj.cadastrarSeguroPJ(input, this);
		}
	}
	
	public void adicionarSeguro(Seguro seguro) {
		listaSeguros.add(seguro);
	}
	
	public void listarTodosSeguros() {
		System.out.println("** LISTAR TODOS OS SEGUROS **");
		if (listaSeguros.isEmpty()) {
			System.out.println("-- ERRO! Nao ha Seguros cadastrados nessa Seguradora! --\n");
			return;
		}
		
		Validacao.listarTodos(listaSeguros, "SEGURO");
	}

	
	public ArrayList<Seguro> listarSegurosPorCliente(Scanner input, String modo) {
		ArrayList<Seguro> listaSegurosCliente = new ArrayList<Seguro>();
		
		if (listaSeguros.isEmpty()) {
			System.out.println("-- ERRO! Nao ha Seguros cadastrados nessa Seguradora! --\n");
		}
		
		System.out.println("-- Deseja listar " + modo + " para que tipo de cliente?\n"
				         + "Insira o numero e pressione ENTER, ou \"0\" para cancelar a operacao. --");
		System.out.println("1 | Pessoas Fisicas (PF)\n"
				         + "2 | Pessoas Juridicas (PJ)");

		String inputAtual = input.nextLine();

		if (inputAtual.equals("0"))
			return listaSegurosCliente;

		ArrayList<Cliente> listaClientesTipo = listarClientes(inputAtual);

		if (listaClientesTipo == null) {
			return listaSegurosCliente;
		}

		if (listaClientesTipo.isEmpty()) {
			System.out.println("-- ERRO! Nenhum Cliente do tipo desejado foi cadastrado nessa Seguradora! --\n");
			return listaSegurosCliente;
		}

		System.out.println("-- Digite o numero correspondente ao Cliente para o qual");
		System.out.println("deseja listar " + modo + " na lista apresentada acima e tecle ENTER,");
		System.out.println("ou \"0\" para cancelar a operacao. --");
		inputAtual = input.nextLine();
		if (inputAtual.equals("0"))
			return listaSegurosCliente;

		while (!Validacao.ehInteiro(inputAtual) || !Validacao.ehIntervaloValido(inputAtual, 1, listaClientesTipo.size())) {
			System.out.println("-- ERRO! Numero invalido. Selecione algum da lista apresentada");
			System.out.println("ou \"0\" para cancelar a operacao. --");
			inputAtual = input.nextLine();
			System.out.println("");
			if (inputAtual.equals("0"))
				return listaSegurosCliente;
		}

		Cliente cl = listaClientesTipo.get(Integer.parseInt(inputAtual) - 1);
		
		ArrayList<Seguro> listaSegurosAux = new ArrayList<Seguro>();
		if (cl.getClass().equals(ClientePF.class)) {
			for (Seguro seguro : listaSeguros) {
				if (seguro.getClass().equals(SeguroPF.class)) 
					listaSegurosAux.add(seguro);
			}
			
			for (Seguro seguro : listaSegurosAux) {
				SeguroPF seguroPF = (SeguroPF)seguro;
				if (seguroPF.getCliente() == cl) 
					listaSegurosCliente.add(seguroPF);
			}
		}
		else {
			for (Seguro seguro : listaSeguros) {
				if (seguro.getClass().equals(SeguroPJ.class))
					listaSegurosAux.add(seguro);
				
			}
			
			for (Seguro seguro : listaSegurosAux) {
				SeguroPJ seguroPJ = (SeguroPJ)seguro;
				if (seguroPJ.getCliente() == cl) 
					listaSegurosCliente.add(seguroPJ);
			}
		}
		
		if (listaSegurosCliente.isEmpty())
			System.out.println("-- ERRO! Nenhum Seguro foi encontrado para esse Cliente! --\n");
		
		return listaSegurosCliente;
	}
	
	public ArrayList<Sinistro> listarSinistrosPorCliente(Scanner input) {
		ArrayList<Sinistro> listaSinistrosCliente = new ArrayList<Sinistro>();
		ArrayList<Seguro> listaSegurosCliente = this.listarSegurosPorCliente(input, "Sinistros");
		
		if (listaSegurosCliente.isEmpty()) {
			return listaSinistrosCliente;
		}
		
		for (Seguro seguro : listaSegurosCliente) {
			for (Sinistro sin : seguro.getListaSinistros()) {
				listaSinistrosCliente.add(sin);
			}
		}
		return listaSinistrosCliente;
	}
	
	public boolean cancelarSeguro(Scanner input, Seguro seguro) {
		if (seguro.getClass().equals(SeguroPF.class)) {
			SeguroPF seguroPF = (SeguroPF)seguro;
			ClientePF cl = seguroPF.getCliente();
			cl.setQtdVeicSegurados(cl.getQtdVeicSegurados() - 1);
		}
		listaSeguros.remove(seguro);
		return true;
	}
	
	private void removerSegurosDeCliente(Cliente cl) {
		ArrayList<Seguro> listaSegurosCliente = new ArrayList<Seguro>();
		ArrayList<Seguro> listaSegurosAux = new ArrayList<Seguro>();
		
		if (cl.getClass().equals(ClientePF.class)) {
			for (Seguro seguro : listaSeguros) {
				if (seguro.getClass().equals(SeguroPF.class)) 
					listaSegurosAux.add(seguro);
			}
			
			for (Seguro seguro : listaSegurosAux) {
				SeguroPF seguroPF = (SeguroPF)seguro;
				if (seguroPF.getCliente() == cl) 
					listaSegurosCliente.add(seguroPF);
			}
		}
		else {
			for (Seguro seguro : listaSeguros) {
				if (seguro.getClass().equals(SeguroPJ.class))
					listaSegurosAux.add(seguro);
				
			}
			
			for (Seguro seguro : listaSegurosAux) {
				SeguroPJ seguroPJ = (SeguroPJ)seguro;
				if (seguroPJ.getCliente() == cl) 
					listaSegurosCliente.add(seguroPJ);
			}
		}
		
		for (Seguro seguro : listaSegurosCliente) {
			listaSeguros.remove(seguro);
		}
	}
	
	
	public boolean excluirCliente(Scanner input) {
		System.out.println("** EXCLUIR CLIENTE **");
		System.out.println("-- Deseja excluir que tipo de cliente? Insira o numero e\n"
				 		 + "pressione ENTER, ou \"0\" para cancelar a operacao. --");
		System.out.println("1 | Pessoas Fisicas (PF)\n"
					     + "2 | Pessoas Juridicas (PJ)");

		String inputAtual = input.nextLine();

		if (inputAtual.equals("0"))
			return false;

		ArrayList<Cliente> listaClientesTipo = listarClientes(inputAtual);

		if (listaClientesTipo == null) {
			return false;
		}

		if (listaClientesTipo.isEmpty()) {
			System.out.println("-- ERRO! Nenhum Cliente do tipo desejado foi cadastrado nessa Seguradora! --\n");
			return false;
		}

		System.out.println("-- Digite o numero correspondente ao Cliente que deseja");
		System.out.println("excluir na lista apresentada acima e tecle ENTER,");
		System.out.println("ou \"0\" para cancelar a operacao. --");
		inputAtual = input.nextLine();
		if (inputAtual.equals("0"))
			return false;

		while (!Validacao.ehInteiro(inputAtual) || !Validacao.ehIntervaloValido(inputAtual, 1, listaClientesTipo.size())) {
			System.out.println("-- ERRO! Numero invalido. Selecione algum da lista apresentada");
			System.out.println("ou \"0\" para cancelar a operacao. --");
			inputAtual = input.nextLine();
			System.out.println("");
			if (inputAtual.equals("0"))
				return false;
		}

		Cliente cl = listaClientesTipo.get(Integer.parseInt(inputAtual) - 1);
		
		if (listaSeguros.isEmpty()) {
			listaClientes.remove(cl);
			return true;
		}
		else {
			removerSegurosDeCliente(cl);
			listaClientes.remove(cl);
			return true;
		}
	}
	
	public void calcularReceita() {
		double soma = 0.0;
		
		for (Seguro seguro : listaSeguros) {
			soma += seguro.calcularValor();
		}
		
		System.out.printf("-- A Seguradora possui %.2f em receita. --\n\n", soma);
	}
	
	@Override
	public String toString() {
		String str = "Nome     | " + nome + "\n"
				   + "CNPJ     | " + cnpj + "\n"
			       + "Telefone | " + telefone + "\n"
			       + "E-mail   | " + email + "\n"
				   + "Endereco | " + endereco;
		return str;
	}
}