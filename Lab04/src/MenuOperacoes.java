
/* Enum "MenuOperacoes"
 * Constantes: 
 * Para o menu inicial:
 - SAIR
 - CADASTRAR
 - LISTAR
 - EXCLUIR
 - GERAR_SINISTRO
 - TRANSFERIR_SEGURO
 - CALCULAR_RECEITA
 
 * Para o submenu Cadastrar:
 - CADASTRAR_CLIENTE
 - CADASTRAR_VEICULO
 - CADASTRAR_SEGURADORA
 
 * Para o submenu Listar:
 - LISTAR_CLIENTE
 - LISTAR_SINISTROS_SEG
 - LISTAR_SINISTROS_CL
 - LISTAR_VEICULO_CL
 - LISTAR_VEICULO_SEG
 
 * Para o submenu Excluir:
 - EXCLUIR_CLIENTE
 - EXCLUIR_VEICULO
 - EXCLUIR_SINISTRO

 * Comum aos submenus:
 - VOLTAR

 * Variáveis:
 - (final) String descricao
 
 * Construtor para a classe
 
 * Getter para a descricao.
 */


public enum MenuOperacoes {
	// Menu inicial
	SAIR("0 | Sair do Sistema"),										       //0
	CADASTRAR("1 | Cadastrar Novo Cliente / Veiculo / Seguradora"),			   //1				    
	LISTAR("2 | Visualizar Clientes / Veiculos / Sinistros"),				   //2				     
	EXCLUIR("3 | Excluir Clientes / Veiculos / Sinistros da Seguradora"),	   //3						     	 
	GERAR_SINISTRO("4 | Gerar Novo Sinistro"),					               //4
	TRANSFERIR_SEGURO("5 | Transferir Seguro de um Cliente a outro"),          //5
	CALCULAR_RECEITA("6 | Calcular Receita Total de Seguradora"),              //6
									     
	// Submenu Cadastrar
	CADASTRAR_CLIENTE("1 | Cadastrar Novo Cliente PF/PJ"),       //7
	CADASTRAR_VEICULO("2 | Cadastrar Novo Veiculo"),		     //8
	CADASTRAR_SEGURADORA("3 | Cadastrar Nova Seguradora"),		 //9
	
	// Submenu Listar
	LISTAR_CLIENTE("1 | Listar Cliente PF/PJ por Seguradora"),   //10
	LISTAR_SINISTROS_SEG("2 | Listar Sinistros por Seguradora"), //11
	LISTAR_SINISTROS_CL("3 | Listar Sinistro por Cliente"),      //12
	LISTAR_VEICULO_CL("4 | Listar Veiculo por Cliente"),         //13
	LISTAR_VEICULO_SEG("5 | Listar Veiculo por Seguradora"),     //14
	
	// Submenu Excluir
	EXCLUIR_CLIENTE("1 | Excluir Cliente"),				         //15
	EXCLUIR_VEICULO("2 | Excluir Veiculo"),					     //16
	EXCLUIR_SINISTRO("3 | Excluir Sinistro"),				     //17
	
	// Voltar
	VOLTAR("0 | Voltar ao Menu Inicial");						 //18
	
	
	private final String descricao;
	
	MenuOperacoes(String descricao) {
		this.descricao = descricao;	
	}
	
	public String getDescricao() {
		return descricao;
	}
}
	

