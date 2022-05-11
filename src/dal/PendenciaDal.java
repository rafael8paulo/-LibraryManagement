package dal;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;
import util.Conexao;

public class PendenciaDal {

    public ObservableList<Pendencia> carregarTabela(String filtro, Conexao connection, Alunfunc alunfunc, String filtro2) {
        ObservableList<Pendencia> lista = FXCollections.observableArrayList();
        Pendencia pend = new Pendencia();

        try {
            ResultSet rs;
            String sql;
            sql = "select p.pend_cod, p.pend_dtinc, p.pend_valor, p.pend_quitada, a.alunfunc_mat, a.alunfunc_nome "
                    + "from pend p "
                    + "inner join emp_dev ed on ed.empdev_cod = p.empdev_cod "
                    + "inner join alun_func a on a.alunfunc_mat = ed.alunfunc_mat "
                    + "WHERE pend_quitada = '" + filtro2 + "'";
              if(!filtro.isEmpty())
                  sql += "and a.alunfunc_mat = " + filtro + "::integer";
            
            System.out.println(sql);
            
            rs = connection.consultar(sql);                        
            
            while (rs.next()) {
                alunfunc.setAlf_nome(rs.getString("alunfunc_nome"));
                pend = new Pendencia(Integer.parseInt(rs.getString("pend_cod")),
                        LocalDate.parse(rs.getString("pend_dtinc"), DateTimeFormatter.ISO_DATE),
                        rs.getString("pend_quitada"), Integer.parseInt(rs.getString("pend_valor")), alunfunc);
                lista.add(pend);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados" + e);
            return null;
        }
    }

    public boolean alterar(Conexao connection, double filtro, Pendencia pendencia) {
        String sql;
        sql = "UPDATE pend SET pend_dtpgto='#1', pend_quitada = 'S' "
                + "WHERE pend_cod=" + pendencia.getPend_cod();
        sql = sql.replace("#1", pendencia.getPend_dtpgto().toString());
        System.out.println(sql);
        return connection.manipular(sql);
        
    }
    public boolean incluirPendencia(Conexao connection, Pendencia pendencia) {
        String sql;
        sql = "INSERT INTO pend(pend_dtinc, pend_valor, pend_quitada, empdev_cod)\n"
                + "	VALUES (CURRENT_DATE, #1, 'N', #2);";

        sql = sql.replace("#1", String.valueOf(pendencia.getValor()));
        sql = sql.replace("#2", String.valueOf(pendencia.getEmpdev_cod()));
        
        System.out.println(sql);
        
        return connection.manipular(sql);
    }
}
