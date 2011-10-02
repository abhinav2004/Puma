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

package Core.desktop.DesktopSettings.Frames;

import Core.Packages.errHandler.errDialog;

import java.io.*;
import javax.swing.*;
import javax.swing.UIManager;
import javax.swing.BorderFactory.*;
import javax.swing.border.*;
import java.awt.*;

import net.miginfocom.layout.*;
import net.miginfocom.swing.*;

public class ThemeSelector extends JLayeredPane
{
	JLabel 		THEME_PIC;
	JComboBox 	THEME_LIST;
	String[]	THEME_LIST_ARRAY;
	
	private void Components()
	{
		//this.setBorder(BorderFactory.createTitledBorder("Theme Selector"));
		this.setLayout(new MigLayout());
		THEME_PIC = new JLabel();
		THEME_LIST_ARRAY = new String[2];
			THEME_LIST_ARRAY[0] = "Nimbus";
			THEME_LIST_ARRAY[1] = "SeaGlass";
		THEME_LIST = new JComboBox(THEME_LIST_ARRAY);	
	}

	private void addComponents()
	{
		this.add(THEME_PIC, "w 100%, h 100%, wrap");
		this.add(new JLabel("Select a theme: "), "wrap");
		this.add(THEME_LIST, "w 100%, h 26");
	}

	public ThemeSelector()
	{
		Components();
		addComponents();
	}
}
