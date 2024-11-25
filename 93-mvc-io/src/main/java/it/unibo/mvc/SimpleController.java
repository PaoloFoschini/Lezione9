package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {
    private String sentence;
    private final List<String> list = new ArrayList<>();
    
    @Override
    public void setNextString(String sentence){
        this.sentence = sentence;
        this.list.add(sentence);   
    }
    @Override
    public String getNextString(){
        if(this.sentence == ""){
            throw new IllegalStateException("No sentences!");
        }
        return this.sentence;
    }
    @Override
    public List<String> getPreviousStrings(){
        if(this.list.isEmpty()){
            System.out.println("The list is empty!");
        }
        return this.list;
    }
    @Override
    public void printSentence(){
        System.out.println("Current sentence is: " + this.sentence);
    }
}
