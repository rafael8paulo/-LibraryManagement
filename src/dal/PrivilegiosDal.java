package dal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.*;
import util.Conexao;
public class PrivilegiosDal implements IntDal<Privilegios>
{
    Conexao connection = new Conexao();
    
    @Override
    public boolean gravar(Privilegios privilegios) {
            return true;
    }

    @Override
    public boolean alterar(Privilegios privilegios) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
 
    @Override
    public boolean apagar(Privilegios privilegios) {
      
        return false;
    }

     public List get(String filtro) {
         
         ArrayList<Privilegios> lista = new ArrayList();
         String url="jdbc:postgresql://localhost/";
         connection.conectar(url,"librarymanagement","postgres","postgres123");
        try{                  
            ResultSet rs;
            String sql;
            sql = "SELECT * FROM perfil_privilegio WHERE per_descricao ilike '%"+filtro+"%'";
            rs =connection.consultar(sql);
            while(rs.next())
            {
                Privilegios privilegios = new Privilegios();
                privilegios.setPer_cod(Integer.parseInt(rs.getString("per_cod")));
                privilegios.setPer_descricao(rs.getString("per_descricao")); 
                lista.add(privilegios);
            }
            
            return lista;
        }
        catch(Exception e)
        {
            System.out.println("Erro ao conectar com o banco de dados"+e);
        }
        return null;
        
    }

    @Override
    public Privilegios get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
