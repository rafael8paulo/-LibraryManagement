package dal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.*;
import util.Conexao;
public class LoginDal implements IntDal<Usuarios>
{
    Conexao connection = new Conexao();
    
    @Override
    public boolean gravar(Usuarios usuarios) {
        String sql;
        String url="jdbc:postgresql://localhost/";
        try{
            connection.conectar(url,"librarymanagement","postgres","postgres123");
            sql= "INSERT INTO usuarios(usu_login,usu_senha,usu_data, per_cod)";
            sql=sql+"VALUES ('#1', '#2','2021-11-7',#4)";           
            sql=sql.replace("#1",usuarios.getUsu_login());
            sql=sql.replace("#2",usuarios.getUsu_senha());
            sql=sql.replace("#4",""+usuarios.getPrivilegio().getPer_cod());
            //sql=sql.replace("#3",usuarios.getData().toString());
            connection.manipular(sql); 
            usuarios.usu_codigo = connection.getMaxPK("usuarios","usu_cod");
            return true;
        }
        catch(Exception e)
        {
            System.out.println("Erro ao conectar com o banco de dados");
            return false;
        }
    }

    @Override
    public boolean alterar(Usuarios usuarios) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
 
    @Override
    public boolean apagar(Usuarios usuarios) {
        
        String sql;
        String url="jdbc:postgresql://localhost/";
        try{
            connection.conectar(url,"librarymanagement","postgres","postgres123");
            sql= "DELETE FROM usuarios WHERE usu_cod = #1";           
            sql=sql.replace("#1",""+usuarios.getUsu_codigo()); 
            return connection.manipular(sql);  
        }
        catch(Exception e)
        {
            System.out.println("Erro ao conectar com o banco de dados");
        }            
        return false;
    }

    @Override
    public Usuarios get(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

     public List get(String filtro) {
         Usuarios usuarios = new Usuarios();
         Privilegios priv = new Privilegios();
         ArrayList<Usuarios> lista = new ArrayList();
         String url="jdbc:postgresql://localhost/";
         connection.conectar(url,"librarymanagement","postgres","postgres123");
        try{                  
            ResultSet rs;
            String sql;
            sql = "SELECT * FROM usuarios WHERE usu_login LIKE '%"+filtro+"%'";
            rs =connection.consultar(sql);
            while(rs.next())
            {
                usuarios.setUsu_login(rs.getString("usu_login"));
                usuarios.setUsu_senha(rs.getString("usu_senha"));
                lista.add(usuarios);  
            }
            return lista;
        }
        catch(Exception e)
        {
            System.out.println("Erro ao conectar com o banco de dados"+e);
        }
        return null;
        
    }
    
}
