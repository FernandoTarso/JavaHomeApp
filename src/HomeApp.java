import java.io.IOException;
import java.util.*;
import java.lang.*;
import java.io.File;
import br.com.fernandotarso.User;
import static br.com.fernandotarso.Fibonacci.fibonacciSequence;
import static br.com.fernandotarso.Calculate.calculator;
import static br.com.fernandotarso.Vetores.calcVetores;
import static br.com.fernandotarso.ListaMercado.listaCompras;

public class HomeApp {

   public static void main(String[] args) {

      try {
         File userList = new File("listaUsuarios.txt");
         if (userList.createNewFile()) {
            System.out.println("Lista de usuários criada: " + userList.getName());
         } else {
            System.out.println("Lista de usuários carregada.\n" + userList.getAbsolutePath());
         }
      } catch (IOException e) {
         throw new RuntimeException(e);
      }

      List<User> users = new ArrayList<>();
      Scanner scanner = new Scanner(System.in);
      boolean isOn = true;
      User usuarioAdm = new User.UserBuilder()
              .firstName("Administrador")
              .lastName("")
              .userName("admin")
              .passWord("password")
              .build();
      usuarioAdm.setFullName();
      users.add(usuarioAdm);



      while (isOn) {
         System.out.println("-------------------------------");
         System.out.println("[1] - Cadastrar novo usuário. -");
         System.out.println("[2] - Entrar  - - - - - - - - -");
         System.out.println("[3] - Sair  - - - - - - - - - -");
         System.out.println("-------------------------------");
         String commandCode = scanner.nextLine();

         switch (commandCode) {
            case "1":
//               User actual = new User();
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
               break;
            case "2":
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
               break;
            case "3":
               isOn = false;
               break;
            default:
               break;
         }

         while (usuarioAdm.isLogged()) {

            System.out.println("Qual aplicativo deseja executar?");
            String app = scanner.nextLine().toLowerCase();
            switch (app) {
               case "calc":
               case "calculator":
               case "calculadora":
                  calculator(); break;
               case "user list":
               case "lista usuario":
               case "show list":
               case "users":
               case "usuarios":
               case "show users":
                  System.out.println("Lista atual de usuários " +
                          "\ncadastrados:");
                  System.out.println("- - - - - - - - - - - - - - - -");
                  for (User user : users) {
                     System.out.println(user);
                     System.out.println("- - - - - - - - - - - - - - - -");
                  }
                  break;
               case "fibo":
               case "fibonacci":
               case "fibonacci sequence":
                  System.out.println("Quantos termos da sequencia" +
                          "\n Fibonacci deseja imprimir?");
                  fibonacciSequence(Integer.parseInt(scanner.nextLine()));
                  break;
               case "vetor":
               case "vetores":
               case "vetorial":
               case "vet":
                  calcVetores();
                  break;
               case "list":
               case "lista":
               case "compra":
               case "compras":
                  listaCompras(); break;
               case "logoff":
               case "off":
                  usuarioAdm.setLogged(false); break;
               default: break;

            }
         }
      }
      scanner.close();
   }
}
