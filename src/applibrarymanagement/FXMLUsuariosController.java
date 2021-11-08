package applibrarymanagement;

import dal.*;
import java.net.URL;
import java.time.LocalDate;
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
        LoginDal loginDal = new LoginDal();
        Privilegios p = new Privilegios();
        Alertas alerta = new Alertas();
        LocalDate data = LocalDate.now();
        Usuarios u = new Usuarios();
        u.setUsu_login(txtUsuario.getText());
        u.setUsu_senha(txtSenha.getText());
        u.setData(data);

        if (!txtUsuario.getText().equalsIgnoreCase("") || !txtSenha.getText().equalsIgnoreCase("")) {
            //pesquisar privilegio
            List<Privilegios> listaCategoria = new ArrayList();
            PrivilegiosDal pDal = new PrivilegiosDal();
            listaCategoria = pDal.get(cboPrivilegios.getSelectionModel().getSelectedItem().toString());
            p.setPer_cod(listaCategoria.get(0).getPer_cod());
            p.setPer_descricao(listaCategoria.get(0).getPer_descricao());
            u.setPrivilegio(p);
            if (loginDal.gravar(u)) {
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
        Usuarios u = new Usuarios();
        LoginDal lDal = new LoginDal();
        u.setUsu_codigo(Integer.parseInt(txtCodigo.getText()));
        u.setUsu_login(txtUsuario.getText());

        if (lDal.apagar(u)) {
            btnExcluir.setDisable(true);
            alerta.mensagem1("Usuário " + txtUsuario.getText() + " excluído com sucesso!!!");
            estadoIncial();
        } else {
            alerta.mensagem1("Erro ao excluir usuário "+ txtUsuario.getText());
        }

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
        btnPesquisar.setDisable(true);
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

    }

    private void carregarPrivilegios() {
        List<Privilegios> listaCategoria = new ArrayList();
        PrivilegiosDal pDal = new PrivilegiosDal();
        listaCategoria = pDal.get("");
        obsPrivilegios = FXCollections.observableArrayList(listaCategoria);
        cboPrivilegios.setItems(obsPrivilegios);
    }

    @FXML
    private void evtBtnPesquisar(ActionEvent event) {
    }

}
