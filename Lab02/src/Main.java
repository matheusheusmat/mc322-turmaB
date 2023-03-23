import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		/* Método main, que cria os objetos e realiza a leitura do usuário para
		 * cada atributo.
		 * 
		 * São criados:
		 * - Objeto da classe Cliente (cliente1), com os atributos nome (String),
		 * dataNascimento (String), idade (int), endereco (String) e cpf (String).
		 * - Objeto da classe Seguradora (seg1), com os atributos nome (String),
		 * telefone (String), email (String) e endereco (String).
		 * - Objeto da classe Veiculo (veiculo1), com os atributos placa (String),
		 * marca (String) e modelo (String).
		 * - Objeto da classe Sinistro (sin1), com os atributos id (int), data
		 * (String) e endereco (String).
		 * 
		 * Há uma verificação do CPF atribuido a um objeto da classe Cliente.
		 * Também, há um gerador de id aleatório para um objeto da classe Sinistro.
		 * 
		 * Ao fim, são impressos os dados de forma organizada, de acordo com a função
		 * toString() de cada classe.
		 * */
		
		Scanner input = new Scanner(System.in);
		
		System.out.println(" -- Cadastro de cliente -- ");
		System.out.print("Insira o nome completo: ");
		String nomeStr = input.nextLine();
		System.out.print("Data de nascimento na forma DD/MM/AAAA: ");
		String dataStr = input.nextLine();
		System.out.print("Idade: ");
		int idadeInt = Integer.parseInt(input.nextLine());
		System.out.print("Endereço: ");
		String enderecoStr = input.nextLine();
		System.out.print("Numero de CPF: ");
		String cpfStr = input.nextLine();
		Cliente cliente1 = new Cliente(nomeStr, cpfStr, dataStr, idadeInt, enderecoStr);
		
		boolean cpfValido = cliente1.validarCPF(cliente1.getCpf());
		while (!cpfValido) {
			System.out.print("Numero de CPF invalido! Insira novamente: ");
			cpfStr = input.nextLine();
			cpfValido = cliente1.validarCPF(cpfStr);
		}
		cliente1.setCpf(cpfStr);
		
		System.out.println("-- Cadastro de Seguradora --");
		System.out.print("Insira o nome da seguradora: ");
		nomeStr = input.nextLine();
		System.out.print("Telefone para contato: ");
		String telStr = input.nextLine();
		System.out.print("E-mail da seguradora: ");
		String emailStr = input.nextLine();
		System.out.print("Endereco da seguradora: ");
		enderecoStr = input.nextLine();
		Seguradora seg1 = new Seguradora(nomeStr, telStr, emailStr, enderecoStr);
		
		
		System.out.println("-- Cadastro de Veículo --");
		System.out.print("Insira a placa do veículo na forma LLL-NLNN: ");
		String placaStr = input.nextLine();
		System.out.print("Marca do veículo: ");
		String marcaStr = input.nextLine();
		System.out.print("Modelo do veículo: ");
		String modeloStr = input.nextLine();
		Veiculo veiculo1 = new Veiculo(placaStr, marcaStr, modeloStr);
		
		System.out.println("-- Cadastro de Sinistro --");
		System.out.print("Data da ocorrência na forma DD/MM/AAAA: ");
		dataStr = input.nextLine();
		System.out.print("Endereço da ocorrência: ");
		enderecoStr = input.nextLine();
		Sinistro sin1 = new Sinistro(0, dataStr, enderecoStr);
		sin1.gerarId();
		
		
		System.out.println(cliente1.toString() + "\n");
		System.out.println(seg1.toString() + "\n");
		System.out.println(veiculo1.toString() + "\n");
		System.out.println(sin1.toString());

		input.close();
	}
}
