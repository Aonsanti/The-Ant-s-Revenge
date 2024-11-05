package Player;
import javax.swing.*;
import java.awt.*;
public class PosturePlayer{
    Player.PlayerCharactor player;
    Image idle;
    Image run;
    Image jump;
    Image stunt;
    Image dead;
    Image punch;
    Image specialAttack;

    public PosturePlayer() {
        idle = new ImageIcon(PosturePlayer.class.getResource("/image/Idle.gif")).getImage();
        run = new ImageIcon(PosturePlayer.class.getResource("/image/Runsmooth.gif")).getImage();
        jump = new ImageIcon(PosturePlayer.class.getResource("/image/jump.png")).getImage();
        dead = new ImageIcon(PosturePlayer.class.getResource("/image/dead.png")).getImage();
        stunt = new ImageIcon(PosturePlayer.class.getResource("/image/stunt.png")).getImage();
        punch = new ImageIcon(PosturePlayer.class.getResource("/image/punch.png")).getImage();
        specialAttack = new ImageIcon(PosturePlayer.class.getResource("/image/specialattack.png")).getImage();
    }

    public void draw(Graphics g, Player.PlayerCharactor player, int x, int y, boolean Flipped) {
        if (player.Dead) {
            drawFlippedImage(g, dead, x,720, 400, 400, Flipped);
        } else if (player.Stunned) {
            drawFlippedImage(g, stunt, x,y+45, 400, 400, Flipped);
        } else if (player.Attacking) {
            drawFlippedImage(g, punch, x, y, 400, 400, Flipped);
        } else if (player.SpecialAttacking) {
            drawFlippedImage(g, specialAttack, x, y, 400, 400, Flipped);
        } else if (player.Running) {
            drawFlippedImage(g, run, x, y - 25, 450, 400, Flipped);
        } else if (player.Jumping) {
            drawFlippedImage(g, jump, x, y - 35, 400, 500, Flipped);
        } else {
            drawFlippedImage(g, idle, x, y, 400, 400, Flipped);
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
