package controle;

import banco_de_dados.BD;
import banco_de_dados.BdException;

import java.sql.*;

public class Sistema {

    private Connection conn = null;
    private Statement st = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public Sistema () {
        conn = BD.abrirConexao();
    }

    public void addProdutos(String nomeProduto, Double preco, int quantidade) {
        try {
            ps = conn.prepareStatement("insert into produtos values (NULL, ?, ?, ?);");
            ps.setString(1,nomeProduto);
            ps.setDouble(2, preco);
            ps.setInt(3, quantidade);

            ps.executeUpdate();
            System.out.println("Produto inserido com sucesso!");

        } catch (SQLException e) {
            throw new BdException(e.getMessage());
        }
    }

    private int pegaId (String nomeProduto) {
        try {
            int id = 0;
            st = conn.createStatement();
            rs = st.executeQuery("select id from produtos where nome = " + nomeProduto);

            while (rs.next()) {
                id = rs.getInt("id");
            }
            return id;
        } catch (SQLException e) {
            throw new BdException(e.getMessage());
        }
    }


}