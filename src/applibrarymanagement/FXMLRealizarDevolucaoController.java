package applibrarymanagement;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import model.Alunfunc;
import model.Empdev;
import model.IEmpDev;
import model.Livro;
import util.Alertas;
import util.Conexao;

public class FXMLRealizarDevolucaoController implements Initializable {

    @FXML
    private TableView<Empdev> tbTabela;
    @FXML
    private TableColumn<Empdev, Integer> tbCodigo;
    @FXML
    private TableColumn<Empdev, String> tbNome;
    @FXML
    private TableColumn<Empdev, LocalDate> tbDtPrevis;
    @FXML
    private TableColumn<Empdev, String> tbAluFun;
    @FXML
    private Button btnDevolucao;
    @FXML
    private Button btnSair;
    @FXML
    private TextField txtMatricula;    

    ObservableList<Empdev> lista;

    Conexao connection = new Conexao();
    @FXML
    private TextField txtNome;
    @FXML
    private Button btnPesquisar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        Platform.runLater(()->{txtMatricula.requestFocus();});
        carregarTabela(0, "");

    }

    @FXML
    private void evtBtnDevolucao(ActionEvent event) {
        
        Alertas alertas = new Alertas();
        
        int codSelecao = tbTabela.getSelectionModel().getSelectedItem().getEmpdev_cod();
               
        IEmpDev iD = new IEmpDev(LocalDate.now());
        iD.setEmpdev_cod(codSelecao);
        
        if(iD.devolucao(connection, codSelecao))
            alertas.mensagem1("Devolução realizada com sucesso!");        
        else
            alertas.mensagem1("Erro ao realizar devolução !");
    }

    @FXML
    private void evtBtnSair(ActionEvent event) {
        btnSair.getScene().getWindow().hide();
    }

    @FXML
    private void evtMatricula(ActionEvent event) {
    }


    @FXML
    private void evtBtnPesquisar(ActionEvent event) {
         
        int mat = 0;  
        
        if(!txtMatricula.getText().isEmpty())
            mat = Integer.parseInt(txtMatricula.getText());
        
        String nome = txtNome.getText();
        carregarTabela(mat, nome);
               
    }

    private void carregarTabela(int mat, String nome) {
        
        Empdev empdev = new Empdev();
        Alunfunc alunfunc = new Alunfunc();
        Livro livro = new Livro();
        
        tbCodigo.setCellValueFactory(new PropertyValueFactory<Empdev, Integer>("empdev_cod"));

        tbNome.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Empdev, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Empdev, String> Livro) {
                return new SimpleStringProperty(
                        livro.getLiv_nome()
                );
            }
        });

        tbDtPrevis.setCellValueFactory(new PropertyValueFactory<Empdev, LocalDate>("dtprev"));

        tbAluFun.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Empdev, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Empdev, String> Alunfunc) {
                return new SimpleStringProperty(
                        alunfunc.getAlf_nome()
                );
            }
        });
        
        lista = (ObservableList<Empdev>) empdev.carregar(connection, mat, nome, alunfunc, livro);
        tbTabela.setItems(lista);
        
        
        System.out.println(lista.toString());
        
    }

}
