package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
  ע�����
 */
class SignIn extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	/*
	 * �������ݿ�
	 * Facade fcd=new Facade();
	 */
	JFrame jf;
	JPanel jp;
	JLabel jl,jl2,jl3;
	static JTextField realName,identityID;
	static JPasswordField password;
	JButton jb1,jb2;
	
	public SignIn(){
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public void signIn(){
		/*boolean flagName = 
		 * ��һ��Ҫд realName.getText.matches(name);
		 *	������ʽ�ж��Ƿ�������ȷ��
		 * ���ܴ���������ʽ����
		 */
		String name = "[\\u4e00-\\u9fa5]{2,4}";
		boolean flagName = realName.getText().matches(name);
		String identity = "^\\d{17}([0-9]|X|x)$";
		boolean flagIdentity = this.identityID.getText().matches(identity);
		String pass = "^\\w{6,}$";
		boolean flagPassword = password.getPassword().toString().matches(pass);
		if(flagName == false){
			JOptionPane.showMessageDialog(null, "�û�����д���󣬱���Ϊ2-4λ�ĺ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
		}else if(flagIdentity == false){
			JOptionPane.showMessageDialog(null, "���֤����д���󣬱���Ϊ18λ�����ֻ���ĸ","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
		}else if(flagPassword == false){
			JOptionPane.showMessageDialog(null, "������д���󣬱���Ϊ6λ���ϵ���ĸ������","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
		}else{
			/*
			 * ����ע�᷽�����ȼ��ע���û��Ƿ����
			 * ����û����ڣ����������Ϊ"";
			 */
		}
		
	}
	
	
}
