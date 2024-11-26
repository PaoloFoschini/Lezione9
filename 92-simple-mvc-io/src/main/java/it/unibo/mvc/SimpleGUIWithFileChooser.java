package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {
    private final JFrame frame = new JFrame();
    private static final int PROPORTION = 5;

    public SimpleGUIWithFileChooser(){
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        final JTextArea textArea = new JTextArea();
        final JButton save = new JButton("Save");
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(save, BorderLayout.SOUTH);
        Controller controller = new Controller();
        final JPanel subPanel = new JPanel();
        subPanel.setLayout(new BorderLayout());
        JTextField textField = new JTextField("" + controller.getPath());
        textField.setEditable(false);
        final JButton browse = new JButton("Browse...");
        final JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(controller.getCurrentFile());
        browse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                if(fc.showSaveDialog(browse) == JFileChooser.APPROVE_OPTION){
                    controller.setCurrentFile(fc.getSelectedFile());
                    textField.setText(controller.getPath());
                }else{
                    JOptionPane.showMessageDialog(browse, "Browse error", "Error occured in browse", 0);
                    System.out.println("unapproved");
                }
            }
        });
        subPanel.add(textField, BorderLayout.CENTER);
        subPanel.add(browse, BorderLayout.EAST);
        panel.add(subPanel, BorderLayout.NORTH);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
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

    private void display(){
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        new SimpleGUIWithFileChooser().display();
    }

}
