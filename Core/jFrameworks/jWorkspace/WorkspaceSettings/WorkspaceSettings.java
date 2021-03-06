/*
 * This file belongs to the Puma Project.
 *
 * This file is under heavy development. But anyone is
 * entitled to change the code as long as they don't
 * break the whole project or a part of it.
 *
 * File belongs to Abhinav Hardikar
 *
 * Developers:
 * 1) Abhinav Hardikar (a.k.a aHardyX) (Contact: ahardyx@yahoo.in)
 */

package Core.jFrameworks.jWorkspace.WorkspaceSettings;

import Core.jFrameworks.jWorkspace.WorkspaceSettings.Frames.*;
import Core.jFrameworks.jErrorHandler.errDialog;

import java.io.*;
import javax.swing.*;
import javax.swing.UIManager;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import net.miginfocom.layout.*;
import net.miginfocom.swing.*;

public class WorkspaceSettings extends JInternalFrame implements ActionListener, ItemListener
{
	Toolkit toolkit =  Toolkit.getDefaultToolkit();
	Dimension ScreenResolution = toolkit.getScreenSize();

	JButton 		cancel;
	JList 			wall_list;
	Container 		ContentPane;
	JTabbedPane 		tabs;
	public JLayeredPane 	THEME_SELECTOR, PREFERENCES, WALLPAPER;
	JLabel			background;

	JCheckBox[] 		check;
	JButton 		apply;

	Image 			img1;
	
	private void Components()
	{
		//apply = new JButton("Apply");
		cancel = new JButton("Cancel");
			cancel.addActionListener(this);
		tabs = new JTabbedPane();			
			tabs.setTabPlacement(JTabbedPane.TOP);
		THEME_SELECTOR = new ThemeSelector();
		PREFERENCES = new JLayeredPane();
			PREFERENCES.setLayout(new MigLayout());
		WALLPAPER =  new Wallpaper();

		ContentPane = this.getContentPane();
			ContentPane.setLayout(new MigLayout());
	}
	
	private void addComponents()
	{	tabs.add("Preferences", PREFERENCES);
		tabs.add("Theme Selector", THEME_SELECTOR);
		tabs.add("Wallpaper", WALLPAPER);
		ContentPane.add(tabs);
		//tabs.setEnabledAt(2, false);
		//ContentPane.add(apply, "w 100, h 26, x 180");
		//ContentPane.add(cancel, "w 100, h 26, x 290, gapright 10,  wrap");
	}
	
	public void actionPerformed(ActionEvent event)
	{	
		if(event.getSource() == cancel)
		{
			this.setVisible(false);
		}
	}

	public void disableTheme(boolean option)
	{
		if(option)
		{
			tabs.setEnabledAt(1, false);
			tabs.repaint();
			System.out.println("CORE: INFO: Theme Selector Disabled");
		}
		else
		{
			//THEME_SELECTOR.setEnabled(true);
			tabs.setEnabledAt(1, true);
			System.out.println("CORE: INFO: Theme Selector Enabled");
		}
	}

	public void disableWallpaper(boolean option)
	{
		if(!option)
		{
			img1 = ((new ImageIcon("Core/jFrameworks/jWorkspace/WorkspaceSettings/Frames/default.jpg").getImage()));
			background = new JLabel(new ImageIcon(img1.getScaledInstance((int)ScreenResolution.getWidth(), (int) ScreenResolution.getHeight(), java.awt.Image.SCALE_SMOOTH)));
			background.setSize(ScreenResolution);
			background.setLocation(0,0);
			System.out.println("DEBUG: Adding Wallpaper");
			this.getParent().add(background);
			//background.moveToBack();
		}
		else
		{
			this.getParent().remove(background);
			this.getParent().repaint();
		}		
	}
/*=========================================================================================*/
	private void PreferencesComponents()
	{
		//WorkspaceSettingsWindow = new WorkspaceSettings();
		check = new JCheckBox[3];	
			check[0] = new JCheckBox("Use Global Menu");
				check[0].setEnabled(false);
			check[1] = new JCheckBox("Make Themes Changable", true);
				check[1].addItemListener(this);
			check[2] = new JCheckBox("Enable Wallpaper");
				check[2].addItemListener(this);
				
	}

	private void PreferencesaddComponents()
	{
		PREFERENCES.add(new JLabel("Select as per your preference:"), "wrap, gapbottom 10");
		for (int i = 0; i<3; i++)
			PREFERENCES.add(check[i], "wrap");
	}

	public void itemStateChanged(ItemEvent event)
	{
		if(event.getSource() == check[1])
		{
			if(event.getStateChange() == ItemEvent.SELECTED)
				disableTheme(false);
			else
				disableTheme(true);
		}
		if(event.getSource() == check[2])
		{
			if(event.getStateChange() == ItemEvent.SELECTED)
				disableWallpaper(false);
			else
				disableWallpaper(true);
		}
	}

/*=========================================================================================*/
	/*TODO: Item listener for the Preferences
	public void itemStateChanged(ItemEvent event)
	{
		
	}*/

	public WorkspaceSettings()
	{
		Components();
		addComponents();
		PreferencesComponents();
		PreferencesaddComponents();	
		this.setSize(415,500);
		this.setLocation((((int)ScreenResolution.getWidth())/2) - (this.getWidth())/2 ,(((int)ScreenResolution.getHeight())/2) - (this.getHeight())/2);
		this.setTitle("Desktop Settings");
		this.setClosable(true);
        	//this.setVisible(true);
	}
}
