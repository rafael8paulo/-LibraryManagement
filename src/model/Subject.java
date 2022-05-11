package model;

import util.Conexao;

public interface Subject {   
    
    public boolean notificaDevolucao(Conexao connection);
    public boolean novoListaEspera(Alunfunc af, Conexao connection);
    //public boolean removeListaEspera(Alunfunc af, Conexao connection);
}
