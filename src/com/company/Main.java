package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

  Print printer = new Print();
  Scanner keyboard = new Scanner(System.in);

  public void menu() {
    printer.printMainMenu();
    int choise = chooseAnswer();

    switch (choise) {
      case 1 -> startGame();
      case 2 -> System.out.println("Exit program");
      default -> {
        printer.betweenOptions();
        menu();
      }
    }
  }

  public int chooseAnswer() {
    int chooseAnswer = keyboard.nextInt();
    return chooseAnswer;
  }

  public void startGame() {

    printer.betweenOptions();

    printer.startGameOptions();
    int choice = chooseAnswer();
    switch (choice) {
      case 1 -> {
          printer.betweenOptions();
          computerSetAnswer();
      }
      case 2 -> {
          printer.betweenOptions();
          System.out.println("2: You set answer");
      }
      default -> {
        printer.betweenOptions();
        menu();
      }
    }


  }

  public int[] computerSetAnswer() {
    System.out.println("Computer sets answer: 1 2 3 4");
    int[] corretAnswer = {1, 2, 3, 4};

    return corretAnswer;

  }

  public void playerTurn() {
    System.out.println("Players turn");
    playerAnswer();
    isPlayerAnswerCorrect(computerSetAnswer(), playerAnswer());


  }

  public int[] playerAnswer() {
    System.out.println("player answer: 1, 2, 3, 4");
    int[] playerAnswer = {1, 2, 3, 4};
    return playerAnswer;
  }

  public void isPlayerAnswerCorrect(int[] corretAnswerArray, int[] playerAnswerArray) {
    System.out.println("Is answer correct? Y/N");
    if (Arrays.equals(corretAnswerArray, playerAnswerArray)) {
      System.out.println("Congratulations!");
    } else {
      System.out.println("This does not work");
      anyMatchesInAnswer();
    }
  }

  public void anyMatchesInAnswer() {
    System.out.println("Checking if there is any correct answers? Y/N");
  }


  public static void main(String[] args) {

    new Main().menu();


  }
}
