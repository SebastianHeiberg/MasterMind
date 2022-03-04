package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

  Print printer = new Print();
  int[] theCorretAnswer = new int[4];
  int[] playerAnswer = new int[4];
  Scanner keyboard = new Scanner(System.in);

  public void menu() {

    printer.printMainMenu();
    int choise = chooseAnswer();

    switch (choise) {
      case 1 -> {
        printer.betweenOptions();
        startGame();
      }
      case 2 -> {
        printer.betweenOptions();
        System.out.println("Exit program");
      }
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

    printer.startGameOptions();
    int choice = chooseAnswer();
    switch (choice) {
      case 1 -> {
        printer.printTheCorretCode();
        setTheCorrectAnswerArray();
        playerTurn();
      }
      case 2 -> {
        printer.betweenOptions();
        System.out.println("2: computer set answer");
      }
      default -> {
        printer.betweenOptions();
        menu();
      }
    }

  }

  public void setTheCorrectAnswerArray() {
    setsAnswer(theCorretAnswer);
  }

  public int[] setsAnswer(int[] answerArray) {

    for (int i = 0; i < answerArray.length; i++) {
      printer.chooseNumber(i);
      answerArray[i] = chooseAnswer();
    }
    return answerArray;
  }

  public void playerTurn() {

    printer.printPlayerturn();
    setsAnswer(playerAnswer);

    isPlayerAnswerCorrect(theCorretAnswer, playerAnswer);


  }

//  public int[] playerAnswer() {
//    System.out.println("player answer: 1, 2, 3, 4");
//    int[] playerAnswer = {1, 2, 3, 4};
//    return playerAnswer;
//  }

  public void isPlayerAnswerCorrect(int[] corretAnswerArray, int[] playerAnswerArray) {

    if (Arrays.equals(corretAnswerArray, playerAnswerArray)) {
      printer.youWin();
    } else {
      anyMatchesInAnswer();
    }
  }

  public void anyMatchesInAnswer() {
    System.out.println();
    System.out.println("Checking if there is any correct answers? Y/N");
  }


  public static void main(String[] args) {

    new Main().menu();


  }
}
