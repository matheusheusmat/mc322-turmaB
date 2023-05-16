import java.text.SimpleDateFormat;
import java.util.Date;

/* Classe "Sinistro"
 * Variáveis de classe:
 - int contador

 * Variáveis de instância:
 - (final) int id
 - String data
 - String endereco
 - Seguradora seguradora
 - Veiculo veiculo
 - Cliente cliente

 * Getters e setters para cada variável.

 * Construtor para classe, recebendo cada uma das variáveis de instância acima,
 com exceção de int id, pois essa é criada pelo contador, e é somado 1 ao contador.
 Dessa forma, o id é único para cada instância criada.
 
 * Métodos de instância:
 + @Override String toString(): retorna uma String com as variáveis de instância, mais
 os dados do Veículo, Cliente e Seguradora associados a esta instância.
 */

public class Sinistro {
	private static int contador = 1;
	private final int id;
	private Date data;
	private String endereco;
	private Seguradora seguradora;
	private Veiculo veiculo;
	private Cliente cliente;
	
	public Sinistro(Date data, Seguradora seg, Veiculo vei, Cliente cli) {
		this.id = contador;
		contador++;
		this.data = data;
		this.seguradora = seg;
		this.veiculo = vei;
		this.cliente = cli;
	}

	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Sinistro.contador = contador;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Seguradora getSeguradora() {
		return seguradora;
	}

	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String str = "Numero de identificacao do sinistro | " + getId() + "\n"
				   + "Data da ocorrencia | " + sdf.format(getData()) + "\n"
				   + "Endereco da ocorrencia | " + getEndereco() + "\n"
				   + "-- DADOS DO CLIENTE --\n" + getCliente().toString() + "\n" 
				   + "-- DADOS DO VEICULO --\n" + getVeiculo().toString()
				   + "-- DADOS DA SEGURADORA -- \n" + getSeguradora().toString();
		
		
		return str;
	}
}
