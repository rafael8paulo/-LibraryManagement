package dal;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Alunfunc;
import model.Autor;
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
            
            if(dias > 0){
                return dias;
            }
            
            return 0;

        } catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados" + e);
        }

        return dias;
    }

}
