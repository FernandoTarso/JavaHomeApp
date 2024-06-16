package br.com.fernandotarso;

public class Fibonacci {

   public static void fibonacciSequence(int terms) {

      if (terms > 93) {
         terms = 93;
      }

      long x_1 = -1;
      long x_2 = 1;
      long sum;

      for (int i = 0; i < terms ; i++) {
         sum = x_1 + x_2;
         x_1 = x_2;
         x_2 = sum;
         System.out.println(sum);
      }
   }
}
