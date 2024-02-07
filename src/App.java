import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Map<String, String> pessoas = new HashMap<>();

        System.out.println("Informe 'sair' para encerrar.");

        while (true) {
            System.out.print("Informe o nome: ");
            String nome = scanner.nextLine();

            if (nome.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.print("Informe o sexo 'Feminino ou Masculino': ");
            String sexo = scanner.nextLine();

            pessoas.put(nome, sexo);
        }

        separarPessoasSexo(pessoas);
    }

    private static void separarPessoasSexo(Map<String, String> pessoas) {
        Map<String, String> sexoMasculino = new HashMap<>();
        Map<String, String> sexoFeminino = new HashMap<>();

        for (Map.Entry<String, String> entry : pessoas.entrySet()) {
            String nome = entry.getKey();
            String sexo = entry.getValue();

            switch (sexo.toLowerCase()) {
                case "masculino":
                    sexoMasculino.put(nome, sexo);
                    break;
                case "feminino":
                    sexoFeminino.put(nome, sexo);
                    break;
                default:
                    System.out.println("Sexo não reconhecido.. " + nome + ": " + sexo);
            }
        }

        System.out.println("Do sexo Masculino:");
        exibirPessoas(sexoMasculino);

        System.out.println("Do sexo Feminino:");
        exibirPessoas(sexoFeminino);

    }

    private static void exibirPessoas(Map<String, String> pessoas) {
        for (Map.Entry<String, String> entry : pessoas.entrySet()) {
            System.out.println("Nome: " + entry.getKey() + ", Sexo: " + entry.getValue());
        }
    }
}