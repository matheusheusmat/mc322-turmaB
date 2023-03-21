
public class Main {
	public static void main(String[] args) {
		Cliente cliente1 = new Cliente("Matheus Ponte", "766.335.860-01", "09/01/2003",
				 20, "Jose Cantusio, 73");
		boolean cpfValido = cliente1.validarCPF(cliente1.getCpf());
		if (!cpfValido) {
			System.out.println("CPF Invalido! Insira novamente.");
		}
		System.out.println(cliente1.toString());
		
		Seguradora seg1 = new Seguradora("SegCamp", "27918155", "segcamp@gmail.com",
										 "Rua Saturnino de Brito, 99");
		System.out.println(seg1.toString());
		
		Veiculo veiculo1 = new Veiculo("ABC1D23", "General Motors", "Celta");
		System.out.println(veiculo1.toString());
		
		Sinistro sinistro1 = new Sinistro(0, "12/12/2023", "Avenida Brasil");
		System.out.println(sinistro1.toString());
	}
}
