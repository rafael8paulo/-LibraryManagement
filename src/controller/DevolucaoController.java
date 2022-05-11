package controller;

import java.time.LocalDate;
import model.Configuracoes;
import model.Empdev;
import model.Exemplar;
import model.IEmpDev;
import model.Pendencia;
import util.Alertas;
import util.Conexao;

public class DevolucaoController {

    public void devolucao(int codSelecao) {

        Conexao connection = new Conexao();
        Alertas alertas = new Alertas();

        IEmpDev iD = new IEmpDev(LocalDate.now());
        iD.setEmpdev_cod(codSelecao);

        Empdev e = new Empdev();
        e.setEmpdev_cod(codSelecao);

        int diasAtraso = e.consultarDiasEmAtraso(connection);

        if (iD.devolucao(connection, codSelecao)) {

            alertas.mensagem1("Devolução realizada com sucesso!");

            if (diasAtraso > 0) {

                Configuracoes c = new Configuracoes();
                c.exibir(connection);

                double valor = (double) (c.getConf_juro() * diasAtraso) / 100;
                valor = valor * diasAtraso;

                Pendencia p = new Pendencia();
                p.setValor(valor);
                p.setEmpdev_cod(codSelecao);
                p.inserirPerdencia(connection);

                alertas.mensagem1(
                        "Exemplar em atraso !! \n"
                        + "Nova pendencia inserida no sistema, no valor de R$ "
                        + valor);
            }
            Exemplar exemp = new Exemplar(codSelecao);
            exemp.notificaDevolucao(connection);
        } else {
            alertas.mensagem1("Erro ao realizar devolução !");
        }
    }

}
