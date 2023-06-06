import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ClientePF extends Cliente {
/* Classe "ClientePF" herda de classe "Cliente"
 * Variáveis de instância:
 - (final) String cpf
 - Date dataNascimento 
 - String educacao 
 - String genero 
 - ArrayList<Veiculo> listaVeiculos
 - int qtdVeicSegurados
 
 * Getters e setters para cada variável.
 
 * Construtor para a classe, que recebe nome e cpf.
 
 * Métodos da classe:
 + public static ClientePF criarClientePF(Scanner input): instancia um ClientePF e recebe 
 as informações do usuário (nome, endereço, CPF, data de nascimento, gênero, idade,
 e-mail, telefone educação e classe econômica). Ao final, retorna o ClientePF criado. 
	  
 + public boolean adicionarVeiculo(Scanner input): instancia e adiciona um Veiculo na 
 listaVeiculos de um ClientePF.
 
 + public boolean removerVeiculo(Scanner input, Seguradora seg): imprime e remove um veiculo
 da listaVeiculos. Também remove um Seguro associado a ele, caso exista.
 
 - private boolean temSeguroERemove(Seguradora seg, Veiculo veic, Boolean remover): procura
 um Veiculo na listaSeguros de uma Seguradora. Retorna true, caso encontre. Se remover == true, 
 e o encontrar, o remove da lista.
 
 + public boolean cadastrarSeguroPF(Scanner input, Seguradora seg): cadastra um Seguro, caso
 o ClientePF possua Veiculos. Realiza a verificacao se o Veiculo já é ou não segurado, ou seja,
 possui um Seguro associado a ele.

 + public String toString(): Retorna uma String com alguns dos atributos de instância.
 
 */
	
	private final String cpf;
	private Date dataNascimento;
	private String genero;
	private String educacao;
	private ArrayList<Veiculo> listaVeiculos;
	private int qtdVeicSegurados = 0;
	
	public ClientePF(String nome, String cpf) {
		super(nome);
		this.cpf = cpf;
		this.listaVeiculos = new ArrayList<Veiculo>();
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEducacao() {
		return educacao;
	}

	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}

	public ArrayList<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}

	public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}

	public String getCpf() {
		return cpf;
	}
	
	public int getQtdVeicSegurados() {
		return qtdVeicSegurados;
	}

	public void setQtdVeicSegurados(int qtdVeicSegurados) {
		this.qtdVeicSegurados = qtdVeicSegurados;
	}

	public static ClientePF criarClientePF(Scanner input) {
		System.out.println("\n** CADASTRO DE PESSOA FISICA **");
		
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
		
		System.out.print("Genero: ");
		inputAtual = input.nextLine();
		cl.setGenero(inputAtual);
		
		System.out.print("Nivel de escolaridade: ");
		inputAtual = input.nextLine();
		cl.setEducacao(inputAtual);
		
		System.out.print("Endereco: ");
		inputAtual = input.nextLine();
		cl.setEndereco(inputAtual);
		
		System.out.print("Telefone: ");
		inputAtual = input.nextLine();
		cl.setTelefone(inputAtual);
		
		System.out.print("E-mail: ");
		inputAtual = input.nextLine();
		cl.setEmail(inputAtual);
		
		System.out.println("-- Cliente cadastrado com sucesso! --\n");
		
		return cl;
	}
	
	public boolean adicionarVeiculo(Scanner input) {
		Veiculo veic = Veiculo.criarVeiculo(input);
		System.out.println("-- Veiculo cadastrado com sucesso! --\n");
		listaVeiculos.add(veic);
		return true;
	}
	
	public boolean removerVeiculo(Scanner input, Seguradora seg) {
		System.out.println("** REMOVER VEICULO **");
		if (listaVeiculos.isEmpty()) {
			System.out.println("-- ERRO! Nenhum Veiculo foi cadastrado para esse Cliente PF. --");
			return false;
		}
		
		Validacao.listarTodos(listaVeiculos, "VEICULO");
		System.out.println("-- Digite o numero correspondente ao Veiculo que deseja remover");
		System.out.println("e tecle ENTER, ou \"0\" para cancelar a operacao. --");
		String inputAtual = input.nextLine();
		
		if (inputAtual.equals("0"))
			return false;
		
		while (!Validacao.ehInteiro(inputAtual) || !Validacao.ehIntervaloValido(inputAtual, 1, listaVeiculos.size())) {
			 System.out.println("-- ERRO! Numero invalido. Selecione algum da lista apresentada");
			 System.out.println("ou \"0\" para cancelar a operacao. --");
			 inputAtual = input.nextLine();
			 System.out.println("");
			 if (inputAtual.equals("0"))
				 return false;
		}
		Veiculo veic = listaVeiculos.get(Integer.parseInt(inputAtual) - 1);
		temSeguroERemove(seg, veic, true);
		return listaVeiculos.remove(veic);
	}
	
	private boolean temSeguroERemove(Seguradora seg, Veiculo veic, Boolean remover) {
		SeguroPF seguroPF = null;
		boolean encontrou = false;
		if ((seg.getListaSeguros()).isEmpty())
			return encontrou;
		
		for (Seguro seguro : seg.getListaSeguros()) {
			if (seguro.getClass().equals(SeguroPF.class)) {
				seguroPF = (SeguroPF)seguro;
				if (seguroPF.getVeiculo() == veic) {
					encontrou = true;
					break;
				}
			}
		}
		
		if (encontrou && remover) {
			seg.getListaSeguros().remove(seguroPF);
			qtdVeicSegurados--;
		}
		
		return encontrou;
	}
	
	public boolean cadastrarSeguroPF(Scanner input, Seguradora seg) {
		if (listaVeiculos.isEmpty()) {
			System.out.println("-- ERRO! Nenhum Veiculo cadastrado para esse Cliente! --");
			return false;
		}
		
		Validacao.listarTodos(listaVeiculos, "VEICULO");
		System.out.println("-- Digite o numero correspondente ao Veiculo para o qual deseja");
		System.out.println("cadastrar Seguro e tecle ENTER, ou \"0\" para cancelar a operacao. --");
		String inputAtual = input.nextLine();
		
		if (inputAtual.equals("0"))
			return false;
		
		while (!Validacao.ehInteiro(inputAtual) || !Validacao.ehIntervaloValido(inputAtual, 1, listaVeiculos.size())) {
			 System.out.println("-- ERRO! Numero invalido. Selecione algum da lista apresentada");
			 System.out.println("ou \"0\" para cancelar a operacao. --");
			 inputAtual = input.nextLine();
			 System.out.println("");
			 if (inputAtual.equals("0"))
				 return false;
		}
		
		Veiculo veic = listaVeiculos.get(Integer.parseInt(inputAtual) - 1);
		
		if (temSeguroERemove(seg, veic, false)) {
			System.out.println("-- ATENCAO! Este Veiculo ja possui Seguro! --");
			return false;
		}
		
		SeguroPF seguroPF = SeguroPF.criarSeguroPF(input, this, veic, seg);
		seg.adicionarSeguro(seguroPF);
		return true;
	}
	
	@Override
	public String toString() {
		String str = "Nome     | " + this.getNome() + "\n"
				   + "CPF      | " + cpf + "\n"
				   + "Idade    | " + this.getIdade() + "\n"
				   + "Genero   | " + genero + "\n"
				   + "Educacao | " + educacao + "\n"
				   + "Telefone | " + this.getTelefone() + "\n"
				   + "E-mail   | " + this.getEmail() + "\n"
				   + "Endereco | " + this.getEndereco();
		return str;
	}
	
}
