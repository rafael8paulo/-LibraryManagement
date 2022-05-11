package dal;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Alunfunc;
import model.Espera;
import model.Exemplar;
import util.Conexao;

public class EsperaDal {

    public boolean gravar(Alunfunc af, Exemplar exemp, Conexao connection) {
        String sql;
        try {
            connection.conectar();
            sql = "INSERT INTO public.espera("
                    + "alunfunc_mat, exemp_cod)"
                    + " VALUES (#1, #2);";
            sql = sql.replace("#1", String.valueOf(af.getAlf_codigo()));
            sql = sql.replace("#2", String.valueOf(exemp.getExemp_cod()));

            connection.manipular(sql);

            return true;
        } catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados");
            return false;
        }
    }

    public List listaDeEspera(Conexao connection, Exemplar exemp) {
        ArrayList<Espera> lista = new ArrayList();

        connection.conectar();

        try {
            ResultSet rs;
            String sql;
            sql = "SELECT * FROM espera WHERE exemp_cod = " + exemp.getExemp_cod();
            rs = connection.consultar(sql);
            while (rs.next()) {
                lista.add(
                        new Espera(
                                rs.getInt("esp_cod"),
                                new Alunfunc(rs.getInt("alunfunc_mat")),
                                new Exemplar(rs.getInt("exemp_cod"))
                        )
                );
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados" + e);
        }

        return null;
    }

}
