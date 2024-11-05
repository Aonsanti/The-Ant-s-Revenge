package Player;
import java.awt.*;

import Screen.UpStat;

public class PlayerCharactor {
    public static int healthplayer = 100;
    public static int healthplayer_default = 100;
    public static int normal_attack = 10;
    public static int normal_attack_default = 10;
    public static int kick = 20;
    public static int kick_default = 20;
    public int playermove_x = 100;
    public int playermove_y = 600;
    public int verticalVelocity = 0;
    public int jumpHeight = -50;
    public int gravity = 5;
    public int stunTimer = 0;
    public boolean OnGround = true;
    public boolean facingRight = true;
    public boolean Jumping = false;
    public boolean Attacking = false;
    public boolean SpecialAttacking = false;
    public boolean Dead = false;
    public boolean Stunned = false;
    public boolean KnockedBack = false;
    public boolean Running = false;
    // public boolean Dash = false;
    public boolean MovingLeft = false;
    public boolean MovingRight = false;
    public boolean attackDelay_K = false;
    public boolean attackDelay_L = false;
    public static boolean enemy2Unlocked = false;
    public static boolean enemy3Unlocked = false;
    public static boolean enemyExtraUnlocked = false;

    public void HealthDefault(){
        if(UpStat.Player_Point_Health >= 1){
            healthplayer = healthplayer_default;
        }
    }
    public void PunchDamage(){
        if(UpStat.Player_Point_Punch >= 1){
            normal_attack = normal_attack_default;
        }
    }
    public void KickDamage(){
        if(UpStat.Player_Point_Kick >= 1){
            kick = kick_default;
        }
    }
    // Player Hitbox
    public Rectangle getHitbox() {
        return new Rectangle(playermove_x, playermove_y, 200, 200);
    }

    // Player AttackHitbox
    public Rectangle getAttackHitbox() {
        int attackWidth = 225;int attackHeight = 200;
        if (facingRight) {return new Rectangle(playermove_x + 100, playermove_y, attackWidth, attackHeight);} 
        else {return new Rectangle(playermove_x - attackWidth, playermove_y, attackWidth, attackHeight);}
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
