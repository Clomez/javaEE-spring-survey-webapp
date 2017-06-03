package com.clomez.survey.beans;

/**
 * Created by clomez on 28.5.2017.
 */
public class Answer {

    public String name;
    int question_id;
    int answer_group;

    public Answer(String name, int question_id, int answer_group) {
        this.name = name;
        this.question_id = question_id;
        this.answer_group = answer_group;
    }

    public Answer() {
    }

    public String getName() {
        return name;
    }

    public Answer setName(String name) {
        this.name = name;
        return this;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public Answer setQuestion_id(int question_id) {
        this.question_id = question_id;
        return this;
    }

    public int getAnswer_group() {
        return answer_group;
    }

    public Answer setAnswer_group(int answer_group) {
        this.answer_group = answer_group;
        return this;
    }
}
