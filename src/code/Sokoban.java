package code;

import java.awt.EventQueue;
import java.io.IOException;
import javax.swing.JFrame;


public class Sokoban extends JFrame {


    public static void main(String[] args) throws IOException {
        EventQueue.invokeLater(() -> {
            try {
                new Level(1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
