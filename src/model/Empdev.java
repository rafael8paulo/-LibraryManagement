package model;

import java.time.LocalDate;

public class Empdev {            
    
    private int empdev_codigo;
    private LocalDate empdev_dt_emprestimo;
    private LocalDate empdev_dt_dev;
    private char empdev_eperaca;
    private LocalDate dt_prevista_dev;
    private int exemp_codigo;
    private int liv_codigo;
    private int aut_codigo;
    private int eit_codigo;

    public Empdev(int empdev_codigo, LocalDate empdev_dt_emprestimo, LocalDate empdev_dt_dev, char empdev_eperaca, LocalDate dt_prevista_dev, int exemp_codigo, int liv_codigo, int aut_codigo, int eit_codigo) {
        this.empdev_codigo = empdev_codigo;
        this.empdev_dt_emprestimo = empdev_dt_emprestimo;
        this.empdev_dt_dev = empdev_dt_dev;
        this.empdev_eperaca = empdev_eperaca;
        this.dt_prevista_dev = dt_prevista_dev;
        this.exemp_codigo = exemp_codigo;
        this.liv_codigo = liv_codigo;
        this.aut_codigo = aut_codigo;
        this.eit_codigo = eit_codigo;
    }

    public int getEmpdev_codigo() {
        return empdev_codigo;
    }

    public void setEmpdev_codigo(int empdev_codigo) {
        this.empdev_codigo = empdev_codigo;
    }

    public LocalDate getEmpdev_dt_emprestimo() {
        return empdev_dt_emprestimo;
    }

    public void setEmpdev_dt_emprestimo(LocalDate empdev_dt_emprestimo) {
        this.empdev_dt_emprestimo = empdev_dt_emprestimo;
    }

    public LocalDate getEmpdev_dt_dev() {
        return empdev_dt_dev;
    }

    public void setEmpdev_dt_dev(LocalDate empdev_dt_dev) {
        this.empdev_dt_dev = empdev_dt_dev;
    }

    public char getEmpdev_eperaca() {
        return empdev_eperaca;
    }

    public void setEmpdev_eperaca(char empdev_eperaca) {
        this.empdev_eperaca = empdev_eperaca;
    }

    public LocalDate getDt_prevista_dev() {
        return dt_prevista_dev;
    }

    public void setDt_prevista_dev(LocalDate dt_prevista_dev) {
        this.dt_prevista_dev = dt_prevista_dev;
    }

    public int getExemp_codigo() {
        return exemp_codigo;
    }

    public void setExemp_codigo(int exemp_codigo) {
        this.exemp_codigo = exemp_codigo;
    }

    public int getLiv_codigo() {
        return liv_codigo;
    }

    public void setLiv_codigo(int liv_codigo) {
        this.liv_codigo = liv_codigo;
    }

    public int getAut_codigo() {
        return aut_codigo;
    }

    public void setAut_codigo(int aut_codigo) {
        this.aut_codigo = aut_codigo;
    }

    public int getEit_codigo() {
        return eit_codigo;
    }

    public void setEit_codigo(int eit_codigo) {
        this.eit_codigo = eit_codigo;
    }
    
}
