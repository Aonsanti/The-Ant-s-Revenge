package Enemy;
import javax.swing.*;
import java.awt.*;
public class PostureEnemy3 {
    Image attack;
    Image stunt;
    Image dead;
    Image run;

    public PostureEnemy3() {
        attack = new ImageIcon(PostureEnemy3.class.getResource("/image/Enemy3attack.gif")).getImage();
        stunt = new ImageIcon(PostureEnemy3.class.getResource("/image/Enemy3stunt.png")).getImage();
        dead = new ImageIcon(PostureEnemy3.class.getResource("/image/Enemy3dead.png")).getImage();
        run = new ImageIcon(PostureEnemy3.class.getResource("/image/Enemy3Run.gif")).getImage();
    }
    public void draw(Graphics g, Enemy.Enemy3_Charactor enemy3, int x, int y, boolean Flipped) {
        if (enemy3.Dead) {
            drawFlippedImage(g, dead, x, y-20, 600, 600, Flipped);
        } else if (enemy3.Stunned) {
            drawFlippedImage(g, stunt, x, y, 550, 550, Flipped);
        } else if (enemy3.Attacking) {
            drawFlippedImage(g, attack, x, y, 600, 600, Flipped);
        } else{
            drawFlippedImage(g, run, x, y+45, 600, 550, Flipped);
        } 
    }
    private void drawFlippedImage(Graphics g, Image img, int x, int y, int width, int height, boolean flip) {
        Graphics2D g2d = (Graphics2D) g;
        if (flip) {
            g2d.drawImage(img, x + width, y, -width, height, null);
        } else {
            g2d.drawImage(img, x, y, width, height, null);
        }
    }
}
