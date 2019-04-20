package fin.controller;

import javax.swing.JOptionPane;

import fin.model.*;
import fin.model.Character;
import fin.view.*;

public class FinalController
{
	private FinalFrame appFrame;
	private GamePanel appPanel;
	
	private Character player;
	private Character enemy;
	
	public FinalController()
	{
		appFrame = new FinalFrame(this);
	}
	
	public FinalFrame getFrame()
	{
		return appFrame;
	}
	
	public void start()
	{
		/*if(appPanel.getPlayerHPValue() < 1)
		{
			appPanel.changeLoseLabel();
		}
		if(appPanel.getEnemyHPValue() < 1)
		{
			appPanel.changeWinLabel();
		}*/
	}
	
	public int [] getCharacterHP(int index)
	{
		int [] hpData = new int[2];
		
		hpData[0] = player.getHealth();
		hpData[1] = enemy.getHealth();
		return hpData;
	}
	
	public void play()
	{
		appFrame.replaceScreen("GAME");
		makeEnemy();
	}
	
	public void makeCharacter(int type)
	{
		if(type == 1)
		{
			player = new Warrior();
		}
		if(type == 2)
		{
			player = new Wizard();
		}
		if(type == 3)
		{
			player = new Thief();
		}
		if(type == 4)
		{
			player = new Archer();
		}
		if(type == 5)
		{
			enemy = new Warrior();
		}
		if(type == 6)
		{
			enemy = new Wizard();
		}
		if(type == 7)
		{
			enemy = new Thief();
		}
		if(type == 8)
		{
			enemy = new Archer();
		}
	}
	
	public void makeEnemy()
	{
		/*4 is how many numbers there are, and 5 is the first of those 4 numbers*/
		makeCharacter((int)(Math.random() * 4) + 5);
	}
	
	public void playerFight()
	{
		int damage = calculateDamage(10, 6);
		enemy.setHealth(enemy.getHealth() - damage);
		/*appPanel.setEnemyHPValue(appPanel.getEnemyHPValue() - damage);*/
	}
	
	public void enemyFight()
	{
		int damage = calculateDamage(10, 6);
		player.setHealth(player.getHealth() - damage);
		/*appPanel.setPlayerHPValue(appPanel.getPlayerHPValue() - damage);*/
	}
	
	public int defend()
	{
		int extraDefense = 5;
		return extraDefense;
	}
	
	/*public int potion()
	{
		
	}*/

	public int calculateDamage(int attack, int defense)
	{
		/*A number between 1 and 20 is generated*/
		int criticalChance = ((int)(Math.random() * 20) + 1);
		/*The damage will be between below 2 and above 2 the character's attack stat*/
		int damage = ((attack - defense) + ((int)(Math.random() * 5) - 2));
		if(criticalChance == 20)
		{
			damage = damage * 2;
		}
		return damage;
	}
	
	/*public int getPlayerHealth()
	{
		int health = player.getHealth();
		return health;
	}
	
	public int getEnemyHealth()
	{
		int health = enemy.getHealth();
		return health;
	}*/
}