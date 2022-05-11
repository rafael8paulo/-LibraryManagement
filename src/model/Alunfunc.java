package model;

import dal.AlunfuncDal;
import java.util.ArrayList;
import java.util.List;
import util.Conexao;

public class Alunfunc implements Observer{

    private String alf_nome;
    public int alf_codigo;
    private String alf_email;
    private String alf_celular;
    private String alf_logradouro;
    private String alf_numres;
    private String alf_tipo;

    public Alunfunc(int alf_codigo) {
        this.alf_codigo = alf_codigo;
    }

        
    public String getAlf_email() {
        return alf_email;
    }

    public void setAlf_email(String alf_email) {
        this.alf_email = alf_email;
    }

    public String getAlf_celular() {
        return alf_celular;
    }

    public void setAlf_celular(String alf_celular) {
        this.alf_celular = alf_celular;
    }

    public String getAlf_logradouro() {
        return alf_logradouro;
    }

    public void setAlf_logradouro(String alf_logradouro) {
        this.alf_logradouro = alf_logradouro;
    }

    public String getAlf_numres() {
        return alf_numres;
    }

    public void setAlf_numres(String alf_numres) {
        this.alf_numres = alf_numres;
    }

    public String getAlf_tipo() {
        return alf_tipo;
    }

    public void setAlf_tipo(String alf_tipo) {
        this.alf_tipo = alf_tipo;
    }

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

    public void pesquisar(Conexao connection, String filtro) {
        List<Alunfunc> lista = new ArrayList();
        AlunfuncDal alunfuncDal = new AlunfuncDal();
        lista = alunfuncDal.pesquisarAlunfunc(this, connection, filtro);
    }
    
    public boolean pesquisaByName(Conexao connection, String filtro, Cidades cid)
    {
       AlunfuncDal alunfuncDal = new AlunfuncDal();
       List<Alunfunc> lista = new ArrayList();
       
       lista = alunfuncDal.pesquisarAlunfuncByName(this, connection, filtro, cid);

        if (!lista.isEmpty()) {
            lista.get(0).getAlf_nome();
            lista.get(0).getAlf_logradouro();
            lista.get(0).getAlf_email();
            lista.get(0).getAlf_celular();
            lista.get(0).getAlf_tipo();        
            return true;
        } else {
            return false;
        }
    }        

    public boolean gravar(Conexao connection, Cidades cid) {
       AlunfuncDal afDal = new AlunfuncDal();
       return afDal.gravar(this, cid, connection);
    }
   
    @Override
    public void atualizar() {
        System.out.println("Olá "+this.alf_nome+" o livro está disponivel");
    }

}
