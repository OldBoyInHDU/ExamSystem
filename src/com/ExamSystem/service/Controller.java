package com.ExamSystem.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.ExamSystem.GUI.ExamFrame;
import com.ExamSystem.GUI.LoginFrame;
import com.ExamSystem.beams.EntityContext;
import com.ExamSystem.beams.Question;
import com.ExamSystem.beams.User;

public class Controller {
	private List<Question> paper;
	private EntityContext entityContext;
	private LoginFrame loginFrame;
	private ExamFrame examFrame;
	private int count = 0;
	private int grades = 0;
	private Thread timer;
	
	public Controller() {
		paper = new ArrayList<Question>();
		timer = creTimer();
	}
	
	public Thread creTimer() {
		timer = new Thread(new Runnable() {
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
						
						examFrame.showTime(hh, mm, ss);
						
//						System.out.println(hh + ":" + mm + ":" + ss);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		});
		
		return timer;
	}
	
	/**
	 * 登陆操作
	 * @return 
	 */
	public User login() throws IdOrPwdException {
//		boolean isCorrect = false;
		int id = Integer.parseInt(loginFrame.getSnField().getText()) ;
		String password =new String( loginFrame.getPsField().getPassword());
//		User user = entityContext.getUsers().get(id);
		User user = null;
		for(int i = 0; i < entityContext.getUsers().size(); i++) {
			if((id) == entityContext.getUsers().get(i).getId()) {
				user = entityContext.getUsers().get(i);
			} 
		}
		if(user == null) {
			throw new IdOrPwdException("用户名错误！");
		} else if(!user.getPassword().equals(password)) {
			throw new IdOrPwdException("密码错误！");
		} else {
			return user;
		}
		/*for(int i = 0; i < entityContext.getUsers().size(); i++) {
			if((id) == entityContext.getUsers().get(i).getId()
					&& new String(password).equals(entityContext.getUsers().get(i).getPassword())) {
				isCorrect = true;
			}
		}*/
		/*return isCorrect;*/
	}
	
	/**
	 * 生成试卷
	 * @return
	 * @throws IOException
	 */
	public List<Question> createPaper() throws IOException{
		Map<Integer, List<Question>> totalQues = new EntityContext().parseQues();
		for(int i = 1; i <= 10; i++) {
			List<Question> sgModeQues = totalQues.get(i);
			int quesNum = sgModeQues.size();
			int[] indexs = crRanNum(quesNum);
			paper.add(sgModeQues.get(indexs[0]));
			paper.add(sgModeQues.get(indexs[1]));
		}
		return paper;
	}
	
	//随机生成2个随机数
	private int[] crRanNum(int quesNum) {
		int[] indexs = new int[2];
		int index1 = (int)(Math.random()*quesNum);
		int index2 = index1;
		while(true) {
			index2 = (int)(Math.random()*quesNum);
			if(index2 != index1) {
				break;
			}
		}
		indexs[0] = index1;
		indexs[1] = index2;
		
		return indexs;
	}

	
	

	
	/**
	 * 上一题
	 */
	public void formerQuesArea() {
		if(count > 0) {
			count--;
			examFrame.formerQuesArea(paper.get(count).getInfoQ(), paper.get(count).getOption(), count);
		}
	}
	
	/**
	 * 下一题
	 */
	public void nextQuesArea() {
		if(count < 19 && checkAnswer()) {
			grades += 5;
			System.out.println("已得分数：" + grades);
		}else {
			System.out.println("已得分数：" + grades);
		}
		System.out.println(entityContext.getUserAnsRecord());
		
		if(count < 19) {
			count++;
			examFrame.nextQuesArea(paper.get(count).getInfoQ(), paper.get(count).getOption(), count);
		}else if(count == 19){
			
		}
	}
	
	/**
	 * 	获得和检查答案，计算分数
	 */
	public boolean checkAnswer() {
//		Integer[] userAns = examFrame.getUserAns().toArray(new Integer[0]);
		Integer[] userAns = entityContext.getUserAnsRecord().get(count).toArray(new Integer[0]);
		System.out.println("用户答案"+Arrays.toString(userAns));
		
		int[] answer = paper.get(count).getAnswer();
		System.out.println("标准答案"+Arrays.toString(answer));
		
		int[] userAnsInt = new int[userAns.length];
		for(int i = 0; i < userAnsInt.length; i++) {
			userAnsInt[i] = userAns[i];
		}
		System.out.println("用户答案"+Arrays.toString(userAnsInt));
		
		Arrays.sort(answer);
		Arrays.sort(userAnsInt);
		return Arrays.equals(answer, userAnsInt);
		
		
		
		
	}
	
	
	/**
	 * 交卷
	 */
	
	
	/**
	 * 获得登陆的用户对象
	 * @return
	 */
	public User getUser(String sn) {
		int id = Integer.parseInt(sn);
		for(int i = 0; i < entityContext.getUsers().size(); i++) {
			if(id == (entityContext.getUsers().get(i).getId())) {
				return entityContext.getUsers().get(i);
			}
		}
		return null;
	}
	
	/**
	 * 倒计时操作
	 * @return
	 */
	public void startTimeCount() {
		timer.start();
//		new Controller().timer.start();
	}
	
	
	
	//----
	public List<Question> getPaper() {
		return paper;
	}

	public void setPaper(List<Question> paper) {
		this.paper = paper;
	}

	public EntityContext getEntityContext() {
		return entityContext;
	}

	public void setEntityContext(EntityContext entityContext) {
		this.entityContext = entityContext;
	}

	public LoginFrame getLoginFrame() {
		return loginFrame;
	}

	public void setLoginFrame(LoginFrame loginFrame) {
		this.loginFrame = loginFrame;
	}

	public ExamFrame getExamFrame() {
		return examFrame;
	}

	public void setExamFrame(ExamFrame examFrame) {
		this.examFrame = examFrame;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getGrades() {
		return grades;
	}

	public void setGrades(int grades) {
		this.grades = grades;
	}

	public Thread getTimer() {
		return timer;
	}

	public void setTimer(Thread timer) {
		this.timer = timer;
	}

	
	
}
