import java.util.ArrayList;
import java.util.Scanner;

/* Classe "Cliente"
 * Variáveis de instância:
 - String nome
 - String endereco
 - ArrayList<Veiculo> listaVeiculos
 * Getters e setters para cada variável.
 
 * Construtor para a classe, que recebe cada uma das variáveis acima, com exceção
 de listaVeiculos, que é criada vazia, para posterior adição.
  
 * Métodos de classe:
 + boolean isInteger(String str): retorna true caso for um valor inteiro, e false
 caso não. Isso é feito pelo tratamento de exceções.

 * Métodos de instância:
 + void adicionarVeiculo(Scanner input): cria uma instância de Veiculo e a adiciona
 na listaVeiculos da instância de Cliente.
 */



public class Cliente {
	private String nome;
	private String endereco;
	private ArrayList<Veiculo> listaVeiculos;
	
	
	public Cliente(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
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
	
	public Veiculo getVeiculo(int num) {
		return listaVeiculos.get(num);
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
	
	
	public void adicionarVeiculo(Scanner input) {
		Veiculo veic = new Veiculo(null, null, null, 0);
		
		System.out.print("Marca do veiculo: ");
		String inputAtual = input.nextLine();
		veic.setMarca(inputAtual);
		
		System.out.print("Modelo do veiculo: ");
		inputAtual = input.nextLine();
		veic.setModelo(inputAtual);
		
		System.out.print("Ano do veiculo, na forma AAAA: ");
		inputAtual = input.nextLine();
		boolean ehInteiro = isInteger(inputAtual);
		while (!ehInteiro || inputAtual.length() != 4) {
			System.out.print("-- ERRO: insira o ano na forma correta, com quatro "
							   + "dígitos numéricos (AAAA): ");
			inputAtual = input.nextLine();
			ehInteiro = isInteger(inputAtual);
		}
		veic.setAnoFabricacao(Integer.parseInt(inputAtual));
		
		System.out.print("Placa do veiculo: ");
		inputAtual = input.nextLine();
		veic.setPlaca(inputAtual);
		
		listaVeiculos.add(veic);
		return;
	}
	
}
