package br.com.fernandotarso;
import java.util.Scanner;

public class Calculate {
   public static void calculator() {
      Scanner scanner = new Scanner(System.in);
      String[] command;
      System.out.println("Digite uma operação\nentre dois inteiros:");
      command = scanner.nextLine().split(" ");
      while (!command[0].isEmpty()) {
         calculate(Integer.parseInt(command[0]), command[1], Integer.parseInt(command[2]));
         command = scanner.nextLine().split(" ");
      }
      System.out.println("Closing...");
   }
   static void calculate(int number1, String operation, int number2) {
      if (operation.equalsIgnoreCase("+")) {
         System.out.println(number1 + number2);
      } else if (operation.equalsIgnoreCase("-")) {
         System.out.println(number1 - number2);
      } else if (operation.equalsIgnoreCase("x")) {
         System.out.println(number1 * number2);
      } else if (operation.equalsIgnoreCase("/")) {
         System.out.println((number1 / number2) + ", com resto " + (number1 % number2));
      } else {
         System.out.println("Operador invalido.");
      }
   }
}