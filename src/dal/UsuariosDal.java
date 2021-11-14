package dal;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import model.*;
import util.Conexao;

public class UsuariosDal{

    public boolean gravar(Usuarios usuarios, Privilegios privilegios, Conexao connection) {
        String sql;
        String url = "jdbc:postgresql://localhost/";
        try {
            connection.conectar(url, "librarymanagement", "postgres", "postgres123");
            
            sql = "INSERT INTO usuarios(usu_login,usu_senha,usu_data, per_cod)";
            sql = sql + "VALUES ('#1', '#2','2021-11-7',#4)";
            sql = sql.replace("#1", usuarios.getUsu_login());
            sql = sql.replace("#2", usuarios.getUsu_senha());
            sql = sql.replace("#4", "" + privilegios.getPer_cod());
            //sql=sql.replace("#3",usuarios.getData().toString());
            connection.manipular(sql);
            usuarios.usu_codigo = connection.getMaxPK("usuarios", "usu_cod");
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados");
            return false;
        }
    }

    public boolean apagar(Usuarios usuarios, Conexao connection) {
        String sql;
        String url = "jdbc:postgresql://localhost/";
        try {
            connection.conectar(url, "librarymanagement", "postgres", "postgres123");
            sql = "DELETE FROM usuarios WHERE usu_cod = #1";
            sql = sql.replace("#1", "" + usuarios.getUsu_codigo());
            return connection.manipular(sql);
        } catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados");
        }
        return false;
    }

    public List get(Usuarios usuarios,String filtro, Conexao connection) {
        ArrayList<Usuarios> lista = new ArrayList();
        String url = "jdbc:postgresql://localhost/";
        connection.conectar(url, "librarymanagement", "postgres", "postgres123");
        try {
            ResultSet rs;
            String sql;
            sql = sql = "SELECT * FROM usuarios WHERE usu_login ilike '%" + filtro + "%'";
            rs = connection.consultar(sql);
            while (rs.next()) {
                usuarios.setUsu_login(rs.getString("usu_login"));
                usuarios.setUsu_senha(rs.getString("usu_senha"));
                usuarios.setUsu_codigo(Integer.parseInt(rs.getString("usu_cod")));
                usuarios.setData(LocalDate.parse(rs.getString("usu_data"), DateTimeFormatter.ISO_DATE));
                lista.add(usuarios);               
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados" + e);
        }
        return null;

    }

}
