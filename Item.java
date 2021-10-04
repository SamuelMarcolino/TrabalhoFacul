package model;

public abstract class Item {
	private String nome;
	private double valor;
	private int codigo;
	
	public Item (String nome, double valor, int codigo) {
	
	}
	public abstract float calcularVenda();
	

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nome);
		sb.append(";");
		sb.append(valor);
		sb.append(";");
		sb.append(codigo);
		
		return sb.toString();
	}
	public String getNome() {
		return nome;
	}
	public double getValor () {
		return valor;
	}
	public int getCodigo() {
		return codigo;
	}
	public double calcularValorVenda() {
		return 0;
	}
}
