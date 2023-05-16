import java.util.Scanner;

public class Main {

	/* Classe "Main" for lab03.java by heusmat
	 * Métodos:
	 - static MenuOperacoes lerOp(int opcaoInt): lê o número inserido pelo usuário, e
	 retorna a descrição presente na opção correspondente na classe enum MenuOperacoes.
	 - static void printMenuInicial: imprime as descrições correspondentes ao menuInicial.
	 - static void printSubCadastar: imprime as descrições correspondentes ao submenuCadastrar.
	 - static void printSubListar: imprime as descrições correspondentes ao submenuListar.
	 - static void printSubExcluir: imprime as descrições correspondentes ao submenuExcluir.
	 - static void menuInicial: lê do usuário, chama a opção desejada do MenuOperacoes e chama o
	método condizente com a selecionada. 
	 - static void submenuCadastrar: lê do usuário, chama a opção desejada do MenuOperacoes e chama o
	método condizente com a selecionada.
	 - static void submenuListar: lê do usuário, chama a opção desejada do MenuOperacoes e chama o
	método condizente com a selecionada.
	 - static void submenuExcluir: lê do usuário, chama a opção desejada do MenuOperacoes e chama o
	método condizente com a selecionada.
	 */
	
	private static MenuOperacoes lerOp(int opcaoInt) {
		MenuOperacoes opcaoMenu = (MenuOperacoes.values())[opcaoInt];
		return opcaoMenu;
	}
	
	private static void printMenuInicial(){
		System.out.println("  | MENU INICIAL");
		MenuOperacoes opcoes[] = MenuOperacoes.values();
		for (int i = 0; i < 7; i++) {
			System.out.println((opcoes[i]).getDescricao());
		}
	}
	
	private static void printSubCadastrar() {
		System.out.println("  | CADASTRAR");
		MenuOperacoes opcoes[] = MenuOperacoes.values();
		for (int i = 7; i < 10; i++) {
			System.out.println((opcoes[i]).getDescricao());
		}
		System.out.println((opcoes[18]).getDescricao());
	}
	
	private static void printSubListar() {
		System.out.println("  | VISUALIZAR");
		MenuOperacoes opcoes[] = MenuOperacoes.values();
		for (int i = 10; i < 15; i++) {
			System.out.println((opcoes[i]).getDescricao());
		}
		System.out.println((opcoes[18]).getDescricao());
	}
	
	private static void printSubExcluir() {
		System.out.println("  | EXCLUIR");
		MenuOperacoes opcoes[] = MenuOperacoes.values();
		for (int i = 15; i < 18; i++) {
			System.out.println((opcoes[i]).getDescricao());
		}
		System.out.println((opcoes[18]).getDescricao());
	}
	
	private static void menuInicial(Scanner input) {
		boolean continua = true;
		Seguradora seg;
		while (continua) {
			printMenuInicial();
			String opcaoStr = input.nextLine();
			if (!Validacao.ehInteiro(opcaoStr) || !Validacao.ehIntervaloValido(opcaoStr, 0, 6)) {
				System.out.println("Opcao invalida! Selecione de 1 a 6, ou 0 para sair!");
			}
			else {
				MenuOperacoes opcao = lerOp(Integer.parseInt(opcaoStr));
				switch (opcao) {
				case CADASTRAR:
					submenuCadastrar(input);
					break;
				case LISTAR:
					submenuListar(input);
					break;
				case EXCLUIR:
					submenuExcluir(input);
					break;
				case GERAR_SINISTRO:
					seg = Seguradora.encontrarSeguradora(input);
					if (seg != null) {
						System.out.println("\n-- Cadastro de Sinistro --");
						seg.gerarSinistro(input);
					}
					break;
				case TRANSFERIR_SEGURO:
					System.out.println("\n-- Transferencia de Seguro --");
					Seguradora.transferirSeguro(input);
					break;
				case CALCULAR_RECEITA:
					System.out.println("\n-- Calculo de Receita da Seguradora --");
					seg = Seguradora.encontrarSeguradora(input);
					if (seg != null) {
						seg.calcularReceita();
					}
					break;
				case SAIR:
					System.out.println("SAINDO...");
					continua = false;
					break;
				default:
					break;
				}
			}
		}
	}
	
	private static void submenuCadastrar(Scanner input) {
		boolean voltar = false;
		Seguradora seg;
		while (!voltar) {
			printSubCadastrar();
			String opcaoStr = input.nextLine();
			if (!Validacao.ehInteiro(opcaoStr) || !Validacao.ehIntervaloValido(opcaoStr, 0, 3)) {
				System.out.println("Opcao invalida! Selecione de 1 a 3, ou 0 para voltar!");
			}
			else {
				int opcaoInt = Integer.parseInt(opcaoStr);
				if (opcaoInt == 0)
					opcaoInt += 12;
				MenuOperacoes opcao = lerOp(opcaoInt + 6);
				switch (opcao) {
				case CADASTRAR_CLIENTE:
					System.out.println("\n-- Cadastro de Cliente --");
					seg = Seguradora.encontrarSeguradora(input);
					if (seg != null) {
						System.out.println("-- Deseja cadastrar Pessoa Fisica ou Juridica? --");
						System.out.print("Insira 'PF' ou 'PJ': ");
						String inputAtual = input.nextLine();
						switch (inputAtual) {
						case "pf":
						case "PF":
							System.out.println("\n-- Cadastro de Pessoa Fisica --");
							ClientePF clpf = ClientePF.criarClientePF(input);
							seg.cadastrarCliente(clpf);
							break;
						case "pj":
						case "PJ":
							System.out.println("\n-- Cadastro de Pessoa Juridica --");
							ClientePJ clpj = ClientePJ.criarClientePJ(input);
							seg.cadastrarCliente(clpj);
							break;
						default:
							System.out.println("-- ERRO: Tipo de cliente invalido! --");
						}
					}
					break;
				case CADASTRAR_VEICULO:
					System.out.println("\n-- Cadastro de Veiculo --");
					seg = Seguradora.encontrarSeguradora(input);
					if (seg != null) {
						Cliente cl = seg.encontrarCliente(input);
						if (cl != null) {
							cl.adicionarVeiculo(input);
						}
					}
					break;
				case CADASTRAR_SEGURADORA:
					System.out.println("\n-- Cadastro de Seguradora --");
					Seguradora.cadastrarSeguradora(input);
					break;
				case VOLTAR:
					voltar = true;
					break;
				default:
				}
			}
		}
	}
	
	private static void submenuListar(Scanner input) {
		boolean voltar = false;
		while (!voltar) {
			printSubListar();
			String opcaoStr = input.nextLine();
			if (!Validacao.ehInteiro(opcaoStr) || !Validacao.ehIntervaloValido(opcaoStr, 0, 5)) {
				System.out.println("Opcao invalida! Selecione de 1 a 5, ou 0 para voltar!");
			}
			else {
				int opcaoInt = Integer.parseInt(opcaoStr);
				if (opcaoInt == 0)
					opcaoInt += 9;
				MenuOperacoes opcao = lerOp(opcaoInt + 9);
				switch (opcao) {
				case LISTAR_CLIENTE:
					System.out.println("\n-- Listar todos os Clientes --");
					Seguradora seg = Seguradora.encontrarSeguradora(input);
					if (seg != null) {
						System.out.println("-- Deseja listar Pessoas Fisicas ou Juridicas? --");
						System.out.print("Insira 'PF' ou 'PJ': ");
						String inputAtual = input.nextLine();
						seg.listarClientes(inputAtual);
					}
					break;
				case LISTAR_SINISTROS_SEG:
					System.out.println("\n-- Listar todos os Sinistros da Seguradora --");
					seg = Seguradora.encontrarSeguradora(input);
					if (seg != null) {
						seg.listarSinistros();
					}
					break;
				case LISTAR_SINISTROS_CL:
					System.out.println("\n-- Listar Sinistros em nome de um Cliente --");
					seg = Seguradora.encontrarSeguradora(input);
					if (seg != null) {
						if ((seg.getListaSinistros()).isEmpty()) 
							System.out.println("-- ERRO! Nao ha sinistros cadastrados na seguradora. --");
						else {
							System.out.print("Insira o nome do cliente procurado: ");
							String inputAtual = input.nextLine();
							seg.visualizarSinistros(inputAtual);
						}
					}
					break;
				case LISTAR_VEICULO_CL:
					System.out.println("\n-- Listar Veiculos de um Cliente --");
					seg = Seguradora.encontrarSeguradora(input);
					if (seg != null) {
						Cliente cl = seg.encontrarCliente(input);
						if (cl != null)
							cl.listarVeiculos();
					}
					break;
				case LISTAR_VEICULO_SEG:
					System.out.println("\n-- Listar Veiculos cadastrados em Seguradora --");
					seg = Seguradora.encontrarSeguradora(input);
					if (seg != null) {
						seg.listarVeiculosSeg();
					}
					break;
				case VOLTAR:
					voltar = true;
					break;
				default:
				}
			}
		}
	}
	
	
	
	private static void submenuExcluir(Scanner input) {
		boolean voltar = false;
		Seguradora seg;
		while (!voltar) {
			printSubExcluir();
			String opcaoStr = input.nextLine();
			if (!Validacao.ehInteiro(opcaoStr) || !Validacao.ehIntervaloValido(opcaoStr, 0, 3)) {
				System.out.println("Opcao invalida! Selecione de 1 a 3, ou 0 para voltar!");
			}
			else {
				int opcaoInt = Integer.parseInt(opcaoStr);
				if (opcaoInt == 0)
					opcaoInt += 4;
				MenuOperacoes opcao = lerOp(opcaoInt + 14);
				switch (opcao) {
				case EXCLUIR_CLIENTE:
					System.out.println("\n-- Excluir um Cliente --");
					seg = Seguradora.encontrarSeguradora(input);
					if (seg != null) {
						Cliente cl = seg.encontrarCliente(input);
						if (cl != null)
							seg.excluirCliente(cl);
					}
					break;
				case EXCLUIR_VEICULO:
					System.out.println("\n-- Excluir um Veiculo de Cliente --");
					seg = Seguradora.encontrarSeguradora(input);
					if (seg != null) {
						Cliente cl = seg.encontrarCliente(input);
						if (cl != null)
							cl.excluirVeiculo(input);
					}
					break;
				case EXCLUIR_SINISTRO:
					System.out.println("\n-- Excluir um Sinistro da Seguradora --");
					seg = Seguradora.encontrarSeguradora(input);
					if (seg != null) {
						seg.excluirSinistro(input);
					}
					break;
				case VOLTAR:
					voltar = true;
					break;
				default:
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		menuInicial(input);
	}
}
