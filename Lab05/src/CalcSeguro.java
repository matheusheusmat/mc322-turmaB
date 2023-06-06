public enum CalcSeguro {
	/* Enum "CalcSeguro"
	 * Constantes: 
	 VALOR_BASE
	 FATOR_18_30
	 FATOR_30_60
	 FATOR_60_90

	 * Variáveis:
	 - (final) String descricao
	 
	 * Construtor para a classe
	 
	 * Getter para a descricao.
	 */
	
	VALOR_BASE(10.0),
	FATOR_18_30(1.25),
	FATOR_30_60(1.0),
	FATOR_60_90(1.5);
	
	private final double fator;
	
	CalcSeguro(double fator) {
		this.fator = fator;
	}
	
	public double getFator() {
		return fator;
	}
}
