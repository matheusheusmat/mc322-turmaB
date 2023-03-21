public class Cliente {
    
    private String nome;
    private String cpf;
    private String dataNascimento;
    private int idade;
    private String endereco;
    
    public Cliente(String nome, String cpf, String dataNascimento, int idade, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.endereco = endereco;
    }
    
    String getNome() {
        return nome;
    }

    String getCpf() {
        return cpf;
    }
    
    String getDataNascimento() {
        return dataNascimento;
    }
    
    int getIdade() {
        return idade;
    }
    
    String getEndereco() {
        return endereco;
    }
    
    void setNome(String nome) {
        this.nome = nome;
    }
    
    void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    void setIdade(int idade) {
        this.idade = idade;
    }
    
    void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    
    
    public boolean validarCPF(String cpf) {
    	String cpfSoNum = cpf.replaceAll("[^0-9]", ""); // Verificar se não tem 11 digitos
    	if (cpfSoNum.length() != 11) 
    		return false;
    	
    	for (int i = 0; i < 11; i++) { // Verificar se digitos são todos iguais
    		char digAtual = cpfSoNum.charAt(i);
    		if (i == 10)
    			return false;
    		char digProx = cpfSoNum.charAt(i + 1);
    		if (digAtual != digProx)
    			break;
    	}
    	
    	int primDigVer;
    	int soma = 0; // Cálculo de digito verificador
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
    		return false;
    	
    	int segDigVer;
    	soma = 0; // Cálculo de digito verificador
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
    		return false;
    	return true;
    }
    
    public String toString() {
    	String str = "-- Dados do cliente --" + "\nNome: " + this.getNome() +
    	"\nCPF: " + this.getCpf() +
    	"\nData de Nascimento: " + this.getDataNascimento() +
    	"\nIdade: " + this.getIdade() +
    	"\nEndereco: " + this.getEndereco();
    	return str;
    }
}
