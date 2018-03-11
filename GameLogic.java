/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.util.Scanner;

/**
 *
 * @author kleps
 */
public class GameLogic {
    
    private MyWord myWord = new MyWord();
    private final Scanner sc = new Scanner(System.in);
    private final Display display = new Display();
    
    private char userInput;
    
    public GameLogic(MyWord myWord){
        this.myWord = myWord;
    }
    public void gameLoop(){
        display.printBoard(myWord);
        while(isGameNotOver()){
            printInfoForUser();
            getUserInput();
            setNumberOfAttemts();
            setWordVisibility();
            display.printBoard(myWord);
        }
        printGameResult();
    }
    private boolean isGameNotOver(){
        if(isLooser())
            return false;
        for(int i = 0; i<myWord.word.length(); i++){
            if(myWord.wordVisibility[i] == false)
                return true;
        }
        return false;
    }
    private void getUserInput(){
        userInput = sc.next().charAt(0);
    }
    private void setWordVisibility(){
        for(int i = 0; i<myWord.word.length(); i++){
            if(myWord.word.charAt(i) == userInput)
                myWord.wordVisibility[i] = true;
        }
    }
    private void printInfoForUser(){
        System.out.println("enter your letter: ");
    }
    private boolean isLooser(){
        return myWord.currentMistakesNumber == myWord.maxNumberOfMistakes;
    }
    private void printGameResult(){
        if(isLooser())
            System.out.println("You lost!");
        else
            System.out.println("You won!");
        System.out.println("Game over!");
    }
    private void setNumberOfAttemts(){
        for(int i = 0; i<myWord.word.length(); i++){
            if(myWord.word.charAt(i) == userInput)
                return;
        }
        myWord.currentMistakesNumber++;
                      
    }
    
}
