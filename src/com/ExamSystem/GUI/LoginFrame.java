package com.ExamSystem.GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * 	登陆界面
 * 	1. 登陆按钮添加事件监听
 * 		-> 触发的是ClientContext的登陆方法
 * @author HuangHeng
 *
 */
public class LoginFrame extends JFrame{
	private ClientContext clientContext;
	
	//输入框属性值：学号、密码
	private JTextField snField;
	private JPasswordField psField;
	
	//错误信息提示
	private JLabel wrongMessage;
	
	public LoginFrame() {
		init();
	}
	
	public void init() {
		setTitle("登陆考试系统");
		
		JPanel bgPanel = bgPanel();
		JPanel ntPanel = ntPanel();
		JPanel ctPanel = ctPanel();
		JPanel btPanel = btPanel();
		
		bgPanel.add(ntPanel, BorderLayout.NORTH);
		bgPanel.add(ctPanel, BorderLayout.CENTER);
		bgPanel.add(btPanel, BorderLayout.SOUTH);
		
		add(bgPanel);
		setSize(600, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int option = JOptionPane.showConfirmDialog(bgPanel, "确认关闭系统吗？");
				if(option == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
			
		});
//		setVisible(true);
	}
	
	/**
	 * 背景panel backgroundPanel
	 * 布局模式：东西南北中
	 * @return bgPanel
	 */
	public JPanel bgPanel() {
		JPanel bgPanel = new JPanel();
		bgPanel.setLayout(new BorderLayout());
		
		return bgPanel;
	}
	
	/**
	 * 北panel northPanel
	 * 布局模式：flow
	 * 存标题
	 * @return ntPanel
	 */
	public JPanel ntPanel() {
		JPanel ntPanel = new JPanel();
		
		//字体：标题
		Font titleFont = new Font("微软雅黑",1, 26);
		
		JLabel title = new JLabel("登陆考试系统");
		title.setFont(titleFont);
		ntPanel.add(title);
		return ntPanel;
	}
	
	/**
	 * 中panel centerPanel
	 * 布局模式：null
	 * 存用户名、密码以及对应的两个输入框
	 * @return	ctPanel
	 */
	public JPanel ctPanel() {
		JPanel ctPanel = new JPanel();
		ctPanel.setLayout(null);
		
		//字体；用户名、密码
		Font infoFont = new Font("微软雅黑",1, 15);
		
		JLabel schoolNum = new JLabel("学号：");
		JLabel password = new JLabel("密码：");
		snField = new JTextField();
		psField = new JPasswordField();
		wrongMessage = new JLabel();
		
		
		schoolNum.setFont(infoFont);
		password.setFont(infoFont);
		wrongMessage.setFont(infoFont);
		
		
		schoolNum.setSize(50, 100);
		password.setSize(50, 100);
		snField.setSize(400, 30);//大小
		psField.setSize(400, 30);//大小
		wrongMessage.setSize(200,50);
		
		
		schoolNum.setLocation(70, 10);
		password.setLocation(70, 70);
		snField.setLocation(110, 45);//位置
		psField.setLocation(110, 105);//位置
		wrongMessage.setLocation(110, 125);
		
		
		
		ctPanel.add(schoolNum);
		ctPanel.add(snField);
		ctPanel.add(password);
		ctPanel.add(psField);
		ctPanel.add(wrongMessage);
		
		return ctPanel;
	}
	
	/**
	 * 南panel 
	 * 布局格式：默认flow
	 * @return btPanel
	 */ 
	public JPanel btPanel() {
		JPanel btPanel = new JPanel();
		
		JButton login = new JButton("Login");
		JButton cancel = new JButton("Cancel");
		
		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				
				if("Login".equals(command)) {
					clientContext.login();
				}
				
			}
			
		});
		
		btPanel.add(login);
		btPanel.add(cancel);
		
		btPanel.add(login);
		btPanel.add(cancel);
		
		return btPanel;
	}
	
	/**
	 * 展示错误提示
	 * @param wrongMessage
	 */
	public void showWrongMessage(String wrongMessage) {
		this.wrongMessage.setText(wrongMessage);
	}
	
	public ClientContext getClientContext() {
		return clientContext;
	}

	public void setClientContext(ClientContext clientContext) {
		this.clientContext = clientContext;
	}

	public JTextField getSnField() {
		return snField;
	}

	public void setSnField(JTextField snField) {
		this.snField = snField;
	}

	public JPasswordField getPsField() {
		return psField;
	}

	public void setPsField(JPasswordField psField) {
		this.psField = psField;
	}

	public JLabel getWrongMessage() {
		return wrongMessage;
	}

	public void setWrongMessage(JLabel wrongMessage) {
		this.wrongMessage = wrongMessage;
	}
	
	
}


