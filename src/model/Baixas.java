package model;

import java.time.LocalDate;


public class Baixas {
    
    
    private int baix_cod;
    private String baix_motivo;
    private LocalDate baix_data;
    private Exemplar exemplar;
    private Empdev empdev;

    public Baixas(int baix_cod, String baix_motivo, LocalDate baix_data, Exemplar exemplar, Empdev empdev) {
        this.baix_cod = baix_cod;
        this.baix_motivo = baix_motivo;
        this.baix_data = baix_data;
        this.exemplar = exemplar;
        this.empdev = empdev;
    }

    public Baixas() {
    }

    public Baixas(String baix_motivo, LocalDate baix_data, Exemplar exemplar) {
        this.baix_motivo = baix_motivo;
        this.baix_data = baix_data;
        this.exemplar = exemplar;
    }

    public Baixas(String baix_motivo, LocalDate baix_data, Exemplar exemplar, Empdev empdev) {
        this.baix_motivo = baix_motivo;
        this.baix_data = baix_data;
        this.exemplar = exemplar;
        this.empdev = empdev;
    }
       
    public int getBaix_cod() {
        return baix_cod;
    }

    public String getBaix_motivo() {
        return baix_motivo;
    }

    public LocalDate getBaix_data() {
        return baix_data;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public Empdev getEmpdev() {
        return empdev;
    }
    
    
    
}
