/*
 * This file belongs to the Puma Project.
 *
 * This file is under heavy development. But anyone is
 * entitled to change the code as long as they don't
 * break the whole project or a part of it.
 *
 * File belongs to Abhinav Hardikar
 *
 * Developers (You can add your name if you make any notable changes): 
 * 1) Abhinav Hardikar (a.k.a aHardyX) (Contact: ahardyx@yahoo.in)
 */

package Core;

import java.io.*;
import javax.swing.*;
import java.util.*;

import Core.jFrameworks.jWorkspace.*;
import Core.jFrameworks.jErrorHandler.*;
import Core.jFrameworks.jCredentials.*;

class core
{
	static String 		THEME_NAME;
	
	private void readSettings()
	{
		try
		{
			core cr = new core();
			FileReader fw = new FileReader("Core/jFrameworks/jWorkspace/WorkspaceSettings/Workspace.settings");
			BufferedReader br = new BufferedReader(fw);
				StringTokenizer token = new StringTokenizer(br.readLine(), "=");
				cr.THEME_NAME = token.nextToken();
				cr.THEME_NAME = token.nextToken();
				//System.out.println(cr.THEME_NAME); //DEBUG: Remove first comment to start debugging
			br.close();
			fw.close();
			
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

	public static void main(String args[]) throws Exception
	{
		System.out.println("Initializing Core Puma.....");
		core cr = new core();
		System.out.println("Reading Configurations and Settings....");
		cr.readSettings();
		System.out.println("Core initialized. Transfering Control to Core.....");
		System.out.println("CORE: INFO: Setting theme....");
		if((THEME_NAME).equals("SeaGlass"))
			UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		else if((THEME_NAME).equals("Nimbus"))
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		else if((THEME_NAME).equals("Metal"))
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		
		loginDialog Frame = new loginDialog();
		//jWorkspace Frame = new jWorkspace();
		//System.out.println("Hi!");
		Frame.setVisible(true);
	}
}
