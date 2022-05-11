package model;

public class CartaoCredito implements FormaDePagamento
{
    @Override
    public double desconto()
    {
        return 0; //sem desconto
    } 
}
