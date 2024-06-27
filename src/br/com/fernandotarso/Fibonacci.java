package br.com.fernandotarso;

public class Fibonacci {

   public static void fibonacciSequence(int terms) {

      if (terms > 92) {
         terms = 92;
      }

      long x_1 = 0;
      long x_2 = 1;
      long sum = x_1;

      for (int i = 0; i < terms; i++) {
         System.out.println(sum);
         sum = x_1 + x_2;
         x_1 = x_2;
         x_2 = sum;

      }
   }
}
//   public static void fibo() {
//      fibo(0, 1, 0, 10);
//   }
//   private static void fibo(long a, long b, int counter, int terms) {
//      long sum = a;
//      System.out.println(sum);
//      sum = a+b;
//      counter++;
//      if (counter<terms){
//         fibo(b, sum, counter, terms);
//      }
//   }

//   public static void fibonacciSequence(int terms) {
//
//      if (terms > 93) {
//         terms = 93;
//      }
//
//      long x_1 = -1;
//      long x_2 = 1;
//      long sum;
//
//      for (int i = 0; i < terms ; i++) {
//         sum = x_1 + x_2;
//         x_1 = x_2;
//         x_2 = sum;
//         System.out.println(sum);
//      }
//   }
