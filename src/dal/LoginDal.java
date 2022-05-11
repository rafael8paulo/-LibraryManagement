package dal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Login;
import util.Banco;
import util.Conexao;

public class LoginDal { 
    
    public List get(Login login,String filtro, Conexao connection) {
        
        ArrayList<Login> lista = new ArrayList();                        
        connection.conectar();
        
        try {
            ResultSet rs;
            String sql;
            sql = sql = "SELECT * FROM usuarios WHERE usu_login ilike '%" + filtro + "%'";
            rs = connection.consultar(sql);
            while (rs.next()) {
                login.setLogin(rs.getString("usu_login"));
                login.setSenha(rs.getString("usu_senha"));
                login.setPerfil(rs.getInt("per_cod"));
                lista.add(login);               
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados" + e);
        }
        return null;
    }
}
