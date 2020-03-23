package com.mycompany.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.mycompany.model.Author;
import com.mycompany.model.Tutorial;
import com.mycompany.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TutorialResolver implements GraphQLResolver<Tutorial> {

    private AuthorRepository authorRepository;

    @Autowired
    public TutorialResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Tutorial tutorial) throws Throwable {
        return authorRepository.findById(tutorial.getAuthor().getId()).orElseThrow(null);
    }
}