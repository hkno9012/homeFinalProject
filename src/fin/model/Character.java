    
package fin.model;

import fin.controller.FinalController;

public abstract class Character
{
	private FinalController app;
	
	private String name;
	private int health;
	private int attack;
	private int defense;
	private int speed;
	
	public Character(String name, 
			int health, int attack,
			int defense, int speed)
	{
		this.name = name;
		this.health = health;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public int getAttack()
	{
		return attack;
	}
	
	public int getDefense()
	{
		return defense;
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setHealth(int health)
	{
		this.health = health;
	}
	
	public void setAttack(int attack)
	{
		this.attack = attack;
	}
	
	public void setDefense(int defense)
	{
		this.defense = defense;
	}
	
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}
}