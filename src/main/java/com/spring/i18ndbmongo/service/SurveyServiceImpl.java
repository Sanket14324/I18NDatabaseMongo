package com.spring.i18ndbmongo.service;

import com.spring.i18ndbmongo.model.Survey;
import com.spring.i18ndbmongo.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyServiceImpl implements ISurveyService{


    @Autowired
    private SurveyRepository surveyRepository;
    @Override
    public Survey saveSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

    @Override
    public Survey getSurveyById(String id) {
        return surveyRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public List<Survey> getAllSurvey() {
        return surveyRepository.findAll();
    }

    @Override
    public Survey getSurveyByEMailAndTitle(String email, String title) {
        return surveyRepository.findByEmailAndTitle(email, title);
    }
}
