package model;

import java.time.LocalDate;

public class Usuarios 
{
    public int usu_codigo;
    private String usu_login;
    private String usu_senha;
    private LocalDate data;
    private Privilegios privilegio;
    
    public Usuarios(int usu_codigo, String usu_login, String usu_senha, 
            LocalDate data, Privilegios privilegio) {
        this.usu_codigo = usu_codigo;
        this.usu_login = usu_login;
        this.usu_senha = usu_senha;
        this.data = data;
        this.privilegio = privilegio;
    }

    public Usuarios() {
    }

    public int getUsu_codigo() {
        return usu_codigo;
    }

    public void setUsu_codigo(int usu_codigo) {
        this.usu_codigo = usu_codigo;
    }

    public String getUsu_login() {
        return usu_login;
    }

    public void setUsu_login(String usu_login) {
        this.usu_login = usu_login;
    }

    public String getUsu_senha() {
        return usu_senha;
    }

    public void setUsu_senha(String usu_senha) {
        this.usu_senha = usu_senha;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Privilegios getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(Privilegios privilegio) {
        this.privilegio = privilegio;
    }

    public boolean validarUsuario( Usuarios u)
    {
        boolean valida = true;
        if(getUsu_login().equalsIgnoreCase("") || getUsu_login().length() < 3 )
        {
            valida = false;
        }
        else if(getUsu_senha().equalsIgnoreCase("") || getUsu_senha().length() < 3)
        {
            valida = false;
        }
        return valida;
    }
    
    
    @Override
    public String toString() {
        return "Usuarios{" + "usu_codigo=" + usu_codigo + 
                ", usu_login=" + usu_login + 
                ", usu_senha=" + usu_senha + 
                ", data=" + data +'}';
    }    

}
