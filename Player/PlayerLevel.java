package Player;

import Screen.UpStat;

public class PlayerLevel {
   public static int playerLevel = 0;
   public static int playerExp = 0;
   public static int maxExp = 100;
   public static int maxExp_default = 100;
   public static int maxLevel = 10;
   public void increaseMaxLevel(){
      if (PlayerRebirth.Rebirth > 0) {
         maxLevel = (maxLevel+10);
      }
   }
   public void levelUp() {
      if (playerLevel >= maxLevel) {
         playerLevel = maxLevel;
         playerExp = maxExp;
      } 
      else {
         while (playerExp >= maxExp) {
            playerExp -= maxExp;
            maxExp += 100;
            ++playerLevel;
            UpStat.Player_Point += 1;
         }
      }
   }
}