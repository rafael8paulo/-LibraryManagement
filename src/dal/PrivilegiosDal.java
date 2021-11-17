package dal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.*;
import util.Conexao;

public class PrivilegiosDal {

    public List retornarLista(Privilegios privilegios, Conexao connection, String filtro) {

        ArrayList<Privilegios> lista = new ArrayList();
        String url = "jdbc:postgresql://localhost/";
        connection.conectar(url, "librarymanagement", "postgres", "postgres123");
        try {
            ResultSet rs;
            String sql;
            sql = "SELECT * FROM perfil_privilegio WHERE per_descricao ilike '%" + filtro + "%'";
            rs = connection.consultar(sql);
            while (rs.next()) {
                privilegios = new Privilegios(rs.getInt("per_cod"),
                        rs.getString("per_descricao"),rs.getBoolean("per_incluir"),rs.getBoolean("per_excluir"),
                        rs.getBoolean("per_consultar"),rs.getBoolean("per_editar"),rs.getBoolean("per_movimentar"));
                lista.add(privilegios);
            }
            return lista;
        }
        catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados" + e);
        }
        return null;
    }
    
    public List retornaPrivilegio (Privilegios privilegios, Conexao connection, String filtro){
        ArrayList<Privilegios> lista = new ArrayList();
        String url = "jdbc:postgresql://localhost/";
        connection.conectar(url, "librarymanagement", "postgres", "postgres123");
        try {
            ResultSet rs;
            String sql;
            sql = "SELECT * FROM perfil_privilegio WHERE per_descricao ilike '%" + filtro + "%'";
            rs = connection.consultar(sql);
            while (rs.next()) {
                privilegios = new Privilegios(rs.getInt("per_cod"),
                        rs.getString("per_descricao"),false,false,false,false,false);
                lista.add(privilegios);
            }
            return lista;
        }
        catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados" + e);
        }
        return null;
    }
    
    public List retornaPrivilegioById (Privilegios privilegios, Conexao connection, int filtro){
        ArrayList<Privilegios> lista = new ArrayList();
        String url = "jdbc:postgresql://localhost/";
        connection.conectar(url, "librarymanagement", "postgres", "postgres123");
        try {
            ResultSet rs;
            String sql;
            sql = "SELECT * FROM perfil_privilegio WHERE per_cod=" + filtro;
            rs = connection.consultar(sql);
            while (rs.next()) {
                privilegios = new Privilegios(rs.getInt("per_cod"),
                        rs.getString("per_descricao"),rs.getBoolean("per_incluir"),rs.getBoolean("per_excluir"),
                        rs.getBoolean("per_consultar"),rs.getBoolean("per_editar"),rs.getBoolean("per_movimentar"));
                lista.add(privilegios);
            }
            return lista;
        }
        catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados" + e);
        }
        return null;
    }
    
    
    
    

}
