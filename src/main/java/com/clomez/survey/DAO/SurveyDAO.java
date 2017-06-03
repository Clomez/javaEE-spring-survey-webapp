package com.clomez.survey.DAO;

import com.clomez.survey.beans.Answer;
import com.clomez.survey.beans.Question;
import com.clomez.survey.beans.Survey;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by clomez on 27.5.2017.
 */


public class SurveyDAO {

    private static DataSource dataSource = CustomDataSource.getDataSource();
    private static JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

    public  void saveAnserws(Answer answer){

        jdbcTemplate.update(
                "INSERT INTO answer (name, question_id, answer_group) VALUES (?, ?, ?)",
                answer.getName(),
                answer.getQuestion_id(),
                answer.getAnswer_group());

    }
    public void saveSurvey(Survey survey){

        jdbcTemplate.update(
                "INSERT INTO survey (user_id, name, description, enabled) VALUES (1, ?, ? ,?)",
                survey.getName(),
                survey.getDescription(),
                survey.isEnabled());

    }

    public List<Question> getSurveyById(int id) {
        ArrayList<Question> question = new ArrayList<Question>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(
                "SELECT * FROM question WHERE survey_id = ?",
                id);

        for (Map row : rows) {
            String surveyIDraw = (String)row.get("survey_id");
            int surveyID = Integer.parseInt(surveyIDraw);

            String name = (String)row.get("name");

            Long idRaw = (Long)row.get("id");
            Integer idA = Integer.valueOf(idRaw.intValue());

            question.add(new Question(idA, surveyID, name));

        }

        return question;

    }
    public int getHighestId() {

        int highest = 0;
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(
                "SELECT * FROM question ORDER BY survey_id DESC LIMIT 1;");

        for (Map row : rows) {
            String something = (String)row.get("survey_id");
            highest = Integer.parseInt(something);
            return highest;
        }

        return highest;
    }

    public void saveQuestions(Question question) {
        String text = "text";

        jdbcTemplate.update(
                "INSERT INTO question (survey_id, type, name) VALUES (?, ?, ?)",
                question.getSurveyid(),
                text,
                question.getName());
    }
}
