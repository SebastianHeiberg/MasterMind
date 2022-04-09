package com.company;

public class Opponent {

  public int[] theCorretAnswer;

  public Opponent() {
    this.theCorretAnswer = new int[4];
  }

  public void autoSetTheCorrectAnswerArray() {
    for (int i = 0; i < theCorretAnswer.length; i++) {
      int a = (int) (1 + (Math.random() * 4));
      theCorretAnswer[i] = a;
    }
  }

  public void manualySetTheCorrectAnswerArray(int index, int value) {
    theCorretAnswer[index] = value;
  }

  public int[] getTheCorretAnswer() {
    return theCorretAnswer;
  }
}
