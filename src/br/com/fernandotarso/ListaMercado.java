package br.com.fernandotarso;
import java.util.*;

public class ListaMercado {

   static Scanner scanner = new Scanner(System.in);
   static List<String> listaDeCompras = new ArrayList<>();

   public static void listaCompras() {
      boolean listaOn = true;
      while (listaOn) {
         System.out.println("- - - - - - - - - - - - -");
         System.out.println("O que deseja fazer?");
         System.out.println("add: adiciona um item;");
         System.out.println("rem: remove um item;");
         System.out.println("list: exibe a lista atual;");
         System.out.println("sair: fecha o programa.");
         System.out.println("- - - - - - - - - - - - -");
         String acao = scanner.nextLine().trim();
         switch (acao) {
            case "add":
               adicionarItem(); break;
            case "rem":
               removerItem(); break;
            case "list":
               listarItens(); break;
            case "sair":
//               scanner.close();
               listaOn = false; break;
            default: break;
         }

      }
   }

   public static void adicionarItem() {
      System.out.println("Digite a quantidade e item \nque deseja adicionar:");
      System.out.println("- - - - - - - - - - - - - - -");
      String item = scanner.nextLine();
      System.out.println("- - - - - - - - - - - - - - -");
      listaDeCompras.add(item);
      System.out.println("O item " + item + " foi adicionado.");
      System.out.println("- - - - - - - - - - - - - - -");
   }

   public static void listarItens() {
      System.out.println("Lista atual:");
      for (String item: listaDeCompras) {
         System.out.println("- - - - - - - - - - - - - - -");
         System.out.print((listaDeCompras.indexOf(item)+1) + " - ");
         System.out.println(listaDeCompras.get(listaDeCompras.indexOf(item)));
      }
      System.out.println("- - - - - - - - - - - - - - -");
      System.out.println("Lista aberta. Enter para fechar.");
      scanner.nextLine();
   }

   public static void removerItem() {
      listarItens();
      System.out.println("Indique o índice do item \nque deseja remover:");
      int indice = scanner.nextInt();
      scanner.nextLine();
      String item = listaDeCompras.get(indice-1);
      System.out.println("Removendo...");
      System.out.println("- - - - - - - - - - - - - - -");
      listaDeCompras.remove(indice-1);
      System.out.println("O item " + item + " foi removido.");
      System.out.println("- - - - - - - - - - - - - - -");
   }

}