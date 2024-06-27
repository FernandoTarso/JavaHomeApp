import static br.com.fernandotarso.Calculate.calculator;
import static br.com.fernandotarso.Fibonacci.fibonacciSequence;
import static br.com.fernandotarso.ListaMercado.listaCompras;
import br.com.fernandotarso.User;
import static br.com.fernandotarso.User.createListFile;
import static br.com.fernandotarso.Vetores.calcVetores;
import java.io.*;
import java.util.*;

public class HomeApp {

   public static void main(String[] args) {

      List<User> users = new ArrayList<>();
      Scanner scanner = new Scanner(System.in);
      File listaUsuario = createListFile();

      User usuarioAdm = new User.UserBuilder()
              .firstName("Administrador")
              .lastName("")
              .userName("admin")
              .passWord("password")
              .build();
      usuarioAdm.setFullName();
      users.add(usuarioAdm);

      boolean isOn = true;
      while (isOn) {
         System.out.println("-------------------------------");
         System.out.println("[1] - Cadastrar novo usuário. -");
         System.out.println("[2] - Entrar  - - - - - - - - -");
         System.out.println("[3] - Sair  - - - - - - - - - -");
         System.out.println("-------------------------------");
         String commandCode = scanner.nextLine();

         switch (commandCode) {
            case "1" -> {
                System.out.println("Digite o nome do usuário: - - -");
                String actualFirstName = (scanner.nextLine());
                System.out.println("Digite o sobrenome do usuário: ");
                String actualLastName = scanner.nextLine();
                System.out.println("Digite o loggin da conta: - - -");
                String actualUserName = scanner.nextLine();
                boolean pWconf = false;
                while (!pWconf) {
                    System.out.println("Digite a senha da conta: - - -");
                    String actualPassWord = scanner.nextLine();
                    System.out.println("Digite a senha novamente: - - -");
                    String passWordConfirmation = scanner.nextLine();
                    if (actualPassWord.equals(passWordConfirmation)) {
                        pWconf = true;
                        User actual = new User.UserBuilder()
                                .firstName(actualFirstName)
                                .lastName(actualLastName)
                                .userName(actualUserName)
                                .passWord(actualPassWord)
                                .build();
                        actual.setFullName();
                        users.add(actual);
                        System.out.println("* * * * * * * * * * * * * * * *");
                        System.out.println("Usuário cadastrado com sucesso.");
                        System.out.println("* * * * * * * * * * * * * * * *");
                    } else {
                        System.out.println("Senha incompatível. - - - - - -");
                    }
                }
              }
            case "2" -> {
                System.out.println("Usuário:");
                String userEntry = scanner.nextLine();
                System.out.println("Senha:");
                String userPass = scanner.nextLine();
                if (usuarioAdm.getUserName().equals(userEntry)
                        && usuarioAdm.getPassWord().equals(userPass)) {
                    usuarioAdm.setLogged(true);
                    System.out.println("Bem vindo, " + usuarioAdm.getFirstName() + ".");
                } else {
                    System.out.println("Credenciais inválidas.");
                    System.out.println("Tente novamente.");
                }
              }
            case "3" -> isOn = false;
            default -> {
              }
         }

         while (usuarioAdm.isLogged()) {

            System.out.println("Qual aplicativo deseja executar?");
            String app = scanner.nextLine().toLowerCase();
            switch (app) {
               case "calc", "calculator", "calculadora" -> calculator();
               case "user list", "lista usuario", "show list", "users", "usuarios", "show users" -> {
                   System.out.println("""
                     Lista atual de usuários
                     cadastrados:""");
                   System.out.println("- - - - - - - - - - - - - - - -");
                   for (User user : users) {
                       System.out.println(user);
                       System.out.println("- - - - - - - - - - - - - - - -");
                   }
                 }
               case "fibo", "fibonacci", "fibonacci sequence" -> {
                   System.out.println("""
                     Quantos termos da sequencia
                     Fibonacci deseja imprimir?""");
                   fibonacciSequence(Integer.parseInt(scanner.nextLine()));
                 }
               case "vetor", "vetores", "vetorial", "vet" -> calcVetores();
               case "list", "lista", "compra", "compras" -> listaCompras();
               case "logoff", "off" -> usuarioAdm.setLogged(false);
               default -> {
                 }
            }
         }
      }
      scanner.close();
   }
}
