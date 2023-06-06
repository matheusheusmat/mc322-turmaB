import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	/* Classe "Main" for lab05.java by heusmat
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
	
	private static void printMenuInicial() {
		System.out.println("BEM VINDO AO SISTEMA DE SEGURADORAS");
		System.out.println("Ainda nao ha seguradoras cadastradas nesse sistema!");
		System.out.println("Para acessa-lo, cadastre a primeira seguradora.\n");
		System.out.println("-- Digite uma opcao e tecle ENTER --");
		MenuOperacoes opcoes[] = MenuOperacoes.values();
		System.out.println((opcoes[0]).getDescricao());
		System.out.println((opcoes[26]).getDescricao());
	}
	
	private static void printMenuPrincipal(String nomeSeguradora) {
		System.out.println("  | MENU PRINCIPAL - Seguradora " + nomeSeguradora);
		MenuOperacoes opcoes[] = MenuOperacoes.values();
		for (int i = 1; i < 9; i++) {
			System.out.println((opcoes[i]).getDescricao());
		}
		System.out.println((opcoes[26]).getDescricao());
	}
	
	private static void printSubCadastrar() {
		System.out.println("  | CADASTRAR");
		MenuOperacoes opcoes[] = MenuOperacoes.values();
		for (int i = 9; i < 12; i++) {
			System.out.println((opcoes[i]).getDescricao());
		}
		System.out.println((opcoes[25]).getDescricao());
	}
	
	private static void printSubListar() {
		System.out.println("  | VISUALIZAR");
		MenuOperacoes opcoes[] = MenuOperacoes.values();
		for (int i = 12; i < 16; i++) {
			System.out.println((opcoes[i]).getDescricao());
		}
		System.out.println((opcoes[25]).getDescricao());
	}
	
	private static void printSubSeguro() {
		System.out.println("  | GERENCIAR SEGURO");
		MenuOperacoes opcoes[] = MenuOperacoes.values();
		for (int i = 16; i < 21; i++) {
			System.out.println((opcoes[i]).getDescricao());
		}
		System.out.println((opcoes[25]).getDescricao());
	
	}
	
	private static void printSubFrota() {
		System.out.println("  | GERENCIAR FROTA");
		MenuOperacoes opcoes[] = MenuOperacoes.values();
		for (int i = 21; i < 25; i++) {
			System.out.println((opcoes[i]).getDescricao());
		}
		System.out.println((opcoes[25]).getDescricao());
	
	}
	
	private static boolean menuInicial(Scanner input) {
		boolean continua = true;
		boolean sair = false;
		while (continua) {
			printMenuInicial();
			String opcaoStr = input.nextLine();
			if (!Validacao.ehInteiro(opcaoStr) || !Validacao.ehIntervaloValido(opcaoStr, 0, 1)) {
				System.out.println("Opcao invalida! Selecione 1 ou 0!");
			}
			else {
				int opcaoInt = Integer.parseInt(opcaoStr);
				if (opcaoInt == 0)
					opcaoInt += 26;
				if (opcaoInt == 1)
					opcaoInt -= 1;
				MenuOperacoes opcao = lerOp(opcaoInt);
				switch (opcao) {
				case IN_CADASTRAR:
					Seguradora.cadastrarSeguradora(input);
					continua = false;
					break;
				case SAIR:
					sair = true;
					continua = false;
					break;
				default:
				}
			}
		}
		return sair;
	}
	
	
	private static void menuPrincipal(Scanner input) {
		boolean continua = true;
		Seguradora segAtual = (Seguradora.getListaSeguradoras()).get(0);
		
		while (continua) {
			printMenuPrincipal(segAtual.getNome());
			String opcaoStr = input.nextLine();
			if (!Validacao.ehInteiro(opcaoStr) || !Validacao.ehIntervaloValido(opcaoStr, 0, 8)) {
				System.out.println("Opcao invalida! Selecione de 1 a 8, ou 0 para sair!");
			}
			else {
				int opcaoInt = Integer.parseInt(opcaoStr);
				if (opcaoInt == 0)
					opcaoInt += 26;
				MenuOperacoes opcao = lerOp(opcaoInt);
				switch (opcao) {
				case PR_CADASTRAR:
					submenuCadastrar(input, segAtual);
					break;
				case PR_LISTAR:
					submenuListar(input, segAtual);
					break;
				case PR_SEGURO:
					submenuSeguro(input, segAtual);
					break;
				case PR_GER_FROTA:
					submenuFrota(input, segAtual);
					break;
				case PR_EXCLUIR:
					segAtual.excluirCliente(input);
					break;
				case PR_CALC_RECEITA:
					segAtual.calcularReceita();
					break;
				case PR_CADASTRAR_SEGURADORA:
					Seguradora.cadastrarSeguradora(input);
					break;
				case PR_TROCAR:
					segAtual = Seguradora.trocarSeguradora(input);
					break;
				case SAIR:
					System.out.println("-- Saindo ... --");
					continua = false;
					break;
				default:
					break;
				}
			}
		}
	}
	
	
	private static void submenuCadastrar(Scanner input, Seguradora seg) {
		boolean voltar = false;
		while (!voltar) {
			printSubCadastrar();
			String opcaoStr = input.nextLine();
			if (!Validacao.ehInteiro(opcaoStr) || !Validacao.ehIntervaloValido(opcaoStr, 0, 3)) {
				System.out.println("Opcao invalida! Selecione de 1 a 3, ou 0 para voltar!");
			}
			else {
				int opcaoInt = Integer.parseInt(opcaoStr);
				if (opcaoInt == 0)
					opcaoInt += 17;
				MenuOperacoes opcao = lerOp(opcaoInt + 8);
				switch (opcao) {
				case CAD_CLIENTE:
					System.out.println("** CADASTRAR CLIENTES **");
					System.out.println("-- Insira o tipo que deseja cadastrar e pressione ENTER: --");
					System.out.println("1 | Pessoa Fisica (PF)\n"
									 + "2 | Pessoa Juridica (PJ)");
					String inputAtual = input.nextLine();
					
					switch (inputAtual) {
					case "1":
						ClientePF clpf = ClientePF.criarClientePF(input);
						seg.cadastrarCliente(clpf);
						break;
					case "2":
						ClientePJ clpj = ClientePJ.criarClientePJ(input);
						seg.cadastrarCliente(clpj);
						break;
					default:
						System.out.println("-- ERRO: Tipo de cliente invalido! --\n");
						break;
					}
					break;
				case CAD_SEGURO:
					if (seg.cadastrarSeguro(input))
						System.out.println("-- Seguro cadastrado com sucesso! --\n");
					else
						System.out.println("-- Operacao cancelada. --\n");
					break;
				case CAD_VEICULO:
					seg.atualizarVeiculoPF(input);
					break;
				case VOLTAR:
					voltar = true;
					break;
				default:
				}
			}
		}
	}
	
	
	private static void submenuListar(Scanner input, Seguradora seg) {
		boolean voltar = false;
		while (!voltar) {
			printSubListar();
			String opcaoStr = input.nextLine();
			if (!Validacao.ehInteiro(opcaoStr) || !Validacao.ehIntervaloValido(opcaoStr, 0, 4)) {
				System.out.println("Opcao invalida! Selecione de 1 a 4, ou 0 para voltar!");
			}
			else {
				int opcaoInt = Integer.parseInt(opcaoStr);
				if (opcaoInt == 0)
					opcaoInt += 14;
				MenuOperacoes opcao = lerOp(opcaoInt + 11);
				switch (opcao) {
				case LIST_CLIENTES:
					System.out.println("** LISTAR CLIENTES **");
					System.out.println("-- Insira o tipo que deseja listar e pressione ENTER:");
					System.out.println("1 | Pessoas Fisicas (PF)\n"
									 + "2 | Pessoas Juridicas (PJ)");
					String inputAtual = input.nextLine();
					ArrayList<Cliente> listaClientesTipo = seg.listarClientes(inputAtual);
					
					if (listaClientesTipo.isEmpty())
						System.out.println("-- ERRO! Nenhum Cliente do tipo desejado foi cadastrado nessa Seguradora! --\n");
					break;
				case LIST_SEGURO_SEGURADORA:
					seg.listarTodosSeguros();
					break;
				case LIST_SEGURO_CLIENTE:
					System.out.println("** LISTAR SEGUROS DE UM CLIENTE **");
					ArrayList<Seguro> listaSegurosCliente = seg.listarSegurosPorCliente(input, "Seguros");
					if (listaSegurosCliente.isEmpty()) {
						break;
					}
					Validacao.listarTodos(listaSegurosCliente, "SEGURO");
					break;
				case LIST_SIN_CLIENTE:
					System.out.println("** LISTAR SINISTROS DE UM CLIENTE **");
					ArrayList<Sinistro> listaSinistrosCliente = seg.listarSinistrosPorCliente(input);
					if (listaSinistrosCliente.isEmpty()) {
						break;
					}
					Validacao.listarTodos(listaSinistrosCliente, "SINISTRO");
					break;
				case VOLTAR:
					voltar = true;
					break;
				default:
				}
			}
		}
	}
	
	private static void submenuSeguro(Scanner input, Seguradora seg) {
		boolean voltar = false;
		System.out.println("** GERENCIAR SEGURO **");
		
		if (seg.getListaSeguros().isEmpty()) {
			System.out.println("-- ERRO! Nenhum Seguro foi cadastrado nessa Seguradora! --\n");
			return;
		}
		
		Validacao.listarTodos(seg.getListaSeguros(), "SEGURO");
		System.out.println("-- Digite o numero correspondente ao Seguro que deseja gerenciar");
		System.out.println("na lista apresentada acima e tecle ENTER, ou \"0\" para "
						 + "cancelar a operacao. --");
		String inputAtual = input.nextLine();
		
		if (inputAtual.equals("0"))
			return;
		
		while (!Validacao.ehInteiro(inputAtual) || !Validacao.ehIntervaloValido(inputAtual, 1, seg.getListaSeguros().size())) {
			 System.out.println("-- ERRO! Numero invalido. Selecione algum da lista apresentada");
			 System.out.println("ou \"0\" para cancelar a operacao. --");
			 inputAtual = input.nextLine();
			 System.out.println("");
			 if (inputAtual.equals("0"))
				 return;
		}
		
		Seguro seguro = seg.getListaSeguros().get(Integer.parseInt(inputAtual) - 1);
		
		while (!voltar) {
			printSubSeguro();
			String opcaoStr = input.nextLine();
			if (!Validacao.ehInteiro(opcaoStr) || !Validacao.ehIntervaloValido(opcaoStr, 0, 5)) {
				System.out.println("Opcao invalida! Selecione de 1 a 5, ou 0 para voltar!");
			}
			else {
				int opcaoInt = Integer.parseInt(opcaoStr);
				if (opcaoInt == 0)
					opcaoInt += 10;
				MenuOperacoes opcao = lerOp(opcaoInt + 15);
				switch (opcao) {
				case SEG_AUT_CONDUTOR:
					seguro.autorizarCondutor(input);
					break;
				case SEG_DESAUT_CONDUTOR:
					if (seguro.desautorizarCondutor(input))
						System.out.println("-- Condutor removido do Seguro com sucesso! --\n");
					else
						System.out.println("-- Operacao cancelada. --\n");
					break;
				case SEG_GERAR_SINISTRO:
					if (seguro.gerarSinistro(input))
						System.out.println("-- Sinistro gerado com sucesso! --\n");
					else
						System.out.println("-- Operacao cancelada. --\n");
					break;
				case SEG_CALC_VALOR:
					double valor = seguro.calcularValor();
					System.out.printf("-- Esse seguro possui o valor de %.2f mensais. --\n\n", valor);
					break;
				case SEG_CANCELAR:
					seg.cancelarSeguro(input, seguro);
					System.out.println("-- Seguro cancelado com sucesso! --\n");
					break;
				case VOLTAR:
					voltar = true;
					break;
				default:
				}
			}
		}
	}
	
	private static void submenuFrota(Scanner input, Seguradora seg) {
		boolean voltar = false;
		System.out.println("** GERENCIAR FROTA **");
		
		ArrayList<Cliente> listaClientesPJ = seg.listarClientes("2");
		
		
		if (listaClientesPJ.isEmpty()) {
			System.out.println("-- ERRO! Nenhum Cliente PJ foi cadastrado nessa Seguradora! --\n");
			return;
		}
		
		System.out.println("-- Digite o numero correspondente ao Cliente para o qual");
		System.out.println("deseja gerenciar Frotas na lista apresentada acima e tecle ENTER,");
		System.out.println("ou \"0\" para cancelar a operacao. --");
		String inputAtual = input.nextLine();
		
		if (inputAtual.equals("0"))
			return;
		
		while (!Validacao.ehInteiro(inputAtual) || !Validacao.ehIntervaloValido(inputAtual, 1, listaClientesPJ.size())) {
			 System.out.println("-- ERRO! Numero invalido. Selecione algum da lista apresentada");
			 System.out.println("ou \"0\" para cancelar a operacao. --");
			 inputAtual = input.nextLine();
			 System.out.println("");
			 if (inputAtual.equals("0"))
				 return;
		}
		
		Cliente cl = listaClientesPJ.get(Integer.parseInt(inputAtual) - 1);
		ClientePJ clpj = (ClientePJ)cl;
		
		while (!voltar) {
			printSubFrota();
			String opcaoStr = input.nextLine();
			if (!Validacao.ehInteiro(opcaoStr) || !Validacao.ehIntervaloValido(opcaoStr, 0, 4)) {
				System.out.println("Opcao invalida! Selecione de 1 a 4, ou 0 para voltar!");
			}
			else {
				int opcaoInt = Integer.parseInt(opcaoStr);
				if (opcaoInt == 0)
					opcaoInt += 5;
				MenuOperacoes opcao = lerOp(opcaoInt + 20);
				switch (opcao) {
				case FR_CADASTRAR:
					clpj.cadastrarFrota(input);
					break;
				case FR_ATUALIZAR:
					clpj.atualizarFrota(input);
					break;
				case FR_LISTAR:
					clpj.getVeiculosPorFrota(input);
					break;
				case FR_EXCLUIR:
					clpj.removerFrota(input);
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
		boolean sair = menuInicial(input);
		if (!sair)
			menuPrincipal(input);
		else
			System.out.println("-- Saindo... --");
	}
}
