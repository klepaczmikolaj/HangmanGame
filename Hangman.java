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
public class Hangman {

   static MyWord word = WordGenerator.generateWord();
   static GameLogic game = new GameLogic(word);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        game.gameLoop();
    }
    
}
