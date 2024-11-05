package Enemy;
import java.awt.Rectangle;
public class Enemy2_Charactor {
    public int healthenemy2 = 1600;
    public int healthenemy2_default = 1600;
    public int normal_attack = 10;
    public int enemy2move_x = 1400;
    public int enemy2move_y = 550;
    public int stunTimer = 0;
    public boolean facingRight = false;
    public boolean Attacking = false;
    public boolean Dead = false;
    public boolean KnockedBack = false;
    public boolean Stunned = false;
    public boolean Running = false;

    public Rectangle getHitbox() {
        return new Rectangle(enemy2move_x, enemy2move_y, 100, 200);
    }

    public Rectangle getAttackHitbox() {
        int attackWidth = 250;
        int attackHeight = 200;
        if (facingRight) {
            return new Rectangle(enemy2move_x + 100, enemy2move_y, attackWidth, attackHeight);
        } else {
            return new Rectangle(enemy2move_x - attackWidth, enemy2move_y, attackWidth, attackHeight);
        }
    }
    public void updateStunTimer() {
        if (stunTimer > 0) {
            stunTimer--;
            if (stunTimer == 0) {
                Stunned = false;  // End stun
            }
        }
    }
}
