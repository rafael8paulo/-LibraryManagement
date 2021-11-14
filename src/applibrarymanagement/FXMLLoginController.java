package applibrarymanagement;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Login;
import util.Alertas;
import util.Conexao;

public class FXMLLoginController implements Initializable {
    @FXML
    private TextField txtLogin;
    @FXML
    private PasswordField txtSenha;
    @FXML
    private Button btnEntrar;
    @FXML
    private Button btnSair;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        limparCampos();
         //instanciar model privilegios pra retornar os privilegios
         //gravar os privilegios em uma classe statica
         //gravar o usuario logado em classe estatica     
    }    
    @FXML
    private void evtBtnEntrar(ActionEvent event) throws IOException {
        Conexao connection = new Conexao();
        Alertas a = new Alertas();
        Login login = new Login();
        login.setLogin(txtLogin.getText());
        login.setSenha(txtSenha.getText());
        if(login.validaLogin())
        {  
            if(login.getLogin().equalsIgnoreCase(txtLogin.getText()))
            {
                if(login.getSenha().equalsIgnoreCase(txtSenha.getText()))
                {
                    btnSair.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("FXMLPrincipal.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage=new Stage();
                    stage.setScene(scene);       
                    //stage.setResizable(false);  
                    //stage.initModality(Modality.APPLICATION_MODAL);
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.setMaximized(true);
                    stage.showAndWait();       
                }
                else
                    a.mensagem1("Credenciais não encontradas");
            } 
        }
        else 
            a.mensagem1("Dados inválidos");         
    }
    @FXML
    private void evtBtnSair(ActionEvent event) {
        btnSair.getScene().getWindow().hide();
    }  
    private void limparCampos()
    {
        txtLogin.setText("");
        txtSenha.setText("");
    }
}