package com.company;

import java.util.Arrays;

public class Main {

    public void betweenOptions () {
        System.out.println();
        System.out.println("-".repeat(30));
        System.out.println();
    }

    public void menu () {
        System.out.println("1: Play new game");
        System.out.println("2: End game");
        betweenOptions();
        startGame();
    }

    public void startGame (){
        System.out.println("1: Set answer yourself");
        System.out.println("2: Computer sets answer");

        betweenOptions();
        computerSetAnswer();
        betweenOptions();
        playerTurn();
    }

    public int [] computerSetAnswer () {
        System.out.println("Computer sets answer: 1 2 3 4");
        int [] corretAnswer = {1,2,3,4};

        return corretAnswer;

    }

    public void playerTurn () {
        System.out.println("Players turn");
        playerAnswer();
        isPlayerAnswerCorrect(computerSetAnswer(),playerAnswer());



    }

    public int [] playerAnswer () {
        System.out.println("player answer: 1, 2, 3, 4");
        int [] playerAnswer = {1,2,3,4};
        return playerAnswer;
    }

    public void isPlayerAnswerCorrect(int [] corretAnswerArray, int [] playerAnswerArray) {
        System.out.println("Is answer correct? Y/N");
        if (Arrays.equals(corretAnswerArray,playerAnswerArray)) {
            System.out.println("Congratulations!");
        } else {
            System.out.println("This does not work");
            anyMatchesInAnswer();
        }
    }

    public void anyMatchesInAnswer () {
        System.out.println("Checking if there is any correct answers? Y/N");
    }



    public static void main(String[] args) {

        new Main().menu();

    }
}
