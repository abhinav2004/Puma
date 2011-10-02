package Core;

import java.io.*;
import javax.swing.*;

import Core.desktop.*;
import Core.Packages.errHandler.*;
import Core.Login.*;

class core
{
	public static void main(String args[]) throws Exception
	{
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		//loginDialog Frame = new loginDialog();
		PumaDesktopFrame Frame = new PumaDesktopFrame();
		Frame.setVisible(true);
	}
}
