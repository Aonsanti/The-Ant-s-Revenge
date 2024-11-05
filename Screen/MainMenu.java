package Screen;
import javax.swing.*;

import Player.PlayerLevel;
import Player.PlayerRebirth;

import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame {
    PlayerLevel level;
    PlayerRebirth rebirth;
    Image[] imagebackground;
    int playerbackgroundframe = 0;
    boolean backgroundrunning = true;
    static class DrawGame extends JPanel {
        Image imagebackground;
        public DrawGame(Image imagebackground) {
            this.setLayout(null);
            this.imagebackground = imagebackground;
        }
        public void setBackgroundImage(Image newBackgroundImage) {
            this.imagebackground = newBackgroundImage;
            repaint();
        }
        
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(imagebackground, 0, 0, 1920, 1080, this);
        }
    }
    public MainMenu() {
        level = new PlayerLevel();
        rebirth = new PlayerRebirth();
        level.levelUp();
        JButton Startbutton = new JButton();
        JButton Exitbutton = new JButton();
        JButton Rebirthbutton = new JButton();
        JButton Upstat = new JButton();

        imagebackground = new Image[]{
            new ImageIcon(getClass().getResource("/image/BackgroundImage_Frame1.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/BackgroundImage_Frame2.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/BackgroundImage_Frame3.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/BackgroundImage_Frame4.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/BackgroundImage_Frame5.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/BackgroundImage_Frame6.png")).getImage(),
            new ImageIcon(getClass().getResource("/image/BackgroundImage_Frame7.png")).getImage()
        };
        DrawGame drawGame = new DrawGame(imagebackground[playerbackgroundframe]);
        add(drawGame, BorderLayout.CENTER); 
        startBackgroundAnimation(drawGame);

        JLabel Levelbarlevel = new JLabel("Level: " + PlayerLevel.playerLevel);
        Levelbarlevel.setBounds(10, 50, 200, 50);
        Levelbarlevel.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        if (PlayerLevel.playerExp == PlayerLevel.maxLevel) {
            Levelbarlevel.setText("Level: " +PlayerLevel.playerExp+" Max");
        }
        Levelbarlevel.setForeground(Color.WHITE);
        drawGame.add(Levelbarlevel);

        
        JLabel Rebirthtext = new JLabel("Rebirth: "+PlayerRebirth.Rebirth);
        Rebirthtext.setBounds(10, 90, 200, 50);
        Rebirthtext.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        Rebirthtext.setForeground(Color.WHITE);
        drawGame.add(Rebirthtext);

        JLabel Levelbarexptext = new JLabel("Exp: " + PlayerLevel.playerExp + "/" + PlayerLevel.maxExp);
        Levelbarexptext.setBounds(15, 10, 200, 50);
        Levelbarexptext.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        drawGame.add(Levelbarexptext);

        JPanel expBarContainer = new JPanel();
        expBarContainer.setBounds(10, 10, 400, 50);
        expBarContainer.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        expBarContainer.setLayout(null);
        drawGame.add(expBarContainer);

        JPanel expBar = new JPanel();
        expBar.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        double ExpPercentage = (double) PlayerLevel.playerExp / PlayerLevel.maxExp;
        int WidthExpBar = (int) (ExpPercentage * 400);
        expBar.setSize(WidthExpBar, 50);
        expBar.setBounds(0, 0, WidthExpBar, 50);
        expBar.setBackground(Color.GREEN);
        expBarContainer.add(expBar);

        Startbutton.setText("Start");
        Startbutton.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
        Startbutton.setFocusPainted(false);
        Startbutton.setBounds(1400, 390, 400, 100);
        Startbutton.addActionListener((ActionEvent e) -> {
            switchToSelectEnemy(this);
        });
        drawGame.add(Startbutton);

        Exitbutton.setText("Exit");
        Exitbutton.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
        Exitbutton.setFocusPainted(false);
        Exitbutton.setBounds(1400, 840, 400, 100);
        Exitbutton.addActionListener((ActionEvent e) -> {
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to Exit?", "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                System.exit(0);
            }
        });
        drawGame.add(Exitbutton);

        Rebirthbutton.setText("Rebirth : Must level " + PlayerLevel.maxLevel);
        Rebirthbutton.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        Rebirthbutton.setFocusPainted(false);
        Rebirthbutton.setBounds(1400, 540, 400, 100);
        Rebirthbutton.setEnabled(false);
        if (PlayerLevel.playerLevel >= PlayerLevel.maxLevel) {
            Rebirthbutton.setEnabled(true);
            Rebirthbutton.setText("Rebirth");
            Rebirthbutton.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
            
            Rebirthbutton.addActionListener((ActionEvent e) -> {
                rebirth.Rebirth_Level();
                Rebirthtext.setText("Rebirth: " + PlayerRebirth.Rebirth);
                Levelbarlevel.setText("Level: " + PlayerLevel.playerExp);
                Levelbarexptext.setText("Exp: " + PlayerLevel.playerExp + "/" + PlayerLevel.maxExp);
                expBar.setBorder(BorderFactory.createLineBorder(Color.black, 2));
                expBar.setSize(WidthExpBar, 50);
                expBar.setBounds(0, 0, 0, 50);
                repaint();
                
                Rebirthbutton.setText("Rebirth : Must level " +PlayerLevel.maxLevel);
                Rebirthbutton.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
                Rebirthbutton.setEnabled(false);
            });
        }
        drawGame.add(Rebirthbutton);

        Upstat.setText("UpStats");
        Upstat.setFocusPainted(false);
        Upstat.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
        Upstat.setBounds(1400, 690, 400, 100); 
        Upstat.addActionListener((ActionEvent e)->{
            JFrame newwindow =  new JFrame("Player Upstat Window");
            newwindow.setUndecorated(true);
            UpStat.PlayerUpStat(newwindow);
            newwindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        });
        drawGame.add(Upstat);
        // Frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1080);
        setResizable(false);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);
        repaint();

    }
    private void startBackgroundAnimation(DrawGame drawGame) {
        Thread animationThread = new Thread(() -> {
            while (backgroundrunning) {
                playerbackgroundframe = (playerbackgroundframe + 1) % imagebackground.length;
                drawGame.setBackgroundImage(imagebackground[playerbackgroundframe]);
                
                // Calculate the delay based on fps
                int delay = 1000 / 7;
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    backgroundrunning = false;
                }
            }
        });
        animationThread.start();
    }

    private void switchToSelectEnemy(JFrame frame) {
        frame.getContentPane().removeAll();
        frame.repaint(); // Refresh the frame
        SelectEnemy.displaySelectEnemy(frame);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainMenu::new);
    }
}