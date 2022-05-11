package dal;

import java.sql.ResultSet;
import model.Exemplar;
import model.Empdev;
import model.Livro;
import util.Conexao;

public class ExemplarDal {

    public boolean alterar(Conexao connection, Exemplar exemplar) {
        String sql;

        try {

            sql = "UPDATE exemplar SET status_cod = 5 WHERE exemp_cod = (SELECT exemp_cod FROM i_empdev WHERE empdev_cod = " + exemplar.getExemp_cod() + ")";

            System.out.println(sql);

            connection.manipular(sql);

        } catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados");
            return false;
        }
        return true;
    }

    public boolean emprestar(Conexao connection, Exemplar exemplar) {
        String sql;

        try {

            sql = "UPDATE exemplar SET status_cod = 4 WHERE exemp_cod = "+exemplar.getExemp_cod();

            System.out.println(sql);

            connection.manipular(sql);

        } catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados");
            return false;
        }
        return true;
    }
    
    public boolean consultaExemplarDisponivel(Livro l, Conexao connection, Exemplar exemp) {                      
        
        try {
            ResultSet rs;
            String sql;
            sql = "select e.exemp_cod "
                    + "from livros l "
                    + "inner join exemplar e on e.liv_cod = l.liv_cod "
                    + "where l.liv_cod = " + l.getLiv_codigo()
                    + " and e.status_cod = 1";
            rs = connection.consultar(sql);
            while (rs.next()) {
                exemp.setExemp_cod(rs.getInt("exemp_cod"));
            }
            return true;
        }
        catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados" + e);
        }
        return false;                                  
    }

}
