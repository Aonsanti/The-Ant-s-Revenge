package Enemy;
import javax.swing.*;
import java.awt.*;
public class PostureEnemy4 {
    Image attack;
    Image stunt;
    Image dead;
    Image run;

    public PostureEnemy4() {
        attack = new ImageIcon(PostureEnemy4.class.getResource("/image/Enemy4attack.gif")).getImage();
        stunt = new ImageIcon(PostureEnemy4.class.getResource("/image/Enemy4stunt.png")).getImage();
        dead = new ImageIcon(PostureEnemy4.class.getResource("/image/Enemy4dead.png")).getImage();
        run = new ImageIcon(PostureEnemy4.class.getResource("/image/Enemy4Run.gif")).getImage();
    }
    public void draw(Graphics g, Enemy.Enemy4_Charactor enemy4, int x, int y, boolean Flipped) {
        if (enemy4.Dead) {
            drawFlippedImage(g, dead, x, y+45, 450, 450, Flipped);
        } else if (enemy4.Stunned) {
            drawFlippedImage(g, stunt, x, y+50, 400, 400, Flipped);
        } else if (enemy4.Attacking) {
            drawFlippedImage(g, attack, x, y-30, 450, 450, Flipped);
        } else{
            drawFlippedImage(g, run, x, y+90, 450, 400, Flipped);
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
