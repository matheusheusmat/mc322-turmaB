
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
	
	
	@Override
	public String toString() {
		String str = "Marca: " + this.getMarca() + "\n"
				   + "Modelo: " + this.getModelo() + "\n"
				   + "Ano de fabricacao: " + this.getAnoFabricacao() + "\n"
				   + "Placa: " + this.getPlaca() + "\n";
		return str;
	}
	
	
}
