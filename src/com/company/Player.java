package com.company;

public class Player {

  private int[] playerAnswer;
  int[][] playerHistory;

  public Player (){
    this.playerAnswer = new int[4];
    this.playerHistory = new int[10][4];
  }

  public void addToPlayerHistory () {

  }

  public int[][] getPlayerHistory() {
    return playerHistory;
  }

  public int[] getPlayerAnswer() {
    return playerAnswer;
  }

  public void setsPlayerAnswerArray(int index, int value ) {
      playerAnswer[index] = value;
    }
  }

//  public void addArrayToGameHistory() {
//
//    for (int i = 0 + roundCount; i < roundCount + 1; i++) {
//      for (int j = 0; j < 4; j++) {
//        playerHistory[i][j] = playerAnswer[j];
//      }
//    }


