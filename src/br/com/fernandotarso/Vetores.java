package br.com.fernandotarso;
import static java.lang.Math.*;
import java.util.*;
public class Vetores {

   public static void calcVetores() {

      Scanner scanner = new Scanner(System.in);

      System.out.println("Infofme as coordenadas \ndo vetor A:");
      String[] entry_a = scanner.nextLine().split(" ");
      double[] vetor_a = {Double.parseDouble(entry_a[0]), Double.parseDouble(entry_a[1])};

      System.out.println("Infofme as coordenadas \ndo vetor B:");
      String[] entry_b = scanner.nextLine().split(" ");
      double[] vetor_b = {Double.parseDouble(entry_b[0]), Double.parseDouble(entry_b[1])};

      System.out.println("Vetor A: [ " + vetor_a[0] + " , " + vetor_a[1] + " ];");
      System.out.println("Vetor B: [ " + vetor_b[0] + " , " + vetor_b[1] + " ];");

      double modulo_a = sqrt(pow(vetor_a[0], 2) + pow(vetor_a[1], 2));
      double modulo_b = sqrt(pow(vetor_b[0], 2) + pow(vetor_b[1], 2));
      System.out.println(modulo_a);
      System.out.println(modulo_b);

      System.out.println("Produto interno entre A e B:");
      double pI_a_b = 0;
      for (int i = 0; i < vetor_a.length; i++) {
         pI_a_b += vetor_a[i] * vetor_b[i];
      }
      System.out.println(pI_a_b);
      System.out.println("Angulo entre A e B:");
      double ang_a_b_rad = acos(pI_a_b/(modulo_a * modulo_b));
      double ang_a_b_graus = (acos(pI_a_b/(modulo_a * modulo_b)))*(180/PI);
      System.out.println(ang_a_b_graus + "graus, ou " + ang_a_b_rad + " radianos.");

      System.out.println("Produto vetorial A X B:");
      System.out.println("Vetor A: [ " + vetor_a[0] + " , " + vetor_a[1] + " ];");
      System.out.println("Vetor B: [ " + vetor_b[0] + " , " + vetor_b[1] + " ];");
      double pV_a_b = modulo_a * modulo_b * (sin(ang_a_b_rad));
      System.out.println(pV_a_b);
      scanner.close();
   }
}