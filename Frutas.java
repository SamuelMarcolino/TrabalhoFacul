package model;



public class Frutas extends Item {

	private boolean cortada;
	private double peso;
	private String variedade; 
	
	public Frutas(String nome, double valor, int codigo) {
		super (nome, valor, codigo);
	}


	@Override
	public double calcularValorVenda() {
		return getValor() + (cortada ? 5 : 0) + 0.01f * peso;
	}
	
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(cortada ? "Cortada" : "Inteira");
		sb.append(";");
		sb.append(peso);
		sb.append(";");
		sb.append(variedade);
		sb.append(";");
		sb.append(calcularValorVenda());
		
		return sb.toString();
	}

	public boolean isCortada() {
		return cortada;
	}

	public void setCortada(boolean cortada) {
		this.cortada = cortada;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double tamanho) throws PesoZeradoException {
		
		if(tamanho <= 0) {
			throw new PesoZeradoException("Impossível calcular o valor de venda com o peso negativo ou zerado.");
		}
		
		
	}

	public String getVariedade() {
		return variedade;
	}

	public void setVariedade(String variedade) {
		this.variedade = variedade;
	}



	public float calcularVenda() {

		return 0;
	}
}