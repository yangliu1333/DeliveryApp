import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Example code for lecture 13 (Functional Programming).
 * @author Jeffrey Eppinger & Terry Lee
 */
public class Sample {

    /**
     * Simple program to demo how to write lambda expression with one parameter.
     * @param args arguments
     */
    public static void main(String[] args) {
        // window frame
        JFrame window = new JFrame("Before Java 8");

        // container
        JPanel pane = new JPanel();

        // components
        JButton button = new JButton("Send");
        JLabel label = new JLabel("Not sent!");

        Font font = new Font(Font.MONOSPACED, Font.BOLD, 25);
        button.setFont(font);
        label.setFont(font);

        // use lambda expression
        button.addActionListener(e -> label.setText("sent!"));

        // add components into the container
        pane.add(button);
        pane.add(label);

        // set content pane of the window
        window.setContentPane(pane);
        window.setSize(180, 150);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

}
