/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author kleps
 */
public class WordGenerator {
    static private MyWord myWord = new MyWord();
    static private Random ran = new Random();
    static private File file = new File("word_list.txt");
    static private ArrayList<String> wordList = new ArrayList<>();
    
    static MyWord generateWord(){
        setRandomWord();
        setVisibility();
        return myWord;
    }
    static private void setRandomWord(){
        readWordListFromFile();
        int index = ran.nextInt(wordList.size());
        myWord.word = wordList.get(index);
    }
    static private void setVisibility(){
        myWord.wordVisibility = new boolean[myWord.word.length()];
        setVisibilityFalse();
        setRandomCharsVisible();
    }
    static private void setVisibilityFalse(){
        for(int i = 0; i<myWord.word.length(); i++)
            myWord.wordVisibility[i] = false;
    }
    //method to modify
    static private void setRandomCharsVisible(){
        char randomChar = drawRandomCharFromMyWord(); 
        for(int i = 0; i<myWord.word.length(); i++)
            if(myWord.word.charAt(i) == randomChar)
                myWord.wordVisibility[i] = true;
    }
    static private void readWordListFromFile(){
        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                wordList.add(sc.nextLine());
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
            System.out.println("file not found");
        }
    }
    static private char drawRandomCharFromMyWord(){
       int randomCharIndex = ran.nextInt(myWord.word.length());
       char randomChar = myWord.word.charAt(randomCharIndex);
       return randomChar;
    }
}
