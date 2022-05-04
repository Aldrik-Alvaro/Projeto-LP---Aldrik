package com.example.view;


import java.io.IOException;
import java.util.ArrayList;

import DTO.CarroDTO;
import DTO.ClienteDTO;
import DTO.MotoDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloController {

	
	
	@FXML
    private AnchorPane geral;

    @FXML
    private TextField txtnome;

    @FXML
    private TextField txtcpf;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txttel;

    @FXML
    private TextField txtplaca;

    @FXML
    private TextField txtcor;

    @FXML
    private TextField txtpreco;

    @FXML
    private TextField txtmarca;


    @FXML
    private TextField txtmarcam;

    @FXML
    private TextField txtcorm;

    @FXML
    private TextField txtprecom;

    @FXML
    private TextField txtano;

    @FXML
    void btnCadastrar(ActionEvent event) {
    	
    	String nome = this.txtnome.getText();
    	String cpf = this.txtcpf.getText();
    	String telefone = this.txttel.getText();
    	String email = this.txtemail.getText();
    	
    	
    	ClienteDTO objClienteDTO = new ClienteDTO (nome, cpf,telefone,email);
    	objClienteDTO.setNome(nome);
    	objClienteDTO.setCpf(cpf);
    	objClienteDTO.setTelefone(telefone);
    	objClienteDTO.setEmail(email);
    	
    	ArrayList<String> Cliente = new ArrayList<String>();
    	Cliente.add(nome);
    	Cliente.add(cpf);
    	Cliente.add(telefone);        
    	Cliente.add(email); 
    	
        System.out.println("A lista de cadastro do Cliente:" + Cliente);
    	System.out.println(objClienteDTO.getNome());
    	System.out.println(objClienteDTO.getCpf());
    	System.out.println(objClienteDTO.getTelefone());
    	System.out.println(objClienteDTO.getEmail());
    }
    

    @FXML
    void btnCadastrarcarro(ActionEvent event) {
    	String placa = this.txtplaca.getText();
    	String cor = this.txtcor.getText();
    	String marca = this.txtmarca.getText();
        String preco = this.txtpreco.getText();
    	
    	
    	CarroDTO objCarroDTO = new CarroDTO( placa,cor,marca,preco);
    	objCarroDTO.setPlaca(placa);
    	objCarroDTO.setCor(cor);
    	objCarroDTO.setMarca(marca);
    	objCarroDTO.setPreco(preco);
    	
    	ArrayList<String> Carro = new ArrayList<String>();
    	Carro.add(placa);
    	Carro.add(cor);
    	Carro.add(marca);        
    	Carro.add(preco); 
    	
        System.out.println("A lista de cadastro do Carro:" +Carro);
    	System.out.println(objCarroDTO.getPlaca());
    	System.out.println(objCarroDTO.getCor());
    	System.out.println(objCarroDTO.getMarca());
    	System.out.println(objCarroDTO.getPreco());
    }
    
    @FXML
    void btnCadastrarmoto(ActionEvent event) {
    	String marca = this.txtmarcam.getText();
    	String cor = this.txtcorm.getText();
    	String ano = this.txtano.getText();
    	String preco = this.txtprecom.getText();
    	
    	
    	MotoDTO objMotoDTO  = new MotoDTO(marca, cor, ano,preco);
    	objMotoDTO.setMarca(marca);
    	objMotoDTO.setCor(cor);
    	objMotoDTO.setAno(ano);
    	objMotoDTO.setPreco(preco);
    	
    	ArrayList<String> Moto = new ArrayList<String>();
    	Moto.add(ano);
    	Moto.add(cor);
    	Moto.add(marca);        
    	Moto.add(preco); 
    	
        System.out.println("A lista de cadastro da Moto:"+ Moto);
    	System.out.println(objMotoDTO.getMarca());
    	System.out.println(objMotoDTO.getCor());
    	System.out.println(objMotoDTO.getAno());
    	System.out.println(objMotoDTO.getPreco());
    }
    @FXML
    void btnCarro(ActionEvent event) throws IOException{
     
    	FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Carro.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load(), 426, 170);
        Stage stage = new Stage();
        stage.setTitle("Cadastro de Carro");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void btnMoto(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Moto.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load(), 426, 190);
        Stage stage = new Stage();
        stage.setTitle("Cadastro de Moto");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

}
