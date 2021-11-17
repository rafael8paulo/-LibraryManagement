package applibrarymanagement;

import dal.AlunfuncDal;
import dal.CidadesDal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Alunfunc;
import model.Cidades;
import model.Privilegios;
import util.Alertas;
import util.Conexao;

public class FXMLAlunfuncController implements Initializable {

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
    private TextField txtNome;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtFone;
    @FXML
    private TextField txtLogradouro;
    @FXML
    private TextField txtNumresidencial;
    @FXML
    private TextField txtCep;
    @FXML
    private TextField txtMunicipio;
    @FXML
    private TextField txtUf;
    @FXML
    private ComboBox<String> cboTipos;
    @FXML
    private TextField txtPesquisa;
    @FXML
    private Button btnSair;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtCodigo.setDisable(true);
        estadoInicial();
        carregarTipos();
        if (!Privilegios.per_incluir) {
            btnIncluir.setDisable(true);
        }
        if (!Privilegios.per_excluir) {
            btnExcluir.setDisable(true);
        }
        if (!Privilegios.per_consultar) {
            btnPesquisar.setDisable(true);
        }

    }

    @FXML
    private void evtBtnIncluir(ActionEvent event) {
        limparCampos();
        estadoEdicao();
        carregarTipos();
    }

    @FXML
    private void evtBtnSalvar(ActionEvent event) {
        Alertas alerta = new Alertas();
        Alunfunc af = new Alunfunc();
        Conexao connection = new Conexao();
        AlunfuncDal afDal = new AlunfuncDal();
        Cidades cid = new Cidades();
        
        if (txtCodigo.getText().equalsIgnoreCase("")) {
            if (!txtNome.getText().equalsIgnoreCase("") || !txtEmail.getText().equalsIgnoreCase("")
                    || !txtFone.getText().equalsIgnoreCase("") || !txtLogradouro.getText().equalsIgnoreCase("")
                    || !txtNumresidencial.getText().equalsIgnoreCase("") || !txtCep.getText().equalsIgnoreCase("")) {
                af.setAlf_nome(txtNome.getText());
                af.setAlf_email(txtEmail.getText());
                af.setAlf_celular(txtFone.getText());
                af.setAlf_logradouro(txtLogradouro.getText());
                af.setAlf_numres(txtNumresidencial.getText());
                cid.setCid_cep(Integer.parseInt(txtCep.getText()));
                af.setAlf_tipo(cboTipos.getSelectionModel().getSelectedItem().toString());
                if (af.gravar(connection, cid)) {
                    txtCodigo.setText(Integer.toString(af.getAlf_codigo()));
                    alerta.mensagem1("Salvo com Sucesso!!!");
                    btnExcluir.setDisable(false);
                } else {
                    alerta.mensagem1("Erro ao gravar!!!");
                }

            } else {
                alerta.mensagem1("Complete os campos!!!");
            }
        }
        //fazer update

    }

    @FXML
    private void evtBtnExcluir(ActionEvent event) {
    }

    @FXML
    private void evtBtnPesquisar(ActionEvent event) {
    }

    @FXML
    private void evtcboTipos(ActionEvent event) {
    }

    @FXML
    private void evtBtnSair(ActionEvent event) {
        btnSair.getScene().getWindow().hide();
    }

    @FXML
    private void evtCep(ActionEvent event) {
        Cidades cid = new Cidades();

        Conexao connection = new Conexao();
        cid.pesquisar(connection, txtCep.getText());
        txtMunicipio.setText(cid.getCid_municipio());
        txtUf.setText(cid.getCid_uf());
    }

    private void carregarTipos() {
        ObservableList<String> itens = FXCollections.observableArrayList();
        itens.addAll("ALUNO", "FUNCIONÁRIO");
        cboTipos.setItems(itens);
    }

    private void estadoInicial() {
        btnSalvar.setDisable(true);
        btnExcluir.setDisable(true);
        txtNome.setDisable(true);
        txtEmail.setDisable(true);
        txtFone.setDisable(true);
        txtLogradouro.setDisable(true);
        txtMunicipio.setDisable(true);
        txtNumresidencial.setDisable(true);
        txtUf.setDisable(true);
        txtCep.setDisable(true);
        cboTipos.setDisable(true);

    }

    private void estadoEdicao() {
        txtCodigo.setDisable(true);
        btnSalvar.setDisable(false);
        txtNome.setDisable(false);
        txtEmail.setDisable(false);
        txtFone.setDisable(false);
        txtLogradouro.setDisable(false);
        txtMunicipio.setDisable(false);
        txtNumresidencial.setDisable(false);
        txtUf.setDisable(false);
        txtCep.setDisable(false);
        cboTipos.setDisable(false);
    }

    private void limparCampos() {
        txtCodigo.setText("");
        txtNome.setText("");
        txtEmail.setText("");
        txtFone.setText("");
        txtLogradouro.setText("");
        txtMunicipio.setText("");
        txtNumresidencial.setText("");
        txtUf.setText("");
        txtCep.setText("");
        txtPesquisa.setText("");
    }
}
