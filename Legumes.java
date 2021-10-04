package model;

public class Legumes extends Item {
	
	private double peso;
	private boolean cortado;
	private String variedade;

	public Legumes(String nome, double valor, int codigo) {
		super(nome, valor, codigo);
	}

	@Override
	public double calcularValorVenda() {
		return getValor() + (cortado ? 5 : 0) + 0.01f * peso;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(peso);
		sb.append(";");
		sb.append(cortado ? "Cortado" : "Inteiro");
		sb.append(";");
		sb.append(variedade);
		sb.append(";");
		sb.append(calcularValorVenda());
		
		return sb.toString();
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) throws PesoZeradoException {
		
		if(peso <= 0) {
			throw new PesoZeradoException("Impossível calcular o valor de venda com o peso negativo ou zerado.");
		}
		
		this.peso = peso;
	}

	public boolean isCortado() {
		return cortado;
	}

	public void setCortado(boolean cortado) {
		this.cortado = cortado;
	}

	public String getVariedade() {
		return variedade;
	}

	public void setVariedade(String variedade) {
		this.variedade = variedade;
	}

	@Override
	public float calcularVenda() {
		return 0;
	}

}