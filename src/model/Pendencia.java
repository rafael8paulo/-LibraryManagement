package model;
import dal.PendenciaDal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import util.Conexao;

public class Pendencia {
    private int pend_cod;
    private LocalDate pend_dtpgto;
    private String quitada;
    private int valor;
    private Alunfunc alunfunc;

    public Pendencia() {
    }

    public Pendencia(int pend_cod, LocalDate pend_dtpgto, String quitada, int valor, Alunfunc alunfunc) {
        this.pend_cod = pend_cod;
        this.pend_dtpgto = pend_dtpgto;
        this.quitada = quitada;
        this.valor=valor;
        this.alunfunc = alunfunc;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
    public int getPend_cod() {
        return pend_cod;
    }

    public void setPend_cod(int pend_cod) {
        this.pend_cod = pend_cod;
    }

    public LocalDate getPend_dtpgto() {
        return pend_dtpgto;
    }

    public void setPend_dtpgto(LocalDate pend_dtpgto) {
        this.pend_dtpgto = pend_dtpgto;
    }

    public String getQuitada() {
        return quitada;
    }

    public void setQuitada(String quitada) {
        this.quitada = quitada;
    }

    public Alunfunc getAlunfunc() {
        return alunfunc;
    }

    public void setAlunfunc(Alunfunc alunfunc) {
        this.alunfunc = alunfunc;
    }

    @Override
    public String toString() {
        return "Pendencia{" + "pend_cod=" + pend_cod + ", pend_dtpgto=" + pend_dtpgto + ", quitada=" + quitada + ", valor=" + valor + ", alunfunc=" + alunfunc + '}';
    }
    

    
    public List<Pendencia>carregar(Conexao connection, int filtro, String filtro2, Alunfunc alunfunc)
    {
        List<Pendencia> listaPend = new ArrayList();
        PendenciaDal pDal = new PendenciaDal();       
        listaPend = pDal.carregarTabela(filtro, connection,alunfunc,filtro2);
        return listaPend;
    } 
    
    public boolean baixarPendencia(Conexao connection, int codSelecao)
    {
        PendenciaDal pDal = new PendenciaDal();  
        this.pend_cod = codSelecao;
        this.pend_dtpgto = LocalDate.now();
        pDal.alterar(connection, valor, this);
        return true;
    }
    
    
}
