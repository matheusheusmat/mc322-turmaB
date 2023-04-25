import java.util.Scanner;
import java.util.Date;


/* Classe "Main" for lab03.java by heusmat
 * Métodos:
 + void menuInicial(): imprime o menu com as opções.
 + boolean validarData(String dataStr): verifica se a data dada na entrada é válida, 
 seguindo o modelo DD/MM/AAAA.
 + Date formatarData(String dataStr, Scanner input): dada uma String, retorna uma data 
 formatada do modo desejado, se for possível.
 + Seguradora criarSeguradora(Scanner input): cria uma instância da classe Seguradora.
 + ClientePF criarClientePF(Scanner input): cria uma instância da classe ClientePF, e
 adiciona-a à listaClientes da Seguradora.
 + ClientePJ criarClientePJ(Scanner input): cria uma instância da classe ClientePJ, e
 adiciona-a à listaCliente da Seguradora.
 */

public class Main {
	public static void menuInicial() {
		System.out.println("-- Digite o numero da opcao desejada --");
		System.out.println("1 - Cadastro de Novo Cliente para Pessoas Físicas");
		System.out.println("2 - Cadastro de Novo Cliente para Pessoas Jurídicas");
		System.out.println("3 - Cadastro de Veiculo para Cliente");
		System.out.println("4 - Cadastro de Sinistro");
		System.out.println("5 - Listar clientes da Seguradora");
		System.out.println("6 - Listar veiculos de Cliente");
		System.out.println("7 - Visualizar sinistros de Cliente");
		System.out.println("8 - Listar todos os sinistros da Seguradora");
		System.out.println("9 - Remover cliente da Seguradora");
		System.out.println("0 - Sair do sistema");
	}
	
	
	public static boolean validarData(String dataStr) {
		String dataSoNum = dataStr.replaceAll("[^0-9]", "");
		if (dataStr.length() != 10 || dataSoNum.length() != 8 ||
		dataStr.charAt(2) != '/' || dataStr.charAt(5) != '/') {
			System.out.println("-- ERRO! Data invalida! Escreva novamente conforme o modelo: DD/MM/AAAA\n"
								   + "(exemplo, Nove de Março de 1999 - 09/03/1999): --");
			return false; 
		}
		return true;
	}
	
	
	public static Date formatarData(String dataStr, Scanner input) {
		boolean dataValida = validarData(dataStr);
		while (!dataValida) {
			dataStr = input.nextLine();
			dataValida = validarData(dataStr);
		}
		
		int dia = Integer.parseInt(dataStr.substring(0, 2));
		int mes = Integer.parseInt(dataStr.substring(3, 5));
		int ano = Integer.parseInt(dataStr.substring(6, 10));

		Date data = new Date(ano - 1900, mes - 1, dia);
		return data;
	}
	
	
	public static Seguradora criarSeguradora(Scanner input) {
		Seguradora seg = new Seguradora(null, null, null, null);
		
		System.out.print("Nome da Seguradora: ");
		String inputAtual = input.nextLine();
		seg.setNome(inputAtual);
		
		System.out.print("Telefone da Seguradora: ");
		inputAtual = input.nextLine();
		seg.setTelefone(inputAtual);
		
		System.out.print("E-mail da Seguradora: ");
		inputAtual = input.nextLine();
		seg.setEmail(inputAtual);
		
		System.out.print("Endereco da Seguradora: ");
		inputAtual = input.nextLine();
		seg.setEndereco(inputAtual);
		
		System.out.println("Seguradora cadastrada com sucesso!\n");
		return seg;
	}
	
	
	public static ClientePF criarClientePF(Scanner input) {
		System.out.print("Nome do Cliente: ");
		String inputAtual = input.nextLine();
		
		System.out.print("CPF do Cliente: ");
		String cpf = input.nextLine();
		boolean cpfValido = ClientePF.validarCPF(cpf);
		while(!cpfValido) {
			System.out.print("CPF invalido! Insira novamente: ");
			cpf = input.nextLine();
			cpfValido = ClientePF.validarCPF(cpf);
		}
		
		ClientePF cl = new ClientePF(inputAtual, null, cpf, null, null, null, null, null);
		
		System.out.println("Data de nascimento, na forma DD/MM/AAAA\n"
						   + "(exemplo, Nove de Março de 1999 - 09/03/1999):");
		inputAtual = input.nextLine();
		Date data = formatarData(inputAtual, input);
		cl.setDataNascimento(data);
		
		System.out.println("Data da licenca de motorista, na forma DD/MM/AAAA\n"
						   + "(exemplo, Vinte e oito de Julho de 2021 - 28/07/2021):");
		inputAtual = input.nextLine();
		data = formatarData(inputAtual, input);
		cl.setDataLicenca(data);
		
		System.out.print("Endereco: ");
		inputAtual = input.nextLine();
		cl.setEndereco(inputAtual);
		
		System.out.print("Nivel de escolaridade: ");
		inputAtual = input.nextLine();
		cl.setEducacao(inputAtual);
		
		System.out.print("Genero: ");
		inputAtual = input.nextLine();
		cl.setGenero(inputAtual);
		
		System.out.print("Classe economica: ");
		inputAtual = input.nextLine();
		cl.setClasseEconomica(inputAtual);
		
		System.out.println("-- Cliente cadastrado com sucesso! --\n");
		return cl;
	}
	
	
	public static ClientePJ criarClientePJ(Scanner input) {
		System.out.print("Nome da Empresa: ");
		String inputAtual = input.nextLine();
		
		System.out.print("CNPJ da Empresa: ");
		String cnpj = input.nextLine();
		boolean cnpjValido = ClientePJ.validarCNPJ(cnpj);
		while (!cnpjValido) {
			System.out.print("CNPJ invalido! Insira novamente: ");
			cnpj = input.nextLine();
			cnpjValido = ClientePJ.validarCNPJ(cnpj);
		}
		
		ClientePJ cl = new ClientePJ(inputAtual, null, cnpj, null);
		
		System.out.print("Endereco: ");
		inputAtual = input.nextLine();
		cl.setEndereco(inputAtual);
		
		System.out.println("Data de fundacao da empresa, na forma DD/MM/AAAA\n"
						 + "(exemplo, 01 de Agosto de 2011 - 01/08/2011):");
		
		inputAtual = input.nextLine();
		
		Date data = formatarData(inputAtual, input);
		cl.setDataFundacao(data);
		
		System.out.println("-- Empresa cadastrada com sucesso! --\n");
		return cl;
	}
	
	
	public static void main(String[] args) {
		System.out.println("-- Bem-vindo ao Sistema de Seguros --");
		Scanner input = new Scanner(System.in);
		
		Seguradora seg = criarSeguradora(input);
		
		boolean continua = true;
		
		while (continua) {
			menuInicial();
			String opcao = input.nextLine();
			switch(opcao) {
				case "1":
					System.out.println("-- Cadastro de Novo Cliente PF --\n");
					ClientePF clpf = criarClientePF(input);
					seg.cadastrarCliente(clpf);
					break;
				case "2":
					System.out.println("-- Cadastro de Novo Cliente PJ --\n");
					ClientePJ clpj = criarClientePJ(input);
					seg.cadastrarCliente(clpj);
					break;
				case "3":
					System.out.println("-- Cadastro de Veiculo para Cliente --\n");
					seg.cadastrarVeiculo(input);
					break;
				case "4":
					System.out.println("-- Cadastro de Sinistro --\n");
					seg.gerarSinistro(input);
					break;
				case "5":
					System.out.println("-- Listar clientes da Seguradora --\n");
					System.out.println("Tipo do Cliente que deseja listar (PF / PJ): ");
					String tipoCliente = input.nextLine();
					seg.listarClientes(tipoCliente);
					break;
				case "6":
					System.out.println("-- Listar veiculos de Cliente --\n");
					System.out.print("Insira o nome do cliente ou da empresa cliente: ");
					String nomeCliente = input.nextLine();
					seg.listarVeiculos(nomeCliente);	
					break;
				case "7":
					System.out.println("-- Visualizar sinistros de um Cliente --\n");
					System.out.print("Insira o nome do cliente ou da empresa cliente: ");
					nomeCliente = input.nextLine();
					seg.visualizarSinistro(nomeCliente);
					break;
				case "8":
					System.out.println("-- Listar todos os sinistros da Seguradora --\n");
					seg.listarSinistros();
					break;
				case "9":
					System.out.println("-- Remover cliente da Seguradora --\n");
					System.out.print("Insira o nome do cliente ou da empresa cliente: ");
					nomeCliente = input.nextLine();
					seg.removerCliente(nomeCliente);
					break;
				case "0":
					System.out.println("-- Sair do sistema --");
					continua = false;
					break;
				default:
					System.out.println("-- ERRO: Opcao invalida. Escolha uma opcao de 1 a 9, ou 0 para sair: -- ");
			}
		}
	}
	
	
}
