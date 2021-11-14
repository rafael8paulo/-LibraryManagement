package model;
import dal.LoginDal;
import java.util.ArrayList;
import java.util.List;
import util.Conexao;

public class Login {

    private String login;
    private String senha;

    public Login(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Login() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Login{" + "login=" + login + ", senha=" + senha + '}';
    }

    public boolean validaLogin() {
        boolean valida = true;
        if (getLogin().equalsIgnoreCase("") || getLogin().length() < 3) {
            valida = false;
        } else if (getSenha().equalsIgnoreCase("") || getSenha().length() < 3) {
            valida = false;
        }
        return valida;
    }
    public boolean logar(Conexao connection) {
        LoginDal ldal = new LoginDal();
        List<Login>lista = new ArrayList();
        lista = ldal.get(this,getLogin(),connection);
        if(lista.size()<=0)           
            return false;
        else    
        {
            setLogin(lista.get(0).getLogin());
            setSenha(lista.get(0).getSenha());           
            return true; 
        }
    }
}
