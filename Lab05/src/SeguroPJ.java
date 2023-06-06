import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SeguroPJ extends Seguro {
 /* Classe "SeguroPF" herda de "Seguro"
 * Variáveis de instância:
 - Veiculo veiculo
 - ClientePF cliente
 
 * Getters e setters para cada variável.
 
 * Construtor para a classe.
	 
 * Métodos de classe:
 
 + public boolean autorizarCondutor(Scanner input): instancia e adiciona um Condutor na
 listaCondutores do Seguro.

 + public boolean desautorizarCondutor(Scanner input): imprime todos os condutores da
 listaCondutores, caso existam. Pede ao usuário que escolha um para remover da lista.

 + public boolean gerarSinistro(Scanner input): instancia e adiciona um Sinistro, tanto na
 listaSinistros do Seguro quanto na listaSinistros do Condutor envolvido.

 + public double calcularValor(): realiza o cálculo do valorMensal do Seguro, de acordo com
 uma fórmula específica. 

 + public String toString(): Retorna uma String com alguns dos atributos de instância.
 */

	private Frota frota;
	private ClientePJ cliente;
	
	public SeguroPJ() {
		super();
	}

	public Frota getFrota() {
		return frota;
	}

	public void setFrota(Frota frota) {
		this.frota = frota;
	}

	public ClientePJ getCliente() {
		return cliente;
	}

	public void setCliente(ClientePJ cliente) {
		this.cliente = cliente;
	}

	public static SeguroPJ criarSeguroPJ(Scanner input, ClientePJ cl, Frota fr, Seguradora seg) {
		SeguroPJ seguroPJ = new SeguroPJ();
		
		seguroPJ.setCliente(cl);
		seguroPJ.setFrota(fr);
		seguroPJ.setSeguradora(seg);
		
		System.out.println("Data de inicio da vigencia do seguro, na forma DD/MM/AAAA\n"
				   		 + "(exemplo, Nove de Março de 2022 - 09/03/2022):");
		String inputAtual = input.nextLine();
		Date dataInicio = Validacao.formatarData(inputAtual, input);
		seguroPJ.setDataInicio(dataInicio);
		
		System.out.println("Data de fim da vigencia do seguro, na forma DD/MM/AAAA\n"
					     + "(exemplo, Quinze de Abril de 2026 - 15/04/2026):");
		inputAtual = input.nextLine();
		Date dataFim = Validacao.formatarData(inputAtual, input);
		
		while (!Validacao.inicioAntesDoFim(dataInicio, dataFim)) {
			System.out.println("-- ERRO! A data de fim informada eh anterior a data de\n"
							 + "inicio! Insira novamente, na forma DD/MM/AAAA: --");
			inputAtual = input.nextLine();
			dataFim = Validacao.formatarData(inputAtual, input);
		}
		
		seguroPJ.setDataFim(dataFim);
		
		return seguroPJ;
	}
	
	@Override
	public boolean autorizarCondutor(Scanner input) {
		System.out.println("** AUTORIZAR UM CONDUTOR **");
		
		System.out.print("Nome do Condutor: ");
		String inputAtual = input.nextLine();
		boolean apenasLetras = Validacao.apenasLetras(inputAtual);
		while (!apenasLetras) {
			System.out.println("Atencao! O nome deve conter apenas letras.");
			System.out.print("Insira novamente: ");
			inputAtual = input.nextLine();
			apenasLetras = Validacao.apenasLetras(inputAtual);
		}
		
		System.out.print("CPF do Condutor: ");
		String cpf = input.nextLine();
		boolean cpfValido = Validacao.validarCPF(cpf);
		while(!cpfValido) {
			System.out.print("CPF invalido! Insira novamente: ");
			cpf = input.nextLine();
			cpfValido = Validacao.validarCPF(cpf);
		}
		
		Condutor cond = new Condutor(inputAtual, cpf);
		
		System.out.println("Data de nascimento, na forma DD/MM/AAAA\n"
						   + "(exemplo, Nove de Março de 1999 - 09/03/1999):");
		inputAtual = input.nextLine();
		Date data = Validacao.formatarData(inputAtual, input);
		int idade = Validacao.calcularIdade(data);
		while (idade < 18) {
			System.out.println("Idade invalida! O Condutor deve ser maior de 18 anos.");
			System.out.print("Insira novamente: ");
			inputAtual = input.nextLine();
			data = Validacao.formatarData(inputAtual, input);
			idade = Validacao.calcularIdade(data);
		}
		cond.setDataNascimento(data);
		cond.setIdade(idade);
		
		System.out.print("Endereco: ");
		inputAtual = input.nextLine();
		cond.setEndereco(inputAtual);
		
		System.out.print("Telefone: ");
		inputAtual = input.nextLine();
		cond.setTelefone(inputAtual);
		
		System.out.print("E-mail: ");
		inputAtual = input.nextLine();
		cond.setEmail(inputAtual);
		
		System.out.println("-- Condutor cadastrado com sucesso! --\n");
		this.getListaCondutores().add(cond);
		return true;
	}

	@Override
	public boolean desautorizarCondutor(Scanner input) {
		System.out.println("** DESAUTORIZAR CONDUTOR **"); 
		if (this.getListaCondutores().isEmpty()){
			System.out.println("-- ERRO! Nao ha Condutores cadastrados nesse Seguro! --");
			return false;
		}
		
		Validacao.listarTodos(getListaCondutores(), "CONDUTOR");
		
		System.out.println("-- Digite o numero correspondente ao Condutor que deseja remover");
		System.out.println("na lista apresentada acima e tecle ENTER, ou \"0\" para "
						 + "cancelar a operacao. --");
		String inputAtual = input.nextLine();
		
		if (inputAtual.equals("0"))
			return false;
		
		while (!Validacao.ehInteiro(inputAtual) || !Validacao.ehIntervaloValido(inputAtual, 1, this.getListaCondutores().size())) {
			 System.out.println("-- ERRO! Numero invalido. Selecione algum da lista apresentada");
			 System.out.println("ou \"0\" para cancelar a operacao. --");
			 inputAtual = input.nextLine();
			 System.out.println("");
			 if (inputAtual.equals("0"))
				 return false;
		}
		
		this.getListaCondutores().remove(Integer.parseInt(inputAtual) - 1);
		
		return true;
	}

	@Override
	public boolean gerarSinistro(Scanner input) {
		System.out.println("** GERAR SINISTRO DE SEGURO **");
		System.out.println("-- O ocorrido aconteceu com o Titular do Seguro ou com um");
		System.out.println("dos Condutores por ele autorizados? Digite uma das opcoes e");
		System.out.println("aperte ENTER, ou \"0\" para cancelar. --");
		System.out.println("1 | Titular do Seguro");
		System.out.println("2 | Condutor Autorizado");
		
		String inputAtual = input.nextLine();
		
		if (inputAtual.equals("0"))
			return false;
		
		while (!Validacao.ehInteiro(inputAtual) || !Validacao.ehIntervaloValido(inputAtual, 1, 2)) {
			 System.out.println("-- ERRO! Numero invalido. Selecione algum da lista apresentada");
			 System.out.println("ou \"0\" para cancelar a operacao. --");
			 inputAtual = input.nextLine();
			 System.out.println("");
			 if (inputAtual.equals("0"))
				 return false;
		}
		
		if (inputAtual.equals("1")) {
			Sinistro sin = new Sinistro();
			sin.setCondutor(null);
			sin.setSeguro(this);
			
			System.out.print("Data do ocorrido, no formato DD/MM/AAAA: ");
			inputAtual = input.nextLine();
			Date data = Validacao.formatarData(inputAtual, input);
			sin.setData(data);
			
			System.out.print("Endereco do ocorrido: ");
			inputAtual = input.nextLine();
			sin.setEndereco(inputAtual);
			
			this.setQtdSinistrosCliente(getQtdSinistrosCliente() + 1);
			this.getListaSinistros().add(sin);
			return true;
		}
		
		else {
			if (this.getListaCondutores().isEmpty()) {
				System.out.println("-- ERRO! Nao ha Condutores cadastrados nesse Seguro! --");
				return false;
			}
			
			Validacao.listarTodos(getListaCondutores(), "CONDUTOR");
			
			System.out.println("-- Digite o numero correspondente ao Condutor ao qual deseja");
			System.out.println("associar o Sinistro na lista apresentada acima e tecle ENTER,\n"
							 + "ou \"0\" para cancelar a operacao. --");
			inputAtual = input.nextLine();
			
			if (inputAtual.equals("0"))
				return false;
			
			while (!Validacao.ehInteiro(inputAtual) || !Validacao.ehIntervaloValido(inputAtual, 1, this.getListaCondutores().size())) {
				 System.out.println("-- ERRO! Numero invalido. Selecione algum da lista apresentada");
				 System.out.println("ou \"0\" para cancelar a operacao. --");
				 inputAtual = input.nextLine();
				 System.out.println("");
				 if (inputAtual.equals("0"))
					 return false;
			}
			
			Condutor cond = this.getListaCondutores().get(Integer.parseInt(inputAtual) - 1);
			
			Sinistro sin = new Sinistro();
			sin.setCondutor(cond);
			sin.setSeguro(this);
			
			System.out.print("Data do ocorrido, no formato DD/MM/AAAA: ");
			inputAtual = input.nextLine();
			Date data = Validacao.formatarData(inputAtual, input);
			sin.setData(data);
			
			System.out.print("Endereco do ocorrido: ");
			inputAtual = input.nextLine();
			sin.setEndereco(inputAtual);
			
			this.getListaSinistros().add(sin);
			cond.getListaSinistros().add(sin);
			this.setQtdSinistrosCondutor(getQtdSinistrosCondutor() + 1);
			return true;
		}
	}

	@Override
	public double calcularValor() {
		ClientePJ cl = this.getCliente();
		int qtdFunc = cl.getQtdFuncionarios();
		int anosFund = cl.getIdade();
		int qtdVeic = frota.getQtdVeiculos();
		
		double valor = (CalcSeguro.VALOR_BASE.getFator()) * (10 + (double)qtdFunc / 10)
					 * (1 + 1 / ((double)qtdVeic + 2))
					 * (1 + 1 / ((double)anosFund + 2))
					 * (2 + (double)this.getQtdSinistrosCliente() / 10)
					 * (5 + (double)this.getQtdSinistrosCondutor() / 10);
		
		return valor;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Cliente cl = this.getCliente();
		ClientePJ clpj = (ClientePJ)cl;
		Frota fr = this.getFrota();
		
		String str = "Numero de Identificacao    | " + this.getId() + "\n"
				   + "Tipo                       | Seguro PJ" + "\n"  
				   + "Data de Inicio da Vigencia | " + sdf.format(this.getDataInicio()) + "\n"
				   + "Data de Fim da Vigencia    | " + sdf.format(this.getDataFim()) + "\n"
				   + "-- DADOS DO CLIENTE --\n"
				   + "Nome da Empresa | " + clpj.getNome() + "\n"
				   + "CNPJ            | " + clpj.getCnpj() + "\n"
				   + "-- DADOS DA FROTA --\n"
				   + "Codigo           | " + fr.getCode() + "\n"
				   + "Qtd. de Veiculos | " + fr.getQtdVeiculos();
		return str;
	}
}
