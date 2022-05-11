package controller;

import model.Boleto;
import model.CartaoCredito;
import model.FormaDePagamento;
import model.PIX;

public class PendenciaController 
{
    public double pagamento(String opcaopgt, double valor)
    {
        FormaDePagamento formapgt;
        
        double valorfinal;
        
        if("PIX".equals(opcaopgt)) 
        {
            formapgt = new PIX();
        }
        else if("CARTÃO DE CRÉDITO".equals(opcaopgt)) 
        {
            formapgt = new CartaoCredito();
        }
        else
        {
            formapgt = new Boleto();
        }
        
        valorfinal = valor-(valor*(formapgt.desconto()/100));
        
        return valorfinal;
    } 
}
