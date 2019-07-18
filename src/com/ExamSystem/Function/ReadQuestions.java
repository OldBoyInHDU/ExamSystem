package com.ExamSystem.Function;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ExamSystem.beams.Question;

public class ReadQuestions {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("E:\\[JavaPractice]\\Zhizhen\\ExamSystem\\corejava.txt"), "GBK"
                )
        );

        Map<Integer, List<Question>> map = new HashMap<>();

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


                if (map.get(sgQus.getLevel()) == null) {
                    List<Question> list = new ArrayList<>();
                    list.add(sgQus);
                    map.put(sgQus.getLevel(), list);
                } else {
                    map.get(sgQus.getLevel()).add(sgQus);//map中get出来再add 这个Question
                }
            }

        for(Question q : map.get(3)){
            System.out.println(q);
        }


    }
}
