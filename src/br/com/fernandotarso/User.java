package br.com.fernandotarso;

import java.io.File;
import java.io.IOException;

public class User {


//   C:\Users\Fernando\IdeaProjects\HomeApp\listaUsuarios.txt

   // Propriedades

   private boolean isLogged;
   static int userNumber;
   private String firstName;
   private String lastName;
   private String fullName;
   private String userName;
   private String passWord;

   // Construtores

   public User(){
      userNumber++;
   }

   public User(String firstName, String lastName, String userName, String passWord) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.userName = userName;
      this.passWord = passWord;
      userNumber++;
   }

   // Metodos

   public void setLogged(boolean logged) {
      this.isLogged = logged;
   }
   public boolean isLogged() {
      return this.isLogged;
   }

   public static int getUserNumber() {
      return userNumber;
   }
   public static void setUserNumber(int userNumber) {
      User.userNumber = userNumber;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }
   public String getFirstName() {
      return this.firstName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }
   public String getLastName() {
      return this.lastName;
   }

   public void setFullName() {
      this.fullName =  this.firstName + " " + this.lastName;
   }
   public String getFullName() {
      return this.fullName;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }
   public String getUserName() {
      return userName;
   }

   public void setPassWord(String passWord) {
      this.passWord = passWord;
   }
   public String getPassWord() {
      return passWord;
   }

   @Override
   public String toString() {
      return "Nome: " + fullName +
              "\nUsuário: " + userName +
              "\nOnline: " + isLogged;
   }

   public static File createListFile() {
      File userList;
      try {
         userList = new File("listaUsuarios.txt");
         if (userList.createNewFile()) {
            System.out.println("Lista de usuários criada: " + userList.getName());
         } else {
            System.out.println("Lista de usuários carregada.\n" + userList.getAbsolutePath());
         }
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
      return userList;
   }

//   Builder

   public static class UserBuilder {

      private String firstName;
      private String lastName;
      private String userName;
      private String passWord;


      public UserBuilder firstName(String firstName) {
         this.firstName = firstName;
         return this;
      }
      public UserBuilder lastName(String lastName) {
         this.lastName = lastName;
         return this;
      }
      public UserBuilder userName(String userName) {
         this.userName = userName;
         return this;
      }
      public UserBuilder passWord(String passWord) {
         this.passWord = passWord;
         return this;
      }

      public User build() {
         return new User(firstName, lastName, userName, passWord);
      }
   }

}
