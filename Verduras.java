package model;


public class Verduras extends Item {
	
	private boolean hidroponica;
	private String variedade;
	private float quantidade;

	public Verduras(String nome, float valor, int codigo) {
		super(nome, valor, codigo);
	}

	public double calcularValorVenda() {		
		return getValor() + (hidroponica ? 3 : 0) + 0.03f * quantidade;
	}

	public boolean isHidroponica() {
		return hidroponica;
	}

	public void setHidroponica(boolean hidroponica) {
		this.hidroponica = hidroponica;
	}

	public String getVariedade() {
		return variedade;
	}

	public void setVariedade(String variedade) {
		this.variedade = variedade;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) throws QuantidadeZeradaException {
		
		if(quantidade <= 0) {
			throw new QuantidadeZeradaException("Não possível calcular o valor de venda com a quantidade negativa ou zerada.");
		}
		
		this.quantidade = quantidade;
	}


	public float calcularVenda() {
	
		return 0;
	}
}