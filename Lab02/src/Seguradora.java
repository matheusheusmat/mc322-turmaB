public class Seguradora {
    
    private String nome;      // Declaração dos atributos da classe Seguradora, todos privados:
    private String telefone;  // nome (String), telefone (String), email (String) e endereco (String).
    private String email;
    private String endereco;
    
    public Seguradora(String nome, String telefone, String email, String endereco) { //Construtor
    	/* Construtor de um objeto da classe Seguradora. */
    	
    	this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }
    
    public String getNome() {
    	/* Getter que retorna a String nome. */ 
    	
    	return nome; 
    }
    
    public String getTelefone() {
    	/* Getter que retorna a String telefone. */ 
    	
        return telefone;
    }
    
    public String getEmail() {
    	/* Getter que retorna a String email. */ 
    	
        return email;
    }
    
    public String getEndereco() {
    	/* Getter que retorna a String endereco. */ 
    	
        return endereco;
    }
    
    public void setNome(String nome) {
    	/*  Setter que altera o valor da String nome. */
    	
        this.nome = nome;
    }
    
    public void setTelefone(String telefone) {
    	/* Setter que altera o valor da String telefone. */
    	
        this.telefone = telefone; 
    }
    
    public void setEmail(String email) {
    	/* Setter que altera o valor da String email. */
    	
        this.email = email;
    }
    
    public void setEndereco(String endereco) {
    	/* Setter que altera o valor da String endereco. */
    	
        this.endereco = endereco;
    }
    
    public String toString() {
    	/* Organiza uma String com os dados de um objeto da classe Seguradora, para
    	 * sua posterior impressão.
    	*/
    	
    	String str = "-- Dados da seguradora --" + "\nNome: " + this.getNome() +
    	"\nTelefone: " + this.getTelefone() +
    	"\nEmail: " + this.getEmail() +
    	"\nEndereco: " + this.getEndereco();
    	return str;
    }
    
    
    
    
    
    
    
}