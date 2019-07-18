package com.ExamSystem.test;

import java.io.IOException;
import java.util.List;

import com.ExamSystem.beams.Question;
import com.ExamSystem.service.Controller;

public class Test02_makePaper {
	public static void main(String[] args) throws IOException {
		List<Question> paper = new Controller().createPaper();
		for(Question q : paper) {
			System.out.println(q);
		}
		
	}
}
