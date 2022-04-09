package com.company;

import java.util.Arrays;

public class Compare {
  private final int[] tempMatchesArray;
  private final int[] correctPlaceAndValue;
  private final int[] correctValueWrongPlace;
  private final int answerLength = 4;

  public Compare() {
    this.tempMatchesArray = new int[4];
    this.correctPlaceAndValue = new int[10];
    this.correctValueWrongPlace = new int[10];
  }

  public int anyMatchesInPositionsAndValues(Player thePlayer, Opponent theComputer, int roundCount) {
    int correctMatches = 0;

    for (int i = 0; i < 4; i++) {

      if (theComputer.getTheCorretAnswer()[i] == thePlayer.getPlayerAnswer()[i]) {
        correctMatches += 1;
        tempMatchesArray[i] = 0;
      } else {
        tempMatchesArray[i] = (theComputer.getTheCorretAnswer()[i]);
      }
    }
    correctPlaceAndValue[roundCount] = correctMatches;
    return correctMatches;
  }

  public int anyMathcesInCorrectValuesOnly(int roundCount, Player thePlayer) {

    int correctValueCount = 0;
    boolean onlyCountANumberOnce;

    for (int i = 0; i < answerLength; i++) {
      onlyCountANumberOnce = true;
      for (int j = 0; j < answerLength; j++) {

        if (thePlayer.getPlayerAnswer()[i] == tempMatchesArray[j] && onlyCountANumberOnce) {
          correctValueCount++;
          tempMatchesArray[j] = 0;
          onlyCountANumberOnce = false;
        }
      }
    }
    correctValueWrongPlace[roundCount] = correctValueCount;
    return correctValueCount;
  }

  public int[] getCorrectPlaceAndValue() {
    return correctPlaceAndValue;
  }

  public int[] getCorrectValueWrongPlace() {
    return correctValueWrongPlace;
  }

  public boolean isPlayerAnswerCorrect(int[] corretAnswerArray, int[] playerAnswerArray) {

    return Arrays.equals(corretAnswerArray, playerAnswerArray);
  }

}
