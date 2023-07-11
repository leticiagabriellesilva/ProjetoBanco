import java.util.Scanner;

public class BancoVirtual {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        double saldo = 0;
        double valor = 0;
        int opcao = 0;
        String introducao = """
        Bem vindo ao Banco Virtual!
        Para iniciar o cadastro, digite seu nome: """;

        // Dados do cliente
        System.out.println(introducao);
        String nome = leitura.nextLine();
        System.out.println("Digite o tipo de conta que deseja, corrente ou poupança: ");
        String tipoConta = leitura.nextLine();
        System.out.println("Digite o valor inicial para abertura da conta: ");
        saldo = leitura.nextDouble();
        
        String extrato = """
                ***************************     
                
                Nome: %s
                Tipo de conta: %s
                Saldo: %2f
                
                ***************************
                """.formatted(nome, tipoConta, saldo);

        System.out.println(extrato);
        
        while (opcao != 4) {

            // Menu de Opções
            String menu = """
                    
                Escolha uma opção:
                1 - Consultar o saldo.
                2 - Receber PIX.
                3 - Enviar PIX.
                4 - Sair.

                    """;
            System.out.println("\n" + menu);
            opcao = leitura.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println(nome + ", seu saldo é: " + saldo);
                    break;
                case 2:
                    System.out.println("Digite o valor a receber: ");
                    valor = leitura.nextDouble();
                    saldo += valor;
                    System.out.println("\n Seu saldo atual é:" + saldo);
                    break;
                case 3:
                    System.out.println("Digite o valor para transferência: ");
                    valor = leitura.nextDouble();
                    if (valor <= saldo) {
                        saldo -= valor;
                    } else {
                        System.out.println("Saldo insuficiente");
                    }
                    System.out.println("\n Seu saldo atual é:" + saldo);
                    break;
                case 4:
                    System.out.println("Obrigado por utilizar nosso banco!");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }
}
