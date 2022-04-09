package com.company;

import java.util.Scanner;

public class GameEngine {

  public final UI ui = new UI();
  public final Scanner keyboard = new Scanner(System.in);
  public final Player thePlayer = new Player();
  public final Opponent theComputer = new Opponent();
  public final Compare compareAnswers = new Compare();
  public int roundCount = 0;
  public final int roundGameLimit = 10;
  public boolean hasWon = false;

  public void menu() {

    ui.displayMainMenu();
    int choise = chooseAnswer();


    switch (choise) {
      case 1 -> {
        ui.displayBetweenOptions();
        startGame();
      }
      case 2 -> {
        ui.displayBetweenOptions();
        System.out.println("Exit program");
      }
      default -> {
        ui.displayBetweenOptions();
        menu();
      }
    }
  }

  private void startGame() {

    ui.displayStartGameOptions();
    int choice = chooseAnswer();
    switch (choice) {
      case 1 -> {
        ui.displayTheCorretCode();
        playerSetTheCorrectAnswerArray();
      }
      case 2 -> {
        theComputer.autoSetTheCorrectAnswerArray();
      }
      default -> {
        ui.displayBetweenOptions();
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
      ui.displayChooseNumber(i);
      int valueInArray = chooseAnswer();
      theComputer.manualySetTheCorrectAnswerArray(i, valueInArray);

    }
  }

  private void playerSetThePlayerAnswerArray() {
    int answerLength = 4;

    for (int i = 0; i < answerLength; i++) {
      ui.displayChooseNumber(i);
      int valueInArray = chooseAnswer();
      thePlayer.setsPlayerAnswerArray(i, valueInArray);

    }
  }

  private void posibilityToShowGameHistory() {
    ui.displayHistory();
    int chooseAnswer = chooseAnswer();
    if (chooseAnswer == 1) {
      ui.displayHistory(roundCount, thePlayer.getPlayerHistory(), compareAnswers.getCorrectPlaceAndValue(), compareAnswers.getCorrectValueWrongPlace());
    }
  }

  private void playerTurn() {

    while (!hasWon) {

      ui.displayPlayerturn();

      if (roundCount != 0) {
        posibilityToShowGameHistory();
      }

      ui.displayEnterNumbers();
      playerSetThePlayerAnswerArray();
      initalCompareOfAnswers();

      if (roundCount == roundGameLimit) {
        ui.displayPlayerLost();
      } else if (hasWon) {
        ui.displayYouWin();
      } else {
        findMatchesInPositionsAndValues();
        findMathcesInCorrectValuesOnly();
        thePlayer.addAnswerToPlayerHistory(roundCount);
        increaseRoundCount();
      }
    }
  }

  private void increaseRoundCount() {
    roundCount++;
  }

  private void initalCompareOfAnswers(){
    hasWon = compareAnswers.isPlayerAnswerCorrect(theComputer.getTheCorretAnswer(), thePlayer.getPlayerAnswer());
  }

  private void findMatchesInPositionsAndValues() {
    int correctMatches = compareAnswers.anyMatchesInPositionsAndValues(thePlayer, theComputer, roundCount);
    ui.displayMatchesPositionAndValue(correctMatches);

  }

  private void findMathcesInCorrectValuesOnly() {
    int correctValueCount = compareAnswers.anyMathcesInCorrectValuesOnly(roundCount, thePlayer);
    ui.displayMatchesValueOnly(correctValueCount);
  }

  public static void main(String[] args) {
    GameEngine obj = new GameEngine();
    obj.menu();
  }
}
