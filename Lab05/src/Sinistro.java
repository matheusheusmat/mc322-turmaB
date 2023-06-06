import java.text.SimpleDateFormat;
import java.util.Date;

public class Sinistro {
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
