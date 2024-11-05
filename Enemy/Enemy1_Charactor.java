package Enemy;
import java.awt.Rectangle;
public class Enemy1_Charactor {
    public int healthenemy1 = 400;
    public int healthenemy1_default = 400;
    public int normal_attack = 3;
    public int enemy1move_x = 1400;
    public int enemy1move_y = 550;
    public int stunTimer = 0;
    public boolean facingRight = false;
    public boolean Attacking = false;
    public boolean Dead = false;
    public boolean KnockedBack = false;
    public boolean Stunned = false;
    public boolean Running;

    public Rectangle getHitbox() {
        return new Rectangle(enemy1move_x, enemy1move_y, 100, 200);
    }

    public Rectangle getAttackHitbox() {
        int attackWidth = 225;
        int attackHeight = 200;
        if (facingRight) {
            return new Rectangle(enemy1move_x + 100, enemy1move_y, attackWidth, attackHeight);
        } else {
            return new Rectangle(enemy1move_x - attackWidth, enemy1move_y, attackWidth, attackHeight);
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
