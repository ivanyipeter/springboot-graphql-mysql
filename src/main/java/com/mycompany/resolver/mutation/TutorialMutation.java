package com.mycompany.resolver.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.mycompany.model.Author;
import com.mycompany.model.Tutorial;
import com.mycompany.repository.TutorialRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TutorialMutation implements GraphQLMutationResolver {

    private TutorialRepository tutorialRepository;

    @Autowired
    public TutorialMutation(TutorialRepository tutorialRepository) {
        this.tutorialRepository = tutorialRepository;
    }

    public Tutorial createTutorial(String title, String description, Long authorId) {
        Tutorial tutorial = new Tutorial();
        tutorial.setAuthor(new Author(authorId));
        tutorial.setTitle(title);
        tutorial.setDescription(description);
        tutorialRepository.save(tutorial);
        return tutorial;
    }

    public boolean deleteTutorial(Long id) {
        tutorialRepository.deleteById(id);
        return true;
    }

    public Tutorial updateTutorial(Long id, String title, String description) throws NotFoundException {
        Optional<Tutorial> optionalTutorial = tutorialRepository.findById(id);

        if (optionalTutorial.isPresent()) {
            Tutorial tutorial = optionalTutorial.get();

            if (title != null) {
                tutorial.setTitle(title);
            }

            if (description != null) {
                tutorial.setDescription(description);
            }

            tutorialRepository.save(tutorial);
            return tutorial;
        }
        throw new NotFoundException("Not found Tutorial to update!");

    }
}
