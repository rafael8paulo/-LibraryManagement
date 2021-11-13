package dal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Login;
import util.Conexao;

public class LoginDal {   
    public List get(Login login,String filtro, Conexao connection) {
        ArrayList<Login> lista = new ArrayList();
        String url = "jdbc:postgresql://localhost/";
        connection.conectar(url, "librarymanagement", "postgres", "postgres123");
        try {
            ResultSet rs;
            String sql;
<<<<<<< HEAD
            sql = sql = "SELECT * FROM usuarios WHERE usu_login ilike '%" + filtro + "%'";
            rs = connection.consultar(sql);
            while (rs.next()) {
                login.setLogin(rs.getString("usu_login"));
                login.setSenha(rs.getString("usu_senha"));
                lista.add(login);               
=======
            sql = "SELECT * FROM usuarios WHERE usu_login LIKE '%"+filtro+"%'";
            rs =connection.consultar(sql);
            while(rs.next())
            {
                usuarios.setUsu_login(rs.getString("usu_login"));
                usuarios.setUsu_senha(rs.getString("usu_senha"));
                lista.add(usuarios);  
>>>>>>> b339f3d272e1cfb3ec5f82f1d89435cbd6209669
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados" + e);
        }
        return null;
    }
}
