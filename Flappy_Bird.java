import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Flappy_Bird extends JPanel implements ActionListener, KeyListener {

    int boardWidth = 360;
    int boardHeight = 640;

    // Images
    Image bgImg;
    Image birdImg;
    Image topPipe;
    Image bottomPipe;

    Bird bird;
    int velocityY = 0;
    int gravity = 1;

    Timer gameLoop;

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

    public Flappy_Bird() {
        setPreferredSize(new Dimension(boardWidth, boardHeight));

        setFocusable(true);
        addKeyListener(this);

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

        gameLoop = new Timer(1000 / 60, this);
        gameLoop.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void move() {
        // bird
        velocityY += gravity;
        bird.y += velocityY;
        bird.y = Math.max(bird.y, 0);
    }

    public void draw(Graphics g) {
        g.drawImage(bgImg, 0, 0, boardWidth, boardHeight, null);
        g.drawImage(bird.img, bird.x, bird.y, bird.width, bird.height, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            velocityY = -9;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
