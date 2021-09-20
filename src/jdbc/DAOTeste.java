package jdbc;

public class DAOTeste {

	public static void main(String[] args) {
	
		DAO dao = new DAO();
		
		String sql = "INSERT INTO pessoas (nome) VALUES (?)";
		System.out.println(dao.incluir(sql, "Joao da Silva"));
		dao.incluir(sql, "Joao da Silva");
		dao.incluir(sql, "Ana L�cia");
		dao.incluir(sql, "M�nica");
		dao.incluir(sql, "Elda Joaquina");
		
		dao.close();

	}

}
