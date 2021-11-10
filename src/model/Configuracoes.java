package model;

public class Configuracoes {
    public int conf_cod;
    private double conf_multa;
    private double conf_juro;
    private int conf_limDia;

    public Configuracoes(int conf_cod, double conf_multa, double conf_juro, int conf_limDia) {
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
        this.conf_juro = conf_juro;
    }

    public int getConf_limDia() {
        return conf_limDia;
    }

    public void setConf_limDia(int conf_limDia) {
        this.conf_limDia = conf_limDia;
    }

    @Override
    public String toString() {
        return "Configuracoes{" + "conf_cod=" + conf_cod + ", conf_multa=" + conf_multa + ", conf_juro=" + conf_juro + ", conf_limDia=" + conf_limDia + '}';
    }
    
}
