package model;

import dal.EsperaDal;
import java.util.List;
import util.Conexao;

public class Espera {
    
    private int esp_cod;
    private Alunfunc alunoFunc;
    private Exemplar exemplar;

    public Espera() {
    }   

    public Espera(int esp_cod, Alunfunc alunoFunc, Exemplar exemplar) {
        this.esp_cod = esp_cod;
        this.alunoFunc = alunoFunc;
        this.exemplar = exemplar;
    }

    public Espera(Alunfunc alunoFunc, Exemplar exemplar) {
        this.alunoFunc = alunoFunc;
        this.exemplar = exemplar;
    }
    
    

    public boolean insereLista(Alunfunc af, Exemplar exemp, Conexao connection){
        
        if(new EsperaDal().gravar(af, exemp, connection))
            return true;
        
        return false;
    }
           
    public List<Espera> listaDeEspera(Exemplar exemp, Conexao connection){
        return new EsperaDal().listaDeEspera(connection, exemp);
    }

    public int getEsp_cod() {
        return esp_cod;
    }

    public void setEsp_cod(int esp_cod) {
        this.esp_cod = esp_cod;
    }

    public Alunfunc getAlunoFunc() {
        return alunoFunc;
    }

    public void setAlunoFunc(Alunfunc alunoFunc) {
        this.alunoFunc = alunoFunc;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }
    
    
    
}
