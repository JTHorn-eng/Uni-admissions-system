import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.JToolBar;

public class TestApplicationWindow {

	private JFrame frmLogin;
	private JTextField name;
	private JTextField code;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestApplicationWindow window = new TestApplicationWindow();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestApplicationWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("University Project");
		frmLogin.setBounds(100, 100, 1024, 768);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JScrollPane viewerScroll = new JScrollPane();
		viewerScroll.setBounds(398, 58, 600, 404);
		frmLogin.getContentPane().add(viewerScroll);
		
		JPanel viewer = new JPanel();
		viewerScroll.setViewportView(viewer);
		viewer.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel logged = new JLabel("Logged in as");
		logged.setFont(new Font("Tahoma", Font.PLAIN, 12));
		logged.setBounds(10, 11, 137, 21);
		frmLogin.getContentPane().add(logged);
		
		JPanel info = new JPanel();
		info.setBounds(10, 34, 378, 43);
		frmLogin.getContentPane().add(info);
		info.setLayout(null);
		
		JButton logout = new JButton("Logout");
		logout.setBounds(182, 11, 89, 23);
		info.add(logout);
		
		JLabel nameTemp = new JLabel("Mr Example Username");
		nameTemp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nameTemp.setBounds(10, 11, 168, 19);
		info.add(nameTemp);
		
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		exit.setBounds(281, 11, 89, 23);
		info.add(exit);
		
		JPanel viewing = new JPanel();
		viewing.setBounds(10, 88, 378, 129);
		frmLogin.getContentPane().add(viewing);
		viewing.setLayout(null);
		
		name = new JTextField();
		name.setToolTipText("Type here");
		name.setBounds(10, 35, 270, 28);
		viewing.add(name);
		name.setColumns(10);
		
		JButton searchBut = new JButton("Add");
		searchBut.setIcon(new ImageIcon(TestApplicationWindow.class.getResource("/javax/swing/plaf/metal/icons/ocean/hardDrive.gif")));
		searchBut.setBounds(283, 36, 85, 23);
		viewing.add(searchBut);
		
		JLabel records = new JLabel("Add New Department");
		records.setFont(new Font("Tahoma", Font.PLAIN, 12));
		records.setBounds(10, 11, 170, 23);
		viewing.add(records);
		
		code = new JTextField();
		code.setToolTipText("Type here");
		code.setColumns(10);
		code.setBounds(10, 74, 270, 28);
		viewing.add(code);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(398, 22, 600, 25);
		frmLogin.getContentPane().add(toolBar);
		
		JButton student = new JButton("Student");
		toolBar.add(student);
		
		JButton degree = new JButton("Degree");
		toolBar.add(degree);
		
		JButton department = new JButton("Department");
		toolBar.add(department);
		
		JPanel genInfo = new JPanel();
		genInfo.setBounds(398, 472, 600, 246);
		frmLogin.getContentPane().add(genInfo);
		genInfo.setLayout(null);
		
		JLabel Select = new JLabel("Information");
		Select.setBounds(10, 11, 111, 25);
		genInfo.add(Select);
	}
}
