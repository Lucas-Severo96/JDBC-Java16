package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AtualizarPessoas {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("Informe o Id (Código): ");
		int novoId = sc.nextInt();

		String selectSQL = "SELECT codigo, nome FROM pessoas WHERE codigo = ?";
		String updateSQL = "UPDATE pessoas SET nome = ? WHERE codigo = ?";
		
		Connection conexao = FabricaDeConexao.getConexao();
		PreparedStatement pst = conexao.prepareStatement(selectSQL);
		pst.setInt(1, novoId);
		ResultSet r = pst.executeQuery();
		
		if(r.next()) {
			Pessoa p = new Pessoa(r.getInt(1), r.getString(2));
			System.out.println("O nome atual é " + p.getNome());
			sc.nextLine();
			System.out.print("Informe o novo Nome que será inserido: ");
			String novoNome = sc.nextLine();
			
			pst.close();
			pst = conexao.prepareStatement(updateSQL);
			pst.setString(1, novoNome);
			pst.setInt(2, novoId);
			pst.execute();
			
			System.out.println("Pessoa alterada com Sucesso!");
		} else {
			System.out.println("Pessoa não encontrada!");
		}
		conexao.close();
		sc.close();
	}

}
