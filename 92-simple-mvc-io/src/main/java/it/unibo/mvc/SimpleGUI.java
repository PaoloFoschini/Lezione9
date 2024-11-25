package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * implement `SimpleGUI` class in such a way that:
 *
 * 1. It has a main method that starts the graphical application
 * 2. In its constructor, sets up the whole view
 * 3. The graphical interface consists of a `JTextArea` with a button "Save" right below (see `src/test/resources/ex02.png` for the expected result). 
 * 4. SUGGESTION: Use a `JPanel` with `BorderLayout`
 * 5. By default, if the graphical interface is closed the program must exit (call `setDefaultCloseOperation`)
 * 6. The program asks the controller to save the file if the button "Save" gets pressed.
 *
 */
public final class SimpleGUI {
    private final JFrame frame = new JFrame();
    private static final int PROPORTION = 5;

    public SimpleGUI(){
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        final JTextArea textArea = new JTextArea();
        final JButton button = new JButton("Save");
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);
        Controller controller = new Controller();

        button.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent event){
                try{
                    controller.write(textArea.getText());
                }catch(IOException e){
                    System.out.println("???");
                }
            }
        });

        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        new SimpleGUI().display();
    }
}
