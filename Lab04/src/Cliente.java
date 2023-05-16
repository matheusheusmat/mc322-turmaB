import java.util.ArrayList;
import java.util.Scanner;

/* Classe "Cliente"
 * Variáveis de instância:
 - String nome
 - String endereco
 - ArrayList<Veiculo> listaVeiculos
 - double valorSeguro
 - int qtdSinistros
 * Getters e setters para cada variável.
 
 * Construtor para a classe, que recebe cada uma das variáveis acima, com exceção
 de listaVeiculos, que é criada vazia, para posterior adição.

 * Métodos de instância:
 + void adicionarVeiculo(Scanner input): cria uma instância de Veiculo e a adiciona
 na listaVeiculos da instância de Cliente.
 + void listarVeiculos(Scanner input): imprime todas as instâncias de Veiculo presentes
 na listaVeiculos, em forma de lista. Caso nenhum esteja presente, imprime uma mensagem e
 interrompe a execução da função.
 + void excluirVeiculo(Scanner input): imprime todas as instâncias de Veiculo presentes
 na listaVeiculos, em forma de lista. Caso nenhum esteja presente, imprime uma mensagem e
 interrompe a execução da função. Em seguida, pede um número inteiro e válido para remoção
 da lista.
 + double calcularScore(): retorna 0.0, pois a função de calcular está sobrescrita nas
 classes ClientePF e ClientePJ.
 */

public class Cliente {
	private String nome;
	private String endereco;
	private ArrayList<Veiculo> listaVeiculos;
	private double valorSeguro;
	private int qtdSinistros = 0;
	
	public Cliente(String nome) {
		this.nome = nome;
		this.listaVeiculos = new ArrayList<Veiculo>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public ArrayList<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}

	public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}

	public double getValorSeguro() {
		return valorSeguro;
	}

	public void setValorSeguro(double valorSeguro) {
		this.valorSeguro = valorSeguro;
	}
	
	public int getQtdSinistros() {
		return qtdSinistros;
	}

	public void setQtdSinistros(int qtdSinistros) {
		this.qtdSinistros = qtdSinistros;
	}
	
	public Veiculo getVeiculo(int num) {
		return listaVeiculos.get(num);
	}
	
	
	public void adicionarVeiculo(Scanner input) {
		Veiculo veic = new Veiculo();
		
		System.out.print("Marca do veiculo: ");
		String inputAtual = input.nextLine();
		veic.setMarca(inputAtual);
		
		System.out.print("Modelo do veiculo: ");
		inputAtual = input.nextLine();
		veic.setModelo(inputAtual);
		
		System.out.print("Ano do veiculo, na forma AAAA: ");
		inputAtual = input.nextLine();
		boolean ehInteiro = Validacao.ehInteiro(inputAtual);
		while (!ehInteiro || inputAtual.length() != 4) {
			System.out.println("-- ERRO: insira o ano na forma correta, com quatro "
							   + "\ndígitos numéricos (AAAA): --");
			inputAtual = input.nextLine();
			ehInteiro = Validacao.ehInteiro(inputAtual);
		}
		veic.setAnoFabricacao(Integer.parseInt(inputAtual));
		
		System.out.print("Placa do veiculo: ");
		inputAtual = input.nextLine();
		veic.setPlaca(inputAtual);
		
		System.out.println("-- Veiculo cadastrado com sucesso! --");
		listaVeiculos.add(veic);
	}
	
	public void listarVeiculos() {
		int contador = 1;
		
		if (listaVeiculos.isEmpty()) {
			System.out.println("Nao ha veiculos cadastrados para esse cliente.\n");
			return;
		}
		
		for (Veiculo v : listaVeiculos) {
			System.out.println("-- Veiculo " + contador + " --\n" + v.toString());
			contador++;
		}
	}
	
	public void excluirVeiculo(Scanner input) {
		if (listaVeiculos.isEmpty()) {
			System.out.println("ERRO! Nao ha veiculos cadastrados para esse cliente.\n");
			return;
		}
		
		System.out.println("-- Selecione o numero correspondente ao veiculo que deseja remover: --");
		this.listarVeiculos();
		String inputAtual = input.nextLine();
		boolean ehInteiro = Validacao.ehInteiro(inputAtual);
		boolean ehIntervaloValido = Validacao.ehIntervaloValido(inputAtual, 1, listaVeiculos.size());
		
		while(!ehInteiro || !ehIntervaloValido) {
			System.out.println("-- ERRO! Veiculo invalido.\nDigite o numero correto conforme a lista apresentada: ");
			inputAtual = input.nextLine();
			ehInteiro = Validacao.ehInteiro(inputAtual);
			ehIntervaloValido = Validacao.ehIntervaloValido(inputAtual, 1, listaVeiculos.size());
		}
		
		listaVeiculos.remove(Integer.parseInt(inputAtual) - 1);
		System.out.println("-- Veiculo removido com sucesso! --\n");
	}
	
	public double calcularScore() {
		return 0.0;
	}

	
}
