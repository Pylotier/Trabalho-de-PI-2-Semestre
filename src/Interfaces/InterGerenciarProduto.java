package Interfaces;

import ClassesMarketplace.ClassProduto;

public interface InterGerenciarProduto {
    public void RegistrarProduto(String nome, double preco, String descricao, int qtde);
    public void AplicarPromocao();
    public ClassProduto AtualizarProtudo(String nome, double preco, String descricao, int qtde);
    public void ExcluirProduto(int Id,String nomeComerciante);
    public void OffSaleProduto(int Id, String nomeComerciante);
}
