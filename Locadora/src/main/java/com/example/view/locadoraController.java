package com.example.view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import modal.locadoraDAO;
import modal.locadoraDTO;

public class locadoraController implements Initializable {
	
	 @FXML
	    private TableColumn<locadoraDTO, String> col_carro_cor;

	    @FXML
	    private TableColumn<locadoraDTO, Integer> col_carro_id;

	    @FXML
	    private TableColumn<locadoraDTO, String> col_carro_marca;

	    @FXML
	    private TableColumn<locadoraDTO, String> col_carro_placa;

	    @FXML
	    private TableColumn<locadoraDTO, String> col_carro_preco;

	    @FXML
	    private TableColumn<locadoraDTO, String> col_cliente_cpf;

	    @FXML
	    private TableColumn<locadoraDTO, String> col_cliente_email;

	    @FXML
	    private TableColumn<locadoraDTO, Integer> col_cliente_id;

	    @FXML
	    private TableColumn<locadoraDTO, String> col_cliente_nome;

	    @FXML
	    private TableColumn<locadoraDTO, String> col_cliente_telefone;

	    @FXML
	    private TableColumn<locadoraDTO, String> col_moto_ano;

	    @FXML
	    private TableColumn<locadoraDTO, String> col_moto_cor;

	    @FXML
	    private TableColumn<locadoraDTO, Integer> col_moto_id;

	    @FXML
	    private TableColumn<locadoraDTO, String> col_moto_marca;

	    @FXML
	    private TableColumn<locadoraDTO, String> col_moto_preco;

	    @FXML
	    private AnchorPane geral1;

	    @FXML
	    private Tab tabCliente;

	    @FXML
	    private Tab tabMoto;

	    @FXML
	    private Tab tab_carro;

	    @FXML
	    private TableView<locadoraDTO> tableview_carro;

	    @FXML
	    private TableView<locadoraDTO> tableview_cliente;

	    @FXML
	    private TableView<locadoraDTO> tableview_moto;

	    @FXML
	    private TextField txt_carro_cor;

	    @FXML
	    private TextField txt_carro_marca;

	    @FXML
	    private TextField txt_carro_placa;

	    @FXML
	    private TextField txt_carro_preco;

	    @FXML
	    private TextField txt_cliente_cpf;

	    @FXML
	    private TextField txt_cliente_email;

	    @FXML
	    private TextField txt_cliente_nome;

	    @FXML
	    private TextField txt_cliente_telefone;

	    @FXML
	    private TextField txt_moto_ano;

	    @FXML
	    private TextField txt_moto_cor;

	    @FXML
	    private TextField txt_moto_marca;

	    @FXML
	    private TextField txt_moto_preço;
	    
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		///COMEÇO DO CODIGO///
	    
	    //private locadoraDTO dto;
	    private locadoraDAO dao;
	    
	    @Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
	    	dao = new locadoraDAO();
	    	
	    	col_cliente_id.setCellValueFactory(new PropertyValueFactory<>("cliente_id"));
	    	col_cliente_nome.setCellValueFactory(new PropertyValueFactory<>("cliente_nome"));
	    	col_cliente_cpf.setCellValueFactory(new PropertyValueFactory<>("cliente_cpf"));
	    	col_cliente_email.setCellValueFactory(new PropertyValueFactory<>("cliente_email"));
	    	col_cliente_telefone.setCellValueFactory(new PropertyValueFactory<>("cliente_telefone"));
	    	
	    	col_carro_id.setCellValueFactory(new PropertyValueFactory<>("carro_id"));
	    	col_carro_placa.setCellValueFactory(new PropertyValueFactory<>("carro_placa"));
	    	col_carro_marca.setCellValueFactory(new PropertyValueFactory<>("carro_marca"));
	    	col_carro_cor.setCellValueFactory(new PropertyValueFactory<>("carro_cor"));
	    	col_carro_preco.setCellValueFactory(new PropertyValueFactory<>("carro_preco"));
	    	
	    	col_moto_id.setCellValueFactory(new PropertyValueFactory<>("moto_id"));
	    	col_moto_marca.setCellValueFactory(new PropertyValueFactory<>("moto_marca"));
	    	col_moto_preco.setCellValueFactory(new PropertyValueFactory<>("moto_preco"));
	    	col_moto_cor.setCellValueFactory(new PropertyValueFactory<>("moto_cor"));
	    	col_moto_ano.setCellValueFactory(new PropertyValueFactory<>("moto_ano"));
		}
	    
	    ////////////////////////////////////
	    //CLIENTE
	    @FXML
	    void btn_cliente_cadastrar() {
	    	locadoraDTO cliente = new locadoraDTO();
			
			cliente.setCliente_nome(txt_cliente_nome.getText());
			cliente.setCliente_cpf(txt_cliente_cpf.getText());
			cliente.setCliente_email(txt_cliente_email.getText());
			cliente.setCliente_telefone(txt_cliente_telefone.getText());
		
			try {
				dao.cadastrar_cliente(cliente);
				exibiDialogoINFO("Cliente cadastrando com sucesso!");
				//btn_cad_limpar();
				txt_cliente_nome.clear();
				txt_cliente_cpf.clear();
				txt_cliente_email.clear();
				txt_cliente_telefone.clear();
				btn_cliente_pesquisar();
				
			} catch (Exception e) {
				// TODO: handle exception
				exibiDialogoERRO("ERRO! Falha ao cadastrar cliente.");
				e.printStackTrace();
			}
	    	

	    }

	    @FXML
	    void btn_cliente_pesquisar() {
	    	try {
	    		List<locadoraDTO> resultado =  dao.consultar_cliente();
	        	if(resultado.isEmpty()) {
	        		exibiDialogoINFO("Nenhum cliente encontrado!");
	        	}else {
	        		tableview_cliente.setItems(FXCollections.observableArrayList(resultado));
	        	}
			} catch (Exception e) {
				// TODO: handle exception
				exibiDialogoERRO("Falha ao realizar a consulta!");
				e.printStackTrace();
			}
	    }
	    
	    ////////////////////////////////////
	    //CARRO
	    @FXML
	    void btn_carro_cadastrar() {
	    	locadoraDTO carro = new locadoraDTO();
			
	    	carro.setCarro_placa(txt_carro_placa.getText());
	    	carro.setCarro_marca(txt_carro_marca.getText());
	    	carro.setCarro_cor(txt_carro_cor.getText());
	    	carro.setCarro_preco(txt_carro_preco.getText());
		
			try {
				dao.cadastrar_carro(carro);
				exibiDialogoINFO("Carro cadastrando com sucesso!");
				//btn_cad_limpar();
				txt_carro_placa.clear();
				txt_carro_marca.clear();
				txt_carro_cor.clear();
				txt_carro_preco.clear();
				btn_carro_pesquisar();
				
			} catch (Exception e) {
				// TODO: handle exception
				exibiDialogoERRO("ERRO! Falha ao cadastrar carro.");
				e.printStackTrace();
			}
	    	

	    }

	    
	    @FXML
	    void btn_carro_pesquisar() {
	    	try {
	    		List<locadoraDTO> resultado =  dao.consultar_carro();
	        	if(resultado.isEmpty()) {
	        		exibiDialogoINFO("Nenhum carro encontrado!");
	        	}else {
	        		tableview_carro.setItems(FXCollections.observableArrayList(resultado));
	        	}
			} catch (Exception e) {
				// TODO: handle exception
				exibiDialogoERRO("Falha ao realizar a consulta!");
				e.printStackTrace();
			}
	    }
	    
	   ////////////////////////////////////
	   //MOTO
	    @FXML
	    void btn_moto_cadastrar() {
	    	locadoraDTO moto = new locadoraDTO();
			
	    	moto.setMoto_marca(txt_moto_marca.getText());
	    	moto.setMoto_preco(txt_moto_preço.getText());
	    	moto.setMoto_cor(txt_moto_cor.getText());
	    	moto.setMoto_ano(txt_moto_ano.getText());
		
			try {
				dao.cadastrar_moto(moto);
				exibiDialogoINFO("Moto cadastrando com sucesso!");
				//btn_cad_limpar();
				txt_moto_marca.clear();
				txt_moto_preço.clear();
				txt_moto_cor.clear();
				txt_moto_ano.clear();
				btn_moto_pesquisar();
				
			} catch (Exception e) {
				// TODO: handle exception
				exibiDialogoERRO("ERRO! Falha ao cadastrar Moto.");
				e.printStackTrace();
			}

	    }

	    @FXML
	    void btn_moto_pesquisar() {
	    	try {
	    		List<locadoraDTO> resultado =  dao.consultar_moto();
	        	if(resultado.isEmpty()) {
	        		exibiDialogoINFO("Nenhum carro encontrado!");
	        	}else {
	        		tableview_moto.setItems(FXCollections.observableArrayList(resultado));
	        	}
			} catch (Exception e) {
				// TODO: handle exception
				exibiDialogoERRO("Falha ao realizar a consulta!");
				e.printStackTrace();
			}

	    }
	    
	    ///////////////////////////////////////////////////////////////////////////////////////////////////////
	    
	    //INFOS ERRO/SUCESSO
	    
	    private void exibiDialogoINFO(String informacao) {
	    	Alert alert = new Alert(AlertType.INFORMATION);
	    	alert.setTitle("Informação");
	    	alert.setHeaderText(null);
	    	alert.setContentText(informacao);
	    	
	    	alert.showAndWait();
	    	
	    }
	    
	     void exibiDialogoERRO(String erro) {
	    	Alert alert = new Alert(AlertType.ERROR);
	    	alert.setTitle("Informação");
	    	alert.setHeaderText(null);
	    	alert.setContentText(erro);
	    	
	    	alert.showAndWait();
	    	
	    }
	     

}
