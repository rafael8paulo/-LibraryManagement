package model;
import dal.UsuariosDal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import util.Conexao;

public class Usuarios {

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

    public boolean gravar(Conexao connection, Privilegios privilegios, String filtro) {
        UsuariosDal uDal = new UsuariosDal();
        privilegios.carregaPrivilegio(connection, filtro);
        return uDal.gravar(this, privilegios, connection);
    }

    public boolean excluir(Conexao connection) {
        UsuariosDal uDal = new UsuariosDal();
        uDal.apagar(this, connection);
        return true;
    }

    public boolean pesquisar(Conexao connection, String auxiliar) {
        UsuariosDal lDal = new UsuariosDal();
        List<Usuarios> lista = new ArrayList();
        lista = lDal.get(this, auxiliar, connection);

        if (!lista.isEmpty()) {
            lista.get(0).getUsu_codigo();
            lista.get(0).getUsu_login();
            lista.get(0).getUsu_senha();
            lista.get(0).getData().toString();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Usuarios{" + "usu_codigo=" + usu_codigo
                + ", usu_login=" + usu_login
                + ", usu_senha=" + usu_senha
                + ", data=" + data + '}';
    }

}
