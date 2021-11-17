package model;

import dal.AutorDal;
import java.util.List;
import util.Conexao;

public class Autor {
    
    private int aut_cod;
    private String aut_nome;

    public Autor(int aut_cod, String aut_nome) {
        this.aut_cod = aut_cod;
        this.aut_nome = aut_nome;
    }

    public Autor(String aut_nome) {
        this.aut_nome = aut_nome;
    }

    public Autor() {
    }

    public int getAut_cod() {
        return aut_cod;
    }

    public void setAut_cod(int aut_cod) {
        this.aut_cod = aut_cod;
    }

    public String getAut_nome() {
        return aut_nome;
    }

    public void setAut_nome(String aut_nome) {
        this.aut_nome = aut_nome;
    }
    
    
    public boolean gravar(Conexao connection, Privilegios  privilegios){              
        return new AutorDal().gravar(this, privilegios, connection);        
    }
    
    public boolean alterar (Conexao connection, Privilegios  privilegios){
        return new AutorDal().alterar(this, privilegios, connection);
    }
    
    public boolean apagar (Conexao connection, Privilegios  privilegios){
        return new AutorDal().apagar(this, privilegios, connection);
    }
    
    public Autor get (Conexao connection, Privilegios  privilegios, int id){
        return new AutorDal().get(id, privilegios, connection);
    }
    
    public List get (Conexao connection, Privilegios  privilegios, String filtro){
        return new AutorDal().get(filtro, privilegios, connection);
    }
    
}
