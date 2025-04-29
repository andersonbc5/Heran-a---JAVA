package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class ProdutoUsado extends Produto{
    
    private LocalDate fabricacao;

    public ProdutoUsado(){
        super();
    }

    public ProdutoUsado(String nome, Double preco, LocalDate fabricacao) {
        super(nome, preco);
        this.fabricacao = fabricacao;
    }

    public LocalDate getFabricacao() {
        return fabricacao;
    }

    public void setFabricacao(LocalDate fabricacao) {
        this.fabricacao = fabricacao;
    }

    @Override
    public String etiquetaPreco(){
        return getNome() +
            " (usado) R$: " +
            String.format("%.2f", getPreco()) +
            " (Data de fabricação: " +
            fabricacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
            ")";

    }
    
}
