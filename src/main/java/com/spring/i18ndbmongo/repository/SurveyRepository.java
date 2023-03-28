package com.spring.i18ndbmongo.repository;

import com.spring.i18ndbmongo.model.Survey;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends MongoRepository<Survey, String> {

    Survey findByEmailAndTitle(String email, String title);
}
