package Core.desktop;

import java.io.*;
import javax.swing.*;
import java.awt.*;

public class PumaDesktopFrame extends JWindow
{
	//Getting the users native screen resolution.		
	Toolkit toolkit =  Toolkit.getDefaultToolkit ();
	Dimension ScreenResolution = toolkit.getScreenSize();

	//Initializing Class variables
	Container DesktopContainer;

	private void Components()
	{
		DesktopContainer = new Container();
	}
	
	private void addComponents()
	{
		this.setContentPane(DesktopContainer);
	}
	
	public PumaDesktopFrame()
	{
		try
		{
			this.setLayout(null);
			this.setSize(ScreenResolution);
			this.setLocationRelativeTo(null);

			Components();
			addComponents();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
