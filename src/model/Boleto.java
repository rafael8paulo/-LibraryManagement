package model;

public class Boleto implements FormaDePagamento
{
    @Override
    public double desconto()
    {
        return 10; //10% de desconto
    } 
}
