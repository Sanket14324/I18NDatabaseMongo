package com.spring.i18ndbmongo.controller;


import com.spring.i18ndbmongo.model.Survey;
import com.spring.i18ndbmongo.service.ISurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/survey")
public class Controller {

    @Autowired
    private ISurveyService surveyService;


    @PostMapping("/{lang}")
    public ResponseEntity<Survey> saveSurvey(@RequestBody Survey survey, @PathVariable String lang){

        Survey surveyImpl = surveyService.getSurveyByEMailAndTitle(survey.getEmail(), survey.getTitle());

        System.out.println(surveyImpl);

        if(surveyImpl != null){
            if(lang.equals("en")){
                if(surveyImpl.getEn() == null){
                    surveyImpl.setEn(survey.getEn());
                    surveyService.saveSurvey(surveyImpl);
                    return ResponseEntity.ok(surveyImpl);
                }
                else{
                    return ResponseEntity.status(401).body(null);
                }

            }
            else if(lang.equals("sh")){
                if(surveyImpl.getSh() == null){
                    surveyImpl.setSh(survey.getSh());
                    surveyService.saveSurvey(surveyImpl);
                    return ResponseEntity.ok(surveyImpl);
                }
                else{
                    return ResponseEntity.status(401).body(null);
                }
            }
        }


        if(lang.equals("en")){
            survey.setSh(null);
        }
        else if(lang.equals("sh")){
            survey.setEn(null);
        }
        return ResponseEntity.ok(surveyService.saveSurvey(survey));
    }


    @GetMapping("/{id}")
    public Survey getSurveyById(@PathVariable String id){

        return surveyService.getSurveyById(id);


    }


    @GetMapping
    public List<Survey> getAllSurveys(){
        return surveyService.getAllSurvey();
    }


    @GetMapping("/{email}/{title}")
    public Survey getSurveyByEmailAndTitle(@PathVariable String email, @PathVariable String title){

        Survey survey =  surveyService.getSurveyByEMailAndTitle(email, title);
        System.out.println(survey);

        return survey;

    }

    @GetMapping("/{email}/{title}/{lang}")
    public ResponseEntity<Survey> getSurveyByEmailAndLanguage(@PathVariable String email,@PathVariable String title, @PathVariable String lang){

        Survey surveyImpl = surveyService.getSurveyByEMailAndTitle(email, title);



        if(surveyImpl != null){
            Survey survey = new Survey();
            if(lang.equals("en")){
                if(surveyImpl.getEn() != null){
                    survey.setEmail(surveyImpl.getEmail());
                    survey.setTitle(surveyImpl.getTitle());
                    survey.setEn(surveyImpl.getEn());
                    survey.setSh(null);
                    return ResponseEntity.ok(survey);
                }
                else{
                    return ResponseEntity.status(404).body(null);
                }

            }
            else if(lang.equals("sh")){
                if(surveyImpl.getSh() != null){
                    survey.setEmail(surveyImpl.getEmail());
                    survey.setTitle(surveyImpl.getTitle());
                    survey.setSh(surveyImpl.getSh());
                    survey.setEn(null);
                    return ResponseEntity.ok(survey);
                }
                else{
                    return ResponseEntity.status(404).body(null);
                }

            }
        }

        return ResponseEntity.status(404).body(null);



    }
}
