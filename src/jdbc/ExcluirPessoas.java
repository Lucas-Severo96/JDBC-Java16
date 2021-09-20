package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirPessoas {

	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe o codigo: ");
		int codigo = sc.nextInt();
		
		Connection conexao = FabricaDeConexao.getConexao();
		String sql = "DELETE FROM pessoas WHERE codigo = ?";
		
		PreparedStatement pst = conexao.prepareStatement(sql);
		pst.setInt(1, codigo);
		
		if(pst.executeUpdate() > 0) {
			System.out.println("Pessoa Excluída com Sucesso!");
		} else {
			System.out.println("Nada feito!");
		}
		
		conexao.close();
		pst.close();
		sc.close();

	}
}
