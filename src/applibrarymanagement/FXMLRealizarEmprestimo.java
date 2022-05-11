package applibrarymanagement;

import controller.EmprestimoController;
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
import javax.swing.JOptionPane;
import model.Alunfunc;
import model.Cidades;
import model.Empdev;
import model.Exemplar;
import model.IEmpDev;
import model.Livro;
import util.Alertas;
import util.Conexao;

public class FXMLRealizarEmprestimo implements Initializable {

    @FXML
    private Button btnSair;
    @FXML
    private Button btnIncluir;
    @FXML
    private Button btnSalvar;
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
    private ComboBox<Livro> cboLivros;
    @FXML
    private TextField txtPesquisa;

    private ObservableList<Livro> obsLivro;

    Alertas alerta = new Alertas();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        estadoInicial();
        carregaLivros();
    }

    @FXML
    private void evtBtnSair(ActionEvent event) {
        btnSair.getScene().getWindow().hide();
    }

    @FXML
    private void evtBtnIncluir(ActionEvent event) {
        limparCampos();
        estadoEdicao();
        //carregarTipos();
    }

    @FXML
    private void evtBtnSalvar(ActionEvent event) {

        Livro l = new Livro();        
        l = cboLivros.getSelectionModel().getSelectedItem();

        Alunfunc af = new Alunfunc(txtNome.getText(),Integer.parseInt(txtCodigo.getText()));
        
        //new Alunfunc(, Integer.parseInt(txtCodigo.getText()))
        
        new EmprestimoController().Emprestimo(l, af);
    }

    @FXML
    private void evtBtnPesquisar(ActionEvent event) {

        Alertas alerta = new Alertas();
        Conexao connection = new Conexao();
        estadoInicial();
        Alunfunc af = new Alunfunc();
        Cidades cid = new Cidades();
        btnSalvar.setDisable(false);
        String auxiliar;

        if (txtPesquisa.getText().matches("^[a-zA-Z]+$")) {
            auxiliar = txtPesquisa.getText();
            if (af.pesquisaByName(connection, auxiliar, cid)) {
                txtCodigo.setText(Integer.toString(af.getAlf_codigo()));
                txtNome.setText(af.getAlf_nome());
                txtEmail.setText(af.getAlf_email());
                txtFone.setText(af.getAlf_celular());
                txtEmail.setText(af.getAlf_email());
                //txtLogradouro.setText(af.getAlf_logradouro());
                //btnExcluir.setDisable(false);
                estadoEdicao();
            } else {
                alerta.mensagem1("Usuário não encontrado!!!");
                txtPesquisa.setText("");
            }
        } else {
            alerta.mensagem1("Pesquise pelo nome!!!");
        }
    }

    private void estadoInicial() {
        btnSalvar.setDisable(true);
        txtCodigo.setDisable(true);
        txtNome.setDisable(true);
        txtEmail.setDisable(true);
        txtFone.setDisable(true);
        cboLivros.setDisable(true);
        txtPesquisa.setDisable(true);
    }

    private void estadoEdicao() {

        btnSalvar.setDisable(false);
        txtPesquisa.setDisable(false);
        cboLivros.setDisable(false);
    }

    private void limparCampos() {
        txtCodigo.setText("");
        txtNome.setText("");
        txtEmail.setText("");
        txtFone.setText("");
        txtPesquisa.setText("");
        //carregaLivros();
    }

    @FXML
    private void evtcboLivros(ActionEvent event) {
    }

    private void carregaLivros() {
        Livro l = new Livro();
        Conexao connection = new Conexao();

        obsLivro = FXCollections.observableArrayList(l.todosLivros(connection));

        cboLivros.setItems(obsLivro);
    }

}
