package model;

import dal.ExemplarDal;
import java.util.List;
import util.Conexao;


public class Exemplar implements Subject{
    
    private int exemp_cod;
    private String exemp_setor;
    private Status status;
    private Livro livro;
        
    public Exemplar(int exemp_cod, String exemp_setor, Status status, Livro livro) {
        this.exemp_cod = exemp_cod;
        this.exemp_setor = exemp_setor;
        this.status = status;
        this.livro = livro;
    }

    public Exemplar(String exemp_setor, Status status, Livro livro) {
        this.exemp_setor = exemp_setor;
        this.status = status;
        this.livro = livro;
    }

    public Exemplar(int exemp_cod) {
        this.exemp_cod = exemp_cod;
    }        
    
    public Exemplar() {
    }
            
    public int getExemp_cod() {
        return exemp_cod;
    }

    public void setExemp_cod(int exemp_cod) {
        this.exemp_cod = exemp_cod;
    }

    public String getExemp_setor() {
        return exemp_setor;
    }

    public void setExemp_setor(String exemp_setor) {
        this.exemp_setor = exemp_setor;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }    
            
    public boolean alterar(Conexao connection){
        
        if(new ExemplarDal().alterar(connection, this))
            return true;
        
        return false;
    }
    
    public boolean emprestar(Conexao connection){
        
        if(new ExemplarDal().emprestar(connection, this))
            return true;
        
        return false;
    }
    
    public boolean consultaExemplarDisponivel(Conexao connection, Livro l){
        
        if(new ExemplarDal().consultaExemplarDisponivel(l, connection, this))
            return true;
        
        return false;
    }

    @Override
    public boolean notificaDevolucao(Conexao connection) {
        
        List<Espera> lista = new Espera().listaDeEspera(this, connection);
                
        for(Espera e : lista){
            e.getAlunoFunc().atualizar(); //Envia SMS ou Email
        }
        
        return false;
    }

    @Override
    public boolean novoListaEspera(Alunfunc af, Conexao connection) {
        
        Espera e = new Espera();
        
        if(e.insereLista(af, this, connection)){
            return true;
        }
        
        return false;
        
    }
    
}
