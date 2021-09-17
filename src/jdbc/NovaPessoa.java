package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NovaPessoa {

	public static void main(String[] args) throws SQLException {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Informe o nome: ");
		String nome = entrada.nextLine();
		
		Connection conexao = FabricaDeConexao.getConexao();
		
		String sql = "INSERT INTO pessoas (nome) VALUES (?)";
		PreparedStatement pst = conexao.prepareStatement(sql);
		pst.setString(1, nome);
		
		
		pst.execute();
		
		System.out.println("Pessoa incluida com sucesso!");
		entrada.close();
	}
}
