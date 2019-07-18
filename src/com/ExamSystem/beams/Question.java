package com.ExamSystem.beams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 	问题类
 * @author HuangHeng
 *
 */
public class Question {
	private int[] answer;
    private int score;
    private int level;
    private String infoQ;
    private String[] option;

    public Question(int[] answer, int score, int level, String infoQ, String[] option) {
        this.answer = answer;
        this.score = score;
        this.level = level;
        this.infoQ = infoQ;
        this.option = option;
    }

    
    public int[] getAnswer() {
		return answer;
	}

	public void setAnswer(int[] answer) {
		this.answer = answer;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getInfoQ() {
		return infoQ;
	}

	public void setInfoQ(String infoQ) {
		this.infoQ = infoQ;
	}

	public String[] getOption() {
		return option;
	}

	public void setOption(String[] option) {
		this.option = option;
	}

	@Override
    public String toString() {
        return "Question{" +
                "answer=" + Arrays.toString(answer) +
                ", score=" + score +
                ", level=" + level +
                ", infoQ='" + infoQ + '\'' +
                ", option=" + Arrays.toString(option) +
                '}';
    }
}
