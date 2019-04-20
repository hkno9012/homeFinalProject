package fin.view;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import fin.controller.FinalController;

public class StartPanel extends JPanel
{
	private FinalController app;
	private SpringLayout appLayout;
	
	private JButton startButton;
	private JButton exitButton;
	private JButton warriorSelectButton;
	private JButton wizardSelectButton;
	private JButton thiefSelectButton;
	private JButton archerSelectButton;
	
	public StartPanel(FinalController app)
	{
		super();
		this.app = app;
		this.appLayout = new SpringLayout();
		
		startButton = new JButton("Start");
		exitButton = new JButton("Exit");
		warriorSelectButton = new JButton("Warrior");
		wizardSelectButton = new JButton("Wizard");
		thiefSelectButton = new JButton("Thief");
		archerSelectButton = new JButton("Archer");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		//this.setPreferredSize(new Dimension(1000, 500));
		this.setBackground(Color.WHITE);
		
		this.add(startButton);
		this.add(exitButton);
		this.add(warriorSelectButton);
		this.add(wizardSelectButton);
		this.add(thiefSelectButton);
		this.add(archerSelectButton);
		
		startButton.setVisible(true);
		exitButton.setVisible(true);
		warriorSelectButton.setVisible(false);
		wizardSelectButton.setVisible(false);
		thiefSelectButton.setVisible(false);
		archerSelectButton.setVisible(false);
		
		startButton.setEnabled(true);
		exitButton.setEnabled(true);
		warriorSelectButton.setEnabled(false);
		wizardSelectButton.setEnabled(false);
		thiefSelectButton.setEnabled(false);
		archerSelectButton.setEnabled(false);
		
		warriorSelectButton.setBackground(Color.RED);
		warriorSelectButton.setOpaque(true);
		wizardSelectButton.setBackground(Color.CYAN);
		wizardSelectButton.setOpaque(true);
		thiefSelectButton.setBackground(Color.GRAY);
		thiefSelectButton.setOpaque(true);
		archerSelectButton.setBackground(Color.GREEN);
		archerSelectButton.setOpaque(true);
	}
	
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, startButton, 10, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, startButton, -390, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.WEST, startButton, 0, SpringLayout.WEST, exitButton);
		appLayout.putConstraint(SpringLayout.EAST, startButton, 0, SpringLayout.EAST, exitButton);
		appLayout.putConstraint(SpringLayout.WEST, exitButton, 245, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, exitButton, -474, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, exitButton, -80, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.WEST, warriorSelectButton, 74, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, wizardSelectButton, 160, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, wizardSelectButton, -230, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, warriorSelectButton, 0, SpringLayout.SOUTH, wizardSelectButton);
		appLayout.putConstraint(SpringLayout.EAST, warriorSelectButton, -61, SpringLayout.WEST, wizardSelectButton);
		appLayout.putConstraint(SpringLayout.WEST, wizardSelectButton, 245, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, warriorSelectButton, 0, SpringLayout.NORTH, wizardSelectButton);
		appLayout.putConstraint(SpringLayout.NORTH, exitButton, 50, SpringLayout.SOUTH, wizardSelectButton);
		appLayout.putConstraint(SpringLayout.NORTH, thiefSelectButton, 160, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, thiefSelectButton, -50, SpringLayout.NORTH, exitButton);
		appLayout.putConstraint(SpringLayout.EAST, wizardSelectButton, -61, SpringLayout.WEST, thiefSelectButton);
		appLayout.putConstraint(SpringLayout.WEST, thiefSelectButton, 416, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, thiefSelectButton, -474, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, archerSelectButton, 0, SpringLayout.NORTH, warriorSelectButton);
		appLayout.putConstraint(SpringLayout.WEST, archerSelectButton, 61, SpringLayout.EAST, thiefSelectButton);
		appLayout.putConstraint(SpringLayout.SOUTH, archerSelectButton, 0, SpringLayout.SOUTH, warriorSelectButton);
		appLayout.putConstraint(SpringLayout.EAST, archerSelectButton, -303, SpringLayout.EAST, this);
	}
	
	private void changeToSelectScreen()
	{
		startButton.setVisible(false);
		exitButton.setVisible(false);
		warriorSelectButton.setVisible(true);
		wizardSelectButton.setVisible(true);
		thiefSelectButton.setVisible(true);
		archerSelectButton.setVisible(true);
		
		startButton.setEnabled(false);
		exitButton.setEnabled(false);
		warriorSelectButton.setEnabled(true);
		wizardSelectButton.setEnabled(true);
		thiefSelectButton.setEnabled(true);
		archerSelectButton.setEnabled(true);
	}
	
	private void setupListeners()
	{
		startButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				changeToSelectScreen();
			}
		});
		
		exitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				System.exit(0);
			}
		});
		
		warriorSelectButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				app.makeCharacter(1);
				app.play();
			}
		});
		
		wizardSelectButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				app.makeCharacter(2);
				app.play();
			}
		});
		
		thiefSelectButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				app.makeCharacter(3);
				app.play();
			}
		});
		
		archerSelectButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				app.makeCharacter(4);
				app.play();
			}
		});
	}
}