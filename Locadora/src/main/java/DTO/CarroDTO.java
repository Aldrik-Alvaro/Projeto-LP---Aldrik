package DTO;

public class CarroDTO {
	
	
	
	private String placa; 
	private String cor; 
	private String marca;
	private String preco;
	
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	
	public CarroDTO (String placa, String cor, String marca,String preco) {
				this.placa=placa;
				this.cor=cor;
				this.marca=marca;
			    this.preco=preco;
		}
	}
	
	

