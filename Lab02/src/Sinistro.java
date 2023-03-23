import java.util.Random;

public class Sinistro {
    
	private int id; 		 // Declaração dos atributos da classe Sinistro, todos privados:
    private String data;     // int (id), data (String) e endereco (String).
    private String endereco;
    
    public Sinistro(int id, String data, String endereco) {
    	/* Construtor de um objeto da classe Sinistro. */
    	
    	this.id = id;
        this.data = data;
        this.endereco = endereco;
    }
    
    public int getId() {
    	/* Getter que retorna o int id. */ 
    	
        return id;
    }
    
    public String getData() {
    	/* Getter que retorna a String data. */ 
    	
        return data;
    }
    
    public String getEndereco() {
    	/* Getter que retorna a String endereco. */ 
    	
        return endereco;
    }
    
    public void setId(int id) {
    	/*  Setter que altera o valor do int id. */
    	
        this.id = id;
    }
    
    public void setData(String data) {
    	/*  Setter que altera o valor da String data. */
    	
        this.data = data;
    }
    
    public void setEndereco(String endereco) {
    	/*  Setter que altera o valor da String endereco. */
    	
        this.endereco = endereco;
    }
    
    public void gerarId() {
    	/* Método que gera um inteiro aleatório entre 0 e 10000, para servir
    	 * de código identificador de um objeto da classe Sinistro, sendo armazenado
    	 * no atributo "id" (int).
    	 * */
    	
    	Random aleat = new Random();
    	int novoId = aleat.nextInt(10000);
    	System.out.print(novoId);
    	this.setId(novoId);
    }
    
    
    public String toString() {
    	/* Organiza uma String com os dados de um objeto da classe Sinistro, para
    	 * sua posterior impressão.
    	*/
    	
    	String str = "-- Dados do sinistro --" + "\nID: " + this.getId() +
    	"\nData: " + this.getData() +
    	"\nEndereco: " + this.getEndereco();
    	return str;	
    }
}