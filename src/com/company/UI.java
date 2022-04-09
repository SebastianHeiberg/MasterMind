package com.company;

public class UI {

  UI() {

  }

  public void displayTheCorretCode() {
    displayBetweenOptions();
    System.out.println("You must first make the secret code." +
        "\nThe code consists of 4 digits, with a value between 1 and 4.");
  }

  public void displayBetweenOptions() {
    System.out.println();
    System.out.println("-".repeat(30));
    System.out.println();
  }

  public void displayMainMenu() {
    System.out.println("1: Play new game");
    System.out.println("2: End game");
    System.out.print("Enter choice here: ");
  }

  public void displayStartGameOptions() {
    System.out.println("You now have to decide, how the 4 diget secret code gets set.");
    System.out.println("1: You set the code");
    System.out.println("2: Let computer set the code");
    System.out.print("Enter choice here: ");
  }

  public void displayChooseNumber(int number) {
    System.out.print("Enter the value of the " + (number + 1) + " diget out of 4: ");
  }

  public void displayPlayerturn() {
    displayBetweenOptions();
    System.out.println("Players turn");
  }

  public void displayEnterNumbers() {
    System.out.println();
    System.out.println("You can now try to guess the secret code.");
    System.out.println("Remember that the numbers are between 1 and 4.");
  }

  public void displayYouWin() {
    displayBetweenOptions();
    System.out.println("Congratulations! You guessed it!");
  }

  public void displayMatchesPositionAndValue(int number) {
    System.out.println();
    System.out.println("You had " + number + " correct mathces in position and value.");
  }

  public void displayMatchesValueOnly(int number) {
    System.out.println("You had " + number + " correct mathces in value only.");
  }

  public void displayHistory(int roundcount, int[][] playerHistory, int[] corretvalue, int[] correctplacement) {
    System.out.println();
    System.out.println("A correct placement/value = X and a corret value only = O ");
    for (int i = 0; i < roundcount; i++) {
      System.out.printf("""
          \nThe %d round - | %d | %d | %d | %d |\t-\t""", i + 1, playerHistory[i][0], playerHistory[i][1], playerHistory[i][2], playerHistory[i][3]);
      System.out.print("X ".repeat(corretvalue[i]) + "O ".repeat(correctplacement[i]));
    }
    System.out.println();
  }

  public void displayHistory() {
    System.out.print("Enter 1 if you want to display round history, else enter 2 to guess again. ");
  }

  public void displayPlayerLost() {
    System.out.println("Game over");
  }

}
