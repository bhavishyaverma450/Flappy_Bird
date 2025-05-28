import javax.swing.*;

public class App {
    public static void main(String[] args) {
        int boardWidth = 360;
        int boardHeight = 640;

        JFrame frame = new JFrame("Flappy Bird");
        // frame.setLocationRelativeTo(null);
        frame.setSize(boardWidth, boardHeight);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Flappy_Bird fp = new Flappy_Bird();
        frame.add(fp);
        frame.pack();// if this is not used then it will count the size of the bar where flappy bird
                     // is written in the height and width
        fp.requestFocus();
        frame.setVisible(true);

    }
}
