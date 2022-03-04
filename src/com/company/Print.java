package com.company;

public class Print {

  Print () {

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
    System.out.println("1: Let computer set answer");
    System.out.println("2: You set the answer");
    System.out.print("Enter choice here: ");
  }


}
