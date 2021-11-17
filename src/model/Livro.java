package model;

import java.time.LocalDate;

public class Livro {

    private int liv_codigo;
    private String liv_nome;
    private LocalDate liv_dtpublic;
    private int liv_qtdpaginas;

    public Livro(int liv_codigo, String liv_nome, LocalDate liv_dtpublic, int liv_qtdpaginas) {
        this.liv_codigo = liv_codigo;
        this.liv_nome = liv_nome;
        this.liv_dtpublic = liv_dtpublic;
        this.liv_qtdpaginas = liv_qtdpaginas;
    }

    public Livro(String liv_nome) {
        this.liv_nome = liv_nome;
    }
    
    public Livro() {
    }
        
    public Livro(String liv_nome, LocalDate liv_dtpublic, int liv_qtdpaginas) {
        this.liv_nome = liv_nome;
        this.liv_dtpublic = liv_dtpublic;
        this.liv_qtdpaginas = liv_qtdpaginas;
    }

    public int getLiv_codigo() {
        return liv_codigo;
    }

    public void setLiv_codigo(int liv_codigo) {
        this.liv_codigo = liv_codigo;
    }

    public String getLiv_nome() {
        return liv_nome;
    }

    public void setLiv_nome(String liv_nome) {
        this.liv_nome = liv_nome;
    }

    public LocalDate getLiv_dtpublic() {
        return liv_dtpublic;
    }

    public void setLiv_dtpublic(LocalDate liv_dtpublic) {
        this.liv_dtpublic = liv_dtpublic;
    }

    public int getLiv_qtdpaginas() {
        return liv_qtdpaginas;
    }

    public void setLiv_qtdpaginas(int liv_qtdpaginas) {
        this.liv_qtdpaginas = liv_qtdpaginas;
    }
    
    
    
}
