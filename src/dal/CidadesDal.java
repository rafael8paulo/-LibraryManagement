package dal;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Alunfunc;
import model.Cidades;
import util.Conexao;

public class CidadesDal {
    
    public List pesquisarCid (Cidades cid, Conexao connection, String filtro){
        
        ArrayList<Alunfunc> lista = new ArrayList();       
        connection.conectar();
        
        try {
            ResultSet rs;
            String sql;
            sql = "SELECT * FROM cidades WHERE cid_ibge = " + Integer.parseInt(filtro);
            rs = connection.consultar(sql);
            while (rs.next()) {
                cid.setCid_cep(rs.getInt("cid_ibge"));
                cid.setCid_municipio(rs.getString("cid_descricao"));
                cid.setCid_uf(rs.getString("uf_descricao"));
            }
            return lista;
        }
        catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados" + e);
        }
        return null;
    }
    
    
    
    
    
    
    
    
}
