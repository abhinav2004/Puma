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

package Core.jFrameworks.jWorkspace;

import Core.jFrameworks.jWorkspace.WorkspaceSettings.*;
import Core.jFrameworks.jWorkspace.jDock.*;
import Core.jFrameworks.jErrorHandler.errDialog;
import Core.jFrameworks.jCredentials.*;

import java.io.*;
import javax.swing.*;
import javax.swing.UIManager;
import java.awt.*;

import net.miginfocom.layout.*;
import net.miginfocom.swing.*;

public class jWorkspace extends JWindow
{
	//Getting the users native screen resolution.
	Toolkit toolkit =  Toolkit.getDefaultToolkit();
	Dimension ScreenResolution = toolkit.getScreenSize();

	//Initializing Class variables
	Container DesktopContainer;
	JDesktopPane Desktop;
	JLabel background;
	JLabel[] DockIcons;	
	JLayeredPane DockObject;

	private void Components()
	{
		DockObject = new jDock();

		Image img1 = ((new ImageIcon("Core/jFrameworks/jWorkspace/default.jpg").getImage()));

		DesktopContainer = new Container();
			DesktopContainer.setLayout(new MigLayout());
		Desktop = new JDesktopPane();
			Desktop.setLayout(null);
		background = new JLabel(new ImageIcon(img1.getScaledInstance((int)ScreenResolution.getWidth(), (int) ScreenResolution.getHeight(), java.awt.Image.SCALE_SMOOTH)));
			background.setSize(ScreenResolution);
			background.setLocation(0,0);
	}

	private void addComponents()
	{
		//Desktop.add(new WorkspaceSettings());//, "w 400, h 400, split, span");		
		//Desktop.add(background);
			//Desktop.moveToBack(Desktop);
		System.out.print("CORE: WORKSPACE: DOCK: Setting up jDock....");
		Desktop.add(DockObject);
			Desktop.moveToFront(DockObject);
		System.out.print("[DONE]\n");
		DesktopContainer.add(Desktop, "w 100%, h 100%");
		this.setContentPane(DesktopContainer);
	}

	public jWorkspace()
	{
		try
		{	
				
			this.setLayout(new MigLayout());
			System.out.println("CORE: WORKSPACE: Detecting Screen Resolution......."+(int)ScreenResolution.getWidth()+"x"+(int)ScreenResolution.getHeight());
			this.setSize(ScreenResolution);
			this.setLocationRelativeTo(null);
			//this.setTitle("Puma");
			
			System.out.print("CORE: WORKSPACE: Setting up workspace....");
			Components();
			System.out.print("[DONE]\n");
			addComponents();
			System.out.println("CORE: INFO: Puma is Ready!! Start rolling!");
		}
		catch(Exception e)
		{
			try
			{
				new errDialog(e.toString(), "err");
			}
			catch(Exception main_e)
			{
				System.out.println("ERROR: "+main_e.toString());
			}
		}
	}
}
