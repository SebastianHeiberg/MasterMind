package com.company;

public class Player {

  private int[] playerAnswer;
  int[][] playerHistory;

  public Player (){
    this.playerAnswer = new int[4];
    this.playerHistory = new int[10][4];
  }

  public void addToPlayerHistory (int roundCount) {
     for (int i = roundCount; i < roundCount + 1; i++) {
       System.arraycopy(playerAnswer, 0, playerHistory[i], 0, 4);
    }
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

//


