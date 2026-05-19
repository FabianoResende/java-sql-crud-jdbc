import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        TarefaDAO.criarTabela();
        menu();
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Inserir tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Concluir tarefa");
            System.out.println("4 - Remover tarefa");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Descrição: ");
                    String texto = sc.nextLine();
                    TarefaDAO.inserir(texto);
                }
                case 2 -> {
                    List<Tarefa> lista = TarefaDAO.listar();
                    System.out.println("\n--- LISTA DE TAREFAS ---");
                    lista.forEach(System.out::println);
                }
                case 3 -> {
                    System.out.print("ID da tarefa: ");
                    int id = sc.nextInt();
                    TarefaDAO.concluir(id);
                }
                case 4 -> {
                    System.out.print("ID da tarefa: ");
                    int id = sc.nextInt();
                    TarefaDAO.remover(id);
                }
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}

