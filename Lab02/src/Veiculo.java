public class Veiculo {
    
    private String placa; // Declaração dos atributos da classe Veiculo, todos privados:
    private String marca; // placa (String), marca (String) e modelo (String).
    private String modelo;
    
    public Veiculo(String placa, String marca, String modelo) {
        /* Construtor de um objeto da classe Veiculo. */
    	
    	this.placa = placa; 
        this.marca = marca;
        this.modelo = modelo;
    }
    
    public String getPlaca() {
    	/* Getter que retorna a String placa. */
    	
    	return placa; 
    }
    
    public String getMarca() {
    	/* Getter que retorna a String marca. */
    	
        return marca;
    }
    
    public String getModelo() {
    	/* Getter que retorna a String modelo. */
    	
        return modelo;
    }
    
    public void setPlaca(String placa) {
    	/*  Setter que altera o valor da String placa. */
    	
        this.placa = placa;
    }
    
    public void setMarca(String marca) {
    	/*  Setter que altera o valor da String marca. */
    	
        this.marca = marca;
    }
    
    public void setModelo(String modelo) {
    	/*  Setter que altera o valor da String modelo. */
    	
        this.modelo = modelo;
    }
    
    public String toString() { 
    	/* Organiza uma String com os dados de um objeto da classe Veiculo, para
    	 * sua posterior impressão.
    	*/
    	
    	String str = "-- Dados do veículo --" + "\nPlaca: " + this.getPlaca() +
    	"\nMarca: " + this.getMarca() +
    	"\nModelo: " + this.getModelo();
    	return str;
    }
}