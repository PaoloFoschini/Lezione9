package it.unibo.mvc;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* 
 * The class `Controller` class must implement a simple controller responsible of I/O access. 
 * It considers a single file at a time, and it is able to serialize objects in it.
 *
 * Implement this class with:
 * 
 * 1. A method for setting a File as current file
 * 2. A method for getting the current File
 * 3. A method for getting the path (in form of String) of the current `File`
 * 4. A method that gets a `String` as input and saves its content on the current file.
 * This method may throw an `IOException`.
 * 5. By default, the current file is "output.txt" inside the user home folder.
 * 
 * A String representing the local user home folder can be accessed using `System.getProperty("user.home")`.
 * The separator symbol (/ on *nix, \ on Windows) can be obtained as String through the method `System.getProperty("file.separator")`.
 * The combined use of those methods leads to a software that runs correctly on every platform. 
*/

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private final String propertyPath = System.getProperty("user.home") + System.getProperty("file.separator");
    private File currentFile = new File(propertyPath + "output.txt");

    public void setCurrentFile(File file){
        this.currentFile = file; 
    }

    public File getCurrentFile(){
        return this.currentFile;
    }

    public String getPath(){
        return this.currentFile.getPath();
    }

    public void write(String content) throws IOException{
        try(
            final DataOutputStream output = new DataOutputStream(new FileOutputStream (this.currentFile.getAbsoluteFile()))
        ){
            output.writeUTF(content);
        }
    }


}
