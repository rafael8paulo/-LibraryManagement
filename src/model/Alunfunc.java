package model;

import dal.AlunfuncDal;
import java.util.ArrayList;
import java.util.List;
import util.Conexao;

public class Alunfunc {
    private String alf_nome;
    private int alf_codigo;

    public Alunfunc() {
    }

    public Alunfunc(String alf_nome, int alf_codigo) {
        this.alf_nome = alf_nome;
        this.alf_codigo = alf_codigo;
    }

    public String getAlf_nome() {
        return alf_nome;
    }

    public void setAlf_nome(String alf_nome) {
        this.alf_nome = alf_nome;
    }

    public int getAlf_codigo() {
        return alf_codigo;
    }

    public void setAlf_codigo(int alf_codigo) {
        this.alf_codigo = alf_codigo;
    }
    
    

    @Override
    public String toString() {
        return "Alunfunc{" + "alf_nome=" + alf_nome + ", alf_codigo=" + alf_codigo + '}';
    }
    
    
    public void pesquisar(Conexao connection, String filtro)    
    {
         List<Alunfunc> lista = new ArrayList();
         AlunfuncDal alunfuncDal = new AlunfuncDal();
         lista = alunfuncDal.pesquisarAlunfunc(this, connection, filtro);
    }
    
    
}
