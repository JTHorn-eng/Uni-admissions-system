package students;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import database.Database;
import guis.BaseFrame;
import guis.ModuleFrame;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;

/**
 * 
 * @author horn1
 *
 *	After every operation call revalidate() to update GUI elements
 *
 */

public class StudentFrame extends JFrame {

	
	public static String studentId = "";
	public static JPanel genInfo;
	private static JLabel ireg = new JLabel("");
	private static JLabel iname = new JLabel("");
	private static JLabel iEmail = new JLabel("");
	private static JLabel iTutor = new JLabel("");
	public DefaultListModel<String> listModel = new DefaultListModel<>();

	public StudentFrame(String user) {
		initBaseFrame(user);
	}
	
	
	public void loadStudentInfo(String user) {
		String[] info = Database.getStudentInfo(user).split(" ");
		ireg.setText(info[0]);
		iname.setText(info[1] + " " + info[2] + " " + info[3] );
		iEmail.setText(info[4]);
		iTutor.setText(info[5]);

		revalidate();
		
	}
	
	public void initBaseFrame(String user) {
		new JFrame();
		setTitle("University Project");
		setBounds(100, 100, 1024, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel logged = new JLabel("Logged in as");
		logged.setFont(new Font("Tahoma", Font.PLAIN, 12));
		logged.setBounds(10, 11, 137, 21);
		getContentPane().add(logged);

		JPanel info = new JPanel();
		info.setBounds(10, 34, 378, 43);
		getContentPane().add(info);
		info.setLayout(null);

		JButton logout = new JButton("Logout");
		logout.setBounds(182, 11, 89, 23);
		info.add(logout);

		JLabel nameTemp = new JLabel(user);
		nameTemp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nameTemp.setBounds(10, 11, 168, 19);
		info.add(nameTemp);

		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		exit.setBounds(281, 11, 89, 23);
		info.add(exit);


		
		genInfo = new JPanel();
		genInfo.setBounds(398, 0, 600, 246);
		getContentPane().add(genInfo);
		genInfo.setLayout(null);

		JLabel infoTitle = new JLabel("Information");
		infoTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		infoTitle.setBounds(10, 11, 111, 25);
		genInfo.add(infoTitle);

		JLabel infoReg = new JLabel("Registration number: ");
		infoReg.setBounds(10, 50, 150, 14);
		ireg.setBounds(170, 50, 150, 14);
		genInfo.add(ireg);
		genInfo.add(infoReg);

		JLabel infoName = new JLabel("Name: ");
		infoName.setBounds(10, 75, 150, 14);
		iname.setBounds(60, 75, 150, 14);
		genInfo.add(infoName);
		genInfo.add(iname);

		JLabel infoEmail = new JLabel("Email:");
		infoEmail.setBounds(10, 100, 150, 14);
		iEmail.setBounds(60, 100, 150, 14);
		genInfo.add(infoEmail);
		genInfo.add(iEmail);

		JLabel infoTutor = new JLabel("Tutor:");
		infoTutor.setBounds(10, 125, 150, 14);
		iTutor.setBounds(60, 125, 300, 14);
		genInfo.add(infoTutor);
		genInfo.add(iTutor);

		JButton moduleViewer = new JButton("View Modules");
		moduleViewer.setBounds(10, 189, 150, 23);
		genInfo.add(moduleViewer);

		loadStudentInfo(user);

		
		moduleViewer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ModuleFrame(ireg.getText());
				
			}
		});

		getContentPane().add(genInfo);
		
		

	}
}
