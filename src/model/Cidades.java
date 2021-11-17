package model;
import dal.CidadesDal;
import java.util.ArrayList;
import java.util.List;
import util.Conexao;

public class Cidades {

    private int cid_cep;
    private String cid_municipio;
    private String cid_uf;

    public Cidades(int cid_cep, String cid_municipio, String cid_uf) {
        this.cid_cep = cid_cep;
        this.cid_municipio = cid_municipio;
        this.cid_uf = cid_uf;
    }

    public Cidades() {
    }

    public int getCid_cep() {
        return cid_cep;
    }

    public void setCid_cep(int cid_cep) {
        this.cid_cep = cid_cep;
    }

    public String getCid_municipio() {
        return cid_municipio;
    }

    public void setCid_municipio(String cid_municipio) {
        this.cid_municipio = cid_municipio;
    }

    public String getCid_uf() {
        return cid_uf;
    }

    public void setCid_uf(String cid_uf) {
        this.cid_uf = cid_uf;
    }

    public void pesquisar(Conexao connection, String filtro) {
        List<Alunfunc> lista = new ArrayList();
        CidadesDal cidDal = new CidadesDal();
        lista = cidDal.pesquisarCid(this, connection, filtro);
    }

}
