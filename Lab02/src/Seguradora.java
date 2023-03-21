public class Seguradora {
    
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    
    public Seguradora(String nome, String telefone, String email, String endereco) { //Construtor
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getEndereco() {
        return endereco;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String toString() {
    	String str = "-- Dados da seguradora --" + "\nNome: " + this.getNome() +
    	"\nTelefone: " + this.getTelefone() +
    	"\nEmail: " + this.getEmail() +
    	"\nEndereco: " + this.getEndereco();
    	return str;
    }
    
    
    
    
    
    
    
}