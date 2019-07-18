package com.ExamSystem.Function;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.ExamSystem.beams.User;

public class ReadUsers {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("E:\\[JavaPractice]\\Zhizhen\\ExamSystem\\user1.txt"), "GBK"
                )
        );

//        String testLine = br.readLine();
//        System.out.println(testLine);

        List<User> users = new ArrayList<>();
        String line = null;
        String regex = "[0-9]{4}";
        String regex1= "[\\n\\r\\t]+";

        while((line = br.readLine()) != null){
//            System.out.println(line);

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


        for(User u : users){
            System.out.println(u);
        }
    }
}
