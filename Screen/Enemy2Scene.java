package Screen;
import javax.swing.*;

import Enemy.Enemy2_Charactor;
import Player.PlayerCharactor;
import Player.PlayerLevel;
import Player.PlayerRebirth;

import java.awt.*;
import java.awt.event.*;
public class Enemy2Scene  extends JFrame{
    static int wins = 0;
    static int losses = 0;
    static class DrawGame extends JPanel implements KeyListener, Runnable {
        PlayerCharactor player;
        Enemy.Enemy2_Charactor enemy2;
        Player.PosturePlayer posturePlayer;
        Enemy.PostureEnemy2 postureEnemy2;
        PlayerRebirth rebirth;
        PlayerLevel  player_Level;
        JLabel healthbarplayer;
        JLabel healthbarplayercontainer;
        JLabel healthbarenemy2;
        JLabel healthbarenemy2container;
        JLabel playerHealthLabel;
        JLabel enemyHealthLabel;
        JLabel floorJLabel;
        JLabel countTimeLabel;

        Timer countTimer;
        Timer DelayAttack_K;
        Timer DelayAttack_L;
        Timer DelayEnemy;
        int countTime = 0;
        Image background;
        boolean gameOver = false;

        public DrawGame(Player.PlayerCharactor player, Enemy.Enemy2_Charactor enemy2) {
            this.player = new PlayerCharactor();
            this.enemy2 = new Enemy2_Charactor();
            this.player_Level = new PlayerLevel();
            this.posturePlayer = new Player.PosturePlayer();
            this.postureEnemy2 = new Enemy.PostureEnemy2();

            this.floorJLabel = new JLabel(new ImageIcon(Enemy2Scene.class.getResource("/image/floor.png")));
            this.floorJLabel.setBounds(0, 975, 1920, 1000);
            this.add(this.floorJLabel);

            this.countTimeLabel = new JLabel("Time: " + countTime, SwingConstants.CENTER);
            this.countTimeLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
            this.countTimeLabel.setForeground(Color.WHITE);
            this.countTimeLabel.setBounds(0, 0, 1920, 100);
            this.add(this.countTimeLabel);
            
            this.healthbarplayercontainer = new JLabel();
            this.healthbarplayercontainer.setBounds(20, 20, 400, 50);
            this.healthbarplayercontainer.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            this.healthbarplayercontainer.setBackground(Color.white);
            this.healthbarplayercontainer.setOpaque(true);
            this.healthbarplayercontainer.setLayout(null);

            this.healthbarplayer = new JLabel();
            this.healthbarplayer.setOpaque(true);
            this.healthbarplayer.setBackground(Color.GREEN);
            this.healthbarplayer.setBounds(20, 20, 400, 50);
            this.healthbarplayer.setBorder(BorderFactory.createLineBorder(Color.black, 2));

            this.healthbarenemy2container = new JLabel();
            this.healthbarenemy2container.setBounds(1500, 20, 400, 50);
            this.healthbarenemy2container.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            this.healthbarenemy2container.setBackground(Color.white);
            this.healthbarenemy2container.setOpaque(true);
            this.healthbarenemy2container.setLayout(null);

            this.healthbarenemy2 = new JLabel();
            this.healthbarenemy2.setOpaque(true);
            this.healthbarenemy2.setBackground(Color.GREEN);
            this.healthbarenemy2.setBounds(1500, 20, 400, 50);
            this.healthbarenemy2.setBorder(BorderFactory.createLineBorder(Color.black, 2));

            this.playerHealthLabel = new JLabel("Player Health: " + PlayerCharactor.healthplayer);
            this.playerHealthLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
            this.playerHealthLabel.setBounds(20, 75, 200, 30);
            this.playerHealthLabel.setForeground(Color.WHITE);

            this.enemyHealthLabel = new JLabel("Enemy Health: " + enemy2.healthenemy2);
            this.enemyHealthLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
            this.enemyHealthLabel.setBounds(1500, 75, 200, 30);
            this.enemyHealthLabel.setForeground(Color.WHITE);

            this.setLayout(null);
            this.add(this.healthbarplayer);
            this.add(this.healthbarplayercontainer);
            this.add(this.healthbarenemy2);
            this.add(this.healthbarenemy2container);
            this.add(this.playerHealthLabel);
            this.add(this.enemyHealthLabel);

            this.background = new ImageIcon(Enemy2Scene.class.getResource("/image/Enemy2map.png")).getImage();
            startCountdownTimer();
            setFocusable(true);
            addKeyListener(this);
            new Thread(this).start();
        }

        private void startCountdownTimer() {
            countTimer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    countTime += 1;
                    countTimeLabel.setText("Time: " + countTime);
                    if (player.Dead || enemy2.Dead) {
                        countTimer.stop();
                    }
                }
            });
            countTimer.start();
        }
        private void applyJumpingAndGravity() {
            if (player.Jumping) {
              player.playermove_y += player.verticalVelocity;
              player.verticalVelocity += player.gravity;
        
              if (player.playermove_y >= 600) {
                player.playermove_y = 600;
                player.Jumping = false;
                player.OnGround = true;
                player.verticalVelocity = 0;
              }
            }
          }
        private void enemyAI() {
            if (gameOver || enemy2.Stunned) {
                return;
            }
            int distanceToPlayer = Math.abs(player.playermove_x - enemy2.enemy2move_x);
            if (distanceToPlayer > 225) {
                if (enemy2.enemy2move_x > player.playermove_x) {
                    enemy2.enemy2move_x -= 5;
                    enemy2.facingRight = false;
                    enemy2.Attacking = false;
                } else {
                    enemy2.enemy2move_x += 5;
                    enemy2.facingRight = true;
                }
                if (distanceToPlayer < 325) {
                    enemy2.Attacking = true;
                }
            } else {
                EnemyattackPlayer();
            }
        }

        private void EnemyattackPlayer() {
            if (DelayEnemy == null) {
                DelayEnemy = new Timer(400, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (enemy2.Attacking && enemy2.getAttackHitbox().intersects(player.getHitbox())) {
                            PlayerCharactor.healthplayer -= enemy2.normal_attack;
                            double healthPercentage = (double) PlayerCharactor.healthplayer / PlayerCharactor.healthplayer_default;
                            int WidthHealthplayer = (int) (healthPercentage * 400);
                            healthbarplayer.setSize(WidthHealthplayer, 50);
                            playerHealthLabel.setText("Player Health: " + PlayerCharactor.healthplayer);
                            player.Stunned = true;
                            player.playermove_x -= 30;
                            checkPlayerHealth();
                        }
                    }
                });
                DelayEnemy.setRepeats(true);
                DelayEnemy.start();
            }
            if (enemy2.healthenemy2 > 0 && PlayerCharactor.healthplayer > 0) {
                if (!enemy2.Attacking) {
                    enemy2.Attacking = true;
                }
            } else {
                enemy2.Attacking = false;
                if (DelayEnemy != null) {
                    DelayEnemy.stop();
                }
            }
        }

        private void checkPlayerHealth() {
            double healthPercentage = (double) PlayerCharactor.healthplayer / PlayerCharactor.healthplayer_default;
            if (PlayerCharactor.healthplayer <= 0) {
                PlayerCharactor.healthplayer = 0;
                player.Dead = true;
                repaint();
                gameOver = true;
                losses += 1;
                JOptionPane.showMessageDialog(this, "Losses: " + losses);
                if (DelayEnemy != null) {
                    DelayEnemy.stop();
                }
                handleGameOver();
            }
            if(healthPercentage > 0.75) {this.healthbarplayer.setBackground(Color.GREEN);}
            if(healthPercentage <= 0.75){this.healthbarplayer.setBackground(Color.YELLOW);}
            if(healthPercentage <= 0.50){this.healthbarplayer.setBackground(Color.ORANGE);}
            if(healthPercentage <= 0.25){this.healthbarplayer.setBackground(Color.RED);}
        }

        private void checkEnemyHealth() {
            double enemyHealthPercentage = (double) enemy2.healthenemy2 / enemy2.healthenemy2_default;
            if (enemy2.healthenemy2 <= 0) {
                enemy2.healthenemy2 = 0;
                enemy2.Dead = true;
                if (DelayEnemy != null) {
                    DelayEnemy.stop();
                    DelayEnemy = null;
                }
                repaint();  
                enemyHealthLabel.setText("Enemy Health: 0");
                gameOver = true;
                wins += 1;
                JOptionPane.showMessageDialog(DrawGame.this, "Wins: " + wins);
                handleGameOver();
            } else {
                int newEnemyWidth = (int) (enemyHealthPercentage * 400);
                healthbarenemy2.setSize(newEnemyWidth, 50);
                enemyHealthLabel.setText("Enemy Health: " + enemy2.healthenemy2);
            }
            if(enemyHealthPercentage > 0.75) {this.healthbarenemy2.setBackground(Color.GREEN);}
            if(enemyHealthPercentage <=0.75){this.healthbarenemy2.setBackground(Color.YELLOW);}
            if(enemyHealthPercentage <=0.50){this.healthbarenemy2.setBackground(Color.ORANGE);}
            if(enemyHealthPercentage <=0.25){this.healthbarenemy2.setBackground(Color.RED);}
        }

        private void handleGameOver() {
            player.HealthDefault();
            player.PunchDamage();
            player.KickDamage();
            PlayerCharactor.healthplayer = PlayerCharactor.healthplayer_default;
                if (wins >= 3) {
                    if (!PlayerCharactor.enemy3Unlocked) {
                        JOptionPane.showMessageDialog(this, "Congratulation You win! , Now Enemy 3 Unlocked!");
                        PlayerCharactor.enemy3Unlocked = true;
                    }
                    wins = 0; 
                    losses = 0; 
                    int WinExpGained = 450;
                    PlayerLevel.playerExp += WinExpGained;
                    JOptionPane.showMessageDialog(this, "ExpGained + " + WinExpGained);
                    player_Level.levelUp();
                    gameOver = true;
                    switchToMainMenu();
                } else if (losses >= 3) {
                    int LoseExpGained = 75;
                    PlayerLevel.playerExp += LoseExpGained;
                    JOptionPane.showMessageDialog(this, "Game Over! " + "ExpGained + " + LoseExpGained);
                    losses = 0;
                    wins = 0;
                    player_Level.levelUp();
                    gameOver = true;
                    switchToMainMenu();
            } else {
                restartGame();
            }
        }  
        private void switchToMainMenu() {
            player.HealthDefault();
            player.PunchDamage();
            player.KickDamage();
            gameOver = true;
            countTimer.stop();
            SwingUtilities.invokeLater(MainMenu::new);
            JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            if (currentFrame != null) {
                currentFrame.dispose();
            }
        }
        
        
        private void restartGame() {
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            topFrame.getContentPane().removeAll();
            PlayerCharactor.healthplayer = PlayerCharactor.healthplayer_default;
            DrawGame newGame = new DrawGame(new Player.PlayerCharactor(), new Enemy.Enemy2_Charactor());
            newGame.gameOver = false;
            topFrame.add(newGame);
            topFrame.revalidate();
            topFrame.repaint();
            newGame.requestFocusInWindow();
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (gameOver)
                return;
            switch (e.getKeyCode()) {
                case KeyEvent.VK_SPACE:
                    if (player.OnGround) {
                        player.Jumping = true;
                        player.OnGround = false;
                        player.verticalVelocity = player.jumpHeight;
                    }
                    break;
                case KeyEvent.VK_A:
                    player.playermove_x -= 20;
                    player.facingRight = false;
                    player.Running = true;
                    player.Stunned = false;
                    break;
                case KeyEvent.VK_D:
                    player.playermove_x += 20;
                    player.facingRight = true;
                    player.Running = true;
                    player.Stunned = false;
                    break;

                    case KeyEvent.VK_K:
                    if (DelayAttack_K == null || !DelayAttack_K.isRunning()) {
                        player.Attacking = true;
                        DelayAttack_K = new Timer(250, new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                if (player.getAttackHitbox().intersects(enemy2.getHitbox())) {
                                    enemy2.healthenemy2 -= PlayerCharactor.normal_attack;
                                    enemy2.enemy2move_x += 50;
                                    enemy2.Stunned = true;
                                    enemy2.stunTimer = 5;
                                    healthbarenemy2.setSize(enemy2.healthenemy2, 50);
                                    checkEnemyHealth();
                                }
                                player.Attacking = false;
                                DelayAttack_K.stop();
                            }
                        });
                        DelayAttack_K.setRepeats(false);
                        DelayAttack_K.start();
                    }
                    break;
                
                case KeyEvent.VK_L:
                    if (DelayAttack_L == null || !DelayAttack_L.isRunning()) {
                        player.SpecialAttacking = true;
                        DelayAttack_L = new Timer(1000, new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                if (player.getAttackHitbox().intersects(enemy2.getHitbox())) {
                                    enemy2.healthenemy2 -= PlayerCharactor.kick;
                                    enemy2.enemy2move_x += 300;
                                    enemy2.Stunned = true;
                                    enemy2.stunTimer = 5;
                                    healthbarenemy2.setSize(enemy2.healthenemy2, 50);
                                    checkEnemyHealth();
                                }
                                player.SpecialAttacking = false;
                                DelayAttack_L.stop();
                            }
                        });
                        DelayAttack_L.setRepeats(false);
                        DelayAttack_L.start();
                    }
                    break;
                }   
            }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D) {player.Running = false;}
            if (e.getKeyCode() == KeyEvent.VK_K) {player.Attacking = false;player.Stunned = false;}
            if (e.getKeyCode() == KeyEvent.VK_L) {player.SpecialAttacking = false;player.Stunned = false;}
        }
 
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(background, 0, 0, 1920, 1080, this);
            postureEnemy2.draw(g, enemy2, enemy2.enemy2move_x, enemy2.enemy2move_y, enemy2.facingRight);
            posturePlayer.draw(g, player, player.playermove_x, player.playermove_y, !player.facingRight);

            if (player.playermove_x < 0) {player.playermove_x = 0;} 
            else if (player.playermove_x > 1920 - 400) {player.playermove_x = 1920 - 400;}
            if (enemy2.enemy2move_x < 0) {enemy2.enemy2move_x = 0;} 
            else if (enemy2.enemy2move_x > 1920 - 400) {enemy2.enemy2move_x = 1920 - 400;}

            g.setColor(Color.WHITE);
            g.fillOval(290, 75, 30, 30);
            g.fillOval(340, 75, 30, 30);
            g.fillOval(390, 75, 30, 30);
            g.fillOval(1770, 75, 30, 30);
            g.fillOval(1820, 75, 30, 30);
            g.fillOval(1870, 75, 30, 30);
            if (wins >= 3) { g.setColor(Color.GREEN);g.fillOval(290, 75, 30, 30);}
            if (wins >= 2) {g.setColor(Color.GREEN);g.fillOval(340, 75, 30, 30);}
            if (wins >= 1) {g.setColor(Color.GREEN);g.fillOval(390, 75, 30, 30);}
            if (losses >= 1) {g.setColor(Color.RED);g.fillOval(1770, 75, 30, 30);}
            if (losses >= 2) {g.setColor(Color.RED);g.fillOval(1820, 75, 30, 30);}
            if (losses >= 3) {g.setColor(Color.RED);g.fillOval(1870, 75, 30, 30);}
        }
        @Override
        public void run() {
            while (!gameOver) {
                applyJumpingAndGravity();
                enemyAI();
                checkPlayerHealth();
                checkEnemyHealth();
                enemy2.updateStunTimer();
                repaint();
                try {
                    Thread.sleep(1000/60);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public Enemy2Scene(){
        setSize(1920, 1080);
        setResizable(false);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // public static void main(String[] args) {
    //     Player.PlayerCharactor player = new Player.PlayerCharactor();
    //     Enemy.Enemy2_Charactor enemy2 = new Enemy.Enemy2_Charactor();

    //     JFrame frame = new JFrame();
    //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     frame.setSize(1920, 1080);
    //     frame.setResizable(false);
    //     frame.setUndecorated(true);
    //     frame.setLocationRelativeTo(null);
    //     DrawGame drawGame = new DrawGame(player, enemy2);
    //     frame.add(drawGame);
    //     frame.setVisible(true);
    // }
}