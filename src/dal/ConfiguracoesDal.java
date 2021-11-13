package dal;
import java.sql.ResultSet;
<<<<<<< HEAD
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.*;
import util.Conexao;

public class ConfiguracoesDal{

    public boolean gravar(Configuracoes conf, Conexao connection) {
=======
import java.util.ArrayList;
import java.util.List;
import model.*;
import model.Privilegios;
import model.Usuarios;
import util.Conexao;

public class ConfiguracoesDal implements IntDal<Configuracoes>{
    
     Conexao connection = new Conexao();
    
    @Override
    public boolean gravar(Configuracoes conf) {
>>>>>>> b339f3d272e1cfb3ec5f82f1d89435cbd6209669
        String sql;
        String url="jdbc:postgresql://localhost/";
        try{
            connection.conectar(url,"librarymanagement","postgres","postgres123");
            sql= "INSERT INTO configuracoes(conf_multa,conf_juros,conf_limdias)";
            sql=sql+"VALUES (#1, #2,#3)";           
            sql=sql.replace("#1",""+conf.getConf_multa());
            sql=sql.replace("#2",""+conf.getConf_juro());
            sql=sql.replace("#3",""+conf.getConf_limDia());
            connection.manipular(sql); 
            conf.conf_cod = connection.getMaxPK("configuracoes","conf_codigo");
<<<<<<< HEAD
            return true;         
=======
            return true;
>>>>>>> b339f3d272e1cfb3ec5f82f1d89435cbd6209669
        }
        catch(Exception e)
        {
            System.out.println("Erro ao conectar com o banco de dados");
            return false;
        }
    }

<<<<<<< HEAD
    public boolean apagar(Configuracoes conf, Conexao connection) {      
        String sql;
        String url="jdbc:postgresql://localhost/";
        connection.conectar(url,"librarymanagement","postgres","postgres123");
        try{
            
            sql= "DELETE FROM configuracoes"; 
            if (connection.manipular(sql)){
                return true;
            }      
        }catch(Exception e){
            System.out.println("Erro ao conectar com o banco de dados");
        }   
        return false;
    }

     public List get(Configuracoes conf, Conexao connection) 
     {

        ArrayList<Configuracoes> lista = new ArrayList();
        String url = "jdbc:postgresql://localhost/";
        connection.conectar(url, "librarymanagement", "postgres", "postgres123");
        try {
            ResultSet rs;
            String sql;
            sql = sql = "SELECT * FROM configuracoes";
            rs = connection.consultar(sql);
            while (rs.next()) {
                conf.setConf_cod(Integer.parseInt(rs.getString("conf_codigo")));
                conf.setConf_multa(Integer.parseInt(rs.getString("conf_multa")));
                conf.setConf_juro(Integer.parseInt(rs.getString("conf_juros")));
                conf.setConf_limDia(Integer.parseInt(rs.getString("conf_limdias")));
                lista.add(conf);
                
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados" + e);
        }
        return null;        
    }
  
=======
    @Override
    public boolean alterar(Configuracoes conf) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
 
    @Override
    public boolean apagar(Configuracoes conf) {
        
        String sql;
        String url="jdbc:postgresql://localhost/";
        try{
            connection.conectar(url,"librarymanagement","postgres","postgres123");
            sql= "DELETE FROM configuracoes";                       
            return connection.manipular(sql);  
        }
        catch(Exception e)
        {
            System.out.println("Erro ao conectar com o banco de dados");
        }            
        return false;
    }

    @Override
    public Configuracoes get(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

     public List get(String filtro) {
         
        return null;
        
    }
    
    
    
    
    
    
>>>>>>> b339f3d272e1cfb3ec5f82f1d89435cbd6209669
}
