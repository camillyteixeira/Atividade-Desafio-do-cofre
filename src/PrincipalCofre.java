import java.util.Scanner;
public class PrincipalCofre{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Defina a senha inicial para criar o cofre: ");
        String senhaInicial = scanner.nextLine();
        Cofre meuCofre = new Cofre(senhaInicial);

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("Dados do cofre");
            System.out.println("1 - Abrir cofre");
            System.out.println("2 - Fechar cofre");
            System.out.println("3 - Trancar cofre");
            System.out.println("4 - Destrancar cofre");
            System.out.println("5 - Guardar item");
            System.out.println("6 - Listar itens guardados");
            System.out.println("7 - Ver status do cofre");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    meuCofre.abrir();
                    break;
                case 2:
                    meuCofre.fechar();
                    break;
                case 3:
                    meuCofre.trancar();
                    break;
                case 4:
                    System.out.print("Digite a senha: ");
                    String tentativa = scanner.nextLine();
                    meuCofre.destrancar(tentativa);
                    break;
                case 5:
                    System.out.print("Nome do item para guardar: ");
                    String item = scanner.nextLine();
                    meuCofre.guardarItem(item);
                    break;
                case 6:
                    meuCofre.listarItens();
                    break;
                case 7:
                    meuCofre.verificarStatus();
                    break;
                case 0:
                    System.out.println("Encerrando sistema do cofre");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}