package model;

import java.util.ArrayList;
import java.util.List;

public class TesteSolicitacao {

	public static void main(String[] args) {
		
		Legumes chuchu = new Legumes("Chuchu", 10, 111);
		try {
			chuchu.setVariedade("Branco");
			chuchu.setPeso(1.500);
			chuchu.setCortado(false);
		} catch (PesoZeradoException e) {
			System.out.println(e.getMessage());
		}
		
		Frutas banana = new Frutas("Banana", 4, 999);
		try {
			banana.setCortada(true);
			banana.setVariedade("Caturra");
			banana.setPeso(3.800);
		} catch (PesoZeradoException e) {
			System.out.println(e.getMessage());
		}

		Verduras alface = new Verduras("Alface", 6, 432);
		try {
			alface.setHidroponica(true);
			alface.setVariedade("Mimosa");
			alface.setQuantidade(123);
		} catch (QuantidadeZeradaException e) {
			System.out.println(e.getMessage());
		}
		

		List<Item> listaSacolao = new ArrayList<Item>();		
		listaSacolao.add(chuchu);
		listaSacolao.add(banana);
		listaSacolao.add(alface);


		Cliente cliente = new Cliente("Samuel", "Marcolino", "samuel@marcolino.com.br");
		
		Solicitacao sacolao = new Solicitacao();
		sacolao.setDescricaoItem("Sacolão do dia!");
		sacolao.setWeb(true);
		sacolao.setCliente(cliente);
		sacolao.setItem(listaSacolao);
		
	}
}