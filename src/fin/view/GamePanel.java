package fin.view;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import fin.controller.FinalController;
import fin.model.*;

public class GamePanel extends JPanel
{
	private SpringLayout panelLayout;
	private FinalController app;
	private JButton attackButton;
	private JButton defendButton;
	private JButton potionButton;
	
	private JLabel playerLabel;
	private JLabel enemyLabel;
	private JLabel winLabel;
	private JLabel loseLabel;
	
	private int playerHPValue;
	private int enemyHPValue;
	private JTextField playerHP;
	private JTextField enemyHP;
	
	private ImageIcon playerSprite;
	private ImageIcon enemySprite;
	
	public GamePanel(FinalController app)
	{
		super();
		this.app = app;
		this.panelLayout = new SpringLayout();
		
		this.playerSprite = new ImageIcon(getClass().getResource
				("/fin/view/images/smallCreatePlayerWarrior.png"));
		this.enemySprite = new ImageIcon(getClass().getResource
				("/fin/view/images/smallCreateEnemyWarrior.png"));
		
		playerHP = new JTextField("Player: " + 15);
		enemyHP = new JTextField("Enemy: " + 15);
		
		playerLabel = new JLabel("Player", playerSprite, JLabel.CENTER);
		enemyLabel = new JLabel("Enemy", enemySprite, JLabel.CENTER);
		winLabel = new JLabel("You Won");
		panelLayout.putConstraint(SpringLayout.SOUTH, winLabel, -28, SpringLayout.NORTH, playerLabel);
		panelLayout.putConstraint(SpringLayout.EAST, winLabel, 0, SpringLayout.EAST, playerHP);
		loseLabel = new JLabel("You Lost");
		panelLayout.putConstraint(SpringLayout.NORTH, loseLabel, 0, SpringLayout.NORTH, winLabel);
		panelLayout.putConstraint(SpringLayout.WEST, loseLabel, 0, SpringLayout.WEST, enemyHP);
		
		attackButton = new JButton("Attack");
		defendButton = new JButton("Defend");
		potionButton = new JButton("Potion");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(panelLayout);
		this.add(playerHP);
		this.add(enemyHP);
		this.add(playerLabel);
		this.add(enemyLabel);
		this.add(winLabel);
		winLabel.setVisible(false);
		this.add(loseLabel);
		loseLabel.setVisible(false);
		this.add(attackButton);
		this.add(defendButton);
		this.add(potionButton);
		
		playerLabel.setVerticalTextPosition(JLabel.BOTTOM);
		playerLabel.setHorizontalTextPosition(JLabel.CENTER);
		enemyLabel.setVerticalTextPosition(JLabel.BOTTOM);
		enemyLabel.setHorizontalTextPosition(JLabel.CENTER);
		
		this.setBackground(Color.WHITE);
	}
	
	private void setupLayout()
	{
		panelLayout.putConstraint(SpringLayout.NORTH, attackButton, 20, SpringLayout.NORTH, this);
		panelLayout.putConstraint(SpringLayout.WEST, attackButton, 100, SpringLayout.WEST, this);
		panelLayout.putConstraint(SpringLayout.SOUTH, attackButton, -390, SpringLayout.SOUTH, this);
		panelLayout.putConstraint(SpringLayout.EAST, attackButton, -700, SpringLayout.EAST, this);
		panelLayout.putConstraint(SpringLayout.NORTH, defendButton, 0, SpringLayout.NORTH, attackButton);
		panelLayout.putConstraint(SpringLayout.WEST, defendButton, 135, SpringLayout.EAST, attackButton);
		panelLayout.putConstraint(SpringLayout.SOUTH, defendButton, 0, SpringLayout.SOUTH, attackButton);
		panelLayout.putConstraint(SpringLayout.EAST, defendButton, -115, SpringLayout.WEST, potionButton);
		panelLayout.putConstraint(SpringLayout.NORTH, potionButton, 0, SpringLayout.NORTH, attackButton);
		panelLayout.putConstraint(SpringLayout.WEST, potionButton, 750, SpringLayout.WEST, this);
		panelLayout.putConstraint(SpringLayout.SOUTH, potionButton, -390, SpringLayout.SOUTH, this);
		panelLayout.putConstraint(SpringLayout.EAST, potionButton, -50, SpringLayout.EAST, this);
		panelLayout.putConstraint(SpringLayout.NORTH, enemyHP, 0, SpringLayout.NORTH, playerHP);
		panelLayout.putConstraint(SpringLayout.NORTH, playerHP, 35, SpringLayout.SOUTH, playerLabel);
		panelLayout.putConstraint(SpringLayout.WEST, playerHP, 0, SpringLayout.WEST, playerLabel);
		panelLayout.putConstraint(SpringLayout.WEST, playerLabel, 361, SpringLayout.WEST, this);
		panelLayout.putConstraint(SpringLayout.WEST, enemyHP, 0, SpringLayout.WEST, enemyLabel);
		panelLayout.putConstraint(SpringLayout.NORTH, enemyLabel, -3, SpringLayout.NORTH, playerLabel);
		panelLayout.putConstraint(SpringLayout.WEST, enemyLabel, 203, SpringLayout.EAST, playerLabel);
		panelLayout.putConstraint(SpringLayout.NORTH, playerLabel, 90, SpringLayout.SOUTH, attackButton);
		panelLayout.putConstraint(SpringLayout.EAST, playerLabel, 11, SpringLayout.WEST, defendButton);
	}
	
	
	
	private void setupListeners()
	{
		attackButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				app.playerFight();
				updateHPFields(1);
				app.enemyFight();
				updateHPFields(0);
			}
		});
		
		defendButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				app.defend();
			}
		});
		
		potionButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				
			}
		});
	}
	
	private void sendHPDataToController()
	{
		String [] hpData = new String[2];
		hpData[0] = playerHP.getText();
		hpData[1] = enemyHP.getText();
	}
	
	public void updateHPFields(int index)
	{
		String [] hpData = app.getCharacterHP(index);
		playerHP.setText("Player: " + hpData[0]);
		enemyHP.setText("Enemy: " + hpData[1]);
	}
	
	public void loadSprites(int playerNum, int enemyNum)
	{
		String path = "/create/view/images/";
		String defaultUserName = "smallCreateUserWarrior";
		String defaultEnemyName = "smallCreateEnemyWarrior";
		String extension = ".png";
		String player = "";
		String enemy = "";
		
		if(playerNum == 1)
		{
			player = "warrior";
		}
		if(playerNum == 2)
		{
			player = "Wizard";
		}
		if(playerNum == 3)
		{
			player = "Thief";
		}
		if(playerNum == 4)
		{
			player = "Archer";
		}
		if(enemyNum == 5)
		{
			enemy = "Warrior";
		}
		if(enemyNum == 6)
		{
			enemy = "Wizard";
		}
		if(enemyNum == 7)
		{
			enemy = "Thief";
		}
		if(enemyNum == 8)
		{
			enemy = "Archer";
		}
		
		try
		{
			playerSprite = new ImageIcon(getClass().getResource(path + player.toLowerCase() + extension));
		}
		catch(NullPointerException missingFile)
		{
			playerSprite = new ImageIcon(getClass().getResource(path + defaultUserName + extension));
		}
		playerLabel.setIcon(playerSprite);
		repaint();
		
		try
		{
			enemySprite = new ImageIcon(getClass().getResource(path + enemy.toLowerCase() + extension));
		}
		catch(NullPointerException missingFile)
		{
			enemySprite = new ImageIcon(getClass().getResource(path + defaultEnemyName + extension));
		}
		enemyLabel.setIcon(enemySprite);
		repaint();
	}
	
	public void changeWinLabel()
	{
		winLabel.setVisible(true);
	}
	
	public void changeLoseLabel()
	{
		loseLabel.setVisible(true);
	}
	
	public int getPlayerHPValue()
	{
		return playerHPValue;
	}
	
	public int getEnemyHPValue()
	{
		return enemyHPValue;
	}
	
	public void setPlayerHPValue(int hp)
	{
		this.playerHPValue = hp;
	}
	
	public void setEnemyHPValue(int hp)
	{
		this.enemyHPValue = hp;
	}
}