package applibrarymanagement;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import model.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import util.Alertas;
import util.Conexao;

public class FXMLQuitarController implements Initializable {
    @FXML
    private Button btnSair;
    @FXML
    private Button btnQuitar;
    @FXML
    private TextField txtMatricula;
    @FXML
    private TextField txtNome;
    @FXML
    private DatePicker dpDtPgto;
    @FXML
    private Button btnPesquisar;
    @FXML
    private RadioButton rbQuitada;
    @FXML
    private TableView<Pendencia> tbTabela;
    @FXML
    private TableColumn<Pendencia, Integer> tbCodigo;
    @FXML
    private TableColumn<Pendencia, String> tbNome;
    @FXML
    private TableColumn<Pendencia, Integer> tbValor;
    @FXML
    private TableColumn<Pendencia, LocalDate> tbDtpgto;

    ObservableList<Pendencia> lista;
    @FXML
    private ToggleGroup togglerb;
    @FXML
    private RadioButton rbQuitada1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Platform.runLater(()->{txtMatricula.requestFocus();});
         txtNome.setDisable(true);
         
    }

    @FXML
    private void evtBtnSair(ActionEvent event) {
        btnSair.getScene().getWindow().hide();
    }

    @FXML
    private void evtBtnQuitar(ActionEvent event) {
        Alertas alertas = new Alertas();
        Conexao connection = new Conexao();
        Pendencia pendencia = new Pendencia();
        int codSelecao = tbTabela.getSelectionModel().getSelectedItem().getPend_cod();
        if(pendencia.baixarPendencia(connection, codSelecao))
        {
           alertas.mensagem1("Pendencia quitada com sucesso!");
        }
        else
            alertas.mensagem1("Erro ao quitar pendencia!");
    }

    @FXML
    private void evtDpDtPgto(ActionEvent event) {
    }

    @FXML
    private void evtBtnPesquisar(ActionEvent event) {
        Conexao connection = new Conexao();
        Pendencia pendencia = new Pendencia();
        Alunfunc alunfunc = new Alunfunc();
        int filtro;
        filtro = Integer.parseInt(txtMatricula.getText());       
        tbCodigo.setCellValueFactory(new PropertyValueFactory<Pendencia, Integer >("pend_cod"));
        tbDtpgto.setCellValueFactory(new PropertyValueFactory<Pendencia, LocalDate>("pend_dtpgto"));
        tbValor.setCellValueFactory(new PropertyValueFactory<Pendencia, Integer>("valor"));
        
        tbNome.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Pendencia, String>, ObservableValue<String>>()
        {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Pendencia, String> Alunfun) {
                return new SimpleStringProperty(alunfunc.getAlf_nome());
            }
        });
        String filtro2 = "";
        RadioButton radio;
        radio = (RadioButton) togglerb.getSelectedToggle();       
        if(radio.getText().equalsIgnoreCase("Quitadas"))
        {
           filtro2="S";
        }
        else 
            filtro2="N";
        
        lista = (ObservableList<Pendencia>) pendencia.carregar(connection,filtro, filtro2, alunfunc);     
        tbTabela.setItems(lista);       
    }
    @FXML
    private void evtMatricula(ActionEvent event) {
        Alunfunc alunfunc = new Alunfunc();
        Conexao connection = new Conexao();
        alunfunc.pesquisar(connection, txtMatricula.getText());
        txtNome.setText(alunfunc.getAlf_nome());
    }
        
}


