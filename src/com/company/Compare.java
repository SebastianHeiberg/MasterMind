package com.company;

import java.util.Arrays;

public class Compare {

  private int[] theCorretAnswerValueCompare;
  private int[] matchesArray;
  private int[] correctPlaceAndValue;
  private int[] correctValueWrongPlace;
  private final int answerLength = 4;

  public Compare () {
    this.theCorretAnswerValueCompare = new int[4];
    this.matchesArray = new int[4];
    this.correctPlaceAndValue = new int[10];
    this.correctValueWrongPlace = new int[10];
  }

  public int anyMatchesInPositionsAndValues(Player thePlayer, Opponent theComputer, int roundCount) {
    int correctMatches = 0;

    for (int i = 0; i < 4; i++) {

      if (theComputer.getTheCorretAnswer()[i] == thePlayer.getPlayerAnswer()[i]) {
        correctMatches += 1;
        matchesArray[i] = 0;
        theCorretAnswerValueCompare[i] = -1;
      } else {
        matchesArray[i] = thePlayer.getPlayerAnswer()[i];
        theCorretAnswerValueCompare[i] = theComputer.getTheCorretAnswer()[i];
      }
    }

    correctPlaceAndValue[roundCount] = correctMatches;
    return correctMatches;
  }

  public int anyMathcesInCorrectValuesOnly(int roundCount) {
    boolean dontRepeatCount;
    int correctValueCount = 0;

    for (int i = 0; i < answerLength; i++) {
      dontRepeatCount = true;
      for (int j = 0; j < answerLength; j++) {

        if (matchesArray[j] == theCorretAnswerValueCompare[i] & dontRepeatCount) {
          correctValueCount += 1;
          theCorretAnswerValueCompare[i] = -1;
          matchesArray[j] = 0;
          dontRepeatCount = false;
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

    if (Arrays.equals(corretAnswerArray, playerAnswerArray)) {
      return true;
    }
    return false;
  }

}
