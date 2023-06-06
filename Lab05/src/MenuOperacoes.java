
/* Enum "MenuOperacoes"
 * Constantes: 
 * Para o menu inicial:
 IN_CADASTRAR
 
 * Para o menu principal:
 PR_CADASTRAR
 PR_LISTAR
 PR_SEGURO
 PR_GER_FROTA
 PR_EXCLUIR
 PR_CALC_RECEITA
 PR_CADASTRAR_SEGURADORA
 PR_TROCAR
 
 * Para o submenu cadastrar:
 CAD_CLIENTE
 CAD_SEGURO
 CAD_VEICULO
 
 * Para o submenu listar:
 LIST_CLIENTES
 LIST_SEGURO_SEGURADORA
 LIST_SEGURO_CLIENTE
 LIST_SIN_CLIENTE
 
 * Para o submenu seguro:
 SEG_AUT_CONDUTOR
 SEG_DESAUT_CONDUTOR
 SEG_GERAR_SINISTRO
 SEG_CALC_VALOR
 SEG_CANCELAR
 
 * Para o submenu frota:
 FR_CADASTRAR
 FR_ATUALIZAR
 FR_LISTAR
 FR_EXCLUIR
 
 * Comum aos menus e submenus:
 VOLTAR
 SAIR

 * Variáveis:
 - (final) String descricao
 
 * Construtor para a classe
 
 * Getter para a descricao.
 */


public enum MenuOperacoes {
	// Menu inicial
	IN_CADASTRAR("1 | Cadastrar nova Seguradora"), // 0 
	// SAIR
	
	// Menu principal
	PR_CADASTRAR("1 | Cadastrar - Novo Cliente, Seguro e cadastrar ou remover Veiculo"), // 1 Chama o submenu cadastrar
	PR_LISTAR("2 | Listar - Clientes, Seguros ou Sinistros"), // 2 Chama o submenu listar
	PR_SEGURO("3 | Gerenciar Seguro - Condutores, Novo Sinistro ou Consultar Valor"), // 3 Chama o submenu seguro
	PR_GER_FROTA("4 | Gerenciar Frotas - para Clientes PJ"),// 4
	PR_EXCLUIR("5 | Excluir Cliente da Seguradora"), // 5
	PR_CALC_RECEITA("6 | Calcular receita da Seguradora"), // 6
	PR_CADASTRAR_SEGURADORA("7 | Cadastrar nova Seguradora"), // 7
	PR_TROCAR("8 | Trocar Seguradora"), // 8
	// SAIR
	     
	// Submenu Cadastrar
	CAD_CLIENTE("1 | Cadastrar novo Cliente - Pessoa Física ou Jurídica"), // 9
	CAD_SEGURO("2 | Cadastrar novo Seguro - Pessoa Física ou Jurídica"), // 10
	CAD_VEICULO("3 | Cadastrar ou remover Veiculo - para Clientes PF"), // 11
	// VOLTAR
	
	// Submenu Listar
	LIST_CLIENTES("1 | Listar Clientes por tipo"), // 12
	LIST_SEGURO_SEGURADORA("2 | Listar todos os Seguros da Seguradora"), //13
	LIST_SEGURO_CLIENTE("3 | Listar Seguros por Cliente"), // 14
	LIST_SIN_CLIENTE("4 | Listar Sinistros por Cliente"), // 15
	// VOLTAR	
	
	// Submenu Seguro
	SEG_AUT_CONDUTOR("1 | Autorizar Condutor"), // 16
	SEG_DESAUT_CONDUTOR("2 | Desautorizar Condutor"), // 17
	SEG_GERAR_SINISTRO("3 | Gerar novo Sinistro"), // 18
	SEG_CALC_VALOR("4 | Calcular valor do Seguro"), // 19
	SEG_CANCELAR("5 | Cancelar Seguro"), // 20
	// VOLTAR
	
	// Submenu Frota
	FR_CADASTRAR("1 | Cadastrar nova Frota"), // 21
	FR_ATUALIZAR("2 | Atualizar Frota existente - Adicionar ou remover Veiculo"), // 22 Chama o submenu atualizar frota
	FR_LISTAR("3 | Listar Veiculos de uma Frota"), // 23
	FR_EXCLUIR("4 | Excluir Frota existente"), // 24
	// VOLTAR
	
	// Voltar e sair
	VOLTAR("0 | Voltar ao Menu Principal"), // 25
	SAIR("0 | Sair do Sistema"); // 26
	
	
	private final String descricao;
	
	MenuOperacoes(String descricao) {
		this.descricao = descricao;	
	}
	
	public String getDescricao() {
		return descricao;
	}
}
	