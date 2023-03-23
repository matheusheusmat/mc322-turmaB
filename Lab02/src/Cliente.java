public class Cliente {
    
    private String nome; 			// Declaração dos atributos da classe Cliente, todos privados:
    private String cpf;				// nome (String), cpf (String), dataNascimento (String),
    private String dataNascimento;  // idade (int) e endereco (String).
    private int idade;
    private String endereco;
    
    public Cliente(String nome, String cpf, String dataNascimento, int idade, String endereco) {
    	/* Construtor de um objeto da classe Cliente. */
    	
    	this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.endereco = endereco;
    }
    
    String getNome() {
    	/* Getter que retorna a String nome. */ 
    	
        return nome;
    }

    String getCpf() {
    	/* Getter que retorna a String cpf. */ 
    	
        return cpf;
    }
    
    String getDataNascimento() {
    	/* Getter que retorna a String dataNascimento. */ 
    	
        return dataNascimento;
    }
    
    int getIdade() {
    	/* Getter que retorna o int idade. */ 
    	
        return idade;
    }
    
    String getEndereco() {
    	/* Getter que retorna a String endereco. */ 
    	
        return endereco;
    }
    
    void setNome(String nome) {
    	/*  Setter que altera o valor da String nome. */
    	
        this.nome = nome;
    }
    
    void setCpf(String cpf) {
    	/*  Setter que altera o valor da String cpf. */
    	
        this.cpf = cpf;
    }
    
    void setDataNascimento(String dataNascimento) {
    	/*  Setter que altera o valor da String dataNascimento. */
    	
        this.dataNascimento = dataNascimento;
    }
    
    void setIdade(int idade) {
    	/*  Setter que altera o valor do int idade. */
    	
        this.idade = idade;
    }
    
    void setEndereco(String endereco) {
    	/*  Setter que altera o valor da String endereco. */
    	
        this.endereco = endereco;
    }
    
    public boolean validarCPF(String cpf) {
    	/* Método que verifica se o CPF inserido para o cliente criado é
    	 * ou não válido, com base nos critérios descritos abaixo.
    	 * */
    	
    	String cpfSoNum = cpf.replaceAll("[^0-9]", ""); // Verificar se tem 11 dígitos numéricos.
    	if (cpfSoNum.length() != 11) 					// Se não, retorna falso: CPF inválido.
    		return false;
    	
    	for (int i = 0; i < 11; i++) { 					// Verifica se os dígitos são todos iguais.
    		char digAtual = cpfSoNum.charAt(i);
    		if (i == 10)
    			return false; 							// Se chegar no último, retorna falso: CPF inválido.
    		char digProx = cpfSoNum.charAt(i + 1);
    		if (digAtual != digProx) 					// Um número do CPF é sempre comparado com o dígito
    			break;				 					// subsequente. Caso forem iguais, a checagem continua.
    	}
    	
    	int primDigVer;
    	int soma = 0; 									// Cálculo de primeiro dígito verificador.
    	for (int i = 0; i < 9; i++) {
    		soma += (10 - i) * Character.getNumericValue(cpfSoNum.charAt(i));
    	}
    	int resto = soma % 11;
    	if (resto == 0 || resto == 1) {
    		primDigVer = 0;
    	}
    	else
    		primDigVer = 11 - resto;
    	if (primDigVer != Character.getNumericValue(cpfSoNum.charAt(9)))
    		return false;								// Se o dígito calculado é diferente do presente, retorna
    													// falso: CPF inválido.
    	int segDigVer;									// Cálculo de segundo dígito verificador.
    	soma = 0; 										
    	for (int i = 0; i < 10; i++) {
    		soma += (11 - i) * Character.getNumericValue(cpfSoNum.charAt(i));
    	}
    	resto = soma % 11;
    	if (resto == 0 || resto == 1) {
    		segDigVer = 0;
    	}
    	else
    		segDigVer = 11 - resto;
    	if (segDigVer != Character.getNumericValue(cpfSoNum.charAt(10)))
    		return false;								// Se o dígito calculado é diferente do presente, retorna
    													// falso: CPF inválido.
    	return true; 									// Se passar pelas verificações, o CPF é válido.
    }
    
    public String toString() {
    	/* Organiza uma String com os dados de um objeto da classe Cliente, para
    	 * sua posterior impressão.
    	*/
    	
    	String str = "\n-- Dados do cliente --" + "\nNome: " + this.getNome() +
    	"\nCPF: " + this.getCpf() +
    	"\nData de Nascimento: " + this.getDataNascimento() +
    	"\nIdade: " + this.getIdade() +
    	"\nEndereco: " + this.getEndereco();
    	return str;
    }
}
