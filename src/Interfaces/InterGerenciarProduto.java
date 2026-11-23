package Interfaces;

import ClassesMarketplace.ClassEnderecoProduto;
import ClassesMarketplace.ClassProduto;

public interface InterGerenciarProduto {
    public void RegistrarProduto(String nome, double preco, String descricao, int qtde);
    public void AplicarPromocao();
    public void AtualizarProtudo(ClassProduto cp, ClassEnderecoProduto cend, int id);
    public void ExcluirProduto(int Id);
    public void OffSaleProduto(int Id);
}
