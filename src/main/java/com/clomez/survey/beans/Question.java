package com.clomez.survey.beans;

/**
 * Created by clomez on 27.5.2017.
 */
public class Question {

    private int id;
    private int Surveyid;
    private String name;

    public Question() {
        this.id = 0;
        Surveyid = 0;
        this.name = "name";
    }

    public Question(int id, int surveyid, String name) {
        this.id = id;
        Surveyid = surveyid;
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public Question setId(int id) {
        this.id = id;
        return this;
    }

    public int getSurveyid() {
        return Surveyid;
    }

    public Question setSurveyid(int surveyid) {
        this.Surveyid = surveyid;
        return this;
    }

    public String getName() {
        return name;
    }

    public Question setName(String name) {
        this.name = name;
        return this;
    }
}

