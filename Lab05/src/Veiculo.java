import java.util.Scanner;

/* Classe "Veiculo"
 * Variáveis de instância:
 - String placa
 - String marca
 - String modelo
 - int anoFabricacao

 * Getters e setters para cada variável.

 * Construtor para a classe, recebendo cada uma das variaveis acima.

 * Métodos de instância:
 + @Override String toString(): retorna uma String com as variáveis de instância.
 */

public class Veiculo {
	private String placa;
	private String marca;
	private String modelo;
	private int anoFabricacao;
	
	public Veiculo() {}
	
	public Veiculo(String marca) {
		this.marca = marca;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	
	public static Veiculo criarVeiculo(Scanner input) {
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
		
		return veic;
	}
	
	
	@Override
	public String toString() {
		String str = "Marca             | " + this.getMarca() + "\n"
				   + "Modelo            | " + this.getModelo() + "\n"
				   + "Ano de fabricacao | " + this.getAnoFabricacao() + "\n"
				   + "Placa             | " + this.getPlaca();
		return str;
	}
}