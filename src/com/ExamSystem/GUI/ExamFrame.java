package com.ExamSystem.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.ExamSystem.beams.EntityContext;
import com.ExamSystem.service.Controller;

public class ExamFrame extends JFrame{
	private ClientContext clientContext;
	private Controller controller;
	private EntityContext entityContext;
	
	//可变的属性：
	private JLabel nameLB;
	private JLabel idLB;
	private JLabel timeLB;
	private JLabel subLB;
	private JLabel numLB;
	private JTextArea quesArea;
	private JCheckBox optionA;//按钮
	private JCheckBox optionB;
	private JCheckBox optionC;
	private JCheckBox optionD;
	private JCheckBox oA;//按钮点击后返回的
	private JCheckBox oB;
	private JCheckBox oC;
	private JCheckBox oD;
	private JLabel lbNum; 
//	private List<Integer> userAns = new ArrayList<Integer>();
	
	
	
	private JLabel lbTime;//倒计时
//	private Thread timer;
	
	

	public ExamFrame() {
		init();
		/*timer = new Thread(new Runnable() {
			long time = 60*60;
			
			
			@Override
			public void run() {
				while(true) { 
					time --;
					try {
						Thread.sleep(1000);
						long hh = time / 60 / 60 % 60;
						long mm = time / 60 % 60;
						long ss = time % 60;
						
						showTime(hh, mm, ss);
						
//						System.out.println(hh + ":" + mm + ":" + ss);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		});*/
	}
	
	
	
	public void init() {
		setTitle("小黄信息在线评测");
		
		JPanel bgPanel = bgPanel();
		JPanel ntPanel = ntPanel();
		JPanel btPanel = btPanel();
		
		bgPanel.add(ntPanel, BorderLayout.NORTH);
		bgPanel.add(btPanel, BorderLayout.CENTER);
		this.add(bgPanel);
		setSize(1200, 760);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setVisible(true);
	}
	
	/**
	 * 	背景panel:backgroundPanel
	 *	布局模式：东西南北中
	 * @return	bgPanel 背景Panel
	 */
	public JPanel bgPanel() {
		JPanel btPanel = new JPanel();
		btPanel.setLayout(new BorderLayout());//给底层panel设置布局格式
		return btPanel;
	}
	
	/**
	 * 	North区域panel：northPanel
	 * 	布局模式：flow布局
	 * 	用来存标题
	 * @return	ntPanel 北Panel
	 */
	public JPanel ntPanel() {
		JPanel ntPanel = new JPanel();
		
		//标题字体
		Font titleFont = new Font("微软雅黑", 1, 42);
		
		JLabel title = new JLabel("小黄信息在线测评系统Beta");
		title.setFont(titleFont);
		
		ntPanel.add(title);
		return ntPanel;
	}
	
	/**
	 * center和south区域的底部bottomPanel
	 * 布局模式：null 自定义
	 * @return btPanel 底部panel
	 */
	public JPanel btPanel() {
		JPanel btPanel = new JPanel();
		btPanel.setLayout(null);
		
		//字体:姓名、学号、考试时间、考试科目、题目数量、选项、题目数量、剩余时间、题目信息和选项
		Font bsInfoFont = new Font("微软雅黑", 1, 20);
		
		//1 - 文本标签：基本信息 basicInfo
		nameLB = new JLabel("姓名:");
		idLB = new JLabel("学号:");
		timeLB = new JLabel("考试时间:");
		subLB = new JLabel("考试科目:");
		numLB = new JLabel("题目数量:");
		
		nameLB.setFont(bsInfoFont);
		idLB.setFont(bsInfoFont);
		timeLB.setFont(bsInfoFont);
		subLB.setFont(bsInfoFont);
		numLB.setFont(bsInfoFont);
		
		nameLB.setSize(150, 40);
		idLB.setSize(150, 40);
		timeLB.setSize(300, 40);
		subLB.setSize(400, 40);
		numLB.setSize(150, 40);
		
		nameLB.setLocation(100, 60);
		idLB.setLocation(300, 60);
		timeLB.setLocation(500, 60);
		subLB.setLocation(700, 60);
		numLB.setLocation(950, 60);
		
		btPanel.add(nameLB);
		btPanel.add(idLB);
		btPanel.add(timeLB);
		btPanel.add(subLB);
		btPanel.add(numLB);
		
		//2 - 题目文本域
		quesArea = new JTextArea();
		//设置字体：
		quesArea.setFont(bsInfoFont);
		//设置换行
		quesArea.setLineWrap(true);
		quesArea.setSize(1000,400);
		quesArea.setLocation(88,100);
		btPanel.add(quesArea);
		
		//下部-3： 选项 - 设置监听
		optionA = new JCheckBox("A");
		optionB = new JCheckBox("B");
		optionC = new JCheckBox("C");
		optionD = new JCheckBox("D");
				
		optionA.setFont(bsInfoFont);
		optionB.setFont(bsInfoFont);
		optionC.setFont(bsInfoFont);
		optionD.setFont(bsInfoFont);
		
		optionA.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/*JCheckBox oA = (JCheckBox) e.getSource();
				if(oA.isSelected()) {
					userAns.add(0);
				}else {
					Integer a = 0;
					userAns.remove(a);
				}*/
				oA = (JCheckBox) e.getSource();
			}
			
		});
		
		optionB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/*JCheckBox oB = (JCheckBox) e.getSource();
				if(oB.isSelected()) {
					userAns.add(1);
				}else {
					Integer b = 1;
					userAns.remove(b);
				}*/
				oB = (JCheckBox) e.getSource();
			}
			
		});
		
		optionC.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/*JCheckBox oC = (JCheckBox) e.getSource();
				if(oC.isSelected()) {
					userAns.add(2);
				}else {
					Integer c = 2;
					userAns.remove(c);
				}*/
				oC = (JCheckBox) e.getSource();
			}
			
		});
		
		optionD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/*JCheckBox oD = (JCheckBox) e.getSource();
				if(oD.isSelected()) {
					userAns.add(3);
				}else {
					Integer d = 3;
					userAns.remove(3);
				}*/
				oD = (JCheckBox) e.getSource();
			}
			
		});
		
		optionA.setSize(50, 40);
		optionB.setSize(50, 40);
		optionC.setSize(50, 40);
		optionD.setSize(50, 40);
				
		optionA.setLocation(430, 500);
		optionB.setLocation(530, 500);
		optionC.setLocation(630, 500);
		optionD.setLocation(730, 500);
				
		btPanel.add(optionA);
		btPanel.add(optionB);
		btPanel.add(optionC);
		btPanel.add(optionD);	
		
		//上一题、下一题、交卷
		//字体：上一题、下一题、交卷 button
		Font btClickFont = new Font("微软雅黑", 1, 30);//上一题等一行的字体
		
		JButton former = new JButton("上一题");
		JButton next = new JButton("下一题");
		JButton submit = new JButton("交卷");
				
		former.setFont(btClickFont);
		next.setFont(btClickFont);
		submit.setFont(btClickFont);
		
		//上一题
		former.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.formerQuesArea();
				resetAns();
				recordAns();
			}
			
		});
		
		//下一题
		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				recordAns();
				clientContext.nextQuesArea();
				resetAns();
//				List<Integer> tempUserAns = userAns;
//				entityContext.getUserAnsRecord().put(controller.getCount(), tempUserAns);
//				userAns.clear();
				if(entityContext.getUserAnsRecord().get(controller.getCount()) == null) {
					
					optionA.setSelected(false);
					optionB.setSelected(false);
					optionC.setSelected(false);
					optionD.setSelected(false);
				}
			}
			
		});
		
		//交卷
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clientContext.submit();
				//线程重置
//				timer.destroy();
			}
		});
				
		former.setSize(150, 40);
		next.setSize(150, 40);
		submit.setSize(150, 40);
				
		former.setLocation(346, 550);
		next.setLocation(521, 550);
		submit.setLocation(696, 550);
				
		btPanel.add(former);
		btPanel.add(next);
		btPanel.add(submit);
		
		//底部：题目数量
		lbNum = new JLabel("题目： 20 中的第 1 题");
		lbNum.setFont(bsInfoFont);
				
		lbNum.setSize(300, 40);
		lbNum.setLocation(100, 550);
		btPanel.add(lbNum);
				
		//底部：剩余时间（另外线程）
		lbTime = new JLabel("剩余时间：01:00:00");
		lbTime.setFont(bsInfoFont);
				
				
		lbTime.setSize(300, 40);
		lbTime.setLocation(900, 550);
		btPanel.add(lbTime);
		
		return btPanel;
	}
	
	//记录答案
	public void recordAns() {
		List<Integer> recordedAns = new ArrayList<Integer>();
		if(optionA.isSelected()) {
			recordedAns.add(0);
		}
		if(optionB.isSelected()) {
			recordedAns.add(1);
		}
		if(optionC.isSelected()) {
			recordedAns.add(2);
		}
		if(optionD.isSelected()) {
			recordedAns.add(3);
		}
		entityContext.getUserAnsRecord().put(controller.getCount(), recordedAns);
	}
	
	
	//选项复位
	public void resetAns() {
		Map<Integer, List<Integer>> userAnsRecord = entityContext.getUserAnsRecord();
		List<Integer> historyAns = userAnsRecord.get(controller.getCount());
		Integer a = new Integer(0);
		Integer b = new Integer(1);
		Integer c = new Integer(2);
		Integer d = new Integer(3);
		if(historyAns != null) {
			for(int i = 0; i < historyAns.size(); i++) {
				if(historyAns.contains(a)) {
					optionA.setSelected(true);
				}else {
					optionA.setSelected(false);
				}
				
				if(historyAns.contains(b)) {
					optionB.setSelected(true);
				}else {
					optionB.setSelected(false);
				}
				
				if(historyAns.contains(c)) {
					optionC.setSelected(true);
				}else {
					optionC.setSelected(false);
				}
				
				if(historyAns.contains(d)) {
					optionD.setSelected(true);
				}else {
					optionD.setSelected(false);
				}
			}
		}
	}



	//展示倒计时的方法
	public void showTime(long hour, long minute, long second) {
		String currentTime = "剩余时间:" + hour + ":" + minute + ":" + second;
		if(hour == 0 && minute < 15) {
			lbTime.setForeground(Color.RED);
		}
		lbTime.setText(currentTime);
	}
	
	public void updateView(String name, int id, String infoQ, String[] option) {
		
		nameLB.setText("姓名:" + name);
		idLB.setText("学号:" + String.valueOf(id));
		timeLB.setText("考试时间：1小时");
		subLB.setText("考试科目：阶段测试");
		numLB.setText("题目数量：20");
		quesArea.setText(infoQ + "\n" + "A:" + option[0] + "\n"  + "B:" + option[1] + "\n"  + "C:" + option[2] + "\n"  + "D:" + option[3]);
		
	}

	public void nextQuesArea(String infoQ, String[] option, int count) {
		quesArea.setText(infoQ + "\n" + "A:" + option[0] + "\n"  + "B:" + option[1] + "\n"  + "C:" + option[2] + "\n"  + "D:" + option[3]);
		lbNum.setText("题目： 20 中的第 " + (++count) +" 题");
	}

	public void formerQuesArea(String infoQ, String[] option, int count) {
		resetAns();
		quesArea.setText(infoQ + "\n" + "A:" + option[0] + "\n"  + "B:" + option[1] + "\n"  + "C:" + option[2] + "\n"  + "D:" + option[3]);
		lbNum.setText("题目： 20 中的第 " + (++count) +" 题");
	}

	public ClientContext getClientContext() {
		return clientContext;
	}



	public void setClientContext(ClientContext clientContext) {
		this.clientContext = clientContext;
	}



	public JLabel getNameLB() {
		return nameLB;
	}



	public void setNameLB(JLabel nameLB) {
		this.nameLB = nameLB;
	}



	public JLabel getIdLB() {
		return idLB;
	}



	public void setIdLB(JLabel idLB) {
		this.idLB = idLB;
	}



	public JLabel getTimeLB() {
		return timeLB;
	}



	public void setTimeLB(JLabel timeLB) {
		this.timeLB = timeLB;
	}



	public JLabel getSubLB() {
		return subLB;
	}



	public void setSubLB(JLabel subLB) {
		this.subLB = subLB;
	}



	public JLabel getNumLB() {
		return numLB;
	}



	public void setNumLB(JLabel numLB) {
		this.numLB = numLB;
	}



	public JTextArea getQuesArea() {
		return quesArea;
	}



	public void setQuesArea(JTextArea quesArea) {
		this.quesArea = quesArea;
	}



	public JLabel getLbNum() {
		return lbNum;
	}



	public void setLbNum(JLabel lbNum) {
		this.lbNum = lbNum;
	}



	public JCheckBox getOptionA() {
		return optionA;
	}



	public void setOptionA(JCheckBox optionA) {
		this.optionA = optionA;
	}



	public JCheckBox getOptionB() {
		return optionB;
	}



	public void setOptionB(JCheckBox optionB) {
		this.optionB = optionB;
	}



	public JCheckBox getOptionC() {
		return optionC;
	}



	public void setOptionC(JCheckBox optionC) {
		this.optionC = optionC;
	}



	public JCheckBox getOptionD() {
		return optionD;
	}



	public void setOptionD(JCheckBox optionD) {
		this.optionD = optionD;
	}



	



	public Controller getController() {
		return controller;
	}



	public void setController(Controller controller) {
		this.controller = controller;
	}







	/*public Thread getTimer() {
		return timer;
	}



	public void setTimer(Thread timer) {
		this.timer = timer;
	}*/



//	public List<Integer> getUserAns() {
//		return userAns;
//	}
//
//
//
//	public void setUserAns(List<Integer> userAns) {
//		this.userAns = userAns;
//	}


	public JLabel getLbTime() {
		return lbTime;
	}



	public void setLbTime(JLabel lbTime) {
		this.lbTime = lbTime;
	}



	public EntityContext getEntityContext() {
		return entityContext;
	}



	public void setEntityContext(EntityContext entityContext) {
		this.entityContext = entityContext;
	}

	
}
