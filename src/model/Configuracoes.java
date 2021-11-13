package model;
<<<<<<< HEAD
import dal.ConfiguracoesDal;
import util.Conexao;


public class Configuracoes {
    public int conf_cod;
    private int conf_multa;
    private int conf_juro;
    private int conf_limDia;

    public Configuracoes(int conf_cod, int conf_multa, int conf_juro, int conf_limDia) {
=======

public class Configuracoes {
    public int conf_cod;
    private double conf_multa;
    private double conf_juro;
    private int conf_limDia;

    public Configuracoes(int conf_cod, double conf_multa, double conf_juro, int conf_limDia) {
>>>>>>> b339f3d272e1cfb3ec5f82f1d89435cbd6209669
        this.conf_cod = conf_cod;
        this.conf_multa = conf_multa;
        this.conf_juro = conf_juro;
        this.conf_limDia = conf_limDia;
    }

    public Configuracoes() {
    }

    public int getConf_cod() {
        return conf_cod;
    }

    public void setConf_cod(int conf_cod) {
        this.conf_cod = conf_cod;
    }

<<<<<<< HEAD
    public int getConf_multa() {
        return conf_multa;
    }

    public void setConf_multa(int conf_multa) {
        this.conf_multa = conf_multa;
    }

    public int getConf_juro() {
        return conf_juro;
    }

    public void setConf_juro(int conf_juro) {
=======
    public double getConf_multa() {
        return conf_multa;
    }

    public void setConf_multa(double conf_multa) {
        this.conf_multa = conf_multa;
    }

    public double getConf_juro() {
        return conf_juro;
    }

    public void setConf_juro(double conf_juro) {
>>>>>>> b339f3d272e1cfb3ec5f82f1d89435cbd6209669
        this.conf_juro = conf_juro;
    }

    public int getConf_limDia() {
        return conf_limDia;
    }

    public void setConf_limDia(int conf_limDia) {
        this.conf_limDia = conf_limDia;
    }

<<<<<<< HEAD
    public boolean gravar(Conexao connection)
    {
        ConfiguracoesDal confDal = new ConfiguracoesDal();
        return confDal.gravar(this, connection);
    }
    
    public boolean apagar(Conexao connection)
    {
        ConfiguracoesDal confDal = new ConfiguracoesDal();
        return confDal.apagar(this, connection);
    }
    
    public void exibir(Conexao connection)
    {
        ConfiguracoesDal confDal = new ConfiguracoesDal();
        confDal.get(this, connection);
    }

    @Override
    public String toString() {
        return "Configuracoes{" + "conf_cod=" + conf_cod + 
                ", conf_multa=" + conf_multa + ", conf_juro=" +
                conf_juro + ", conf_limDia=" + conf_limDia + '}';
    }
=======
    @Override
    public String toString() {
        return "Configuracoes{" + "conf_cod=" + conf_cod + ", conf_multa=" + conf_multa + ", conf_juro=" + conf_juro + ", conf_limDia=" + conf_limDia + '}';
    }
    
>>>>>>> b339f3d272e1cfb3ec5f82f1d89435cbd6209669
}
