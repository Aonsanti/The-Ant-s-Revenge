package Enemy;
import javax.swing.*;
import java.awt.*;
public class PostureEnemy1 {
    Image attack;
    Image stunt;
    Image dead;
    Image run;

    public PostureEnemy1() {
        attack = new ImageIcon(PostureEnemy1.class.getResource("/image/Enemyattack.gif")).getImage();
        stunt = new ImageIcon(PostureEnemy1.class.getResource("/image/Enemy1stunt.png")).getImage();
        dead = new ImageIcon(PostureEnemy1.class.getResource("/image/Enemy1dead.png")).getImage();
        run = new ImageIcon(PostureEnemy1.class.getResource("/image/Enemy1Run.gif")).getImage();
    }
    public void draw(Graphics g, Enemy.Enemy1_Charactor enemy1, int x, int y, boolean Flipped) {
        if (enemy1.Dead) {
            drawFlippedImage(g, dead, x, y, 450, 450, Flipped);
        }else if (enemy1.Stunned) {
            drawFlippedImage(g, stunt, x, y, 450, 450, Flipped);
        }else if (enemy1.Attacking) {
            drawFlippedImage(g, attack, x, y, 450, 450, Flipped);
        }else {
            drawFlippedImage(g, run, x, y+45, 400, 400, Flipped);
        }
    }
    private void drawFlippedImage(Graphics g, Image img, int x, int y, int width, int height, boolean flip) {
        Graphics2D g2d = (Graphics2D) g;
        if (flip) {
            g2d.drawImage(img, x + width, y, -width, height, null);
        } 
        else {
            g2d.drawImage(img, x, y, width, height, null);
        }
    }
}
