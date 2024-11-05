package Enemy;
import java.awt.Rectangle;
public class Enemy4_Charactor {
    public int healthenemy4 = 20000;
    public int healthenemy4_default = 20000;
    public int normal_attack = 20;
    public int enemy4move_x = 1400;
    public int enemy4move_y = 560;
    public int stunTimer = 0;
    public boolean facingRight = false;
    public boolean Attacking = false;
    public boolean Dead = false;
    public boolean KnockedBack = false;
    public boolean Stunned = false;
    public boolean Running = false;

    public Rectangle getHitbox() {
        return new Rectangle(enemy4move_x, enemy4move_y, 100, 200);
    }

    public Rectangle getAttackHitbox() {
        int attackWidth = 300;
        int attackHeight = 200;
        if (facingRight) {
            return new Rectangle(enemy4move_x + 100, enemy4move_y, attackWidth, attackHeight);
        } else {
            return new Rectangle(enemy4move_x - attackWidth, enemy4move_y, attackWidth, attackHeight);
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
