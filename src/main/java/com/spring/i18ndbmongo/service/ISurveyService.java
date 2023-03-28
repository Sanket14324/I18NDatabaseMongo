package com.spring.i18ndbmongo.service;

import com.spring.i18ndbmongo.model.Survey;

import java.util.List;

public interface ISurveyService {

    Survey saveSurvey(Survey survey);


    Survey getSurveyById(String id);


    List<Survey> getAllSurvey();



    Survey getSurveyByEMailAndTitle(String email, String title);
}
