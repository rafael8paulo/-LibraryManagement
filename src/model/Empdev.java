package model;

import dal.EmpreDevoDal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import util.Conexao;

public class Empdev {

    private int empdev_cod;
    private LocalDate empdev_dttemp;
    private int empdev_oper;
    private LocalDate dtprev;
    private Alunfunc alunfunc;
    private Livro livro;
    
    public Empdev(int empdev_cod, LocalDate empdev_dttemp, int empdev_oper, LocalDate dtprev, Alunfunc alunfunc) {
        this.empdev_cod = empdev_cod;
        this.empdev_dttemp = empdev_dttemp;
        this.empdev_oper = empdev_oper;
        this.dtprev = dtprev;
        this.alunfunc = alunfunc;
    }

    public Empdev(int empdev_cod, LocalDate dtprev, Alunfunc alunfunc, Livro livro) {
        this.empdev_cod = empdev_cod;
        this.dtprev = dtprev;
        this.alunfunc = alunfunc;
        this.livro = livro;
    }
                    
    public Empdev() {
        dtprev =  LocalDate.now().plusDays(7);        
    }
    
    
    
    public int getEmpdev_cod() {
        return empdev_cod;
    }

    public void setEmpdev_cod(int empdev_cod) {
        this.empdev_cod = empdev_cod;
    }

    public LocalDate getEmpdev_dttemp() {
        return empdev_dttemp;
    }

    public void setEmpdev_dttemp(LocalDate empdev_dttemp) {
        this.empdev_dttemp = empdev_dttemp;
    }

    public int getEmpdev_oper() {
        return empdev_oper;
    }

    public void setEmpdev_oper(int empdev_oper) {
        this.empdev_oper = empdev_oper;
    }

    public LocalDate getDtprev() {
        return dtprev;
    }

    public void setDtprev(LocalDate dtprev) {
        this.dtprev = dtprev;
    }

    public Alunfunc getAlunfunc() {
        return alunfunc;
    }

    public void setAlunfunc(Alunfunc alunfunc) {
        this.alunfunc = alunfunc;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
        
    @Override
    public String toString() {
        return "Empdev{" + "empdev_cod=" + empdev_cod + ", empdev_dttemp=" + empdev_dttemp + ", empdev_oper=" + empdev_oper + ", dtprev=" + dtprev + ", alunfunc=" + alunfunc + ", livro=" + livro + '}';
    }
        
    public List<Empdev>carregar(Conexao connnection, int matricula, String nome, Alunfunc alunfunc, Livro livro)
    {
        List<Empdev> listaPend = new ArrayList();
        EmpreDevoDal Dal = new EmpreDevoDal();       
        listaPend = Dal.carregarTabelaDevo(matricula, nome, connnection, alunfunc, livro);
        return listaPend;
    }         
    
    public int consultarDiasEmAtraso(Conexao connection){        
        return new EmpreDevoDal().atrasoEmDias(connection, this.getEmpdev_cod());        
    }
    
    public boolean Emprestimo(Conexao connection,  int exemp_cod, Alunfunc af){                        
        return new EmpreDevoDal().emprestimo(connection, this, af);
    }
    
    public boolean consultaUltimoID(Conexao connection, Alunfunc af){
        return new EmpreDevoDal().consultaUltimoID(connection, af, this);
    }
    
}
