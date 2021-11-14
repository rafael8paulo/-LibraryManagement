package dal;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;
import util.Conexao;

public class PendenciaDal {

    public ObservableList<Pendencia> carregarTabela(int filtro, Conexao connection, Alunfunc alunfunc, String filtro2) {
        ObservableList<Pendencia> lista = FXCollections.observableArrayList();
        Pendencia pend = new Pendencia();

        try {
            ResultSet rs;
            String sql;
            sql = "select p.pend_cod, p.pend_dtpgto,"
                    + " p.pend_valor, p.pend_quitada,"
                    + " a.alunfunc_mat, a.alunfunc_nome "
                    + "from pend as p inner join alun_func"
                    + " as a on a.alunfunc_mat = p.alunfunc_mat "
                    + "WHERE p.alunfunc_mat = " + filtro + "::integer and pend_quitada = '"+filtro2+"'";
            rs = connection.consultar(sql);

            while (rs.next()) {
                alunfunc.setAlf_nome(rs.getString("alunfunc_nome"));
                pend = new Pendencia(Integer.parseInt(rs.getString("pend_cod")),
                        LocalDate.parse(rs.getString("pend_dtpgto"), DateTimeFormatter.ISO_DATE),
                        rs.getString("pend_quitada"), Integer.parseInt(rs.getString("pend_valor")), alunfunc);
                lista.add(pend);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados" + e);
            return null;
        }
    }

    public boolean alterar(Conexao connection, int filtro, Pendencia pendencia ) {
        String sql;
        sql = "UPDATE pend SET pend_dtpgto='#1', pend_quitada = 'S' "
                + "WHERE pend_cod=" + pendencia.getPend_cod();
        sql = sql.replace("#1",pendencia.getPend_dtpgto().toString());
        return connection.manipular(sql);
    }
}
