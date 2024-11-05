package Enemy;
import java.awt.Rectangle;
public class Enemy3_Charactor {
    public int healthenemy3 = 6400;
    public int healthenemy3_default = 6400;
    public int normal_attack = 50;
    public int enemy3move_x = 1400;
    public int enemy3move_y = 400;
    public int stunTimer = 0;
    public boolean facingRight = false;
    public boolean Attacking = false;
    public boolean Dead = false;
    public boolean KnockedBack = false;
    public boolean Stunned = false;
    public boolean Running = false;

    public Rectangle getHitbox() {
        return new Rectangle(enemy3move_x, enemy3move_y, 250, 600);
    }

    public Rectangle getAttackHitbox() {
        int attackWidth = 250;
        int attackHeight = 600;
        if (facingRight) {
            return new Rectangle(enemy3move_x + 100, enemy3move_y, attackWidth, attackHeight);
        } else {
            return new Rectangle(enemy3move_x - attackWidth, enemy3move_y, attackWidth, attackHeight);
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
