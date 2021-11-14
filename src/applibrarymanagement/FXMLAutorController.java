package applibrarymanagement;

import dal.AutorDal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Autor;
import model.Privilegios;
import util.Alertas;
import util.Conexao;

public class FXMLAutorController implements Initializable {

    @FXML
    private Button btnIncluir;
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnExcluir;
    @FXML
    private Button btnPesquisar;
    @FXML
    private TextField txtCodigo;
    @FXML
    private TextField txtNomeAutor;

    Alertas alerta = new Alertas();
    
    Conexao connection = new Conexao();
    Privilegios p = new Privilegios();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        estadoIncial();
    }

    @FXML
    private void evtBtnIncluir(ActionEvent event) {
        limparCampos();
        estadoEdicao();
    }

    @FXML
    private void evtBtnSalvar(ActionEvent event) {

        if (!txtNomeAutor.getText().isEmpty()) {

            if (txtNomeAutor.getText().matches("^[a-zA-Z]+$")) {                
                Autor a = new Autor(txtNomeAutor.getText());
                if (a.gravar(connection, p)) {
                                                            
                    alerta.mensagem1("Salvo com Sucesso!!!");
                    btnExcluir.setDisable(false);
                    
                } else {
                    alerta.mensagem1("Erro ao gravar!!!");
                }

            } else {
                alerta.mensagem1(" Este campo não permite números ou caracteres especiais ");
            }

        } else {
            alerta.mensagem1("Complete os campos!!!");
        }

    }

    @FXML
    private void evtBtnExcluir(ActionEvent event) {

    }

    @FXML
    private void evtBtnPesquisar(ActionEvent event) {
    }

    private void limparCampos() {
        txtCodigo.setText("");
        txtNomeAutor.setText("");

    }

    private void estadoEdicao() {
        btnSalvar.setDisable(false);
        txtNomeAutor.setDisable(false);
    }

    private void estadoIncial() {
        btnSalvar.setDisable(true);
        txtCodigo.setDisable(true);
        txtNomeAutor.setDisable(true);
    }
    
}
