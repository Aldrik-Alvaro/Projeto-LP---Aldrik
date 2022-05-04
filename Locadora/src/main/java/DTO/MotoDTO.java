package DTO;

public class MotoDTO {
	
	private String marca;
	private String cor;
	private String ano;
	private String preco;
	
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	
	public MotoDTO(String marca,String cor,String ano, String preco) {
		this.marca= marca;
		this.cor=cor;
		this.ano=ano;
		this.preco=preco;
	} 
	
}
