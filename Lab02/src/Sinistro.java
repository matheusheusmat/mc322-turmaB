public class Sinistro {
    private int id;
    private String data;
    private String endereco;
    
    public Sinistro(int id, String data, String endereco) {
        this.id = id;
        this.data = data;
        this.endereco = endereco;
    }
    
    public int getId() {
        return id;
    }
    
    public String getData() {
        return data;
    }
    
    public String getEndereco() {
        return endereco;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setData(String data) {
        this.data = data;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String toString() {
    	String str = "-- Dados do sinistro --" + "\nID: " + this.getId() +
    	"\nData: " + this.getData() +
    	"\nEndereco: " + this.getEndereco();
    	return str;	
    }
}