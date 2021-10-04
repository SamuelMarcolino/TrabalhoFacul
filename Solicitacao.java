package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Solicitacao {

	private String descricaoItem;
	private LocalDateTime data;
	private boolean web;
	private Cliente cliente;
	private List<Item> item;


	
	public Solicitacao(String campos, String campos2, String campos3) {
		// TODO Auto-generated constructor stub
	}

	public Solicitacao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		StringBuilder sb = new StringBuilder();
		sb.append(descricaoItem);
		sb.append(";");
		sb.append(data.format(formato));
		sb.append(";");
		sb.append(web ? "web" : "loja");
		sb.append(";");
		sb.append(cliente.toString());
		sb.append(";");
		if(item != null) {
			sb.append(item.size());
		}
		
		return sb.toString();
	}
	
	public boolean isWeb() {
		return web;
	}
	public void setWeb(boolean web) {
		this.web = web;
	}
	public String getDescricaoItem() {
		return descricaoItem;
	}
	public void setDescricaoItem(String descricaoItem) {
		this.descricaoItem = descricaoItem;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}
}
