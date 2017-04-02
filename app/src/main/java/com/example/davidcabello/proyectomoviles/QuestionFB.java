package com.example.davidcabello.proyectomoviles;

/**
 * Created by davidcabello on 26/02/17.
 */

public class QuestionFB {

<<<<<<< HEAD
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

=======
>>>>>>> 6e522aa30473121a0190f3a11cbca36fe6878d27
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

<<<<<<< HEAD
    public String toString(){
        return this.question + " " + this.category + " " + this.userID;
    }

=======
>>>>>>> 6e522aa30473121a0190f3a11cbca36fe6878d27

}
