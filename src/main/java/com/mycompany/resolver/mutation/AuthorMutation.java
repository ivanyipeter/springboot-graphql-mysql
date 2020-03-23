package com.mycompany.resolver.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.mycompany.model.Author;
import com.mycompany.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorMutation implements GraphQLMutationResolver {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorMutation(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author createAuthor(String name, Integer age) {
        Author author = new Author();
        author.setName(name);
        author.setAge(age);
        authorRepository.save(author);
        return author;
    }
}
