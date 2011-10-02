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

package Core.desktop.DesktopSettings;

import Core.desktop.DesktopSettings.Frames.*;
import Core.Packages.errHandler.errDialog;

import java.io.*;
import javax.swing.*;
import javax.swing.UIManager;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

import net.miginfocom.layout.*;
import net.miginfocom.swing.*;

public class DesktopSettings extends JInternalFrame implements ActionListener//, ItemListener
{
	Toolkit toolkit =  Toolkit.getDefaultToolkit();
	Dimension ScreenResolution = toolkit.getScreenSize();

	JButton apply, cancel;
	JList wall_list;
	Container ContentPane;
	JTabbedPane tabs;

	private void Components()
	{
		apply = new JButton("Apply");
		cancel = new JButton("Cancel");
			cancel.addActionListener(this);
		tabs = new JTabbedPane();			
			tabs.setTabPlacement(JTabbedPane.TOP);

		ContentPane = this.getContentPane();
			ContentPane.setLayout(new MigLayout());
	}
	
	private void addComponents()
	{	tabs.add("Preferences", new OtherPreferences());
		tabs.add("Theme Selector", new ThemeSelector());
		tabs.add("Wallpaper", new JLayeredPane());
		ContentPane.add(tabs, "w 100%, h 100%,span 2, wrap");
		ContentPane.add(apply, "w 100, h 26, x 180");
		ContentPane.add(cancel, "w 100, h 26, x 290, gapright 10,  wrap");
	}
	
	public void actionPerformed(ActionEvent event)
	{	
		if(event.getSource() == cancel)
		{
			this.setVisible(false);
		}
	}

	/*TODO: Item listener for the Preferences
	public void itemStateChanged(ItemEvent event)
	{
		
	}*/

	public DesktopSettings()
	{
		Components();
		addComponents();	
		this.setSize(400,400);
		this.setLocation((((int)ScreenResolution.getWidth())/2) - (this.getWidth())/2 ,(((int)ScreenResolution.getHeight())/2) - (this.getHeight())/2);
		this.setTitle("Desktop Settings");
		this.setClosable(true);
        	//this.setVisible(true);
	}
}
