package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {

    private Connection connect;
    private String erro;

    public Conexao() {
        erro = "";
        connect = null;
        conectar();
    }
    
    public boolean conectar() {
                        
        boolean conectado = false;
        try {
            //Class.forName(driver); "org.postgresql.Driver");
            String url = "jdbc:postgresql://"+Banco.host+":5432/"+Banco.database+"?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";  //"jdbc:postgresql://localhost/"+banco;
            //System.out.println(url);
            connect = DriverManager.getConnection(url, Banco.login, Banco.senha);
            conectado = true;
        } catch (SQLException sqlex) {
            erro = "Impossivel conectar com a base de dados: " + sqlex.toString();
        } catch (Exception ex) {
            erro = "Outro erro: " + ex.toString();
        }
        return conectado;
    }
    
    public String getMensagemErro() {
        return erro;
    }

    public boolean getEstadoConexao() {
        return (connect != null);
    }

    public boolean manipular(String sql) // inserir, alterar,excluir
    {
        boolean executou = false;
        try {
            Statement statement = connect.createStatement();
            int result = statement.executeUpdate(sql);
            statement.close();
            if (result >= 1) {
                executou = true;
            }
        } catch (SQLException sqlex) {
            erro = "Erro: " + sqlex.toString();
        }
        return executou;
    }

    public ResultSet consultar(String sql) {
        ResultSet rs = null;
        try {
            Statement statement = connect.createStatement();
            rs = statement.executeQuery(sql);
            //statement.close();
        } catch (SQLException sqlex) {
            erro = "Erro: " + sqlex.toString();
            rs = null;
        }
        return rs;
    }

    public int getMaxPK(String tabela, String chave) {
        String sql = "select max(" + chave + ") from " + tabela;
        int max = 0;
        ResultSet rs = consultar(sql);
        try {
            if (rs.next()) {
                max = rs.getInt(1);
            }
        } catch (SQLException sqlex) {
            erro = "Erro: " + sqlex.toString();
            max = -1;
        }
        return max;
    }

    public void closeConnection() throws SQLException {
        if (connect != null) {
            connect.close();
        }
    }
}
