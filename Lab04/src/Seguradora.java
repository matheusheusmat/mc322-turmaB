import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/* Classe "Seguradora"
 * Variáveis de classe
 - static ArrayList<Seguradora> listaSeguradoras
 
 * Variáveis de instância
 - String nome
 - String telefone
 - String email
 - String endereco
 - ArrayList<Sinistro> listaSinistros
 - ArrayList<Cliente> listaClientes
 
 
 * Getters e setters para cada variável.
 
 * Construtor para a classe. 
 
 * Métodos de classe
 + boolean isInteger(String str): retorna true caso for um valor inteiro, e false
 caso não. Isso é feito pelo tratamento de exceções.
  
 * Métodos de instância 
 + static Seguradora encontrarSeguradora(Scanner input): o usuário insere o nome de uma 
 seguradora. Se a lista estiver vazia ou se a seguradora desejada não for encontrada,
 retorna null. Se for encontrada, retorna o objeto da classe Seguradora.
 + static boolean cadastrarSeguradora(Scanner input): instancia uma nova seguradora, pedindo
 suas informações ao usuário, e a adiciona na listaSeguradoras.
 + boolean cadastrarCliente(Cliente cliente): dado um novo Cliente, o adiciona na 
 ArrayList<Cliente> listaClientes.
 + Cliente encontrarCliente(String nomeCliente): dado o nome de um Cliente, o procura
 na listaClientes. Caso estiver presente, o retorna (Cliente c). Caso contrário, retorna
 um Cliente null.
 + boolean removerCliente(String nomeCliente): dado o nome de um Cliente, o procura e o
 remove, caso estiver presente. São impressas mensagens de ERRO no caso de não houver clientes
 cadastrados na Seguradora ou o cliente com o nome especificado não ter sido encontrado. Nesses
 casos, retorna false. Caso contrário, o remove da lista e retorna true, mais uma mensagem de
 sucesso.
 + void listarClientes(String tipoCliente): imprime os todos os Clientes de um tipo 
 específico - PF imprime todas as instâncias ClientePF, PJ, ClientePJ - dado pelo 
 usuário. Imprime mensagens de ERRO nos casos de não haver clientes cadastrados na
 Seguradora, de a entrada não ser PF, pf, PJ ou pj, ou de não haver clientes cadastrados
 que sejam da classe especificada. Caso contrário, todas as instâncias ClientePF ou
 ClientePJ armazenadas em listaClientes são impressas, segundo o seu método toString().
 + void cadastrarVeiculo(Scanner input): se não há clientes cadastrados na seguradora ou
 se o cliente cujo nome é pedido ao usuário não for encontrado, imprime mensagens de erro.
 Caso contrário, cadastra o veículo no Cliente, chamando outro método (cadastrarVeiculo).
 Mais detalhes desse método na classe Cliente.
 + void listarVeiculosSeg(): percorre a listaClientes e imprime os veiculos presentes em
 listaVeiculos para cada um, chamando o método listarVeiculos da classe Cliente para isso.
 + boolean gerarSinistro(Scanner input): pede o nome de um cliente. Caso não houver clientes 
 cadastrados na Seguradora, caso o cliente com o nome dado não for encontrado, ou se não 
 houver veículos cadastrados em seu nome, imprime mensagens de ERRO. Caso contrário, são 
 pedidas informações sobre o incidente, e essas, mais o Cliente, o Veiculo e a Seguradora 
 são armazenados em listaSinistros.
 + boolean visualizarSinistros(String nomeCliente): dado um nome de um Cliente, se a lista 
 de Sinistros da Seguradora estiver vazia ou se não houver Sinistros cadastrados no nome do
 cliente, imprime mensagens de ERRO. Caso contrário, imprime todos os sinistros para aquele
 cliente.
 + void listarSinistros(): lista todos os Sinistros cadastrados na listaSinistros da 
 Seguradora, caso houver. Caso não, imprime uma mensagem de erro.
 + public boolean excluirCliente(Cliente cl): dado um objeto Cliente, o remove da listaClientes.
 + public void excluirSinistro(Scanner input): imprime todos os Sinistros da seguradora, caso
 houver, em forma de lista. Em seguida, o usuário insere o número correspondente ao Sinistro
 que deseja remover da lista.
 + public static void transferirSeguro(Scanner input): pede ao usuário os dados do doador 
 e do destinatário dos veículos segurados (nome da Seguradora e nome do Cliente). Em seguida,
 adiciona todos os veículos do doador na lista do destinatário, e esvazia a lista do doador.
 + public double calcularPrecoSeguroCliente(Cliente cl): dado um cliente, calcula o preco de 
 seu seguro, com base no calculaScore() do ClientePF e ClientePJ e sua quantidade de sinistros 
 (qtdSinistros).
 + public void calcularReceita(): realiza a soma de todos os preços de seguros para cada
 Cliente cadastrado em uma seguradora, percorrendo a listaClientes e, sobre cada um, chamando
 calcularPrecoSeguroCliente(Cliente cl). Ao final, imprime a receita com duas casas decimais.
 + @Override String toString(): retorna uma String com as seguintes variáveis de instância de 
 Seguradora: nome, telefone, email e endereco.
 */

public class Seguradora {
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private ArrayList<Cliente> listaClientes;
	private ArrayList<Sinistro> listaSinistros;
	private static ArrayList<Seguradora> listaSeguradoras = new ArrayList<Seguradora>();
	
	public Seguradora(String nome) {
		this.nome = nome;
		this.listaClientes = new ArrayList<Cliente>();
		this.listaSinistros = new ArrayList<Sinistro>();
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

	public ArrayList<Sinistro> getListaSinistros() {
		return listaSinistros;
	}

	public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
		this.listaSinistros = listaSinistros;
	}

	public static ArrayList<Seguradora> getListaSeguradoras() {
		return listaSeguradoras;
	}

	public static void setListaSeguradoras(ArrayList<Seguradora> listaSeguradoras) {
		Seguradora.listaSeguradoras = listaSeguradoras;
	}
	
	
	public static Seguradora encontrarSeguradora(Scanner input) {
		if (listaSeguradoras.isEmpty()) {
			System.out.println("-- ERRO: Nao ha seguradoras cadastradas! --\n");
			return null;
		}
		
		System.out.print("Digite o nome da seguradora: ");
		String nomeProcurado = input.nextLine();
		for (Seguradora seg : listaSeguradoras) {
			if ((seg.getNome()).equalsIgnoreCase(nomeProcurado)) {
				System.out.println("-- Seguradora encontrada! --\n");
				return seg;
			}
		}
		
		System.out.println("-- ERRO: Seguradora nao encontrada! --\n");
		return null;
	}
	
	
	public static boolean cadastrarSeguradora(Scanner input) {
		System.out.print("Nome: ");
		String inputAtual = input.nextLine();
		Seguradora seg = new Seguradora(inputAtual);
		
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
		System.out.println("Seguradora criada com sucesso!");
		return true;
	}
	
	
	public Cliente encontrarCliente(Scanner input) {
		if (listaClientes.isEmpty()) {
			System.out.println("-- ERRO: Nao ha clientes cadastrados na seguradora! --\n");
			return (Cliente)null;
		}
		System.out.println("Insira o nome do Cliente ou da Empresa Cliente: ");
		String nomeCliente = input.nextLine();
		for (Cliente c : listaClientes) {
			if (c.getNome().equalsIgnoreCase(nomeCliente)) {
				System.out.println("-- Cliente encontrado! --\n");
				return c;
			}
		}
		System.out.println("-- ERRO: Cliente procurado não encontrado! --\n");
		return (Cliente)null;
	}
	
	
	public boolean cadastrarCliente(Cliente cliente) {
		listaClientes.add(cliente);
		return true;
	}
	
	
	public void listarClientes(String tipoCliente) {
		int indice = 1;
		
		if (!tipoCliente.equalsIgnoreCase("PJ") && !tipoCliente.equalsIgnoreCase("PF")) {
			System.out.println("-- ERRO: Tipo de cliente inválido! Insira apenas PF ou PJ! --");
			return;
		}
		
		if (listaClientes.isEmpty()) {
			System.out.println("-- ERRO: Nao ha clientes cadastrados na seguradora! --\n");
			return;
		}
		
		if (tipoCliente.equalsIgnoreCase("PF")) {
			for (Cliente c : listaClientes) {
				if ((c.getClass()).equals(ClientePF.class)) {
					System.out.println("-- CLIENTE " + indice + " --\n" + c.toString() + "\n");
					indice++;
				}
			}
		}
		
		else {
			for (Cliente c : listaClientes) {
				if ((c.getClass()).equals(ClientePJ.class)) {
					System.out.println("-- CLIENTE " + indice + " --\n" + c.toString() + "\n");
					indice++;
				}
			}
		}
		
		if (indice == 1)
			System.out.println("-- ERRO: Tipo de cliente especificado nao encontrado! --\n");
		}
	
	
	public void listarVeiculosSeg() { 
		if (listaClientes.isEmpty()) {
			System.out.println("-- ERRO! Nao ha clientes cadastrados na seguradora!");
			return;
		}
		for (Cliente cl : listaClientes) {
			System.out.println("-- Cliente: " + cl.getNome() + " --");
			cl.listarVeiculos();
		}
	}
		
	
	public boolean gerarSinistro(Scanner input) {
		Cliente cl = encontrarCliente(input);
		if (cl != null) {
			if (cl.getListaVeiculos().isEmpty()) {
				System.out.println("-- ERRO: Nao ha veiculos cadastrados em nome do cliente! --\n");
				return false;
			}
			
			System.out.println("\nCom qual veiculo houve o incidente?\nSelecione o numero correspondente ao veiculo: ");
			cl.listarVeiculos();
			String inputAtual = input.nextLine();
			boolean ehInteiro = Validacao.ehInteiro(inputAtual);
			boolean ehIntervaloValido = Validacao.ehIntervaloValido(inputAtual, 1, cl.getListaVeiculos().size());
			
			while(!ehInteiro && !ehIntervaloValido) {
				System.out.println("-- ERRO! Veiculo invalido.\nDigite o numero correto conforme a lista apresentada: ");
				inputAtual = input.nextLine();
				ehInteiro = Validacao.ehInteiro(inputAtual);
				ehIntervaloValido = Validacao.ehIntervaloValido(inputAtual, 1, cl.getListaVeiculos().size());
			}
			
			Veiculo v = cl.getVeiculo(Integer.parseInt(inputAtual) - 1);
			
			System.out.print("Data do incidente: ");
			inputAtual = input.nextLine();
			Date data = Validacao.formatarData(inputAtual, input);
			
			Sinistro sin = new Sinistro(data, this, v, cl);
			
			System.out.print("Endereco onde houve o incidente: ");
			inputAtual = input.nextLine();
			sin.setEndereco(inputAtual);
			
			listaSinistros.add(sin);
			cl.setQtdSinistros(cl.getQtdSinistros() + 1);
			System.out.println("-- Sinistro gerado com sucesso! --\n");
			return true;
		}
		return false;
	}
	
	public boolean visualizarSinistros(String nomeCliente) {
		boolean encontrou = false;
		int contador = 1;
		
		System.out.println("\n-- Sinistros em nome de " + nomeCliente + " --");
		for (Sinistro sin : listaSinistros) {
			if (((sin.getCliente()).getNome()).equalsIgnoreCase(nomeCliente)) {
				System.out.println("-- SINISTRO " + contador + " --\n" + sin.toString());
				encontrou = true;
				contador++;
			}
		}
		if (!encontrou) {
			System.out.println("-- Nenhum sinistro foi encontrado em nome do cliente procurado. --");
		}
		return encontrou;
	}
	
	public void listarSinistros() {
		int contador = 1;
		
		if (listaSinistros.isEmpty()) {
			System.out.println("-- ERRO! Nao ha sinistros cadastrados na seguradora. --");
			return;
		}
		for (Sinistro sin : listaSinistros) {
			System.out.println("-- SINISTRO " + contador + " --\n" + sin.toString());
			contador++;
		}
	}
	
	public boolean excluirCliente(Cliente cl) {
		listaClientes.remove(cl);
		System.out.println("-- Cliente " + cl.getNome() + " removido com sucesso! --");
		return true;
	}
	
	public void excluirSinistro(Scanner input) {
		if (listaSinistros.isEmpty()) {
			System.out.println("-- ERRO! Nao ha sinistros cadastrados na seguradora. --");
			return;
		}
		
		System.out.println("-- Selecione o numero correspondente ao sinistro que deseja remover: --");
		this.listarSinistros();
		String inputAtual = input.nextLine();
		boolean ehInteiro = Validacao.ehInteiro(inputAtual);
		boolean ehIntervaloValido = Validacao.ehIntervaloValido(inputAtual, 1, listaSinistros.size());
		
		while (!ehInteiro && !ehIntervaloValido) {
			System.out.println("-- ERRO! Sinistro invalido.\nDigite o numero correto conforme a lista apresentada: ");
			inputAtual = input.nextLine();
			ehInteiro = Validacao.ehInteiro(inputAtual);
			ehIntervaloValido = Validacao.ehIntervaloValido(inputAtual, 1, listaSinistros.size());
		}
		
		Sinistro sin = listaSinistros.get(Integer.parseInt(inputAtual) - 1);
		Cliente cl = sin.getCliente();
		cl.setQtdSinistros(cl.getQtdSinistros() - 1);
		
		listaSinistros.remove(sin);
		System.out.println("-- Sinistro removido com sucesso! --\n");
		System.out.println("Qtde sinistros: " + cl.getQtdSinistros());
	}
	
	public static void transferirSeguro(Scanner input) {
		System.out.println("-- DADOS DO DOADOR --");
		
		Seguradora segDoador = Seguradora.encontrarSeguradora(input);
		if (segDoador == null)
			return;
		Cliente clDoador = segDoador.encontrarCliente(input);
		if (clDoador == null)
			return;
		if (clDoador.getListaVeiculos().isEmpty()) {
			System.out.println("-- ERRO! O cliente procurado nao possui veiculos cadastrados --");
			return;
		}
		
		System.out.println("-- DADOS DO DESTINATARIO --");
		Seguradora segDest = Seguradora.encontrarSeguradora(input);
		if (segDest == null)
			return;
		Cliente clDest = segDest.encontrarCliente(input);
		if (clDest == null)
			return;

		if (clDoador == clDest) {
			System.out.println("-- ERRO! Nao é possivel transferir seguro de um cliente\npara ele mesmo! --\n");
			return;
		}
		
		for (Veiculo v : clDoador.getListaVeiculos()) {
			clDest.getListaVeiculos().add(v);
		}
		clDoador.getListaVeiculos().clear();
		System.out.println("-- Seguro transferido com sucesso! --");
	}
	
	
	
	public double calcularPrecoSeguroCliente(Cliente cl) {
		double valorSeguro = cl.calcularScore() * (1 + cl.getQtdSinistros());
		cl.setValorSeguro(valorSeguro);
		return valorSeguro;
	}
	
	public void calcularReceita() {
		if (listaClientes.isEmpty()) {
			System.out.println("-- ERRO! Nao ha clientes cadastrados na seguradora! --\n");
			return;
		}
		double receita = 0.0;
		for (Cliente cl : listaClientes) {
			receita += calcularPrecoSeguroCliente(cl);
		}
		System.out.print("-- Receita total da Seguradora " + nome + ": ");
		System.out.printf("%.2f --\n", receita);
	}
	
	@Override
	public String toString() {
		String str = "Nome da seguradora | " + getNome() + "\n"
				   + "Telefone | " + getTelefone() + "\n"
				   + "E-mail | " + getEmail() + "\n"
				   + "Endereco | " + getEndereco() + "\n";
		
		return str;
	}
	

}
