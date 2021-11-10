package dal;
import java.sql.ResultSet;
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
            return true;
        }
        catch(Exception e)
        {
            System.out.println("Erro ao conectar com o banco de dados");
            return false;
        }
    }

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
    
    
    
    
    
    
}
