package applibrarymanagement;
import dal.LoginDal;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import model.Usuarios;
import util.Alertas;

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
        
    }    
    @FXML
    private void evtBtnEntrar(ActionEvent event) throws IOException {
        List<Usuarios>lista = new ArrayList();
        Alertas a = new Alertas();
        Usuarios u = new Usuarios();
        LoginDal ldal = new LoginDal();
        u.setUsu_login(txtLogin.getText());
        u.setUsu_senha(txtSenha.getText());
        if(u.validarUsuario(u))
        {
            lista = ldal.get(u.getUsu_login());
            if(lista.size()<=0)
                a.mensagem1("Credenciais não encontradas");
            else      
            if(lista.get(0).getUsu_login().equalsIgnoreCase(txtLogin.getText()))
            {
                if(lista.get(0).getUsu_senha().equalsIgnoreCase(txtSenha.getText()))
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