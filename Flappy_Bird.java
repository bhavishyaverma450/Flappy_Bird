import javax.swing.*;
import java.awt.*;

public class Flappy_Bird extends JPanel {

    int boardWidth = 360;
    int boardHeight = 640;

    // Images
    Image bgImg;
    Image birdImg;
    Image topPipe;
    Image bottomPipe;

    Bird bird;

    class Bird {
        int x, y, width, height;
        Image img;

        public Bird(Image img, int x, int y, int width, int height) {
            this.img = img;
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
    }

    // Constructor
    public Flappy_Bird() {
        setPreferredSize(new Dimension(boardWidth, boardHeight)); // Required for pack()

        // Images
        birdImg = new ImageIcon("flappybird.png").getImage();
        bgImg = new ImageIcon("flappybirdbg.png").getImage();
        topPipe = new ImageIcon("toppipe.png").getImage();
        bottomPipe = new ImageIcon("bottompipe.png").getImage();

        // Bird
        int birdX = boardWidth / 8;
        int birdY = boardHeight / 2;
        int birdW = 34;
        int birdH = 24;
        bird = new Bird(birdImg, birdX, birdY, birdW, birdH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.drawImage(bgImg, 0, 0, boardWidth, boardHeight, null);
        g.drawImage(bird.img, bird.x, bird.y, bird.width, bird.height, null);
    }

}
