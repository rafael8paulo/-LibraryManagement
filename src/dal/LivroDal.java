package dal;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import model.Livro;
import util.Conexao;

public class LivroDal {
    
    public List getAll(Livro l, Conexao connection) {
        
        ArrayList<Livro> lista = new ArrayList();        
        
        connection.conectar();
        try {
            ResultSet rs;
            String sql;
            sql = sql = "SELECT * FROM livros"; //WHERE liv_nome = '%" + filtro + "%'
            rs = connection.consultar(sql);
            while (rs.next()) {
                
                l.setLiv_codigo(rs.getInt("liv_cod"));
                l.setLiv_nome(rs.getString("liv_nome"));                
                l.setLiv_dtpublic(LocalDate.parse(rs.getString("liv_dtpublic"), DateTimeFormatter.ISO_DATE));
                l.setLiv_qtdpaginas(rs.getInt("liv_qtdpaginas"));                                
                lista.add(l);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados" + e);
        }
        return null;

    }
}
