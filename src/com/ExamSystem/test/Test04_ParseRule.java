package com.ExamSystem.test;

import java.io.IOException;

import com.ExamSystem.beams.EntityContext;

public class Test04_ParseRule {
	public static void main(String[] args) {
		try {
			new EntityContext().parseRule();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
