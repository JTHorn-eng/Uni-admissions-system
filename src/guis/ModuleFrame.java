package guis;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import database.Database;

public class ModuleFrame extends JFrame {


	private String info;
	private String[] columnNames = {"Initial Grade", "Resit Grade", "Has passed", "Module Name", "Credits", "Duration", "Code", "Core", "Study Level"};
	private static String[][] data;
	
	public ModuleFrame(String studentId) {
		init(studentId);
	}
	
	public static void main(String[] args) {
		new ModuleFrame("0");
	}
	

	private void init(String id) {

		setTitle("Module Viewer");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 812, 552);
		
		getContentPane().setLayout(null);

		JPanel List = new JPanel();
		List.setBounds(0, 0, 812, 552);
		getContentPane().add(List);
		List.setLayout(null);

		JLabel title = new JLabel("Modules Taken ");
		title.setFont(new Font("Tahoma", Font.PLAIN, 16));
		title.setBounds(0, 30, 200, 30);
		List.add(title);
	
		String[] info = Database.getStudentModules(id).split(":");

		data = new String[info.length][info[0].split(" ").length];
		for (int c= 0; c < info.length; c++) {
			String[] b = info[c].split(" ");
			for (int a = 0; a < b.length; a++) {
				if (b[a].equals("null")) {
					data[c][a] = "N/A";
				} else {
					data[c][a] = b[a]; 
					System.out.println(data[c][a]);
				}
			}	
		}
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(0, 60, 812, 552);
		
		JTable modules = new JTable(data, columnNames);
		modules.setBounds(0, 0, 812, 552);	
		
		scroll.setViewportView(modules);

		List.add(scroll);
		
		setVisible(true);

	}

}
