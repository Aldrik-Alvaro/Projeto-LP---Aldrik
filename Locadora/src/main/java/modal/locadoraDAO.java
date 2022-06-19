package modal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class locadoraDAO {

	
	//CONEXAO BANCO
	ConnectionFactory conn = new ConnectionFactory();
	PreparedStatement stm;
	
	
	//CADASTRAR / PESQUISAR -- CLIENTE
	public void cadastrar_cliente(locadoraDTO cliente) {
		
		String sql = "INSERT INTO cliente_locadora(nome, cpf, email, telefone) VALUES (?, ?, ?, ?)";
		
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			//PreparedStatement stm = connection.prepareStatement(sql);
			
			stm.setString(1, cliente.getCliente_nome());
			stm.setString(2, cliente.getCliente_cpf());
			stm.setString(3, cliente.getCliente_email());
			stm.setString(4, cliente.getCliente_telefone());
			
			stm.execute();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<locadoraDTO> consultar_cliente() {
		
		List<locadoraDTO> clientes = new ArrayList<>();
		
		String sql = "SELECT * FROM cliente_locadora";
		
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			ResultSet resultSet = stm.executeQuery();
			
			while (resultSet.next()){
			
				locadoraDTO cliente = new locadoraDTO();
				
				cliente.setCliente_id(resultSet.getInt("id_cliente"));
				cliente.setCliente_nome(resultSet.getString("nome"));
				cliente.setCliente_cpf(resultSet.getString("cpf"));
				cliente.setCliente_email(resultSet.getString("email"));
				cliente.setCliente_telefone(resultSet.getString("telefone"));

				clientes.add(cliente);
			}
			
			resultSet.close();
			stm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return clientes;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//CADASTRAR / PESQUISAR -- CARRO
	public void cadastrar_carro(locadoraDTO carro) {
		
		String sql = "INSERT INTO carro_locadora(placa, marca, cor, preco) VALUES (?, ?, ?, ?)";
		
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			//PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, carro.getCarro_placa());
			stm.setString(2, carro.getCarro_marca());
			stm.setString(3, carro.getCarro_cor());
			stm.setString(4, carro.getCarro_preco());
			
			System.out.println("placa:");
			System.out.println(carro.getCarro_placa());
			System.out.println(" ");
			
			stm.execute();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<locadoraDTO> consultar_carro() {
		
		List<locadoraDTO> carros = new ArrayList<>();
		
		String sql = "SELECT * FROM carro_locadora";
		
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			ResultSet resultSet = stm.executeQuery();
			
			while (resultSet.next()){
			
				locadoraDTO carro = new locadoraDTO();
				
				carro.setCarro_id(resultSet.getInt("id_carro"));
				carro.setCarro_placa(resultSet.getString("placa"));
				carro.setCarro_marca(resultSet.getString("marca"));
				carro.setCarro_cor(resultSet.getString("cor"));
				carro.setCarro_preco(resultSet.getString("preco"));

				carros.add(carro);
			}
			
			resultSet.close();
			stm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return carros;
	}

	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//CADASTRAR / PESQUISAR -- MOTO
	public void cadastrar_moto(locadoraDTO moto) {
		
		String sql = "INSERT INTO moto_locadora(marca, preco, cor, ano) VALUES (?, ?, ?, ?)";
		
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			//PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, moto.getMoto_marca());
			stm.setString(2, moto.getMoto_preco());
			stm.setString(3, moto.getMoto_cor());
			stm.setString(4, moto.getMoto_ano());
			
			stm.execute();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<locadoraDTO> consultar_moto() {
		
		List<locadoraDTO> motos = new ArrayList<>();
		
		String sql = "SELECT * FROM moto_locadora";
		
		try(Connection conn = new ConnectionFactory().conectaBD(); PreparedStatement stm = conn.prepareStatement(sql);){
			ResultSet resultSet = stm.executeQuery();
			
			while (resultSet.next()){
			
				locadoraDTO moto = new locadoraDTO();
				
				moto.setMoto_id(resultSet.getInt("id_moto"));
				moto.setMoto_marca(resultSet.getString("marca"));
				moto.setMoto_preco(resultSet.getString("preco"));
				moto.setMoto_cor(resultSet.getString("cor"));
				moto.setMoto_ano(resultSet.getString("ano"));

				motos.add(moto);
			}
			
			resultSet.close();
			stm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return motos;
	}

	
	
}
