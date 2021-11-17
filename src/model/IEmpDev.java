package model;

import dal.ExemplarDal;
import dal.IEmpDevDal;
import java.time.LocalDate;
import util.Conexao;

public class IEmpDev {

    private LocalDate itens_dtdev;
    private int empdev_cod;
    private int exemp_cod;

    public IEmpDev(LocalDate itens_dtdev, int empdev_cod, int exemp_cod) {
        this.itens_dtdev = itens_dtdev;
        this.empdev_cod = empdev_cod;
        this.exemp_cod = exemp_cod;
    }

    public IEmpDev(LocalDate itens_dtdev) {
        this.itens_dtdev = itens_dtdev;
    }

    public LocalDate getItens_dtdev() {
        return itens_dtdev;
    }

    public void setItens_dtdev(LocalDate itens_dtdev) {
        this.itens_dtdev = itens_dtdev;
    }

    public int getEmpdev_cod() {
        return empdev_cod;
    }

    public void setEmpdev_cod(int empdev_cod) {
        this.empdev_cod = empdev_cod;
    }

    public int getExemp_cod() {
        return exemp_cod;
    }

    public void setExemp_cod(int exemp_cod) {
        this.exemp_cod = exemp_cod;
    }

    public boolean devolucao(Conexao connection, int exemp_cod) {

        Exemplar e = new Exemplar();
        e.setExemp_cod(exemp_cod);

        if (e.alterar(connection)) {
            System.out.println("Entrou");
            if (new IEmpDevDal().alterar(connection, this)) {
                System.out.println("Entrou");
                return true;
            }
        }

        return false;
    }
}
