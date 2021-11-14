package applibrarymanagement;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FXMLRealizarDevolucaoController implements Initializable {

    @FXML
    private Button btnQuitar;
    @FXML
    private Button btnPesquisar;
    @FXML
    private TextField txtCodigo;
    @FXML
    private TextField txtVlrPend;
    @FXML
    private TextField txtDtPag;
    @FXML
    private TextField txtCodigoEmp;
    @FXML
    private TextField PendQuitada;
    @FXML
    private TextField txtPesquisa;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        estadoIncial();        
    }    

    @FXML
    private void evtBtnSQuitar(ActionEvent event) {                        
    }

    @FXML
    private void evtBtnPesquisar(ActionEvent event) {
        limparCampos();
        estadoPesquisa();
    }
    
    private void estadoPesquisa() {
        btnQuitar.setDisable(false);
        txtPesquisa.setDisable(false);
    }
    
    private void estadoIncial() {
        btnQuitar.setDisable(true);
        txtCodigo.setDisable(true);
        txtPesquisa.setDisable(true);
        txtCodigo.setDisable(true);
        txtCodigoEmp.setDisable(true);
        txtDtPag.setDisable(true);
        txtVlrPend.setDisable(true);
        PendQuitada.setDisable(true);
    }
    
    private void limparCampos() {
       txtCodigo.setText("");
    }
}
