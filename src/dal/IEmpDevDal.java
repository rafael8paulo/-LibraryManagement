package dal;

import java.time.LocalDate;
import model.Empdev;
import model.Exemplar;
import model.IEmpDev;
import util.Conexao;

public class IEmpDevDal {

    public boolean alterar(Conexao connection, IEmpDev itens) {
        String sql;

        try {

            sql = "UPDATE i_empdev SET itens_dtdev='#1' "
                    + "WHERE empdev_cod= " + itens.getEmpdev_cod();
            sql = sql.replace("#1", LocalDate.now().toString());

            System.out.println(sql);
            connection.manipular(sql);

        } catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados");
            return false;
        }
        return true;
    }

    public boolean emprestimo(Conexao connection, Exemplar exemp, Empdev ep) {

        String sql = "INSERT INTO public.i_empdev(empdev_cod, exemp_cod)"
                + " VALUES (#1, #2);";
        
        sql = sql.replace("#1", String.valueOf(ep.getEmpdev_cod()));
        sql = sql.replace("#2", String.valueOf(exemp.getExemp_cod()));
        
        System.out.println(sql);
        
        try {
            connection.manipular(sql);
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados" + e);
        }
        
        return false;
    }

}
