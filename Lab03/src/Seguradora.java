import java.util.ArrayList;
import java.util.Scanner;

/* Classe "Seguradora"
 * Variáveis de instância
 - String nome
 - String telefone
 - String email
 - String endereco
 - ArrayList<Sinistro> listaSinistros
 - ArrayList<Cliente> listaClientes
 
 * Getters e setters para cada variável.
 
 * Construtor para a classe, recebendo cada uma das variaveis acima, com exceção
 de listaSinistros e listaClientes. Estas serão inicializadas como vazias, para
 posterior adição. 
 
 * Métodos de classe
 + boolean isInteger(String str): retorna true caso for um valor inteiro, e false
 caso não. Isso é feito pelo tratamento de exceções.
  
 * Métodos de instância 
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
 + void listarVeiculos(String nomeCliente): dado o nome de um Cliente, se não houver clientes
 na seguradora, se o cliente com o nome especificado não for encontrado, ou se não houver 
 veículos cadastrados para aquele cliente, são impressas mensagens de ERRO. Caso contrário, 
 serão impressos todos os veículos em listaVeiculos daquele Cliente, segundo o toString() 
 do veículo.
 + boolean gerarSinistro(Scanner input): pede o nome de um cliente. Caso não houver clientes 
 cadastrados na Seguradora, caso o cliente com o nome dado não for encontrado, ou se não 
 houver veículos cadastrados em seu nome, imprime mensagens de ERRO. Caso contrário, são 
 pedidas informações sobre o incidente, e essas, mais o Cliente, o Veiculo e a Seguradora 
 são armazenados em listaSinistros.
 + boolean visualizarSinistro(String nomeCliente): dado um nome de um Cliente, se a lista 
 de Sinistros da Seguradora estiver vazia ou se não houver Sinistros cadastrados no nome do
 cliente, imprime mensagens de ERRO. Caso contrário, imprime todos os sinistros para aquele
 cliente.
 + void listarSinistros(): lista todos os Sinistros cadastrados na listaSinistros da 
 Seguradora, caso houver. Caso não, imprime uma mensagem de erro.
 + @Override String toString(): retorna uma String com as seguintes variáveis de 
 instância de Seguradora: nome, telefone, email e endereco.
 */


public class Seguradora {
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private ArrayList<Sinistro> listaSinistros;
	private ArrayList<Cliente> listaClientes;
	
	public Seguradora() {
		this.listaSinistros = new ArrayList<Sinistro>();
		this.listaClientes = new ArrayList<Cliente>();
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
	public ArrayList<Sinistro> getListaSinistros() {
		return listaSinistros;
	}
	public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
		this.listaSinistros = listaSinistros;
	}
	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}
	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	public static boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
			return true;
		}
		catch (Exception ex) {
			return false;
		}
	}
	
	public boolean cadastrarCliente(Cliente cliente) {
		return listaClientes.add(cliente);
	}
	
	public Cliente encontrarCliente(String nomeCliente) {
		for (Cliente c : listaClientes) {
			if (c.getNome().equalsIgnoreCase(nomeCliente)) 
				return c;
		}
		return (Cliente)null;
	}
	
	
	public boolean removerCliente(String nomeCliente) {
		if (listaClientes.isEmpty()) {
			System.out.println("-- ERRO: Nao ha clientes cadastrados na seguradora! --\n");
			return false;
		}
		Cliente c = this.encontrarCliente(nomeCliente);
		if (c == null) {
			System.out.println("-- ERRO: Cliente nao encontrado! --\n");
			return false;
		}
		else {
			listaClientes.remove(c);
			System.out.println("-- Cliente " + c.getNome() + " removido com sucesso! --\n");
			return true;
		}
	
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
					System.out.println("-- Cliente " + indice + " --\n" + c.toString());
					indice++;
				}
			}
		}
		
		else {
			for (Cliente c : listaClientes) {
				if ((c.getClass()).equals(ClientePJ.class)) {
					System.out.println("-- Cliente " + indice + " --\n" + c.toString());
					indice++;
				}
			}
		}
		
		if (indice == 1)
			System.out.println("-- ERRO: Tipo de cliente especificado nao encontrado! --\n");
		}
		
	
	public void cadastrarVeiculo(Scanner input) {
		if (listaClientes.isEmpty()) {
			System.out.println("-- ERRO: Nao ha clientes cadastrados na seguradora! --\n");
			return;
		}
		
		System.out.print("Nome do cliente: ");
		String nomeCliente = input.nextLine();
		Cliente c = this.encontrarCliente(nomeCliente);
	
		if (c == null) {
			System.out.println("-- ERRO: Cliente nao encontrado! --\n");
			return;
		}
		
		System.out.println("-- Cliente encontrado! --");
		c.adicionarVeiculo(input);
		System.out.println("-- Veiculo cadastrado com sucesso! --\n");
	}
		
	
	public void listarVeiculos(String nomeCliente) {
		int contador = 1;
		
		if (listaClientes.isEmpty()) {
			System.out.println("-- ERRO: Nao ha clientes cadastrados na seguradora! --\n");
			return;
		}
		Cliente c = this.encontrarCliente(nomeCliente);
		
		if (c == null) {
			System.out.println("-- ERRO: Cliente nao encontrado! --\n");
			return;
		}
		
		if (c.getListaVeiculos().isEmpty()) {
			System.out.println("-- ERRO: Nao ha veiculos cadastrados em nome do cliente! --\n");
		}
		
		for (Veiculo v : c.getListaVeiculos()) {
			System.out.println("-- Veiculo " + contador + " --\n" + v.toString());
			contador++;
		}
	}
	
	
	public boolean gerarSinistro(Scanner input) {
		
		if (listaClientes.isEmpty()) {
			System.out.println("-- ERRO: Nao ha clientes cadastrados na seguradora! --\n");
			return false;
		}
		
		System.out.print("Nome do cliente: ");
		String nomeCliente = input.nextLine();
		Cliente c = this.encontrarCliente(nomeCliente);
		
		if (c == null) {
			System.out.println("-- ERRO: Cliente nao encontrado! --\n");
			return false;
		}
		
		if (c.getListaVeiculos().isEmpty()) {
			System.out.println("-- ERRO: Nao ha veiculos cadastrados em nome do cliente! --\n");
			return false;
		}
		
		System.out.println("Com qual veiculo houve o incidente?\nSelecione o numero correspondente ao veiculo: ");
		this.listarVeiculos(nomeCliente);
		String inputAtual = input.nextLine();
		boolean ehInteiro = isInteger(inputAtual);
		
		while (!ehInteiro || Integer.parseInt(inputAtual) > c.getListaVeiculos().size()
			   || Integer.parseInt(inputAtual) <= 0) {
			System.out.println("-- ERRO: Veiculo invalido.\nDigite o numero correto conforme a lista apresentada: ");
			inputAtual = input.nextLine();
			ehInteiro = isInteger(inputAtual);
		}
		
		Veiculo v = c.getVeiculo(Integer.parseInt(inputAtual) - 1);
		
		System.out.print("Data do incidente: ");
		inputAtual = input.nextLine();
		
		Sinistro sin = new Sinistro(inputAtual, this, v, c);
		
		System.out.print("Endereco onde houve o incidente: ");
		inputAtual = input.nextLine();
		sin.setEndereco(inputAtual);
		
		listaSinistros.add(sin);
		System.out.println("-- Sinistro gerado com sucesso! --\n");
		return true;
	}
	

	public boolean visualizarSinistro(String nomeCliente) {
		boolean encontrou = false;
		int contador = 1;
		
		if (listaSinistros.isEmpty()) {
			System.out.println("-- ERRO: Nenhum sinistro foi cadastrado na seguradora! --\n");
			return false;
		}
		
		for (Sinistro s : listaSinistros) {
			if ((s.getCliente().getNome()).equalsIgnoreCase(nomeCliente)) {
				System.out.println("-- Sinistro " + contador + " --\n" + s.toString());
				encontrou = true;
				contador++;
			}
		}
		
		if (!encontrou) {
			System.out.println("-- Nenhum sinistro foi encontrado para este cliente! --\n");
			return false;
		}
		return true;
	}
		
	
	public void listarSinistros() {
		int contador = 1;
		
		if (listaSinistros.isEmpty()) {
			System.out.println("-- ERRO: Nenhum sinistro foi cadastrado na seguradora! --\n");
			return;
		}
		for (Sinistro s : listaSinistros) {
			System.out.println("-- Sinistro " + contador + " --");
			System.out.println(s.toString());
			contador++;
		}
	} 
	

	@Override
	public String toString() {
		String str = "Nome da seguradora: " + getNome() + "\n"
				   + "Telefone: " + getTelefone() + "\n"
				   + "E-mail: " + getEmail() + "\n"
				   + "Endereco: " + getEndereco() + "\n";
		
		return str;
	}
	
}






