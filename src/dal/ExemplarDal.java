package dal;

import model.Exemplar;
import util.Conexao;

public class ExemplarDal {
    
    public boolean alterar(Conexao connection, Exemplar exemplar) {
        String sql;

        try {

            sql = "UPDATE exemplar SET status_cod = 5 WHERE exemp_cod = (SELECT exemp_cod FROM i_empdev WHERE empdev_cod = "+exemplar.getExemp_cod()+")";            
            
            System.out.println(sql);
            
            connection.manipular(sql);

            
        } catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados");
            return false;
        }
        return true;
    }
}
