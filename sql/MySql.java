package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

class MySql {
	ResultSet rs = null;
	Statement stm = null;
	PreparedStatement pst = null;
	Connection conn= null;
	String username;
	String password;
	private MySql(){
		
	}
	private static final MySql ms = new MySql();
	public static MySql getInstance(){
		return ms;
	}
	public void connectSql(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn =
					DriverManager.getConnection("jdbc:mysql://localhost/test?useSSL=false","root","000123");
			System.out.println("Suscessfully connecting! ");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	public void veritySignin(String identityID,String password){
		try {
			String sql = "insert * from system where realName = ? and password = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, identityID);
			pst.setString(1, password);
			rs = pst.executeQuery();
			if(rs.next()){
				JOptionPane.showMessageDialog(null, "��¼�ɹ�!","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
				System.out.println("�ɹ���ȡ�û���Ϣ");
				System.out.println("identityID : " + identityID + "password : " + password);
			}else{
				JOptionPane.showMessageDialog(null, "���֤�Ż������������,����������","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void PassengerSignin(String realName,String identityID,String password){
		try {
			String sql = "select into system values(null,?,?,?,?,null)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, realName);
			pst.setString(2, identityID);
			pst.setString(3, password);
			int i = pst.executeUpdate();
			if(i == 1){
				JOptionPane.showMessageDialog(null, "ע��ɹ�","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null, "ע��ʧ��","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void veritySignup(String identityID){
		try {
			String sql = "select * from system where identityID = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, identityID);
			rs = pst.executeQuery();
			if(rs.next()){
				JOptionPane.showMessageDialog(null, "���û����Ѿ�����","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
			}else{
				/*
				 * ����Ҫ��UI����ע�������û���������ȸ���ˢ������Ϊ�㣬ex: settext("");
				 */
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
