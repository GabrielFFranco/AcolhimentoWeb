package br.com.acolhimento.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Connection;

import br.com.acolhimento.domain.Endereco;

public class EnderecoDAO extends GenericDAO<Endereco> {

	// Método para retornar o ultimo endereço cadastrado.
	public Endereco ultimoEndereco() {

		String comando = "Select MAX(idEndereco) as idEndereco from endereco";

		String usuario = "root";
        String senha = "q1w2e3r4";
        String url = "jdbc:mysql://127.0.0.1:3308/acolhimento?serverTimezone=UTC";
        
        int resultado = 0;
        
		try {

			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			PreparedStatement comandoSQL = conexao.prepareStatement(comando);

			ResultSet retorno = comandoSQL.executeQuery();

			while (retorno.next()) {
				resultado = retorno.getInt("idEndereco");
			}

			comandoSQL.close();
			conexao.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return this.buscar(resultado);

	}

}
