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

        connection.conectar();
        
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
        try {
            connection.conectar();
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
    
    public List pesquisarAlunfuncByName (Alunfunc alunfunc, Conexao connection, String filtro, Cidades cid){
        
        ArrayList<Alunfunc> lista = new ArrayList();        
        connection.conectar();
        
        try {
            ResultSet rs;
            String sql;
            sql = "SELECT * FROM alun_func WHERE alunfunc_nome like "+"'%"+filtro+"%'";
            rs = connection.consultar(sql);
            while (rs.next()) {
                alunfunc.setAlf_codigo(rs.getInt("alunfunc_mat"));
                alunfunc.setAlf_nome(rs.getString("alunfunc_nome"));
                alunfunc.setAlf_celular(rs.getString("alunfunc_telefone"));
                alunfunc.setAlf_tipo(rs.getString("alunfunc_tipo"));
                alunfunc.setAlf_numres(rs.getString("alunfunc_numres"));
                alunfunc.setAlf_logradouro(rs.getString("alunfunc_log"));
                alunfunc.setAlf_email(rs.getString("alunfunc_email"));
                cid.setCid_cep(rs.getInt("cid_ibge"));
            }
            System.out.println(sql);
            lista.add(alunfunc);
            return lista;
        }
        catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados" + e);
        }
        return null;
    }                       
}
