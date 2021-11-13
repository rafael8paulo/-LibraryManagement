package model;

import dal.PrivilegiosDal;
import java.util.ArrayList;
import java.util.List;
import util.Conexao;

public class Privilegios 
{
    public int per_cod;
    public String per_descricao;
    public boolean per_incluir;
    public boolean per_excluir;
    public boolean per_consultar;
    public boolean per_editar;
    public boolean per_movimentar;

    public Privilegios(int per_cod, String per_descricao, 
            boolean per_incluir, boolean per_excluir,
            boolean per_consultar, boolean per_editar,
            boolean per_movimentar) {
        this.per_cod = per_cod;
        this.per_descricao = per_descricao;
        this.per_incluir = per_incluir;
        this.per_excluir = per_excluir;
        this.per_consultar = per_consultar;
        this.per_editar = per_editar;
        this.per_movimentar = per_movimentar;
    }

    public Privilegios() {
        this(0,"",false,false,false,false,false);
    }
    
    public int getPer_cod() {
        return per_cod;
    }

    public void setPer_cod(int per_cod) {
        this.per_cod = per_cod;
    }

    public String getPer_descricao() {
        return per_descricao;
    }

    public void setPer_descricao(String per_descricao) {
        this.per_descricao = per_descricao;
    }

    public boolean isPer_incluir() {
        return per_incluir;
    }

    public void setPer_incluir(boolean per_incluir) {
        this.per_incluir = per_incluir;
    }

    public boolean isPer_excluir() {
        return per_excluir;
    }

    public void setPer_excluir(boolean per_excluir) {
        this.per_excluir = per_excluir;
    }

    public boolean isPer_consultar() {
        return per_consultar;
    }

    public void setPer_consultar(boolean per_consultar) {
        this.per_consultar = per_consultar;
    }

    public boolean isPer_editar() {
        return per_editar;
    }

    public void setPer_editar(boolean per_editar) {
        this.per_editar = per_editar;
    }

    public boolean isPer_movimentar() {
        return per_movimentar;
    }

    public void setPer_movimentar(boolean per_movimentar) {
        this.per_movimentar = per_movimentar;
    }
    
    @Override
    public String toString() {
        return per_descricao;
    }
    
    public List<Privilegios> carregarPrivilegios(Conexao connection)
    {
        PrivilegiosDal pDal = new PrivilegiosDal();
        List<Privilegios> listaCategoria = new ArrayList();
        listaCategoria = pDal.retornarLista(this,connection,"");
        return listaCategoria;
    }
    
    public void carregaPrivilegio(Conexao connection, String filtro)
    {
        PrivilegiosDal pDal = new PrivilegiosDal();
        List<Privilegios> listaCategoria = new ArrayList();
        listaCategoria = pDal.retornaPrivilegio(this,connection,filtro);   
        setPer_cod(listaCategoria.get(0).getPer_cod());
        setPer_descricao(listaCategoria.get(0).getPer_descricao());
    }
}
