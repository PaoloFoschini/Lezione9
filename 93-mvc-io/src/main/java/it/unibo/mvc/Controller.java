package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {
    public void setNextString(String sentence);  

    public String getNextString();
    
    public List<String> getPreviousStrings();

    public void printSentence();
}
