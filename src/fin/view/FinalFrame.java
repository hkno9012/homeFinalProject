
package fin.view;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import fin.controller.FinalController;

public class FinalFrame extends JFrame
{
	private FinalController app;
	private StartPanel startPanel;
	private GamePanel appPanel;
	private JPanel panelCards;
	
	public FinalFrame(FinalController app)
	{
		super();
		this.app = app;
		this.startPanel = new StartPanel(app);
		this.appPanel = new GamePanel(app);
		this.panelCards = new JPanel(new CardLayout());
		setupFrame();
	}
	
	private void setupFrame()
	{
		panelCards.add(startPanel, "START");
		panelCards.add(appPanel, "GAME");
		//this.setContentPane(appPanel);
		this.setTitle("Create Project");
		this.setSize(1000, 500);
		getContentPane().add(panelCards);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		replaceScreen("START");
		this.setVisible(true);
	}
	
	public void replaceScreen(String screen)
	{
		if(screen.equals("GAME"))
		{
			
		}
		((CardLayout)panelCards.getLayout()).show(panelCards, screen);
	}
}