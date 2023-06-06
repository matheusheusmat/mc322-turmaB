import java.util.ArrayList;
import java.util.Scanner;

public class Frota {
	/* Classe "Frota"
	 * Variáveis de classe:
	 - static int contador
	 * Variáveis de instância:
	 - String code
	 - ArrayList<Veiculo> listaVeiculos
	 - int qtdVeiculos
	 
	 * Getters e setters para cada variável.
	 
	 * Construtor para a classe.

	 * Métodos de classe abstratos:
	 + public boolean adicionarVeiculo(Scanner input): instancia um Veiculo e o adiciona na
	 listaVeiculos da Frota.
	 
	 + public boolean removerVeiculo(Scanner input): imprime todos os Veiculos da frota e pede
	 ao usuário o número relacionado ao Veiculo que deseja remover. Remove o Veiculo da
	 listaVeiculos.
	 
	 + public String toString(): Retorna uma String com alguns dos atributos de instância.
	 */
	
	private static int contador = 1;
	private String code;
	private ArrayList<Veiculo> listaVeiculos;
	private int qtdVeiculos;
	
	public Frota() {
		code = Integer.toString(contador);
		contador++;
		this.listaVeiculos = new ArrayList<Veiculo>();
		setQtdVeiculos(0);
	}
	
	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Frota.contador = contador;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ArrayList<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}

	public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
	
	public int getQtdVeiculos() {
		return qtdVeiculos;
	}

	public void setQtdVeiculos(int qtdVeiculos) {
		this.qtdVeiculos = qtdVeiculos;
	}

	public boolean adicionarVeiculo(Scanner input) {
		System.out.println("** CADASTRANDO VEICULO EM FROTA **");
		Veiculo veic = Veiculo.criarVeiculo(input);
		listaVeiculos.add(veic);
		System.out.println("-- Veiculo adicionado com sucesso! --");
		qtdVeiculos++;
		return true;
	}
	
	public boolean removerVeiculo(Scanner input) {
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
		listaVeiculos.remove(Integer.parseInt(inputAtual) - 1);
		qtdVeiculos--;
		return true;
	}
	
	@Override
	public String toString() {
		String str = "Codigo           | " + this.getCode() + "\n"
				   + "Qtd. de veiculos | " + this.getQtdVeiculos();
		return str;
	}
}
