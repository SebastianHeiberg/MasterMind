package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

  Print printer = new Print();
  int[] theCorretAnswer = new int[4];
  int[] theCorretAnswerValueCompare = new int[4];
  int[] playerAnswer = new int[4];
  int[] matchesArray = new int[4];
  boolean hasWon = false;
  Scanner keyboard = new Scanner(System.in);
  int roundCount = 0;
  int roundLimit = 10;
  int [][] playerHistory = new int [4][10];

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

  public void startGame() {

    printer.startGameOptions();
    int choice = chooseAnswer();
    switch (choice) {
      case 1 -> {
        printer.printTheCorretCode();
        playerSetTheCorrectAnswerArray();
        playerTurn();
      }
      case 2 -> {
        autoSetTheCorrectAnswerArray();
        playerTurn();
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

  public void playerSetTheCorrectAnswerArray() {
    setsAnswer(theCorretAnswer);
  }

  public void autoSetTheCorrectAnswerArray() {
    for (int i = 0; i < theCorretAnswer.length; i++) {
      int a = (int) (1 + (Math.random() * 4));
      theCorretAnswer[i] = a;
    }
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

    if (hasWon) {
      printer.youWin();
    } else {
      anyMatchesInPositionsAndValues();
      anyMathcesInCorrectValuesOnly();
      //addArrayToGameHistory();
      //printer.printHistory(roundCount,playerHistory);
      increaseRoundCount();
      playerTurn();
    }
  }

  public void addArrayToGameHistory () {

    for (int i = 0; i < roundCount; i++) {
      for (int j = 0; j < playerAnswer.length; j++) {
        playerHistory [i][j] = playerAnswer[j];
      }
    }
  }

  public void isPlayerAnswerCorrect(int[] corretAnswerArray, int[] playerAnswerArray) {

    if (Arrays.equals(corretAnswerArray, playerAnswerArray)) {
      hasWon = true;
    }
  }

  public void increaseRoundCount () {
    roundCount ++;
  }

  public void anyMatchesInPositionsAndValues() {

    int correctMatches = 0;

    for (int i = 0; i < 4; i++) {

      if (theCorretAnswer[i] == playerAnswer[i]) {
        correctMatches += 1;
        matchesArray[i] = 0;
        theCorretAnswerValueCompare[i] = -1;
      } else {
        matchesArray[i] = playerAnswer[i];
        theCorretAnswerValueCompare[i] = theCorretAnswer[i];

      }

    }
    printer.printMatchesPositionAndValue(correctMatches);


  }

  public void anyMathcesInCorrectValuesOnly() {
    boolean dontRepeatCount;
    int correctValueCount = 0;

    for (int i = 0; i < 4; i++) {
      dontRepeatCount = true;
      for (int j = 0; j < 4; j++) {

        if (matchesArray[j] == theCorretAnswerValueCompare[i] & dontRepeatCount) {
          correctValueCount += 1;
          theCorretAnswerValueCompare [i] = -1;
          matchesArray [j] = 0;
          dontRepeatCount = false;

        }
      }
    }
    printer.printMatchesValueOnly(correctValueCount);
//    System.out.println("player "+ Arrays.toString(playerAnswer));
//    System.out.println("correct " + Arrays.toString(theCorretAnswer));
//    System.out.println("matches" + Arrays.toString(matchesArray));
//    System.out.println("valuecompare "+ Arrays.toString(theCorretAnswerValueCompare));

  }

  public static void main(String[] args) {
    Main obj = new Main();
    obj.menu();


  }
}
