import java.text.SimpleDateFormat;
import java.util.Date;

public class Sinistro {
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
	
	private static int contador = 1;
	private final int id;
	private Date data;
	private String endereco;
	private Condutor condutor;
	private Seguro seguro;
	
	public Sinistro() {
		this.id = contador;
		contador++;
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

	public Condutor getCondutor() {
		return condutor;
	}

	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
	}

	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		String condutorStr = "";
		if (condutor == null) {
			condutorStr = "O condutor foi o Titular do Seguro.";
		}
		else {
			condutorStr = condutor.toString();
		}
		
		
		
		String str = "Numero de identificacao | " + id + "\n"
				   + "Data da ocorrencia      | " + sdf.format(data) + "\n"
				   + "Endereco da ocorrencia  | " + endereco + "\n"
				   + "-- DADOS DO CONDUTOR --\n"
				   + condutorStr + "\n"
				   + "-- DADOS DO SEGURO --\n"
				   + seguro.toString();
		
		return str;
				   
	}
}
