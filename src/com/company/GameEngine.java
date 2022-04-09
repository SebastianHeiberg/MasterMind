package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class GameEngine {

  public final Print printer = new Print();
  public final Scanner keyboard = new Scanner(System.in);
  public final Player thePlayer = new Player();
  public final Opponent theComputer = new Opponent();
  public final Compare compareAnswers = new Compare();
  public int roundCount = 0;
  public final int roundLimit = 10;
  public boolean hasWon = false;

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

  private void startGame() {

    printer.startGameOptions();
    int choice = chooseAnswer();
    switch (choice) {
      case 1 -> {
        printer.printTheCorretCode();
        playerSetTheCorrectAnswerArray();
      }
      case 2 -> {
        theComputer.autoSetTheCorrectAnswerArray();
      }
      default -> {
        printer.betweenOptions();
        menu();
      }
    }

    playerTurn();

  }

  private int chooseAnswer() {
    int chooseAnswer = keyboard.nextInt();
    return chooseAnswer;
  }

  private void playerSetTheCorrectAnswerArray() {

    for (int i = 0; i < 4; i++) {
      printer.chooseNumber(i);
      int valueInArray = chooseAnswer();
      theComputer.manualySetTheCorrectAnswerArray(i, valueInArray);

    }
  }

  private void playerSetThePlayerAnswerArray() {
    int answerLength = 4;

    for (int i = 0; i < answerLength; i++) {
      printer.chooseNumber(i);
      int valueInArray = chooseAnswer();
      thePlayer.setsPlayerAnswerArray(i, valueInArray);

    }
  }

  private void displayHistory() {
    printer.displayHistory();
    int chooseAnswer = chooseAnswer();
    if (chooseAnswer == 1) {
      printer.printHistory(roundCount, thePlayer.getPlayerHistory(), compareAnswers.getCorrectPlaceAndValue(), compareAnswers.getCorrectValueWrongPlace());
    }
  }

  private void playerTurn() {

    while (!hasWon) {

      printer.printPlayerturn();

      if (roundCount != 0) {
        displayHistory();
      }

      printer.printEnterNumbers();
      playerSetThePlayerAnswerArray();

      isPlayerAnswerCorrect(theComputer.getTheCorretAnswer(), thePlayer.getPlayerAnswer());

      if (roundCount == 10) {
        printer.playerLost();
      } else if (hasWon) {
        printer.youWin();
      } else {
        findMatchesInPositionsAndValues();
        findMathcesInCorrectValuesOnly();
        thePlayer.addToPlayerHistory(roundCount);
        increaseRoundCount();
      }
    }
  }

  private void isPlayerAnswerCorrect(int[] corretAnswerArray, int[] playerAnswerArray) {

    if (Arrays.equals(corretAnswerArray, playerAnswerArray)) {
      hasWon = true;
    }
  }

  private void increaseRoundCount() {
    roundCount++;
  }

  private void findMatchesInPositionsAndValues() {
    int correctMatches = compareAnswers.anyMatchesInPositionsAndValues(thePlayer,theComputer,roundCount);
    printer.printMatchesPositionAndValue(correctMatches);

  }

  private void findMathcesInCorrectValuesOnly() {
    int correctValueCount = compareAnswers.anyMathcesInCorrectValuesOnly(roundCount);
    printer.printMatchesValueOnly(correctValueCount);
  }


  public static void main(String[] args) {
    GameEngine obj = new GameEngine();
    obj.menu();
  }
}
