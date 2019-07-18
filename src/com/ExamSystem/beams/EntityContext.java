package com.ExamSystem.beams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 	模拟数据库
 * @author HuangHeng
 *
 */
public class EntityContext {
	private Map<Integer, List<Question>> questions;
	private List<User> users;
	private String rule;
	private Map<Integer, List<Integer>> userAnsRecord = new HashMap<Integer, List<Integer>>();
	
	
	public EntityContext() {
		init();
	}
	
	private void init() {
		try {
			questions = parseQues();
			users = parseUsers();
			rule = parseRule();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//试卷解析:parseQues
     public Map<Integer, List<Question>> parseQues() throws IOException{
    	File file = new File(EntityContext.class.getClassLoader().getResource("com/ExamSystem/util/corejava.txt").getFile());
    	BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(file), "GBK"
                )
        );

        Map<Integer, List<Question>> questions = new HashMap<>();

        String line;

            while((line = br.readLine()) != null) {
                String[] strs = line.split(",");

                //1-1 答案
                int posAnsEq = strs[0].indexOf("=");
                String ansOptionStr = strs[0].substring(posAnsEq + 1);
                int[] answer = null;
                if (ansOptionStr.contains("/")) {
                    String[] SgAnsStr = ansOptionStr.split("/");
                    answer = new int[SgAnsStr.length];
                    for (int k = 0; k < answer.length; k++) {
                        answer[k] = Integer.valueOf(SgAnsStr[k]);
                    }
                } else {
                    answer = new int[1];
                    answer[0] = Integer.valueOf(ansOptionStr);
                }

                //1-2 分数
                int posScoEq = strs[1].indexOf("=");
                String scoStr = strs[1].substring(posScoEq + 1);
                int score = Integer.valueOf(scoStr);

                //1-3 难度

                int posModEq = strs[2].indexOf("=");
                String modStr = strs[2].substring(posModEq + 1);
                int level = Integer.valueOf(modStr);

                //2 题干
                String infoQ = br.readLine();

                //3 选项
                String[] option = {br.readLine(), br.readLine(), br.readLine(), br.readLine()};

                Question sgQus = new Question(answer, score, level, infoQ, option);


                if (questions.get(sgQus.getLevel()) == null) {
                    List<Question> list = new ArrayList<>();
                    list.add(sgQus);
                    questions.put(sgQus.getLevel(), list);
                } else {
                	questions.get(sgQus.getLevel()).add(sgQus);//map中get出来再add 这个Question
                }
            }
            return questions;
    }
	
	//用户解析
    public List<User> parseUsers() throws IOException {
    	File file = new File(EntityContext.class.getClassLoader().getResource("com/ExamSystem/util/user1.txt").getFile());
    	BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(file), "GBK"
                )
        );

        List<User> users = new ArrayList<>();
        String line = null;
        String regex = "[0-9]{4}";
        String regex1= "[\\n\\r\\t]+";

        while((line = br.readLine()) != null){
            if(line.substring(0,4).matches(regex)){
                String[] strs = line.split(":");
                int id = Integer.valueOf(strs[0]);
                String name = strs[1];
                String password = strs[2];
                String type = strs[3];
                String email = strs[4];
                User user = new User(id, name, password, type, email);
                users.add(user);
            }else{
                continue;
            }
        }
        return users;
    }
	
	//考试规则解析
    public String parseRule() throws IOException {
		File file = new File(EntityContext.class.getClassLoader().getResource("com/ExamSystem/util/rule.txt").getFile());
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(file), "GBK"));
		StringBuilder sb = new StringBuilder();
		String line;
		while((line = br.readLine()) != null) {
			sb.append(line);
			sb.append("\n");
		}
		return sb.toString();
	}
	//其他文件内容解析

	public Map<Integer, List<Question>> getQuestions() {
		return questions;
	}

	public void setQuestions(Map<Integer, List<Question>> questions) {
		this.questions = questions;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public Map<Integer, List<Integer>> getUserAnsRecord() {
		return userAnsRecord;
	}

	public void setUserAnsRecord(Map<Integer, List<Integer>> userAnsRecord) {
		this.userAnsRecord = userAnsRecord;
	}

	
	
}
