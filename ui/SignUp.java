package ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SignUp extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	JLabel name = new JLabel("用户名:");
	JLabel password = new JLabel("     密码:");
	JButton exit = new JButton("返回");
	JButton done = new JButton("注册");
	JTextField jname = new JTextField(15);
	JPasswordField jpassword = new JPasswordField(15);
	public SignUp(){
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(3, 2));
		name.setHorizontalAlignment(SwingConstants.RIGHT);
		password.setHorizontalAlignment(SwingConstants.RIGHT);
		jp.add(name);
		jp.add(jname);
		jp.add(password);
		jp.add(jpassword);
		jp.add(done);
		jp.add(exit);
		
		this.add(jp,BorderLayout.CENTER);
		
		
		this.add(jp);
		this.setTitle("注册系统");
		this.setBounds(600, 540, 300, 120);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		
	}
	public static void main(String[] args) {
		SignUp su = new SignUp();
	}
}
