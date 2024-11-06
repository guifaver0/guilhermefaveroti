import java.util.ArrayList;
import java.util.Scanner;

// Classe abstrata Moeda
abstract class Moeda {
    protected double valor;

    public Moeda(double valor) {
        this.valor = valor;
    }

    public abstract double converterParaReal();

    public abstract String getMoeda();
    
    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return getMoeda() + " - Valor: " + valor;
    }
}

// Classe Dolar
class Dolar extends Moeda {
    public Dolar(double valor) {
        super(valor);
    }

    @Override
    public double converterParaReal() {
        return valor * 5.0; // taxa fictícia de conversão para Real
    }

    @Override
    public String getMoeda() {
        return "Dólar";
    }
}

// Classe Euro
class Euro extends Moeda {
    public Euro(double valor) {
        super(valor);
    }

    @Override
    public double converterParaReal() {
        return valor * 5.5; // taxa fictícia de conversão para Real
    }

    @Override
    public String getMoeda() {
        return "Euro";
    }
}

// Classe Real
class Real extends Moeda {
    public Real(double valor) {
        super(valor);
    }

    @Override
    public double converterParaReal() {
        return valor;
    }

    @Override
    public String getMoeda() {
        return "Real";
    }
}

// Classe Cofrinho
class Cofrinho {
    private ArrayList<Moeda> moedas = new ArrayList<>();

    public void adicionarMoeda(Moeda moeda) {
        moedas.add(moeda);
        System.out.println(moeda.getMoeda() + " adicionada ao cofrinho.");
    }

    public void removerMoeda(Moeda moeda) {
        if (moedas.remove(moeda)) {
            System.out.println(moeda.getMoeda() + " removida do cofrinho.");
        } else {
            System.out.println("Moeda não encontrada no cofrinho.");
        }
    }

    public void listarMoedas() {
        if (moedas.isEmpty()) {
            System.out.println("O cofrinho está vazio.");
        } else {
            System.out.println("Moedas no cofrinho:");
            for (Moeda moeda : moedas) {
                System.out.println(moeda);
            }
        }
    }

    public double calcularTotalEmReais() {
        double total = 0;
        for (Moeda moeda : moedas) {
            total += moeda.converterParaReal();
        }
        return total;
    }
}

// Classe Principal
public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cofrinho cofrinho = new Cofrinho();

        while (true) {
            System.out.println("\nMenu do Cofrinho:");
            System.out.println("1. Adicionar moeda");
            System.out.println("2. Remover moeda");
            System.out.println("3. Listar moedas");
            System.out.println("4. Calcular total em Reais");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarMoeda(cofrinho, scanner);
                    break;
                case 2:
                    removerMoeda(cofrinho, scanner);
                    break;
                case 3:
                    cofrinho.listarMoedas();
                    break;
                case 4:
                    double total = cofrinho.calcularTotalEmReais();
                    System.out.printf("Total em Reais: %.2f\n", total);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    private static void adicionarMoeda(Cofrinho cofrinho, Scanner scanner) {
        System.out.println("Escolha o tipo de moeda:");
        System.out.println("1. Dólar");
        System.out.println("2. Euro");
        System.out.println("3. Real");
        System.out.print("Opção: ");
        int tipo = scanner.nextInt();

        System.out.print("Digite o valor da moeda: ");
        double valor = scanner.nextDouble();

        switch (tipo) {
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
                System.out.println("Tipo de moeda inválido.");
                break;
        }
    }

    private static void removerMoeda(Cofrinho cofrinho, Scanner scanner) {
        System.out.print("Digite o valor da moeda para remover: ");
        double valor = scanner.nextDouble();

        for (Moeda moeda : cofrinho.moedas) {
            if (moeda.getValor() == valor) {
                cofrinho.removerMoeda(moeda);
                return;
            }
        }
        System.out.println("Moeda não encontrada.");
    }
}
