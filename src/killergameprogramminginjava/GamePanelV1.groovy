package killergameprogramminginjava

import javax.swing.JPanel
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics
import java.awt.Image

public class GamePanelV1 extends JPanel implements Runnable {
    private static final int PWIDTH = 500
    private static final int PHEIGHT = 400

    private Thread animator;
    private volatile boolean running = false;
    private volatile boolean gameOver = false;

    private Graphics dbg;
    private Image dbImage = null;

    public GamePanelV1() {
        setBackground(Color.white);
        setPreferredSize(new Dimension(PWIDTH, PHEIGHT));
    }

    public void addNotify() {
        super.addNotify();
        startGame();
    }

    private void startGame() {
        if(animator == null || !running) {
            animator = new Thread(this);
            animator.start();
        }
    }

    public void stopgame() {
        running = false;
    }

    public void run() {
        running = true;
        while(running) {
            gameUpdate();
            gameRender();
            repaint();
            try {
                Thread.sleep(20);
            } catch(InterruptedException ex) {}
        }
        System.exit(0);
    }

    public void gameUpdate() {
        if(!gameOver) {
            //
        }
    }

    public void gameRender() {
        if(dbImage == null) {
            dbImage = createImage(PWIDTH, PHEIGHT);
        }
        if (dbImage == null) {
            System.out.println("Unable to create dbImage");
            return;
        } else {
            dbg = dbImage.getGraphics();
        }

        dbg.setColor(Color.white);
        dbg.fillRect(0, 0, PWIDTH, PHEIGHT);

        if (gameOver) {
            //gameOverMessage(dbg);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(dbImage != null) {
            g.drawImage(dbImage, 0, 0, null);
        }
    }
}
