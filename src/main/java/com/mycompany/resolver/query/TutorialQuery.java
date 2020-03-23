package com.mycompany.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.mycompany.model.Tutorial;
import com.mycompany.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TutorialQuery implements GraphQLQueryResolver {

    private TutorialRepository tutorialRepository;

    @Autowired
    public TutorialQuery(TutorialRepository tutorialRepository) {
        this.tutorialRepository = tutorialRepository;
    }

    public List<Tutorial> findAllTutorials() {
        return tutorialRepository.findAll();
    }

    public Long countTutorials() {
        return tutorialRepository.count();
    }
}
