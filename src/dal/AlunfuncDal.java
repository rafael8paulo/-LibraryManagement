package dal;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Alunfunc;
import model.Cidades;
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
    
    public boolean gravar(Alunfunc af, Cidades cid, Conexao connection) {
        String sql;
        String url = "jdbc:postgresql://localhost/";
        try {
            connection.conectar(url, "librarymanagement", "postgres", "postgres123");
            sql = "INSERT INTO alun_func(alunfunc_nome, alunfunc_email, "
                    + "alunfunc_telefone, alunfunc_log,alunfunc_numres, "
                    + "cid_ibge, alunfunc_tipo)";
            sql = sql + "VALUES ('#1', '#2','#3','#4',#5,#6,'#7')";
            sql = sql.replace("#1", af.getAlf_nome());
            sql = sql.replace("#2", af.getAlf_email());
            sql = sql.replace("#3", af.getAlf_celular());
            sql = sql.replace("#4", af.getAlf_logradouro());
            sql = sql.replace("#5", "" + af.getAlf_numres());
            sql = sql.replace("#6", "" + cid.getCid_cep());
            sql = sql.replace("#7", af.getAlf_tipo());
            //sql=sql.replace("#3",usuarios.getData().toString());
            connection.manipular(sql);
            af.alf_codigo = connection.getMaxPK("alun_func", "alunfunc_mat");
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados");
            return false;
        }
    }
    
    
    
    
    
}
