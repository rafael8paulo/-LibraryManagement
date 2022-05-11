package model;

public class PIX implements FormaDePagamento
{
    @Override
    public double desconto()
    {
        return 15; //15% de desconto
    } 
}
