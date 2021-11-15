package dal;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Alunfunc;
import util.Conexao;

public class AlunfuncDal {
    
    public List pesquisarAlunfunc (Alunfunc alunfunc, Conexao connection, String filtro){
        ArrayList<Alunfunc> lista = new ArrayList();
        String url = "jdbc:postgresql://localhost/";
        connection.conectar(url, "librarymanagement", "postgres", "postgres123");
        try {
            ResultSet rs;
            String sql;
            sql = "SELECT * FROM alun_func WHERE alunfunc_mat = " + Integer.parseInt(filtro);
            rs = connection.consultar(sql);
            while (rs.next()) {
                alunfunc.setAlf_codigo(rs.getInt("alunfunc_mat"));
                alunfunc.setAlf_nome(rs.getString("alunfunc_nome"));
            }
            return lista;
        }
        catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados" + e);
        }
        return null;
    }
    
    
}
