package applibrarymanagement;

import dal.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.*;
import util.Alertas;
import util.Conexao;

public class FXMLUsuariosController implements Initializable {

    @FXML
    private Button btnIncluir;
    @FXML
    private Button btnSalvar;
    @FXML
    private ComboBox<Privilegios> cboPrivilegios;
    @FXML
    private TextField txtCodigo;
    @FXML
    private TextField txtUsuario;
    @FXML
    private TextField txtSenha;
    @FXML
    private TextField txtData;
    @FXML
    private Button btnExcluir;

    private ObservableList<Privilegios> obsPrivilegios;
    @FXML
    private Button btnPesquisar;
    @FXML
    private TextField txtPesquisa;
    Alertas alerta = new Alertas();
    Usuarios u = new Usuarios();
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        estadoIncial();
        carregarPrivilegios();

    }

    @FXML
    private void evtBtnIncluir(ActionEvent event) {
        limparCampos();
        estadoEdicao();
    }

    @FXML
    private void evtBtnSalvar(ActionEvent event) {
        Usuarios u = new Usuarios();
        u.setUsu_login(txtUsuario.getText());
        u.setUsu_senha(txtSenha.getText());
        Privilegios privilegios = new Privilegios();
        Conexao connection = new Conexao();
        if (!txtUsuario.getText().equalsIgnoreCase("") || !txtSenha.getText().equalsIgnoreCase("")) {

            if (u.gravar(connection,privilegios, cboPrivilegios.getSelectionModel().getSelectedItem().toString())) 
            {
                txtCodigo.setText(Integer.toString(u.getUsu_codigo()));
                alerta.mensagem1("Salvo com Sucesso!!!");
                btnExcluir.setDisable(false);
            } else {
                alerta.mensagem1("Erro ao gravar!!!");
            }

        } else {
            alerta.mensagem1("Complete os campos!!!");
        }
    }

    @FXML
    private void evtBtnExcluir(ActionEvent event) {
        Alertas alerta = new Alertas();
       
        Conexao connection = new Conexao();       
        u.setUsu_codigo(Integer.parseInt(txtCodigo.getText()));
        u.setUsu_login(txtUsuario.getText());

        if (u.excluir(connection)) {
            btnExcluir.setDisable(true);
            alerta.mensagem1("Usuário " + txtUsuario.getText() + " excluído com sucesso!!!");
            estadoIncial();
        } else {
            alerta.mensagem1("Erro ao excluir usuário " + txtUsuario.getText());
        }
    }

    @FXML
    private void evtBtnPesquisar(ActionEvent event) {
        Conexao connection = new Conexao();
        Usuarios u = new Usuarios();
        estadoIncial();
        String auxiliar;
        
        if (txtPesquisa.getText().matches("^[a-zA-Z]+$")) {
            auxiliar = txtPesquisa.getText();
            if (u.pesquisar(connection, auxiliar)){
                txtCodigo.setText(Integer.toString(u.getUsu_codigo()));
                txtUsuario.setText(u.getUsu_login());
                txtSenha.setText(u.getUsu_senha());
                txtData.setText(u.getData().toString());               
                btnExcluir.setDisable(false); 
            } else {
                alerta.mensagem1("Usuário não encontrado!!!");
                txtPesquisa.setText("");
            }
        } else {
            alerta.mensagem1("Pesquise pelo nome!!!");
        }
    }

    private void carregarPrivilegios() {
        Privilegios p = new Privilegios();
        Conexao connection = new Conexao();
        obsPrivilegios = FXCollections.observableArrayList(p.carregarPrivilegios(connection));
        cboPrivilegios.setItems(obsPrivilegios);
    }

    private void estadoEdicao() {
        btnSalvar.setDisable(false);
        txtUsuario.setDisable(false);
        txtSenha.setDisable(false);
        cboPrivilegios.setDisable(false);
    }

    private void estadoIncial() {
        btnExcluir.setDisable(true);
        btnSalvar.setDisable(true);
        txtCodigo.setDisable(true);
        txtData.setDisable(true);
        txtUsuario.setDisable(true);
        txtSenha.setDisable(true);
        cboPrivilegios.setDisable(true);

    }

    private void limparCampos() {
        txtCodigo.setText("");
        txtData.setText("");
        txtUsuario.setText("");
        txtSenha.setText("");
        txtPesquisa.setText("");

    }
}
