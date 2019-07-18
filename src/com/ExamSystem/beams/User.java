package com.ExamSystem.beams;

import java.util.Objects;

public class User {
	private int id;
    private String name;
    private String password;
    private String type;
    private String email;

    public User(int id, String name,String password, String type, String email){
        this.id = id;
        this.name = name;
        this.password = password;
        this.type = type;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                name.equals(user.name) &&
                password.equals(user.password) &&
                type.equals(user.type) &&
                email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password, type, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
