import java.util.ArrayList;
import java.util.Scanner;

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
	
	public void adicionarVeiculo(Scanner input) {
		Veiculo veic = new Veiculo(null, null, null, 0);
		
		System.out.print("Marca do veiculo: ");
		String inputAtual = input.nextLine();
		veic.setMarca(inputAtual);
		
		System.out.print("Modelo do veiculo: ");
		inputAtual = input.nextLine();
		veic.setModelo(inputAtual);
		
		System.out.print("Ano do veiculo: ");
		inputAtual = input.nextLine();
		veic.setAnoFabricacao(Integer.parseInt(inputAtual));
		
		System.out.print("Placa do veiculo: ");
		inputAtual = input.nextLine();
		veic.setPlaca(inputAtual);
		
		
		listaVeiculos.add(veic);
		return;
	}
	
}
