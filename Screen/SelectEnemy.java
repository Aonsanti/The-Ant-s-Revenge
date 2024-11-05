package Screen;
import javax.swing.*;

import Player.PlayerCharactor;

import java.awt.*;
import java.awt.event.*;

public class SelectEnemy {
    static Image[] imagebackground;
    static int playerbackgroundframe = 0;
    static boolean backgroundrunning = true;

    static Image IconEnemy1;
    static Image IconEnemy2;
    static Image IconEnemy3;
    static Image IconExtraEnemy;

    static class DrawGame extends JPanel {
        Image imagebackground;

        public DrawGame(Image imagebackground) {
            this.imagebackground = imagebackground;
            this.setLayout(null);
        }

        public void setBackgroundImage(Image newBackgroundImage) {
            this.imagebackground = newBackgroundImage;
            repaint();
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(imagebackground , 0, 0, 1920, 1080, this);
        }
    }

    public static void displaySelectEnemy(JFrame frame) {
        // ImageIcon IconEnemy1 = new ImageIcon(SelectEnemy.class.getResource("/image/Enemy1.png"));
        // Image Enemy1 = IconEnemy1.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        // IconEnemy1 = new ImageIcon(Enemy1);

        // ImageIcon IconEnemy2 = new ImageIcon(SelectEnemy.class.getResource("/image/Enemy2.png"));
        // Image Enemy2 = IconEnemy2.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        // IconEnemy2 = new ImageIcon(Enemy2);

        // ImageIcon IconEnemy3 = new ImageIcon(SelectEnemy.class.getResource("/image/Enemy3.png"));
        // Image Enemy3 = IconEnemy3.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        // IconEnemy3 = new ImageIcon(Enemy3);

        // ImageIcon IconExtraEnemy = new ImageIcon(SelectEnemy.class.getResource("/image/Extraenemy.png"));
        // Image ExtraEnemy = IconExtraEnemy.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        // IconExtraEnemy = new ImageIcon(ExtraEnemy);

        IconEnemy1 = new ImageIcon(SelectEnemy.class.getResource("/image/Enemy1.png")).getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH); 
        IconEnemy2 = new ImageIcon(SelectEnemy.class.getResource("/image/Enemy2.png")).getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH); 
        IconEnemy3 = new ImageIcon(SelectEnemy.class.getResource("/image/Enemy3.png")).getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH); 
        IconExtraEnemy = new ImageIcon(SelectEnemy.class.getResource("/image/Extraenemy.png")).getImage().getScaledInstance(450, 450, Image.SCALE_SMOOTH); 

        imagebackground = new Image[]{
            new ImageIcon(SelectEnemy.class.getResource("/image/BackgroundSelectEnemy_Frame1.png")).getImage(),
            new ImageIcon(SelectEnemy.class.getResource("/image/BackgroundSelectEnemy_Frame2.png")).getImage(),
            new ImageIcon(SelectEnemy.class.getResource("/image/BackgroundSelectEnemy_Frame3.png")).getImage(),
            new ImageIcon(SelectEnemy.class.getResource("/image/BackgroundSelectEnemy_Frame4.png")).getImage(),
            new ImageIcon(SelectEnemy.class.getResource("/image/BackgroundSelectEnemy_Frame5.png")).getImage(),
            new ImageIcon(SelectEnemy.class.getResource("/image/BackgroundSelectEnemy_Frame6.png")).getImage(),
            new ImageIcon(SelectEnemy.class.getResource("/image/BackgroundSelectEnemy_Frame7.png")).getImage()
        };
        DrawGame drawGame = new DrawGame(imagebackground[playerbackgroundframe]);
        frame.add(drawGame, BorderLayout.CENTER);
        startBackgroundAnimation(drawGame);

        JButton Backtomenu = new JButton("Back to menu");
        Backtomenu.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        Backtomenu.setBounds(10, 10, 200, 50);
        Backtomenu.setFocusPainted(false);
        Backtomenu.addActionListener((ActionEvent e)->{
            SwingUtilities.invokeLater(MainMenu::new);
        });
        drawGame.add(Backtomenu);

        JButton Closegame = new JButton("X");
        Closegame.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        Closegame.setBounds(1865, 5, 50, 50);
        Closegame.setFocusPainted(false);
        Closegame.addActionListener((ActionEvent e) -> {
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to Exit?", "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                System.exit(0);
            }
        });
        drawGame.add(Closegame);

        JButton buttonenemy1 = new JButton(new ImageIcon(IconEnemy1));
        JButton buttonenemy2 = new JButton(new ImageIcon(IconEnemy2));
        JButton buttonenemy3 = new JButton(new ImageIcon(IconEnemy3));
        JButton buttonenemyextraenemy = new JButton(new ImageIcon(IconExtraEnemy));
        
        JLabel textenemy1 = new JLabel("Enemy1");
        JLabel textenemy2 = new JLabel("Enemy2");
        JLabel textenemy3 = new JLabel("Enemy3");
        JLabel textenemyextraenemy = new JLabel("ExtraEnemy");


        buttonenemy1.setBounds(1100, 100, 350, 350);
        buttonenemy1.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        buttonenemy1.setFocusable(false);
        buttonenemy1.setEnabled(true);

        textenemy1.setBackground(Color.WHITE);
        textenemy1.setHorizontalAlignment(JLabel.CENTER);
        textenemy1.setFont(new Font("Comic Sans MS",Font.BOLD,24));
        textenemy1.setOpaque(true);
        textenemy1.setBounds(1100, 455, 350, 50);
        textenemy1.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

        buttonenemy1.addActionListener((ActionEvent e) -> {
            frame.getContentPane().removeAll();
            Player.PlayerCharactor player = new Player.PlayerCharactor();
            Enemy.Enemy1_Charactor enemy1 = new Enemy.Enemy1_Charactor();
            Enemy1Scene.DrawGame gamePanel = new Enemy1Scene.DrawGame(player, enemy1);
            frame.add(gamePanel);
            frame.revalidate();
            frame.repaint();
            gamePanel.requestFocusInWindow();
        });

        buttonenemy2.setBounds(1500, 100, 350, 350);
        buttonenemy2.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        buttonenemy2.setFocusable(false);
        buttonenemy2.setEnabled(false);

        textenemy2.setBackground(Color.WHITE);
        textenemy2.setHorizontalAlignment(JLabel.CENTER);
        textenemy2.setFont(new Font("Comic Sans MS",Font.BOLD,24));
        textenemy2.setOpaque(true);
        textenemy2.setBounds(1500, 455, 350, 50);
        textenemy2.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

        if (PlayerCharactor.enemy2Unlocked == true) {
            buttonenemy2.setBounds(1500, 100, 350, 350);
            textenemy2.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
            textenemy2.setBounds(1500, 455, 350, 50);
            buttonenemy2.setBackground(null);
            buttonenemy2.setEnabled(true);
        }
        buttonenemy2.addActionListener((ActionEvent e)->{
            frame.getContentPane().removeAll();
            Player.PlayerCharactor player = new Player.PlayerCharactor();
            Enemy.Enemy2_Charactor enemy2 = new Enemy.Enemy2_Charactor();
            Enemy2Scene.DrawGame gamePanel = new Enemy2Scene.DrawGame(player, enemy2);
            frame.add(gamePanel);
            frame.revalidate();
            frame.repaint();
            gamePanel.requestFocusInWindow();
        });

        buttonenemy3.setBounds(1100, 550, 350, 350);
        buttonenemy3.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        buttonenemy3.setFocusable(false);
        buttonenemy3.setEnabled(false);

        textenemy3.setBackground(Color.WHITE);
        textenemy3.setHorizontalAlignment(JLabel.CENTER);
        textenemy3.setFont(new Font("Comic Sans MS",Font.BOLD,24));
        textenemy3.setOpaque(true);
        textenemy3.setBounds(1100, 905, 350, 50);
        textenemy3.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

        if (PlayerCharactor.enemy3Unlocked == true) {
            buttonenemy3.setBounds(1100, 550, 350, 350);
            textenemy3.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
            textenemy3.setBounds(1100, 905, 350, 50);
            buttonenemy3.setBackground(null);
            buttonenemy3.setEnabled(true);
        }
        buttonenemy3.addActionListener((ActionEvent e)->{
            frame.getContentPane().removeAll();
            Player.PlayerCharactor player = new Player.PlayerCharactor();
            Enemy.Enemy3_Charactor enemy3 = new Enemy.Enemy3_Charactor();
            Enemy3Scene.DrawGame gamePanel = new Enemy3Scene.DrawGame(player, enemy3);
            frame.add(gamePanel);
            frame.revalidate();
            frame.repaint();
            gamePanel.requestFocusInWindow();
        });

        buttonenemyextraenemy.setBounds(1500, 550, 350, 350);
        buttonenemyextraenemy.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        buttonenemyextraenemy.setFocusable(false);
        buttonenemyextraenemy.setEnabled(false);

        textenemyextraenemy.setBackground(Color.WHITE);
        textenemyextraenemy.setHorizontalAlignment(JLabel.CENTER);
        textenemyextraenemy.setFont(new Font("Comic Sans MS",Font.BOLD,24));
        textenemyextraenemy.setOpaque(true);
        textenemyextraenemy.setBounds(1500, 905, 350, 50);
        textenemyextraenemy.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        buttonenemyextraenemy.addActionListener((ActionEvent e)->{
            frame.getContentPane().removeAll();
            Player.PlayerCharactor player = new Player.PlayerCharactor();
            Enemy.Enemy4_Charactor enemy4 = new Enemy.Enemy4_Charactor();
            Enemy4Scene.DrawGame gamePanel = new Enemy4Scene.DrawGame(player, enemy4);
            frame.add(gamePanel);
            frame.revalidate();
            frame.repaint();
            gamePanel.requestFocusInWindow();
        });
        // if (PlayerCharactor.enemExtraUnlocked == true) {
        //     buttonenemyextraenemy = new JButton(IconExtraEnemy);
        //     buttonenemyextraenemy.setBounds(640, 350, 250, 250);
        //     textenemyextraenemy.setFont(new Font("Arial", Font.BOLD, 36));
        //     textenemyextraenemy.setBounds(700, 500, 250, 250);
        //     buttonenemyextraenemy.setBackground(null);
        //     buttonenemyextraenemy.setEnabled(true);
        // }
        // buttonenemyextraenemy.addActionListener((ActionEvent e)->{
        //     //Wait Update
        // });

        drawGame.add(buttonenemy1);
        drawGame.add(buttonenemy2);
        drawGame.add(buttonenemy3);
        drawGame.add(buttonenemyextraenemy);
        drawGame.add(textenemy1);
        drawGame.add(textenemy2);
        drawGame.add(textenemy3);
        drawGame.add(textenemyextraenemy);

        frame.revalidate();
        frame.repaint();
    }
    private static void startBackgroundAnimation(DrawGame drawGame) {
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
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);

        displaySelectEnemy(frame);
        frame.setVisible(true);
    }
}
