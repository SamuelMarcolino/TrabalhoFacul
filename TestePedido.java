package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestePedido {

	public static void main(String[] args) {
		
		String dir = "C:/dev/";
		String arq = "pedido.txt";
		
		try {
			
			try {
				FileReader file = new FileReader(dir+arq);				
				BufferedReader leitura = new BufferedReader(file);
				
				FileWriter fileW = new FileWriter(dir+"out_"+arq);
				BufferedWriter escrita = new BufferedWriter(fileW);
				
				String linha = null;
				String[] campos;
				
				linha = leitura.readLine();
				
				List<Item> item = new ArrayList<Item>();
				Solicitacao solicitacao = new Solicitacao();

				while(linha != null) {
					
					campos = linha.split(";");
					
					if(campos.length == 5) {
						Cliente cliente = new Cliente(
								campos[2], 
								campos[3], 
								campos[4]
							);

						solicitacao.setDescricaoItem(campos[0]);
						solicitacao.setWeb(Boolean.valueOf(campos[1]));
						solicitacao.setCliente(cliente);
					} else {
						switch (campos[0]) {
						case "F":
							Frutas frutas = new Frutas(
									campos[1],
									Float.valueOf(campos[2]), 
									Integer.valueOf(campos[3])
								);
							try {
								frutas.setCortada(Boolean.valueOf(campos[4]));
								frutas.setPeso(Float.valueOf(campos[5]));
								frutas.setVariedade(campos[6]);
								
								item.add(frutas);
							} catch ( PesoZeradoException e) {
								System.out.println(e.getMessage());
							}

							break;

						case "L":
							Legumes legumes = new Legumes(
									campos[1],
									Float.valueOf(campos[2]), 
									Integer.valueOf(campos[3])
								);
							try {
								legumes.setPeso(Float.valueOf(campos[4]));
								legumes.setCortado(Boolean.valueOf(campos[5]));
								legumes.setVariedade(campos[6]);
								
								item.add(legumes);
							} catch ( PesoZeradoException e) {
								System.out.println(e.getMessage());
							}

							break;

						case "V":
							Verduras verduras = new Verduras(
									campos[1],
									Float.valueOf(campos[2]), 
									Integer.valueOf(campos[3])
								);
							try {
								verduras.setHidroponica(Boolean.valueOf(campos[4]));
								verduras.setVariedade(campos[5]);
								verduras.setQuantidade(Float.valueOf(campos[6]));
								
								item.add(verduras);
							} catch ( QuantidadeZeradaException e) {
								System.out.println(e.getMessage());
							}	
							break;
							
						default:
							System.out.println("Pedido sem tipo!!!");
							break;
						}
					}					

					linha = leitura.readLine();
				}
				
				solicitacao.setItem(item);

				for(Item prod : solicitacao.getItem()) {
					escrita.write(
							solicitacao.getDescricaoItem()+";"+
							solicitacao.getCliente().getNome()+";"+
							prod.getNome()+";"+
							prod.calcularValorVenda()+"\r\n"
						);
				}

				leitura.close();
				file.close();
				
				escrita.close();
				fileW.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
		} finally {
			System.out.println("Processamento realizado!!!");
		}
	}
}