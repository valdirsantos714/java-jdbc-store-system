package banco_de_dados;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class BD {
	
	private static Connection conn = null;
	
	public static Connection abrirConexao() {
		
		if (conn == null) {
			try {
				Properties props = carregaPropriedades();
				String url = props.getProperty("dburl");
				
				conn = DriverManager.getConnection(url, props);
			
			} catch (SQLException e) {
				throw new BdException(e.getMessage());
			}
			
		}
		return conn;
	}
	
	public static void fecharConexao() {
		if (conn != null) {
			try {
				conn.close();
			
			} catch (SQLException e) {
				throw new BdException(e.getMessage());
			}
		}
	}

	private static Properties carregaPropriedades() {
		try(FileInputStream fs = new FileInputStream("db.propriedades")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		
		} catch (IOException e) {
			throw new BdException(e.getMessage());
		}
	}
	
	public static void fecharStatement(Statement st) {
		
		if (st != null) {
			try {
				st.close();
				
			} catch (SQLException e)  {
				throw new BdException(e.getMessage());
			}
		}
	}
	
	public static void fecharResultSet(ResultSet rs) {
		
		if (rs != null) {
			try {
				rs.close();
				
			} catch (SQLException e) {
				throw new BdException(e.getMessage());
			}
		}
	}
	
	public static void fecharStatementAndResultSet(Statement st, ResultSet rs) {
		
		if (st != null && rs != null) {
			try {
				st.close();
				rs.close();
			
			} catch (SQLException e) {
				throw new BdException(e.getMessage());
			}
		}
	}
}
