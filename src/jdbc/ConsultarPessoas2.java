package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultarPessoas2 {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		Connection conexao = FabricaDeConexao.getConexao();
		String sql = "SELECT * FROM pessoas WHERE nome like ?";
		
		System.out.println("Informe o valor para pesquisa: ");
		String valor = sc.nextLine();
		
		PreparedStatement pst = conexao.prepareStatement(sql);
		pst.setString(1, "%" + valor + "%");
		ResultSet resultado = pst.executeQuery();
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		while(resultado.next()) {
			int codigo = resultado.getInt("codigo");
			String nome = resultado.getString("nome");
			pessoas.add(new Pessoa(codigo, nome));
		}
		
		for(Pessoa p: pessoas) {
			System.out.println(p.getCodigo() + " ---> " + p.getNome());
		}
		
		pst.close();
		conexao.close();
		sc.close();
	}

}
