/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

/**
 *
 * @author kleps
 */
public class Display {
    private MyWord myWord = new MyWord();
    
    public void printBoard(MyWord myWord){
        this.myWord = myWord;
        printWord();
        printHangman();
    }
    private void printWord(){
        System.out.println();
        for(int i = 0; i<myWord.word.length(); i++){
            if(myWord.wordVisibility[i] == true)
                System.out.print(myWord.word.charAt(i)+" ");
            else
                System.out.print("* ");
        }
        System.out.println();
        for(int i = 0; i<myWord.word.length(); i++)
            System.out.print("- ");
    }
    private void printHangman(){
        System.out.println();
        System.out.println();
        System.out.print("Mistakes: "+myWord.currentMistakesNumber);
        System.out.println("/"+myWord.maxNumberOfMistakes);
        System.out.println();

    }
    
    
}
