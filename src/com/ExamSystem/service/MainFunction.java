package com.ExamSystem.service;


import com.ExamSystem.GUI.ClientContext;
import com.ExamSystem.GUI.ExamFrame;
import com.ExamSystem.GUI.LoginFrame;
import com.ExamSystem.GUI.MenuFrame;
import com.ExamSystem.beams.EntityContext;
	
public class MainFunction {	
	public static void main(String[] args) {
		LoginFrame loginFrame = new LoginFrame();
		MenuFrame menuFrame = new MenuFrame();
		ExamFrame examFrame = new ExamFrame();
		ClientContext clientContext = new ClientContext();
		Controller controller = new Controller();
		EntityContext entityContext = new EntityContext();
		
		
		
		//loginFrame注入clientContext
		loginFrame.setClientContext(clientContext);
		
		//clientContext注入loginFrame、menuFrame、controller、
		clientContext.setLoginFrame(loginFrame);
		clientContext.setMenuFrame(menuFrame);
		clientContext.setExamFrame(examFrame);
		clientContext.setController(controller);
		clientContext.setEntityContext(entityContext);
		
		//controller注入loginFrame、entityContext、examFrame、timer
		controller.setLoginFrame(loginFrame);
		controller.setEntityContext(entityContext);
		controller.setExamFrame(examFrame);
		
		//menuFrame注入clientContext、entityContext
		menuFrame.setClientContext(clientContext);
		menuFrame.setEntityContext(entityContext);
		menuFrame.setController(controller);
		
		//examFrame注入clientContext\controller
		examFrame.setClientContext(clientContext);
		examFrame.setController(controller);
		examFrame.setEntityContext(entityContext);
		
		loginFrame.setVisible(true);
	}
}
