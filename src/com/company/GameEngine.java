package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class GameEngine {

  public final Print printer = new Print();
  public final Scanner keyboard = new Scanner(System.in);
  public final Player thePlayer = new Player();
  public final Opponent theComputer = new Opponent();
  public int roundCount = 0;
  public final int roundLimit = 10;

  public int[] theCorretAnswerValueCompare = new int[4];
  public int[] matchesArray = new int[4];
  public int[] correctPlaceAndValue = new int[10];
  public int[] correctValueWrongPlace = new int[10];
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
        theComputer.autoSetTheCorrectAnswerArray();
        playerTurn();
      }
      default -> {
        printer.betweenOptions();
        menu();
      }
    }

  }

  private int chooseAnswer() {
    int chooseAnswer = keyboard.nextInt();
    return chooseAnswer;
  }

  public void playerSetTheCorrectAnswerArray(){
    int answerLength = 4;

    for (int i = 0; i < answerLength; i++) {
      printer.chooseNumber(i);
      int valueInArray = chooseAnswer();
      thePlayer.setsPlayerAnswerArray(i,valueInArray);

    }
  }








  public void displayHistory() {
    printer.displayHistory();
    int chooseAnswer = chooseAnswer();
    if (chooseAnswer == 1) {
      printer.printHistory(roundCount, thePlayer.getPlayerHistory(), correctPlaceAndValue, correctValueWrongPlace);
    }
  }

  public void playerTurn() {

    printer.printPlayerturn();
    displayHistory();
    printer.printEnterNumbers();
//    thePlayer.setsAnswer();

    isPlayerAnswerCorrect(theComputer.getTheCorretAnswer(), thePlayer.getPlayerAnswer());

    if (roundCount == 10) {
      printer.playerLost();
    } else if (hasWon) {
      printer.youWin();
    } else {
//      anyMatchesInPositionsAndValues();
      anyMathcesInCorrectValuesOnly();
  //    addArrayToGameHistory();

      increaseRoundCount();
      playerTurn();
    }
  }



  public void isPlayerAnswerCorrect(int[] corretAnswerArray, int[] playerAnswerArray) {

    if (Arrays.equals(corretAnswerArray, playerAnswerArray)) {
      hasWon = true;
    }
  }

  public void increaseRoundCount() {
    roundCount++;
  }

//  public void anyMatchesInPositionsAndValues() {
//
//    int correctMatches = 0;
//
//    for (int i = 0; i < 4; i++) {
//
//      if (theCorretAnswer[i] == playerAnswer[i]) {
//        correctMatches += 1;
//        matchesArray[i] = 0;
//        theCorretAnswerValueCompare[i] = -1;
//      } else {
//        matchesArray[i] = playerAnswer[i];
//        theCorretAnswerValueCompare[i] = theCorretAnswer[i];
//
//      }
//
//    }
//    printer.printMatchesPositionAndValue(correctMatches);
//    correctPlaceAndValue[roundCount] = correctMatches;
//
//
//  }

  public void anyMathcesInCorrectValuesOnly() {
    boolean dontRepeatCount;
    int correctValueCount = 0;

    for (int i = 0; i < 4; i++) {
      dontRepeatCount = true;
      for (int j = 0; j < 4; j++) {

        if (matchesArray[j] == theCorretAnswerValueCompare[i] & dontRepeatCount) {
          correctValueCount += 1;
          theCorretAnswerValueCompare[i] = -1;
          matchesArray[j] = 0;
          dontRepeatCount = false;

        }
      }
    }
    printer.printMatchesValueOnly(correctValueCount);
    correctValueWrongPlace[roundCount] = correctValueCount;


  }

  public static void main(String[] args) {
    GameEngine obj = new GameEngine();
    obj.menu();


  }
}
