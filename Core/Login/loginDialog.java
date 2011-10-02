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

package Core.Login;

import Core.desktop.*;
import Core.Packages.errHandler.errDialog;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import net.miginfocom.layout.*;
import net.miginfocom.swing.*;

public class loginDialog extends JDialog implements ActionListener
{
	JTextField ID;
	JPasswordField passwd;
	Container ContentPane;
	JButton login, cancel;
	Font font;
	JLabel[] labels;

	private void Components() throws Exception
	{
		font = Font.createFont(Font.TRUETYPE_FONT, new File("Core/fonts/ConsolaMono.ttf"));	
	
		labels = new JLabel[3];
			labels[0] = new JLabel("Please login with your credentials:");
			labels[1] = new JLabel("User: ");
			labels[2] = new JLabel("Password: ");
			
			labels[0].setFont(font.deriveFont(14f));
			labels[1].setFont(font.deriveFont(14f));
			labels[2].setFont(font.deriveFont(14f));

		ContentPane = this.getContentPane();

		ID = new JTextField();
			ID.setFont(font.deriveFont(14f));
		passwd = new JPasswordField();
			passwd.setFont(font.deriveFont(14f));
		login = new JButton("Login");
			login.setFont(font.deriveFont(14f));
			login.addActionListener(this);
		JRootPane rootPane = this.getRootPane();
		rootPane.setDefaultButton(login);

		cancel = new JButton("Cancel");
			cancel.setFont(font.deriveFont(14f));
			cancel.addActionListener(this);

		
	}

	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == login)
		{
			if((ID.getText()).equals("abhinav") && new String((passwd.getPassword())).equals("abhinavh"))
			{
				PumaDesktopFrame Frame = new PumaDesktopFrame();
				this.setVisible(false);
				Frame.setVisible(true);
			}
			else
			{
				try
				{
					new errDialog("ID or Password is wrong!", "err");
				}
				catch(Exception main_e)
				{
					System.out.println("ERROR: "+main_e.toString());
				}		
			}
			
		}
		else if(event.getSource() == cancel)
			System.exit(0);
	}

	private void addComponents() throws Exception
	{
		ContentPane.add(labels[0], "span, wrap, gaptop 5, gapleft 10, gapright 10");
		ContentPane.add(labels[1], "gaptop 10, gapleft 10, gapright 10");
		ContentPane.add(ID, "w 200, h 26, wrap, gaptop 10, gapleft 10, gapright 10");
		ContentPane.add(labels[2], "gaptop 10, gapleft 10, gapright 10");
		ContentPane.add(passwd, "w 200, h 26, wrap, gaptop 10, gapleft 10, gapright 10");
		ContentPane.add(login, "w 100, h 26, align left, gaptop 10, gapleft 10, gapright 10");
		ContentPane.add(cancel, "w 100, h 26, align right, gaptop 10, gapleft 10, gapright 10");
	}

	public loginDialog() throws Exception
	{
		this.setLayout(new MigLayout());

		Components();
		addComponents();	
		
		this.setSize(350,200);
		this.setLocationRelativeTo(null);
		//this.setVisible(true);
	}
}

