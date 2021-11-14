package dal;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Autor;
import model.Privilegios;
import util.Conexao;

public class EmpreDevoDal {
          
    public Autor get(int id, Privilegios privilegios, Conexao connection) {

        Autor aut = null;

        try {
            ResultSet rs;
            String sql;
            sql = "SELECT * FROM autor WHERE aut_cod = " + id;
            rs = connection.consultar(sql);
            if (rs.next()) {
                aut = new Autor(
                        rs.getInt("aut_cod"),
                        rs.getString("aut_nome")
                );
            }

        } catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados" + e);
        }
        return aut;
    }
    
    public List<Autor> get(String filtro, Privilegios privilegios, Conexao connection) {
        
        ArrayList<Autor> lista = new ArrayList();

        try {
            ResultSet rs;
            String sql;
            sql = "SELECT * FROM autor WHERE aut_nome LIKE '%" + filtro + "%'";
            rs = connection.consultar(sql);
            while (rs.next()) {

                lista.add(
                        new Autor(
                                rs.getInt("aut_cod"),
                                rs.getString("aut_nome")
                        )
                );
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados" + e);
        }
        return lista;
    }
}
