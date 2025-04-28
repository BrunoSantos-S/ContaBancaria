import java.util.Scanner;

public class AplicacaoBanco {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n----- MENU -----");
            System.out.println("1 - Cadastrar nova conta");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Listar contas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar

            switch (opcao) {
                case 1:
                    System.out.print("Número da conta: ");
                    String numeroConta = scanner.nextLine();
                    System.out.print("Nome do titular: ");
                    String titular = scanner.nextLine();
                    ContaBancaria novaConta = new ContaBancaria(numeroConta, titular);
                    banco.adicionarConta(novaConta);
                    break;
                case 2:
                    System.out.print("Informe o número da conta para depósito: ");
                    String contaDeposito = scanner.nextLine();
                    ContaBancaria conta1 = banco.buscarConta(contaDeposito);
                    if (conta1 != null) {
                        System.out.print("Valor para depositar: ");
                        double valorDep = scanner.nextDouble();
                        conta1.depositar(valorDep);
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    break;
                case 3:
                    System.out.print("Informe o número da conta para saque: ");
                    String contaSaque = scanner.nextLine();
                    ContaBancaria conta2 = banco.buscarConta(contaSaque);
                    if (conta2 != null) {
                        System.out.print("Valor para sacar: ");
                        double valorSaq = scanner.nextDouble();
                        conta2.sacar(valorSaq);
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    break;
                case 4:
                    banco.listarContas();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
