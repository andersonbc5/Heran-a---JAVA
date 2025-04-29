package Aplicação;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


import entities.Produto;
import entities.ProdutoImportado;
import entities.ProdutoUsado;

class Programa {

    public static void main(String[] args) {

        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // Cria uma lista para armazenar os produtos
        List<Produto> lista = new ArrayList<>();

        // Solicita ao usuário a quantidade de produtos que serão cadastrados
        System.out.print("Digite a quantidade de produtos: ");
        int n = sc.nextInt();

        // Loop para coletar os dados de cada produto
        for (int i = 1; i <= n; i++) {
            System.out.println("Dados do #" + i + " produto: ");
            
            // Pergunta ao usuário o tipo do produto (comum, usado ou importado)
            System.out.print("Comum, usado ou importado (c/u/i)? ");
            char resp = sc.next().charAt(0);

            // Coleta o nome do produto
            System.out.print("Nome: ");
            sc.nextLine(); 
            String nome = sc.nextLine();

            // Coleta o preço do produto
            System.out.print("Preço: ");
            double preco = sc.nextDouble();

            // Verifica o tipo do produto e coleta informações adicionais, se necessário
            if (resp == 'c') {
                // Produto comum
                lista.add(new Produto(nome, preco));
            } else if (resp == 'u') {
                // Produto usado: solicita a data de fabricação
                System.out.print("Data de fabricação (DD/MM/YYYY): ");
                LocalDate data = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                lista.add(new ProdutoUsado(nome, preco, data));
            } else {
                // Produto importado: solicita a taxa de importação
                System.out.println("Taxa de importação: ");
                double taxaAlfandega = sc.nextDouble();
                lista.add(new ProdutoImportado(nome, preco, taxaAlfandega));
            }
        }

        // Exibe as etiquetas de preço de todos os produtos cadastrados
        System.out.println();
        System.out.println("ETIQUETA DE PREÇO: ");
        for (Produto pro : lista) {
            System.out.println(pro.etiquetaPreco());
        }

       
        sc.close();
    }
}