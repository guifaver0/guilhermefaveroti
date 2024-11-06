import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cofrinho cofrinho = new Cofrinho();

        while (true) {
            System.out.println("\nCofrinho de Moedas");
            System.out.println("1. Adicionar Moeda");
            System.out.println("2. Remover Moeda");
            System.out.println("3. Listar Moedas");
            System.out.println("4. Calcular Total em Reais");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.println("1. Dólar");
                System.out.println("2. Euro");
                System.out.println("3. Real");
                System.out.print("Escolha o tipo de moeda: ");
                int tipoMoeda = scanner.nextInt();

                System.out.print("Digite o valor da moeda: ");
                double valor = scanner.nextDouble();

                switch (tipoMoeda) {
                    case 1:
                        cofrinho.adicionarMoeda(new Dolar(valor));
                        break;
                    case 2:
                        cofrinho.adicionarMoeda(new Euro(valor));
                        break;
                    case 3:
                        cofrinho.adicionarMoeda(new Real(valor));
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } else if (opcao == 2) {
                System.out.println("Remover Moeda (imagine que o usuário vai informar a moeda diretamente)");
                // Código para remover uma moeda seria implementado aqui
            } else if (opcao == 3) {
                cofrinho.listarMoedas();
            } else if (opcao == 4) {
                double total = cofrinho.calcularTotalEmReal();
                System.out.println("Total em Real: R$ " + total);
            } else if (opcao == 5) {
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
