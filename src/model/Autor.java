package model;

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
    
    
    
            
}
