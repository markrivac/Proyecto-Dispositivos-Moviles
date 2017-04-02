package com.example.davidcabello.proyectomoviles;

/**
 * Created by davidcabello on 26/02/17.
 */

public class QuestionFB {

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getQuestion() {
        return question;
    }

    public String getCategory() {
        return category;
    }

    public String getUserID() {
        return userID;
    }

    public String question;
    public String category;
    public String userID;

    public QuestionFB(){
    }

    public QuestionFB(String question, String category, String userID) {
        this.question = question;
        this.category = category;
        this.userID = userID;
    }

    public String toString(){
        return this.question + " " + this.category + " " + this.userID;
    }



}
