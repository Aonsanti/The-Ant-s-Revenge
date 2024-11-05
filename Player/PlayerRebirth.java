package Player;

import Screen.UpStat;

public class PlayerRebirth {
    PlayerLevel level = new PlayerLevel();

    public static int Rebirth = 0;
    public static int Rebirth_Point = 0;
    public int Rebirth_Level() {
        if (PlayerLevel.playerLevel >= PlayerLevel.maxLevel) {
            //Reset Level and Exp
            PlayerLevel.playerLevel = 0;   
            PlayerLevel.playerExp = 0;
            PlayerLevel.maxExp = PlayerLevel.maxExp_default;
            //Reset Point
            UpStat.Player_Point = 0;
            UpStat.Player_Point_Health = 0;
            UpStat.Player_Point_Punch = 0;
            UpStat.Player_Point_Kick = 0;
            //Reset Stats
            PlayerCharactor.healthplayer = 100;
            PlayerCharactor.healthplayer_default = 100;
            PlayerCharactor.normal_attack = 10;
            PlayerCharactor.kick = 20; 
            level.increaseMaxLevel();
            //Reset Enemy
            PlayerCharactor.enemy2Unlocked = false;
            PlayerCharactor.enemy3Unlocked = false;
            PlayerCharactor.enemyExtraUnlocked = false;
            Rebirth_Point ++;
        }
        return Rebirth ++;
    }
}
