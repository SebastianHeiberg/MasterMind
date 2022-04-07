package com.company;

public class Print {

  Print() {

  }

  public void printTheCorretCode() {
    betweenOptions();
    System.out.println("You must first make the secret code." +
        "\nThe code consists of 4 digits, with a value between 1 and 4.");

  }

  public void betweenOptions() {
    System.out.println();
    System.out.println("-".repeat(30));
    System.out.println();
  }

  public void printMainMenu() {
    System.out.println("1: Play new game");
    System.out.println("2: End game");
    System.out.print("Enter choice here: ");
  }

  public void startGameOptions() {
    System.out.println("You now have to decide, how the 4 diget secret code gets set.");
    System.out.println("1: You set the code");
    System.out.println("2: Let computer set the code");
    System.out.print("Enter choice here: ");
  }

  public void chooseNumber(int number) {
    System.out.print("Enter the value of the " + (number + 1) + " diget out of 4: ");
  }

  public void printPlayerturn() {
    betweenOptions();
    System.out.println("Players turn");
  }
  public void printEnterNumbers () {
    System.out.println();
    System.out.println("You can now try to guess the secret code.");
  }

  public void youWin() {
    betweenOptions();
    System.out.println("Congratulations! You guessed it!");
  }

  public void printMatchesPositionAndValue(int number) {
    System.out.println();
    System.out.println("You had " + number + " correct mathces in position and value.");
  }

  public void printMatchesValueOnly(int number) {
    System.out.println("You had " + number + " correct mathces in value only.");
  }

  public void printHistory (int roundcount, int [][] playerHistory, int [] corretvalue, int [] correctplacement) {
    System.out.println();
    System.out.println("A correct placement/value = X and a corret value only = O ");
    for (int i = 0; i < roundcount ; i++) {
      System.out.printf("""
          \nThe %d round - | %d | %d | %d | %d |\t-\t""",i+1,playerHistory[i][0], playerHistory[i][1],playerHistory[i][2], playerHistory[i][3]);
      System.out.print("X ".repeat(corretvalue[i])+"O ".repeat(correctplacement[i]));
    }
    System.out.println();
  }

  public void displayHistory () {
    System.out.print("Enter 1 if you want to display round history, else enter 2 to guess again. ");
  }
  public void playerLost () {
    System.out.println("Game over");
  }

}
