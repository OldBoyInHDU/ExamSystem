package com.ExamSystem.GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.ExamSystem.beams.EntityContext;
import com.ExamSystem.service.Controller;

public class MenuFrame extends JFrame{
	private ClientContext clientContext;
	private EntityContext entityContext;
	private Controller controller;
	
	public MenuFrame() {
		init();
	}
		
	public void init() {
		setTitle("小黄在线评测系统");
		
		JPanel bgPanel = bgPanel();
		JPanel ntPanel = ntPanel();
		JPanel ctPanel = ctPanel();
		JPanel btPanel = btPanel();
		
		bgPanel.add(ntPanel, BorderLayout.NORTH);
		bgPanel.add(ctPanel, BorderLayout.CENTER);
		bgPanel.add(btPanel, BorderLayout.SOUTH);
		
		add(bgPanel);
		setSize(800, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		Font titleFont = new Font("微软雅黑",1, 42);
		
		JLabel title = new JLabel("小黄信息在线测评系统Beta");
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
		//字体
		Font buttonFont = new Font("微软雅黑", 1, 32);
		
		/*JButton start = new JButton("开始考试");
		JButton check = new JButton("查看分数");
		JButton rule = new JButton("考试规则");
		JButton quit = new JButton("离开系统");*/
		
		JButton start = createButton("exam.png", "开始考试");
		JButton check = createButton("result.png", "查看分数");
		JButton rule = createButton("message.png", "考试规则");
		JButton quit = createButton("exit.png", "离开系统");
		
		/*JButton start = new JButton("开始考试");
		JButton check = new JButton("查看分数");
		JButton rule = new JButton("考试规则");
		JButton quit = new JButton("离开系统");*/
		
		start.setFont(buttonFont);
		check.setFont(buttonFont);
		rule.setFont(buttonFont);
		quit.setFont(buttonFont);
		
		//查看分数
		check.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(ctPanel, "测试成绩为：" +controller.getGrades());
			}
		});
		
		//离开系统
		quit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(ctPanel, "确定退出系统？");
				if(option == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
			
		});
		
		//考试规则弹窗
		rule.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane option = new JOptionPane();
				JOptionPane.showMessageDialog(ctPanel, entityContext.getRule());
			}
			
		});
		
		//开始考试
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.startExam();
			}
		});
		
		ctPanel.add(start);
		ctPanel.add(check);
		ctPanel.add(rule);
		ctPanel.add(quit);
		
		return ctPanel;
	}
	
	public JPanel btPanel() {
		JPanel btPanel = new JPanel();
		//字体:tips
		Font tipsFont = new Font("微软雅黑", 1, 25);
		
		JLabel tips = new JLabel("小黄制作，欢迎转载！");
		tips.setFont(tipsFont);
		btPanel.add(tips);
		
		return btPanel;
	}
	
	private JButton createButton(String img, String txt) {
		ImageIcon ico = new ImageIcon(this.getClass().getResource(img));
		JButton button = new JButton(txt, ico);
		
		button.setHorizontalTextPosition(JButton.CENTER);//水平位置
		button.setVerticalTextPosition(JButton.BOTTOM);
		
		return button;
	}

	public ClientContext getClientContext() {
		return clientContext;
	}

	public void setClientContext(ClientContext clientContext) {
		this.clientContext = clientContext;
	}

	public EntityContext getEntityContext() {
		return entityContext;
	}

	public void setEntityContext(EntityContext entityContext) {
		this.entityContext = entityContext;
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	
}
