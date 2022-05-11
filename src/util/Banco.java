package util;

public class Banco {
    
    static private Conexao conexao=new Conexao();
    
    static String host = "ec2-44-192-245-97.compute-1.amazonaws.com";
    static String login = "eogmlmangmteiu";
    static String senha = "143600efe47d7eace0c82a3f103edfc664cba7c173f2461c1d52b2e2bd601339";
    static String database = "d6rdde6ibiogqo";
    
    
    private Banco() {        
    }
    
    static public boolean conectar()
    {                
        return conexao.conectar();        
    }
    
    static public Conexao getCon() {
        return conexao;
    }
    
}


