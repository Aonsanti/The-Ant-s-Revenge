package Screen;
import javax.swing.*;

import Player.PlayerCharactor;
// import Player.PlayerRebirth;
import java.awt.*;
import java.awt.event.*;

public class UpStat{
    // public static boolean UnlockDash_Unlock = false;
    public static int Player_Point = 0;
    public static int Player_Point_Health = 0;
    public static int Player_Point_Punch = 0;
    public static int Player_Point_Kick = 0;
    JButton Health = new JButton();
    JButton DamageK = new JButton();
    JButton DamageL = new JButton();
    // JButton Unlocked_Dash = new JButton();

    public static class DrawStat extends JPanel {
        private Image backgroundImage;

        public DrawStat(Image backgroundImage) {
            this.backgroundImage = backgroundImage;
            setLayout(null);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
            }
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);  // Draw the background image
            }
    }

    public void PlayerPointEqualZero() {
        if (Player_Point <= 0) {
            Health.setEnabled(false);
            DamageK.setEnabled(false);
            DamageL.setEnabled(false);
        }
    }
    // public void PlayerRebithPointEqualZero(){
    //     if (PlayerRebirth.Rebirth_Point <= 0) {
    //         Unlocked_Dash.setEnabled(false);
    //     }
    // }

    public static void PlayerUpStat(JFrame frame) {
        UpStat player_upstat = new UpStat();
        PlayerCharactor player = new PlayerCharactor();
        
        ImageIcon backgroundIcon = new ImageIcon(UpStat.class.getResource("/image/Background_Player_Stat.png"));
        Image backgroundImage = backgroundIcon.getImage();

        DrawStat drawStatPanel = new DrawStat(backgroundImage);
        ImageIcon ButtonIcon = new ImageIcon(UpStat.class.getResource("/image/Background_Button_Stats.png"));

        player_upstat.Health.setIcon(ButtonIcon);
        player_upstat.Health.setText("Increase Health + 100");
        player_upstat.Health.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        player_upstat.Health.setForeground(Color.GREEN);
        player_upstat.Health.setHorizontalTextPosition(SwingConstants.CENTER); 
        player_upstat.Health.setVerticalTextPosition(SwingConstants.CENTER); 
        player_upstat.Health.setBorder(BorderFactory.createLineBorder(Color.GREEN,3)); 
        player_upstat.Health.setFocusPainted(false);
        player_upstat.Health.setContentAreaFilled(false);
        player_upstat.Health.setBorderPainted(true);      
        
        player_upstat.DamageK.setIcon(ButtonIcon);
        player_upstat.DamageK.setText("Increase Punch Damage + 5");
        player_upstat.DamageK.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        player_upstat.DamageK.setForeground(Color.RED);
        player_upstat.DamageK.setHorizontalTextPosition(SwingConstants.CENTER); 
        player_upstat.DamageK.setVerticalTextPosition(SwingConstants.CENTER);  
        player_upstat.DamageK.setBorder(BorderFactory.createLineBorder(Color.RED,3)); 
        player_upstat.DamageK.setFocusPainted(false);
        player_upstat.DamageK.setContentAreaFilled(false);
        player_upstat.DamageK.setBorderPainted(true);  

        player_upstat.DamageL.setIcon(ButtonIcon);
        player_upstat.DamageL.setText("Increase Kick Damage + 100");
        player_upstat.DamageL.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        player_upstat.DamageL.setForeground(Color.RED);
        player_upstat.DamageL.setHorizontalTextPosition(SwingConstants.CENTER); 
        player_upstat.DamageL.setVerticalTextPosition(SwingConstants.CENTER);  
        player_upstat.DamageL.setBorder(BorderFactory.createLineBorder(Color.RED,3)); 
        player_upstat.DamageL.setFocusPainted(false);
        player_upstat.DamageL.setContentAreaFilled(false);
        player_upstat.DamageL.setBorderPainted(true);  

        // player_upstat.Unlocked_Dash.setIcon(ButtonIcon);
        // player_upstat.Unlocked_Dash.setText("Unlocked_Dash");
        // player_upstat.Unlocked_Dash.setFont(new Font("Arial", Font.BOLD, 18));
        // player_upstat.Unlocked_Dash.setForeground(Color.BLUE);
        // player_upstat.Unlocked_Dash.setHorizontalTextPosition(SwingConstants.CENTER); 
        // player_upstat.Unlocked_Dash.setVerticalTextPosition(SwingConstants.CENTER);  
        // player_upstat.Unlocked_Dash.setBorder(BorderFactory.createLineBorder(Color.BLUE,3)); 
        // player_upstat.Unlocked_Dash.setFocusPainted(false);
        // player_upstat.Unlocked_Dash.setContentAreaFilled(false);
        // player_upstat.Unlocked_Dash.setBorderPainted(true);  

        JButton CloseButton = new JButton("X");
        CloseButton.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        CloseButton.setBounds(750, 5, 45, 45);
        CloseButton.setFocusPainted(false);
        CloseButton.addActionListener((ActionEvent e) -> {
            frame.dispose();
        });

        JLabel WindowHeader = new JLabel("Player Stats");
        WindowHeader.setBounds(290, 10, 300, 50);
        WindowHeader.setFont(new Font("Comic Sans MS", Font.BOLD, 36));
        WindowHeader.setForeground(Color.WHITE);

        JLabel Health_Stat = new JLabel("Health : " + PlayerCharactor.healthplayer_default);
        Health_Stat.setBounds(100, 50, 200, 50);
        Health_Stat.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        Health_Stat.setForeground(Color.GREEN);

        JLabel Punch_Stat = new JLabel("Punch Damage : " + PlayerCharactor.normal_attack);
        Punch_Stat.setBounds(310, 50, 200, 50);
        Punch_Stat.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        Punch_Stat.setForeground(Color.RED);

        JLabel Kick_Stat = new JLabel("Kick Damage : " + PlayerCharactor.kick);
        Kick_Stat.setBounds(550, 50, 200, 50);
        Kick_Stat.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        Kick_Stat.setForeground(Color.RED);

        
        JLabel Point = new JLabel("Point : " + Player_Point);
        Point.setBounds(100, 100, 200, 50);
        Point.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        Point.setForeground(Color.YELLOW);
        
        // JLabel Rebirth_Point_Label = new JLabel("Rebirth Point : " + PlayerRebirth.Rebirth_Point);
        // Rebirth_Point_Label.setBounds(310, 100, 200, 50);
        // Rebirth_Point_Label.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        // Rebirth_Point_Label.setForeground(Color.PINK);
        
        // JLabel UnlockDashLabel = new JLabel("Dash : Locked");
        // UnlockDashLabel.setBounds(550 , 100 ,200 ,50);
        // UnlockDashLabel.setFont(new Font("Arial",Font.BOLD,18));
        // UnlockDashLabel.setForeground(Color.BLUE);
        
        if (Player_Point >= 1) {
            player_upstat.Health.setEnabled(true);
            player_upstat.DamageK.setEnabled(true);
            player_upstat.DamageK.setText("Increase Damage Punch + 5");
            player_upstat.DamageK.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
            player_upstat.DamageK.setFocusPainted(false);

            player_upstat.DamageL.setEnabled(true);
            player_upstat.DamageL.setText("Increase Damage Kick + 10");
            player_upstat.DamageL.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
            player_upstat.DamageL.setFocusPainted(false);
        } else if (Player_Point <= 0) {
            player_upstat.Health.setEnabled(false);
            player_upstat.Health.setText("You need 1 Point");
            player_upstat.Health.setFont(new Font("Comic Sans MS", Font.BOLD, 24));

            player_upstat.DamageK.setEnabled(false);
            player_upstat.DamageK.setText("You need 1 Point");
            player_upstat.DamageK.setFont(new Font("Comic Sans MS", Font.BOLD, 24));

            player_upstat.DamageL.setEnabled(false);
            player_upstat.DamageL.setText("You need 1 Point");
            player_upstat.DamageL.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        }

        // if (PlayerRebirth.Rebirth >= 1) {
        //     player_upstat.Unlocked_Dash.setEnabled(true);
        //     player_upstat.Unlocked_Dash.setText("Unlock Dash");
        //     player_upstat.Unlocked_Dash.setFont(new Font("Arial", Font.BOLD, 24));
        // } else if (PlayerRebirth.Rebirth <= 0) {
        //     player_upstat.Unlocked_Dash.setEnabled(false);
        //     player_upstat.Unlocked_Dash.setText("You need 1 Rebirth");
        //     player_upstat.Unlocked_Dash.setFont(new Font("Arial", Font.BOLD, 24));
        // }

        player_upstat.Health.addActionListener((ActionEvent e) -> {
            if (Player_Point > 0) {
                PlayerCharactor.healthplayer_default += 100;
                Player_Point -= 1;
                Player_Point_Health += 1;
                player.HealthDefault();
                Health_Stat.setText("Health : " + PlayerCharactor.healthplayer_default);
                Point.setText("Point : " + Player_Point);
                player_upstat.PlayerPointEqualZero();
            }
        });

        player_upstat.DamageK.addActionListener((ActionEvent e) -> {
            if (Player_Point > 0) {
                PlayerCharactor.normal_attack_default += 5;
                Player_Point -= 1;
                Player_Point_Punch += 1;
                player.PunchDamage();
                Punch_Stat.setText("Punch Damage : " + PlayerCharactor.normal_attack_default);
                Point.setText("Point : " + Player_Point);
                player_upstat.PlayerPointEqualZero();
            }
        });

        player_upstat.DamageL.addActionListener((ActionEvent e) -> {
            if (Player_Point > 0) {
                PlayerCharactor.kick_default += 10;
                Player_Point -= 1;
                Player_Point_Kick += 1;
                Kick_Stat.setText("Kick Damage : " + PlayerCharactor.kick_default);
                Point.setText("Point : " + Player_Point);
                player_upstat.PlayerPointEqualZero();
            }
        });

        // player_upstat.Unlocked_Dash.addActionListener((ActionEvent e) -> {
        //     if (PlayerRebirth.Rebirth_Point > 0) {
        //         UnlockDash_Unlock = true;
        //         PlayerRebirth.Rebirth_Point -= 1;
        //         player_upstat.Unlocked_Dash.setEnabled(false);
        //         UnlockDashLabel.setText("Dash : Unlocked");
        //         player_upstat.Unlocked_Dash.setText("Dash Unlocked");
        //         Rebirth_Point_Label.setText("Rebirth Point : " + PlayerRebirth.Rebirth_Point);
        //         player_upstat.PlayerRebithPointEqualZero();
        //     }
        // });

        player_upstat.Health.setBounds(75, 150, 300, 150);
        player_upstat.DamageK.setBounds(425, 150, 300, 150);
        player_upstat.DamageL.setBounds(75, 350, 300, 150);
        // player_upstat.Unlocked_Dash.setBounds(425, 350, 300, 150);

        // Add components to custom panel
        drawStatPanel.add(CloseButton);
        drawStatPanel.add(WindowHeader);
        drawStatPanel.add(Health_Stat);
        drawStatPanel.add(Punch_Stat);
        drawStatPanel.add(Kick_Stat);
        drawStatPanel.add(Point);
        // drawStatPanel.add(Rebirth_Point_Label);
        // drawStatPanel.add(UnlockDashLabel);
        drawStatPanel.add(player_upstat.Health);
        drawStatPanel.add(player_upstat.DamageK);
        drawStatPanel.add(player_upstat.DamageL);
        // drawStatPanel.add(player_upstat.Unlocked_Dash);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.add(drawStatPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // public static void main(String[] args) {
    //     JFrame frame = new JFrame("Player Stats");
    //     UpStat.PlayerUpStat(frame);
    // }
}
