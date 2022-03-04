package com.company;

public class Print {

  Print () {

  }

  public void printTheCorretCode () {
    betweenOptions();
    System.out.println("You must first make the secret code, witch consists of 4 digits.");

  }

  public void betweenOptions () {
    System.out.println();
    System.out.println("-".repeat(30));
    System.out.println();
  }

  public void printMainMenu () {
    System.out.println("1: Play new game");
    System.out.println("2: End game");
    System.out.print("Enter choice here: ");
  }

  public void startGameOptions () {
    System.out.println("1: You set the answer");
    System.out.println("2: Let computer set answer");
    System.out.print("Enter choice here: ");
  }

  public void chooseNumber (int number) {
    System.out.print("Choose the " + (number+1) + " number of 4: ");
  }

  public void printPlayerturn () {
    betweenOptions();
    System.out.println("Players turn");
    System.out.println("You can now try to guess the secret code.");
  }

  public void youWin () {
    betweenOptions();
    System.out.println("Congratulations! You guessed it!");
  }


}
