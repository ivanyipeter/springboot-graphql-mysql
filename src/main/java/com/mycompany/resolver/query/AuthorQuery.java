package com.mycompany.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.mycompany.model.Author;
import com.mycompany.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AuthorQuery implements GraphQLQueryResolver {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorQuery(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthorById(Long id){
        return authorRepository.findById(id);
    }

    public Long countAuthors() {
        return authorRepository.count();
    }
}
