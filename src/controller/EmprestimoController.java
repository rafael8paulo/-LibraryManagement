package controller;

import javax.swing.JOptionPane;
import model.Alunfunc;
import model.Empdev;
import model.Exemplar;
import model.IEmpDev;
import model.Livro;
import util.Alertas;
import util.Conexao;

public class EmprestimoController {

    Alertas alerta = new Alertas();

    public void Emprestimo(Livro l, Alunfunc af) {

        Conexao connection = new Conexao();

        if (l != null) {
            //Consultar se tem livro disponivel
            Exemplar exemp = new Exemplar();

            if (exemp.consultaExemplarDisponivel(connection, l)) 
            {
                //Realizar emprestimo               
                Empdev ed = new Empdev();

                if (ed.Emprestimo(connection, exemp.getExemp_cod(), af)) {
                    IEmpDev ied = new IEmpDev();
                    if (ed.consultaUltimoID(connection, af)) {
                        if (ied.Emprestimo(connection, exemp, ed)) {
                            if (exemp.emprestar(connection)) {
                                alerta.mensagem1("Empréstimo realizado com sucesso!!");
                            } else {
                                alerta.mensagem1("Erro ao realizar empréstimo!!");
                            }
                        } else {
                            alerta.mensagem1("Erro ao realizar empréstimo!!");
                        }
                    } else {
                        alerta.mensagem1("Erro ao realizar empréstimo!!");
                    }
                } else {
                    alerta.mensagem1("Erro ao realizar empréstimo!!");
                }
            } else {
                int resposta = JOptionPane.showConfirmDialog(null, "O livro desejado não está disponível"
                        + "\ndeseja entrar na lista de espera?");
                if (resposta == JOptionPane.YES_OPTION) {
                    if (exemp.novoListaEspera(af, connection)) {
                        alerta.mensagem1("Inserido com sucesso!!");
                    } else {
                        alerta.mensagem1("Erro ao inserir na lista!!");
                    }
                }
            }

        } else {
            alerta.mensagem1("Selecione o campo 'Livro'");
        }
    }
}
