package applibrarymanagement;
import dal.ConfiguracoesDal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Configuracoes;
import util.Alertas;

public class FXMLConfiguracoesController implements Initializable {

    @FXML
    private Button btnIncluir;
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnExcluir;
    @FXML
    private TextField txtQtdeDiasEmp;
    @FXML
    private TextField txtMultaAtraso;
    @FXML
    private TextField txtJuroDia;
    Configuracoes conf = new Configuracoes();
    ConfiguracoesDal confDal = new ConfiguracoesDal();
    Alertas alerta = new Alertas();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void evtBtnIncluir(ActionEvent event) {
        limparCampos();
        estadoEdicao();

    }

    @FXML
    private void evtBtnSalvar(ActionEvent event) {
        if (txtJuroDia.getText().matches("[0-9_].*")
                && txtMultaAtraso.getText().matches("[0-9_].*")
                && txtQtdeDiasEmp.getText().matches("[0-9_].*")) {
            conf.setConf_juro(Integer.parseInt(txtJuroDia.getText()));
            conf.setConf_multa(Integer.parseInt(txtMultaAtraso.getText()));
            conf.setConf_limDia(Integer.parseInt(txtQtdeDiasEmp.getText()));
            
            if (confDal.gravar(conf)) {
                alerta.mensagem1("Configurações salvas com sucesso!!!");
                btnExcluir.setDisable(false);
            } else {
                alerta.mensagem1("Erro ao gravar configurações!!!");
            }
        } else {
            alerta.mensagem1("Informe apenas números!!!");
        }
    }

    @FXML
    private void evtBtnExcluir(ActionEvent event) {
     if(confDal.apagar(conf))
        {
            btnExcluir.setDisable(true);
            alerta.mensagem1("Configurações excluídas com sucesso!!!");        
        }
        else
            alerta.mensagem1("Erro ao excluir configurações!!!");
        limparCampos(); 
        estadoInicial();
    }

    private void limparCampos() {
        txtJuroDia.setText("");
        txtMultaAtraso.setText("");
        txtQtdeDiasEmp.setText("");
    }

    private void estadoInicial() {
        btnExcluir.setDisable(true);
        btnSalvar.setDisable(true);
        txtJuroDia.setDisable(true);
        txtMultaAtraso.setDisable(true);
        txtQtdeDiasEmp.setDisable(true);
    }

    private void estadoEdicao() {
        btnSalvar.setDisable(false);
        txtJuroDia.setDisable(false);
        txtMultaAtraso.setDisable(false);
        txtQtdeDiasEmp.setDisable(false);

    }

}
