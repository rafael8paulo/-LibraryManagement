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
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Privilegios;
import util.Alertas;

public class FXMLPrincipalController implements Initializable {

    @FXML
    private Button btnSair;
    @FXML
    private MenuItem mUsuario;
    @FXML
    private MenuItem mAutor;
    @FXML
    private MenuItem mConfiguracoes;
    @FXML
    private MenuItem mPendencia;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void evtBtnSair(ActionEvent event) {
         btnSair.getScene().getWindow().hide();      
    }

    @FXML
    private void evtmUsuario(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLUsuarios.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage=new Stage();
                    stage.setScene(scene);       
                    //stage.setResizable(false);  
                    stage.initModality(Modality.APPLICATION_MODAL);
                    //stage.initStyle(StageStyle.UNDECORATED);
                    stage.showAndWait();     
    }

    @FXML
    private void evtmAutor(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLAutor.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage=new Stage();
                    stage.setScene(scene);       
                    //stage.setResizable(false);  
                    stage.initModality(Modality.APPLICATION_MODAL);
                    //stage.initStyle(StageStyle.UNDECORATED);
                    stage.showAndWait();     
    }

    @FXML
    private void evtmConfiguracoes(ActionEvent event) throws IOException {
               Parent root = FXMLLoader.load(getClass().getResource("FXMLConfiguracoes.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage=new Stage();
                    stage.setScene(scene);       
                    //stage.setResizable(false);  
                    stage.initModality(Modality.APPLICATION_MODAL);
                    //stage.initStyle(StageStyle.UNDECORATED);
                    stage.showAndWait();  
        
    }

    @FXML
    private void evtmPendencia(ActionEvent event) throws IOException {
        Alertas alerta = new Alertas();
        if(Privilegios.per_movimentar){
                Parent root = FXMLLoader.load(getClass().getResource("FXMLQuitar.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage=new Stage();
                    stage.setScene(scene);       
                    stage.setResizable(false);  
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.showAndWait();
        }
        else
            alerta.mensagem1("Permissão não concedida");
        
        
    }

    @FXML
    private void evtDevolucao(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLRealizarDevolucao.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.showAndWait();

    }

    
}
