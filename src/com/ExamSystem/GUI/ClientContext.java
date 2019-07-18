package com.ExamSystem.GUI;

import java.io.IOException;
import java.util.List;

import com.ExamSystem.beams.EntityContext;
import com.ExamSystem.beams.Question;
import com.ExamSystem.beams.User;
import com.ExamSystem.service.Controller;
import com.ExamSystem.service.IdOrPwdException;

/**
 * 	控制界面的切换
 * @author HuangHeng
 *
 */
public class ClientContext {
	private LoginFrame loginFrame;
	private MenuFrame menuFrame;
	private ExamFrame examFrame;
	private Controller controller;
	private EntityContext entityContext;
	private List<Question> paper;
	private int count = 0;//题号

	//包含所有的界面
	
	/**
	 * 	2. 登陆要使用 用户名 和 密码，从LoginFrame获得
	 * 		a. 传参
	 * 		b. 通过LoginFrame对象，调用getUser()..等get方法
	 * 	3. 登陆成功，界面要切换 MenuFrame.setVisible(true)
	 * 	4. 附加：调用Controller中的Login方法，将用户名和密码与数据库中的用户名密码进行对比
	 */
	//ClientContext中的login()只有切换的作用，真正判断用户名和密码是否匹配是在Controller中的login()方法
	public void login() {
		
		try {
			User user = controller.login();
			
			if(user != null) {
				loginFrame.setVisible(false);
				menuFrame.setVisible(true);
				
			}
		} catch(IdOrPwdException e) {
			loginFrame.showWrongMessage("提示："+e.getMessage());
		} catch(NumberFormatException e) {
			loginFrame.showWrongMessage("提示：用户不合法！");
		}
		
		/*if(isCorrect) {
		}*/
	}
	
	//开始考试
	public void startExam() {
		menuFrame.setVisible(false);
		User user = controller.getUser(loginFrame.getSnField().getText());
		try {
			paper = controller.createPaper();
			examFrame.updateView(user.getName(), user.getId(),paper.get(count).getInfoQ(), paper.get(count).getOption());
		} catch (IOException e) {
			e.printStackTrace();
		}
		controller.startTimeCount();
		examFrame.setVisible(true);
	}
	
	//交卷
	public void submit() {
		examFrame.setVisible(false);
		menuFrame.setVisible(true);
		
	}
	
	//下一题
	public void nextQuesArea() {
		controller.checkAnswer();
		controller.nextQuesArea();
	}

	//上一题
	public void formerQuesArea() {
		controller.formerQuesArea();
	}

	public LoginFrame getLoginFrame() {
		return loginFrame;
	}
	
	
	public void setLoginFrame(LoginFrame loginFrame) {
		this.loginFrame = loginFrame;
	}

	public MenuFrame getMenuFrame() {
		return menuFrame;
	}

	public void setMenuFrame(MenuFrame menuFrame) {
		this.menuFrame = menuFrame;
	}

	public ExamFrame getExamFrame() {
		return examFrame;
	}

	public void setExamFrame(ExamFrame examFrame) {
		this.examFrame = examFrame;
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public EntityContext getEntityContext() {
		return entityContext;
	}

	public void setEntityContext(EntityContext entityContext) {
		this.entityContext = entityContext;
	}

	public List<Question> getPaper() {
		return paper;
	}

	public void setPaper(List<Question> paper) {
		this.paper = paper;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}



	
	
	
	
}
