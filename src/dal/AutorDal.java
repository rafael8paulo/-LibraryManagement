package dal;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Autor;
import util.Conexao;

public class AutorDal implements IntDal<Autor> {

    Conexao connection = new Conexao();

    @Override
    public boolean gravar(Autor entidade) {

        String sql;

        try {

            sql = "INSERT INTO autor (aut_nome)";
            sql = sql + "VALUES ('#1')";
            sql = sql.replace("#1", entidade.getAut_nome());

            connection.manipular(sql);

            return true;
        } catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados");
            return false;
        }
    }

    @Override
    public boolean alterar(Autor entidade) {
        String sql;

        try {

            sql = "UPDATE autor SET aut_nome = '#1' WHERE aut_cod = " + entidade.getAut_cod();
            sql = sql.replace("#1", entidade.getAut_nome());

            connection.manipular(sql);

            return true;
        } catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados");
            return false;
        }
    }

    @Override
    public boolean apagar(Autor entidade) {

        String sql;

        try {

            sql = "DELETE FROM autor WHERE aut_cod = " + entidade.getAut_cod();

            connection.manipular(sql);

            return true;
        } catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados");
            return false;
        }

    }

    @Override
    public Autor get(int id) {

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

    @Override
    public List<Autor> get(String filtro) {
        
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
