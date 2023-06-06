import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public abstract class Seguro {
/* Classe abstrata "Seguro"
 * Variáveis de classe:
 - static int contador
 * Variáveis de instância:
 - Date dataInicio
 - Date dataFim
 - Seguradora seguradora
 - int qtdSinistrosCliente
 - int qtdSinistrosCondutor
 - ArrayList<Sinistro> listaSinistros
 - ArrayList<Condutor> listaCondutores
 - double valorMensal
 
 * Getters e setters para cada variável.
 
 * Construtor para a classe.
	 
 * Métodos de classe abstratos:
 + public abstract boolean autorizarCondutor(Scanner input)

 + public abstract boolean desautorizarCondutor(Scanner input)

 + public abstract boolean gerarSinistro(Scanner input)

 + public abstract double calcularValor()

 + public abstract String toString()
 */
	
	
	private static int contador = 1;
	private final int id;
	private Date dataInicio;
	private Date dataFim;
	private Seguradora seguradora;
	private int qtdSinistrosCliente = 0;
	private int qtdSinistrosCondutor = 0;
	private ArrayList<Sinistro> listaSinistros;
	private ArrayList<Condutor> listaCondutores;
	private double valorMensal;
	
	public Seguro() {
		this.id = contador;
		contador++;
		this.listaSinistros = new ArrayList<Sinistro>();
		this.listaCondutores = new ArrayList<Condutor>();
	}

	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Seguro.contador = contador;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Seguradora getSeguradora() {
		return seguradora;
	}

	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}

	public int getQtdSinistrosCliente() {
		return qtdSinistrosCliente;
	}

	public void setQtdSinistrosCliente(int qtdSinistrosCliente) {
		this.qtdSinistrosCliente = qtdSinistrosCliente;
	}

	public int getQtdSinistrosCondutor() {
		return qtdSinistrosCondutor;
	}

	public void setQtdSinistrosCondutor(int qtdSinistrosCondutor) {
		this.qtdSinistrosCondutor = qtdSinistrosCondutor;
	}

	public ArrayList<Sinistro> getListaSinistros() {
		return listaSinistros;
	}

	public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
		this.listaSinistros = listaSinistros;
	}

	public ArrayList<Condutor> getListaCondutores() {
		return listaCondutores;
	}

	public void setListaCondutores(ArrayList<Condutor> listaCondutores) {
		this.listaCondutores = listaCondutores;
	}

	public double getValorMensal() {
		return valorMensal;
	}

	public void setValorMensal(double valorMensal) {
		this.valorMensal = valorMensal;
	}

	public int getId() {
		return id;
	}
	
	public abstract boolean autorizarCondutor(Scanner input);
	
	public abstract boolean desautorizarCondutor(Scanner input);
	
	public abstract boolean gerarSinistro(Scanner input);
	
	public abstract double calcularValor();
	
	public abstract String toString();
}
