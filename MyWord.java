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
public class MyWord {
    public String word;
    public boolean[] wordVisibility;
    public final int maxNumberOfMistakes = 7;
    public int currentMistakesNumber = 0;
   
}

