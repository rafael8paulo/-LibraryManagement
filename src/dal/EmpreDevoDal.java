package dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Alunfunc;
import model.Empdev;
import model.Livro;
import util.Conexao;

public class EmpreDevoDal {

    public ObservableList<Empdev> carregarTabelaDevo(int mat, String nome, Conexao connection, Alunfunc alunfunc, Livro livro) {

        ObservableList<Empdev> lista = FXCollections.observableArrayList();

        try {
            ResultSet rs;
            String sql;
            sql = "SELECT "
                    + " iemp.empdev_cod,"
                    + " liv.liv_nome,"
                    + " empd.empdev_dtprev,"
                    + " aluf.alunfunc_nome"
                    + " FROM emp_dev empd "
                    + "INNER JOIN i_empdev iemp ON iemp.empdev_cod = empd.empdev_cod "
                    + "INNER JOIN exemplar exem ON exem.exemp_cod = iemp.exemp_cod "
                    + "INNER JOIN livros liv ON liv.liv_cod = exem.liv_cod "
                    + "INNER JOIN alun_func aluf ON aluf.alunfunc_mat = empd.alunfunc_mat "
                    + "WHERE exem.status_cod = 4 ";

            if (mat != 0) {
                sql = sql + " AND aluf.alunfunc_mat = " + mat;
            }
            if (!nome.isEmpty()) {
                sql = sql + " AND aluf.alunfunc_nome LIKE '%" + nome + "%'";
            }

            rs = connection.consultar(sql);
            while (rs.next()) {

                alunfunc.setAlf_nome(rs.getString("alunfunc_nome"));
                livro.setLiv_nome(rs.getString("liv_nome"));

                lista.add(
                        new Empdev(
                                rs.getInt("empdev_cod"),
                                LocalDate.parse(rs.getString("empdev_dtprev"), DateTimeFormatter.ISO_DATE),
                                alunfunc,
                                livro
                        )
                );
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados" + e);
        }
        return lista;
    }

    public int atrasoEmDias(Conexao connection, int empdev_cod) {

        int dias = 0;

        try {
            ResultSet rs;
            String sql;
            sql = "SELECT ( CURRENT_DATE - empdev_dtprev) AS dias FROM emp_dev WHERE empdev_cod = " + empdev_cod;
            rs = connection.consultar(sql);
            while (rs.next()) {
                dias = rs.getInt("dias");
            }

            if (dias > 0) {
                return dias;
            }

            return 0;

        } catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados" + e);
        }

        return dias;
    }

    public boolean emprestimo(Conexao connection, Empdev ed, Alunfunc af) {

        String sql = "INSERT INTO public.emp_dev("
                + "empdev_dtemp, empdev_oper, empdev_dtprev, alunfunc_mat)"
                + "VALUES ('#1', 'P', '#2', #3)";
        
        sql = sql.replace("#1", LocalDate.now().toString());
        sql = sql.replace("#2", ed.getDtprev().toString());
        System.out.println(ed.getDtprev().toString());
        sql = sql.replace("#3", ""+String.valueOf(af.getAlf_codigo()));
        
        System.out.println(sql);
        
        try {
            connection.manipular(sql);
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados" + e);
        }
        
        return false;
    }

    public boolean consultaUltimoID(Conexao connection, Alunfunc af, Empdev ed){

        String sql = "SELECT empdev_cod FROM emp_dev"
                + " WHERE alunfunc_mat = " + af.getAlf_codigo() + " AND empdev_oper = 'P'"
                + " ORDER BY empdev_dtprev DESC LIMIT 1";

        ResultSet rs = connection.consultar(sql);;
        try {
            if (rs.next()) {
                ed.setEmpdev_cod(rs.getInt("empdev_cod"));
                return true;
            }
        } catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados" + e);
        }
        return false;
    }
}
