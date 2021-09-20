package jdbc;

public class DAOTeste {

	public static void main(String[] args) {
	
		DAO dao = new DAO();
		
		String sql = "INSERT INTO pessoas (nome) VALUES (?)";
		System.out.println(dao.incluir(sql, "Joao da Silva"));
		dao.incluir(sql, "Joao da Silva");
		dao.incluir(sql, "Ana Lúcia");
		dao.incluir(sql, "Mônica");
		dao.incluir(sql, "Elda Joaquina");
		
		dao.close();

	}

}
