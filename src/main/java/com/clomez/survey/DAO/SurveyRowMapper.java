package com.clomez.survey.DAO;

import com.clomez.survey.beans.Survey;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by clomez on 27.5.2017.
 */
public class SurveyRowMapper implements RowMapper {


    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Survey survey = new Survey();
        survey.setEnabled(rs.getBoolean("enabled"));
        survey.setId(rs.getInt("id"));
        survey.setName(rs.getString("name"));

        return survey;


    }
}