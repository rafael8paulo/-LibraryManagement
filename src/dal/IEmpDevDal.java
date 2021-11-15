package dal;

import java.time.LocalDate;
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
}
