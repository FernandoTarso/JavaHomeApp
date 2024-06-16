import java.util.*;
import java.lang.*;
import br.com.fernandotarso.User;
import static br.com.fernandotarso.Fibonacci.fibonacciSequence;
import static br.com.fernandotarso.Calculate.calculator;
import static br.com.fernandotarso.Vetores.calcVetores;
import static br.com.fernandotarso.ListaMercado.listaCompras;

public class HomeApp {

   public static void main(String[] args) {
      List<User> users = new ArrayList<>();
      Scanner scanner = new Scanner(System.in);
      boolean isOn = true;
      User usuarioAdm = new User
              ("Administrador",
                      "",
                      "admin",
                      "password");
      usuarioAdm.setFullName();
      users.add(usuarioAdm);

      while (isOn) {
//         System.out.println(usuarioAdm.getUserNumber());
         System.out.println(User.getUserNumber());
         System.out.println("-------------------------------");
         System.out.println("[1] - Cadastrar novo usuário. -");
         System.out.println("[2] - Entrar  - - - - - - - - -");
         System.out.println("[3] - Sair  - - - - - - - - - -");
         System.out.println("-------------------------------");
         String commandCode = scanner.nextLine();

         switch (commandCode) {
            case "1":
               User actual = new User();
               System.out.println("-------------------------------");
               System.out.println("Digite o nome do usuário: - - -");
               System.out.println("-------------------------------");
               actual.setFirstName(scanner.nextLine());
               System.out.println("-------------------------------");
               System.out.println("Digite o sobrenome do usuário: ");
               System.out.println("-------------------------------");
               actual.setLastName(scanner.nextLine());
               actual.setFullName();
               System.out.println("-------------------------------");
               System.out.println("Digite o loggin da conta: - - -");
               System.out.println("-------------------------------");
               actual.setUserName(scanner.nextLine());
               boolean pWconf = false;
               while (!pWconf) {
                  System.out.println("-------------------------------");
                  System.out.println("Digite a senha da conta: - - -");
                  System.out.println("-------------------------------");
                  actual.setPassWord(scanner.nextLine());
                  System.out.println("-------------------------------");
                  System.out.println("Digite a senha novamente: - - -");
                  System.out.println("-------------------------------");
                  String passWordConfirmation = scanner.nextLine();
                  if (passWordConfirmation.equals(actual.getPassWord())) {
                     pWconf = true;
                     users.add(actual);
                     System.out.println("* * * * * * * * * * * * * * * *");
                     System.out.println("Usuário cadastrado com sucesso.");
                     System.out.println("* * * * * * * * * * * * * * * *");
                  } else {
                     System.out.println("-------------------------------");
                     System.out.println("Senha incompatível. - - - - - -");
                     System.out.println("-------------------------------");
                  }
               }
               break;
            case "2":
               System.out.println("Usuário:");
               String userEntry = scanner.nextLine();
               System.out.println("Senha:");
               String userPass = scanner.nextLine();
               if (usuarioAdm.getUserName().equals(userEntry) && usuarioAdm.getPassWord().equals(userPass)) {
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
                  System.out.println("-------------------------------");
                  System.out.println("Lista atual de usuários \ncadastrados:");
                  System.out.println("-------------------------------");
                  System.out.println("- - - - - - - - - - - - - - - -");
                  for (User user : users) {
                     System.out.println(user.getFullName());
                     System.out.println("- - - - - - - - - - - - - - - -");
                  }
                  break;
               case "fibo":
               case "fibonacci":
               case "fibonacci sequence":
                  System.out.println("Quantos termos da sequencia\n Fibonacci deseja imprimir?");
                  int terms = Integer.parseInt(scanner.nextLine());
                  if (terms > 93) {
                     terms = 93;
                  }
                  fibonacciSequence(terms);
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
